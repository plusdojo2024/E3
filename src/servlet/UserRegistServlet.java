package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Users;

@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// もしもログインしていなかったらログインサーブレットにリダイレクトする
/*HttpSession session = request.getSession();
if (session.getAttribute("id") == null) {
response.sendRedirect("/E3/LoginServlet");
return;
}
*/
        // 登録ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
        dispatcher.forward(request, response);
    }


    //コメントに変更ここから

//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// もしもログインしていなかったらログインサーブレットにリダイレクトする
/*HttpSession session = request.getSession();
if (session.getAttribute("id") == null) {
response.sendRedirect("/E3/LoginServlet");
return;
}*/

// リクエストパラメータを取得する
// request.setCharacterEncoding("UTF-8");
// 改造（ここから）
//String ex_ID = request.getParameter("ex_ID");
// String user_name = request.getParameter("user_name");
// String heght = request.getParameter("heght");
// String weight = request.getParameter("weight");
// String gender = request.getParameter("gender");
// String goal_weight = request.getParameter("goal_weight");
// String cat = request.getParameter("cat");

// 改造（ここまで）

// 登録処理を行う
//UsersDAO nDao = new UsersDAO();
//String user_id =(String) session.getAttribute("id");
//　データ型は外部設計書に従って変更されます。
//nDao.insertUsers(new Users(0, user_name,Double.parseDouble(heght),Double.parseDouble(weight),Integer.parseInt(gender),Double.parseDouble(goal_weight),cat));
// 結果ページにフォワードする
//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calorie_regist.jsp");
// dispatcher.forward(request, response);
//}

// termina el doPost
//----------------------------------------------------------------------------------------------------------
//}

    //コメントに変更ここまで


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user_id");
        String password = (String) session.getAttribute("password");

        if (user_id == null || password == null) {
            response.getWriter().write("IDまたはパスワードがセッションに存在しません。");
            return;
        }

        String user_name = request.getParameter("user_name");
        String heightStr = request.getParameter("height");
        String weightStr = request.getParameter("weight");
        String genderStr = request.getParameter("gender");
        String goal_weightStr = request.getParameter("goal_weight");
        //String cat = request.getParameter("cat");

        System.out.println("user_name: " + user_name);
        System.out.println("heightStr: " + heightStr);
        System.out.println("weightStr: " + weightStr);
        System.out.println("genderStr: " + genderStr);
        System.out.println("goal_weightStr: " + goal_weightStr);
        //System.out.println("cat: " + cat);

        double height = 0.0;
        double weight = 0.0;
        int gender = 0;
        double goal_weight = 0.0;

        try {
            if (heightStr != null && !heightStr.isEmpty()) {
                height = Double.parseDouble(heightStr);
            }
            if (weightStr != null && !weightStr.isEmpty()) {
                weight = Double.parseDouble(weightStr);
            }
            if (genderStr != null && !genderStr.isEmpty()) {
                gender = Integer.parseInt(genderStr);
            }
            if (goal_weightStr != null && !goal_weightStr.isEmpty()) {
                goal_weight = Double.parseDouble(goal_weightStr);
            }
        } catch (NumberFormatException e) {
            response.getWriter().write("入力値にエラーがあります。");
            return;
        }

        UsersDAO nDao = new UsersDAO();
        Users user = new Users(0, user_id, password, user_name, height, weight, gender, goal_weight/*, cat*/);
        boolean insertSuccess = nDao.insertUsers(user);

        if (insertSuccess) {
           //response.getWriter().write("ユーザー登録に成功しました。");
           //main.jsp　未完了からコメントにしました。
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
    		dispatcher.forward(request, response);
        } else {
            response.getWriter().write("ユーザー登録に失敗しました。");
        }
    }

}