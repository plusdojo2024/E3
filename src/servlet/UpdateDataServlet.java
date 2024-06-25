package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDataServlet
 */
@WebServlet("/UpdateDataServlet")
public class UpdateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// H2データベースに接続するための情報
        String url = "jdbc:h2:file:C:/pleiades/workspace/data/E3"; // データベースのパス
        String user = "sa";
        String password = "";

        // DB用の変数の初期値
        String Use_name = "";
        Double Height = 0.0;
        Double Weight = 0.0;
        Double Goal_Weight = 0.0;
        String Cat_name = "";

        // フォームから送信されたデータを取得
         Use_name = request.getParameter("user_name");


        String height = request.getParameter("height");
        if( height != null) {
        	 Height = Double.parseDouble(height);
        }else {
        	 Height = 0.0;
        }


        String weight = request.getParameter("weight");
        if( weight != null) {
        	Weight = Double.parseDouble(weight);
        }else {
        	Weight = 0.0;
        }


        String goal_weight = request.getParameter("goal_weight");
        if( goal_weight != null) {
        	Goal_Weight= Double.parseDouble(goal_weight);
        }else {
        	Goal_Weight = 0.0;
        }

        Cat_name = request.getParameter("cat_name");

        System.out.println("Received name: " + Use_name);

        System.out.println("Received height: " + height);
        System.out.println("Received weight: " + weight);
        System.out.println("Received goal_weight: " + goal_weight);
        System.out.println("Received cat_name: " + Cat_name);

        System.out.println();

        System.out.println("Chenged height: " + Height);
        System.out.println("Chenged weight: " + Weight);
        System.out.println("Chenged goal_weight: " + Goal_Weight);

        try {
            // データベースに接続
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            // データベースのテーブルを更新
            String sql = "UPDATE Users SET USER_NAME=?, HEIGHT=?,WEIGHT=?,GOAL_WEIGHT=?,CAT=? where ID = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Use_name);
            ps.setDouble(2, Height);
            ps.setDouble(3, Weight);
            ps.setDouble(4, Goal_Weight);
            ps.setString(5, Cat_name);
            ps.executeUpdate();

            // データベースとの接続を閉じる
            ps.close();
            con.close();

            // 更新が成功したことをクライアントに返す
            response.getWriter().write("データが更新されました");
        }catch (Exception e) {
            // エラーが発生した場合はエラーメッセージをクライアントに返す
            response.getWriter().write("エラーが発生しました：" + e.getMessage());
        }

	}

}
