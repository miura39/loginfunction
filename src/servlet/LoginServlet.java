package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//jspのhomeディレクトリ
	private static final String JSP_HOME = "WEB-INF/jsp/";
	//login.jspのルート
	private static final String JSP_LOGIN = JSP_HOME + "login.jsp";
	
	private static final String JSP_LOGINOK = JSP_HOME + "loginOk.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException{
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userID");
		String pass = request.getParameter("pass");

		//ログイン処理の実行
		Login login = new Login(userId, pass);
		LoginLogic bo = new LoginLogic();
		boolean result = false;
		try {
			result = bo.execute(login);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//ログイン処理の成否によって処理を分岐
		if(result) {
			HttpSession session = request.getSession();
			//jspにデータを渡すためにsetAttributeで指定する
			request.setAttribute("userId", userId);

			session.setAttribute("userId", userId);
		//フォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(JSP_LOGINOK);
			dispatcher.forward(request, response);
		}else {
			//リダイレクト
			response.sendRedirect("/loginfunction/LoginServlet");
		}
	}
}
