package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Calories;

public class CaloriesDAO {

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(int id, String user_id, double calorie) {
		Connection conn = null;
		boolean result = false;

		 Double Sum_Calorie = 0.0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO CALORIES(ID, user_id, calorie) VALUES (NULL, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, user_id);
				pStmt.setDouble(2, calorie);
				System.out.println("カロリー：" + calorie);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
					sql = "SELECT  * FROM SUMCALORIES WHERE user_id = ?";
				PreparedStatement pStmt2 = conn.prepareStatement(sql);
					pStmt2.setString(1, user_id);
				ResultSet resultSet = pStmt2.executeQuery();

				 Sum_Calorie = calorie;

				 if (resultSet.next()) {
					 	Sum_Calorie += resultSet.getDouble("SUM_CALORIE");
	                }



			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			sql = "UPDATE SUMCALORIES  SET SUM_CALORIE=? where user_id = ?";
		PreparedStatement pStmt3 = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt3.setDouble(1, Sum_Calorie);
				pStmt3.setString(2, user_id);

			// SQL文を実行する
			if (pStmt3.executeUpdate() == 1) {
			result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}


	public List<Calories> selectday(Calories calories,String user_id) {
		Connection conn = null;
		List<Calories> CaloriesList = new ArrayList<Calories>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

			// SQL文を準備する
			String sql = "select sum(c.calorie) from calories c where user_id = ? group by to_char(c.days, 'yyyy/mm/dd'),c.user_id;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Calories record = new Calories(
//				rs.getInt("ID"),
//				rs.getString("USER_ID"),
				rs.getDouble("SUM(C.CALORIE)")
				);
				CaloriesList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			CaloriesList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			CaloriesList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					CaloriesList = null;
				}
			}
		}

		// 結果を返す
		return CaloriesList;
	}

	public List<Calories> selectmonth(Calories calories,String user_id) {
		Connection conn = null;
		List<Calories> CaloriesList = new ArrayList<Calories>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

			// SQL文を準備する
			String sql = "select sum(c.calorie) from calories c where user_id = ? group by to_char(c.days, 'yyyy/mm'),c.user_id;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Calories record = new Calories(
//				rs.getInt("ID"),
//				rs.getString("USER_ID"),
				rs.getDouble("SUM(C.CALORIE)")
				);
				CaloriesList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			CaloriesList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			CaloriesList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					CaloriesList = null;
				}
			}
		}

		// 結果を返す
		return CaloriesList;
	}

	public List<Calories> selectall(Calories calories,String user_id) {
		Connection conn = null;
		List<Calories> CaloriesList = new ArrayList<Calories>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT SUM(calorie) FROM CALORIES where user_id = ? GROUP BY user_id;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Calories record = new Calories(
//				rs.getInt("ID"),
//				rs.getString("USER_ID"),
				rs.getDouble("SUM(calorie)")
				);
				CaloriesList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			CaloriesList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			CaloriesList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					CaloriesList = null;
				}
			}
		}

		// 結果を返す
		return CaloriesList;
	}
	//改造ここから
	public double getTotalCaloriesByUserId(String userId) {
        Connection conn = null;
        double totalCalories = 0;

        try {
            // JDBCドライバを読み込む
            Class.forName("org.h2.Driver");

            // データベースに接続する
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

            // SQL文を準備する
            String sql = "SELECT SUM(calorie) FROM CALORIES WHERE user_id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // SQL文を完成させる
            pStmt.setString(1, userId);

            // SQL文を実行し、結果表を取得する
            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                totalCalories = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return totalCalories;
    }
	//改造ここまで
}
