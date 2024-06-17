package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class UsersDAO {
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users users) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from USERS where USER_ID = ? and PASSWORD = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, users.getUser_id());
			pStmt.setString(2, users.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally { //例外が発生してもしなくても行う処理
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

    // 引数usersで指定されたレコードを登録し、成功したらtrueを返す
    public boolean insertUsers(Users users) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのID列にはNULLを指定する）
			String sql = "INSERT INTO Users(ID, USER_ID, PASSWORD, USER_NAME, HEIGHT, WEIGHT, GENDER, GOAL_WEIGHT, CAT) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, users.getUser_id());
				pStmt.setString(2, users.getPassword());
				if (users.getUser_id() != null && !users.getUser_id().equals("")) {
					pStmt.setString(3, users.getUser_id());
				}
				else {
					pStmt.setString(3, "（未設定）");
				}
				if (users.getHeight() != null && !users.getHeight().equals("")) {
					pStmt.setDouble(4, users.getHeight());
				}
				else {
					pStmt.setString(4, "（未設定）");
				}
				if (users.getWeight() != null && !users.getWeight().equals("")) {
					pStmt.setDouble(5, users.getWeight());
				}
				else {
					pStmt.setString(5, "（未設定）");
				}
				if (users.getGender() != null && !users.getGender().equals("")) {
					pStmt.setInt(6, users.getGender());
				}
				else {
					pStmt.setString(6, "（未設定）");
				}
				if (users.getGoal_weight() != null && !users.getGoal_weight().equals("")) {
					pStmt.setDouble(7, users.getGoal_weight());
				}
				else {
					pStmt.setString(7, "（未設定）");
				}
				if (users.getCat() != null && !users.getCat().equals("")) {
					pStmt.setString(8, users.getCat());
				}
				else {
					pStmt.setString(8, "（未設定）");
				}

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

	// 引数usersで指定されたレコードを更新し、成功したらtrueを返す
	public boolean updateUsers(Users users,String user_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Users SET USER_NAME=?, HEIGHT=?, WEIGHT=?, GENDER=?, GOAL_WEIGHT=?, CAT=? where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, users.getUser_name());
			pStmt.setDouble(2, users.getHeight());
			pStmt.setDouble(3, users.getWeight());
			pStmt.setInt(4, users.getGender());
			pStmt.setDouble(5, users.getGoal_weight());
			if (users.getCat() != null && !users.getCat().equals("")) {
				pStmt.setString(6, users.getCat());
			}
			else {
				pStmt.setString(6, "キャットネス");
			}
			pStmt.setString(7, user_id);
//			pStmt.setString(1, "yamadahanako");
//			pStmt.setDouble(2, 147.0);
//			pStmt.setDouble(3, 50.0);
//			pStmt.setInt(4, 2);
//			pStmt.setDouble(5, 75.0);
//			pStmt.setString(6, "neko");
//			pStmt.setString(7, user_id);

			// SQL文を実行する
			int data1 = pStmt.executeUpdate();
			System.out.println("Update Status:" + data1);
			if (data1 == 1) {
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

		// 引数usersで指定されたレコードを更新し、成功したらtrueを返す
//	public boolean updateCat(Users users) {
//		Connection conn = null;
//		boolean result = false;
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");
//
//			// SQL文を準備する
//			String sql = "UPDATE Users SET CAT=?";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			// SQL文を完成させる
//			if (users.getCat() != null && !users.getCat().equals("")) {
//				pStmt.setString(1, users.getCat());
//			}
//			else {
//				pStmt.setString(1, "キャットネス");
//			}
//
//			// SQL文を実行する
//			if (pStmt.executeUpdate() == 1) {
//				result = true;
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				}
//				catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		// 結果を返す
//		return result;
//	}

		// 引数usersで指定されたレコードを更新し、成功したらtrueを返す
		// public boolean updateSumCalories(Users users) {
		// 	Connection conn = null;
		// 	boolean result = false;

		// 	try {
		// 		// JDBCドライバを読み込む
		// 		Class.forName("org.h2.Driver");

		// 		// データベースに接続する
		// 		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E3", "sa", "");

		// 		// SQL文を準備する
		// 		String sql = "UPDATE Users SET SUM_CALORIES = SELECT SUM(CALORIE) FROM CALORIES WHERE USERS.ID = CALORIES.ID";
		// 		PreparedStatement pStmt = conn.prepareStatement(sql);

		// 		// SQL文を実行する
		// 		if (pStmt.executeUpdate() == 1) {
		// 			result = true;
		// 		}
		// 	}
		// 	catch (SQLException e) {
		// 		e.printStackTrace();
		// 	}
		// 	catch (ClassNotFoundException e) {
		// 		e.printStackTrace();
		// 	}
		// 	finally {
		// 		// データベースを切断
		// 		if (conn != null) {
		// 			try {
		// 				conn.close();
		// 			}
		// 			catch (SQLException e) {
		// 				e.printStackTrace();
		// 			}
		// 		}
		// 	}

		// 	// 結果を返す
		// 	return result;
		// }

}
