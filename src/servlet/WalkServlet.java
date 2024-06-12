package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WalkServlet
 */
@WebServlet("/WalkServlet")
public class WalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする

		// カロリー登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/walking.jsp");
		dispatcher.forward(request, response);
	}

	//カロリー登録画面に入力した情報は
	//--------------------------------------------------------------------------------------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/E3/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		String ex_ID = request.getParameter("ex_ID");
		String calorie = request.getParameter("calorie");
		String days = request.getParameter("days");


		// 登録処理を行う
		CaloriesDAO cDao = new CaloriesDAO();

		/*if () {

		}
		else {

		}*/

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/walking.jsp");
		dispatcher.forward(request, response);
	}

	//----------------------------------------------------------------------------------------------

}
