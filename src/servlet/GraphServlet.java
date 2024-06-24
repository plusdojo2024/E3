package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CaloriesDAO;

/**
 * Servlet implementation class GraphServlet
 */
@WebServlet("/GraphServlet")
public class GraphServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
			//	if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/E3/LoginServlet");
		//			return;
		//		}
		
		//改造ここから
        String userId = /*request.getParameter("userId")*/"7499";
        CaloriesDAO caloriesDAO = new CaloriesDAO();
        double totalCalories = caloriesDAO.getTotalCaloriesByUserId(userId);
        request.setAttribute("totalCalories", totalCalories);
        // Redirigir a la página graph.jsp
        request.getRequestDispatcher("/WEB-INF/jsp/graph.jsp").forward(request, response);
        //改造ここまで
        // 活動記録（グラフ）ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/graph.jsp");
		dispatcher.forward(request, response);
		}
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		//改造ここから
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
		//改造ここまで
			
				
			
			//ログイン状態	
				//request.setAttribute("user_id", user_id);
	
	}

}
