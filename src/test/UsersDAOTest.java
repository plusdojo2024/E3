package test;
import dao.UsersDAO;
import model.Users;

public class UsersDAOTest {
	public static void main(String[] args) {
		testIsLoginOK1();	// ユーザーが見つかる場合のテスト
		testIsLoginOK2();	// ユーザーが見つからない場合のテスト
        testinsertUsers();
//        testupdateUsers();
	}

	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		UsersDAO dao = new UsersDAO();
		if (dao.isLoginOK(new Users("hyogo_satou", "password"))) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		UsersDAO dao = new UsersDAO();
		if (!dao.isLoginOK(new Users("DOJO", "pass"))) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	}


	// insert()のテスト

    public static void testinsertUsers() {
        int upDelNumber = 1;		// 後で更新および削除する番号
    	System.out.println("---------- insertUsers()のテスト ----------");
		UsersDAO dao = new UsersDAO();
		Users insRec = new Users(0, "saitama_katou", "kpassword", "katoujirou", 180.0, 80.0, 4, 78.0, "");
		if (dao.insertUsers(insRec)) {
			System.out.println("登録成功！");
//			List<Users> UsersList3 = dao.select(insRec);
//			for (Users users : UsersList3) {
//				System.out.println("id：" + users.getId());
//				System.out.println("ユーザーID：" + users.getUser_id());
//				System.out.println("パスワード：" + users.getPassword());
//				System.out.println("氏名：" + users.getUser_name());
//				System.out.println("身長：" + users.getHeight());
//				System.out.println("体重：" + users.getWeight());
//				System.out.println("性別：" + users.getGender());
//				System.out.println("目標体重：" + users.getGoal_weight());
//				System.out.println();
				upDelNumber = insRec.getId();	// 最後のレコードを後で更新および削除する

		}
		else {
			System.out.println("登録失敗！");
		}
//    }

    // update()のテスト

//    public static void testupdateUsers() {
//        int upDelNumber = 0;		// 後で更新および削除する番号
        System.out.println("---------- updateUsers()のテスト ----------");
//    	UsersDAO dao = new UsersDAO();
		Users upRec = new Users(upDelNumber, "yamashitataturou", 180.0, 75.0, 4, 74.0, "");
		if (dao.updateUsers(upRec,"hyogo_satou")) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}
    }
}