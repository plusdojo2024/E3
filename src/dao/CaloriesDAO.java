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
	public boolean insert(Calories calories,String user_id) {
		Connection conn = null;
		boolean result = false;

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
				pStmt.setDouble(2, calories.getCalorie());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
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
}
