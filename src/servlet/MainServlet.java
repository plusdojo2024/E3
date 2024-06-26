package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*もしもログインしていなかったらログインサーブレットにリダイレクトする*/
		 		HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/E3/LoginServlet");
					return;
				}
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// JDBCドライバの読み込み
        	try {
        		Class.forName("org.h2.Driver");
        	} catch (ClassNotFoundException e) {
        		e.printStackTrace();
        	}
        	// データベース接続情報
            String url = "jdbc:h2:file:C:/pleiades/workspace/data/E3"; // ここに接続URLを設定
            String user = "sa"; // デフォルトでは"sa"
            String password = ""; // パスワードが設定されている場合は設定

            //「user_id」取得
            String user_id =  (String) session.getAttribute("user_id");
            System.out.println("user_ID:" + user_id);

         // データベース接続とクエリ実行
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String sql = "SELECT * FROM Users WHERE user_id = ?"; // SQL文を適切に書き換える
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, user_id); // idが1のレコードを取得する例
                ResultSet resultSet = statement.executeQuery();
                //resultSet.next();

                //値の初期化
                String User_Name  = "";

                Double Height = 0.0;
                String Change_HG = "";

                Double Weight = 0.0;
                String Change_WG = "";

                Double Goal_Weight = 0.0;
                String Change_GW = "";

                String Cat_Name = "";

                //データベースからデータを取得
                if (resultSet.next()) {
                    User_Name =resultSet.getString("USER_NAME");

                    Height = resultSet.getDouble("HEIGHT");
                    Change_HG = String.valueOf(Height);

                    Weight = resultSet.getDouble("WEIGHT");
                    Change_WG = String.valueOf(Weight);

                    Goal_Weight = resultSet.getDouble("GOAL_WEIGHT");
                    Change_GW = String.valueOf(Goal_Weight);

                    Cat_Name = resultSet.getString("CAT");

                    System.out.println("ユーザーネーム : "+ User_Name);
                    System.out.println("身長 : "+ Change_HG);
                    System.out.println("体重 : "+ Change_WG);
                    System.out.println("目標体重 : "+ Change_GW);
                    System.out.println("猫の名前 : "+ Cat_Name);
                }

                // サムカロリーを持ってくる
                sql = "SELECT  * FROM SUMCALORIES WHERE user_id = 'hyogo_satou'"; // SQL文を適切に書き換える
                statement = conn.prepareStatement(sql);
                //statement.setInt(1, 1); // idが1のレコードを取得する例
                resultSet = statement.executeQuery();

                Double Sum_Calorie = 0.0;
                String SC = "";

                if (resultSet.next()) {
                    Sum_Calorie = resultSet.getDouble("SUM_CALORIE");
                    SC = String.valueOf(Sum_Calorie);
                    System.out.println("合計消費カロリー : "+ SC);
                }


                // JSPにデータを送信
                request.setAttribute("User_Name", User_Name);
                request.setAttribute("Height", Change_HG);
                request.setAttribute("Weight", Change_WG);
                request.setAttribute("Goal_Weight", Change_GW);
                request.setAttribute("Cat_Name", Cat_Name);

                request.setAttribute("Sum_Calorie", SC);

                request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);

             // データベースを切断
                statement.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

				/* メインページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response); */
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		String user_id = (String)(session.getAttribute("user_id"));
		session.setAttribute("user_id", user_id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
		}

}
