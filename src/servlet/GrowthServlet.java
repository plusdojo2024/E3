package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GrowthServlet
 */
@WebServlet("/GrowthServlet")
public class GrowthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/E3/LoginServlet");
		//			return;
		//		}
		
		// 成長記録（図鑑）ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/growth.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/E3/LoginServlet");
		//			return;
		//		}
		
		// 成長記録（図鑑）ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/growth.jsp");
			dispatcher.forward(request, response);
		//ログイン状態	
		//	request.setAttribute("user_id", user_id);
			
			
			
			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			double SUM_CALORIE = Double.parseDouble(request.getParameter("SUM_CALORIE"));
			
			// JSPにデータを送信
            request.setAttribute("User_Name", SUM_CALORIE);
            request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			
	}

}
