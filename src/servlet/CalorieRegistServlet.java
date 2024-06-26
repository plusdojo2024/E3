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
@WebServlet("/CalorieRegistServlet")
public class CalorieRegistServlet extends HttpServlet {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calorie_regist.jsp");
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
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 改造（ここから）
		//String ex_ID = request.getParameter("ex_ID");
		//String user_id = request.getParameter("user_id");
		String user_id = "hyogo_satou";

		String calorie = request.getParameter("calorie");
		// 改造（ここまで）

		// 登録処理を行う
		CaloriesDAO cDao = new CaloriesDAO();
        //boolean result = cDao.insert(0, user_id, Double.parseDouble(calorie));
		boolean insertSuccess = cDao.insert(0, user_id, Double.parseDouble(calorie));
		//　データ型は外部設計書に従って変更されます。
		//cDao.insert(0, user_id,/*Integer.parseInt(ex_ID),*/ Double.parseDouble(calorie));
		//if (cDao.insert(0, user_id,/*Integer.parseInt(ex_ID),*/ Double.parseDouble(calorie))) {
			// 登録成功
			//request.setAttribute("message", "登録が成功しました。");
			//request.setAttribute("user_id", user_id);
		//}
		//else {// 登録失敗
		//	request.setAttribute("message", "登録が失敗しました。");
		//}
		// 結果ページにフォワードする

		//  String forwardPath = "/WEB-INF/jsp/calorie_regist.jsp";
		  //  if (result) {
		  //      request.setAttribute("message", "登録が成功しました。");
		  //  } else {
		 //       request.setAttribute("message", "登録が失敗しました。");
		  //  }

		    /*
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calorie_regist.jsp");
		dispatcher.forward(request, response);
		*/
	     //   RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
	      //  dispatcher.forward(request, response);
		//デバッグ
		if (insertSuccess) {

			//response.getWriter().write("ユーザー登録に成功しました。");
	           //main.jsp　未完了からコメントにしました。
		 	//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MainServlet");
    		dispatcher.forward(request, response);

			} else {

			response.getWriter().write("ユーザー登録に失敗しました。");

			}
	}

	// termina el doPost
	//----------------------------------------------------------------------------------------------------------
}