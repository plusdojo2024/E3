package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CaloriesDAO;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/WalkServlet")
public class WalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/E3/LoginServlet");
			return;
		}



		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/walking.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/E3/LoginServlet");
			return;
		}


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String calorie = request.getParameter("calorie");

		// 登録処理を行う
		CaloriesDAO cDao = new CaloriesDAO();
		//　データ型は外部設計書に従って変更されます。
		if (cDao.insert(0,user_id,Double.parseDouble(calorie))) {
			// 登録成功
			request.setAttribute("message", "登録が成功しました。");
		}
		else {// 登録失敗
			request.setAttribute("message", "登録が失敗しました。");
		}

		//セッションオブジェクトに値を格納
		session.setAttribute("user_id", user_id);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
}
