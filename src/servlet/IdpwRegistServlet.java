package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.Users;

/**
 * Servlet implementation class IdpwRegistServlet
 */
@WebServlet("/IdpwRegistServlet")
public class IdpwRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/E3/LoginServlet");
			return;
		}
*/

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/idpw_regist.jsp");
		dispatcher.forward(request, response);
	}


	//----------------------------------------------------------------------------------------------------------
	//empieza el doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/E3/LoginServlet");
			return;
		}*/

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		// 改造（ここから）
		//String ex_ID = request.getParameter("ex_ID");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		// 改造（ここまで）

		// 登録処理を行う
		UsersDAO nDao = new UsersDAO();
		//String user_id =(String) session.getAttribute("id");
		//　データ型は外部設計書に従って変更されます。
		nDao.insertUsers(new Users(0, user_id,password));
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		dispatcher.forward(request, response);
	}

	// termina el doPost
	//----------------------------------------------------------------------------------------------------------
}