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
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/E3/LoginServlet");
					return;
				}
		
		//改造ここから
        String userId = /*request.getParameter("userId")*/"7499";
        CaloriesDAO caloriesDAO = new CaloriesDAO();
        double totalCalories = caloriesDAO.getTotalCaloriesByUserId(userId);
        request.setAttribute("totalCalories", totalCalories);
        // Redirigir a la página growth.jsp
        request.getRequestDispatcher("/WEB-INF/jsp/growth.jsp").forward(request, response);
        //改造ここまで
        
		// 成長記録（図鑑）ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/growth.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		//改造ここから
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
		//改造ここまで
				
				// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/E3/LoginServlet");
					return;
				}

		// 成長記録（図鑑）ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/growth.jsp");
			dispatcher.forward(request, response);
		//ログイン状態
			String user_id = (String)(session.getAttribute("user_id"));
			request.setAttribute("user_id", user_id);



			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			double SUM_CALORIE = Double.parseDouble(request.getParameter("SUM_CALORIE"));

			// JSPにデータを送信
            request.setAttribute("User_Name", SUM_CALORIE);
            request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);

	}

}
