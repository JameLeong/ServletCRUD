package com.james.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.james.service.LoginService;
import com.james.service.impl.LoginServiceImpl;
/**
 * 鐧婚檰
 * @author James
 *
 */
public class LoginController extends HttpServlet {
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1073426851310681916L;
	/**
	 * 鐧婚檰涓氬姟
	 */
	private LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    HttpSession session = request.getSession();
	   
	    //寰楀埌鍙傛暟
		String username = request.getParameter("username");  
		String password = request.getParameter("password");  
		String who = request.getParameter("who");  
		if(loginService.isAuth(username, password,who)){
			//璁剧疆session
			session.setAttribute("username", username);
			System.out.println(username+" "+password+" "+who);
			request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request,response);
		}else{
			//鐧婚檰澶辫触涔嬪悗鐨勬彁绀轰俊鎭�
			request.setAttribute("info","璐︽埛鎴栬�呭瘑鐮侀敊璇�");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	

}
