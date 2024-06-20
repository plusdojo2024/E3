package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateDataServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/E3/LoginServlet");
		}

		// H2データベースに接続するための情報
        String url = "jdbc:h2:file:C:/pleiades/workspace/data/E3"; // データベースのパス
        String user = "sa";
        String password = "";

        try {
            // データベースに接続
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            // データベースのテーブルを更新
            String user_id = (String)(session.getAttribute("user_id"));
            String sql = "DELETE FROM Users WHERE user_id=?";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, user_id);


            // データベースとの接続を閉じる
            pStmt.close();
            con.close();

            //リクエストスコープへ格納
            request.setAttribute("user_id", user_id);

            // 更新が成功したことをクライアントに返す
            response.getWriter().write("データが消去されました");
        }catch (Exception e) {
            // エラーが発生した場合はエラーメッセージをクライアントに返す
            response.getWriter().write("エラーが発生しました：" + e.getMessage());
        }

    // 結果ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
	dispatcher.forward(request, response);

	}

}

