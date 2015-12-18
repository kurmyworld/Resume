package com.chioy.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.User;
import com.chioy.exception.UserException;
import com.chioy.service.UserService;

import fr.chioy.utils.CommonUtils;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset='UTF-8'");
		request.setCharacterEncoding("UTF-8");
		UserService userService = new UserService();
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/resume/MyResume");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/user/login.jsp").forward(request, response);
	}

}
