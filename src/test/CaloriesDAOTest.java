package test;
import java.util.List;

import dao.CaloriesDAO;
import model.Calories;


public class CaloriesDAOTest {
	public static void main(String[] args) {
        testinsert();
		testselectday();	// 日ごとの場合のテスト
        testselectmonth();  //月ごとの場合のテスト
        testselectall();   //全ての合計のテスト
	}

	// insert()のテスト
	public static void testinsert() {
		CaloriesDAO dao = new CaloriesDAO();
		System.out.println("---------- insert()のテスト ----------");
		Calories insRec = new Calories(0, "hyogo_satou", 180.0);
		if (dao.insert(0, "hyogo_satou", 180.0)) {
			System.out.println("登録成功！");
			List<Calories> List3 = dao.selectday(insRec, "hyogo_satou");
			for (Calories calories : List3) {
//				System.out.println("ID：" + calories.getId());
//				System.out.println("ユーザーID：" + calories.getUser_id());
				System.out.println("消費カロリー：" + calories.getCalorie());
				System.out.println();
			}
		}
		else {
			System.out.println("登録失敗！");
		}

	}

	// selectday()のテスト
	public static void testselectday() {
		CaloriesDAO dao = new CaloriesDAO();
		System.out.println("---------- selectday()のテスト ----------");
		List<Calories> List2 = dao.selectday(new Calories(), "hyogo_satou");
		for (Calories calories : List2) {
//			System.out.println("ID：" + calories.getId());
//			System.out.println("ユーザーID：" + calories.getUser_id());
			System.out.println("消費カロリー：" + calories.getCalorie());
			System.out.println();
		}
	}

	// selectmonth()のテスト
	public static void testselectmonth() {
		CaloriesDAO dao = new CaloriesDAO();
		System.out.println("---------- selectmonth()のテスト ----------");
		List<Calories> List2 = dao.selectmonth(new Calories(), "hyogo_satou");
		for (Calories calories : List2) {
//			System.out.println("ID：" + calories.getId());
//			System.out.println("ユーザーID：" + calories.getUser_id());
			System.out.println("消費カロリー：" + calories.getCalorie());
			System.out.println();
		}
	}

	// selectall()のテスト
	public static void testselectall() {
		CaloriesDAO dao = new CaloriesDAO();
		System.out.println("---------- selectall()のテスト ----------");
		List<Calories> List2 = dao.selectall(new Calories(), "hyogo_satou");
		for (Calories calories : List2) {
//			System.out.println("ID：" + calories.getId());
//			System.out.println("ユーザーID：" + calories.getUser_id());
			System.out.println("消費カロリー：" + calories.getCalorie());
			System.out.println();
		}
	}

}
