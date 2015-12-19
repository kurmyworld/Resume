package com.chioy.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.User;
import com.chioy.service.UserService;

public class ModifyPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return ;
		}
		String oldpswd = user.getUserpswd();
		String oldpswd2 = request.getParameter("oldpswd");
		String newpswd = request.getParameter("newpswd");
		if(oldpswd.equals(oldpswd2)){
			user.setUserpswd(newpswd);
			UserService userService = new UserService();
			userService.update(user);
			request.setAttribute("msg", " 更改密码成功！");
			System.out.println(user);
			request.getRequestDispatcher("/user/ModifyPassword.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "旧密码错误！");
			request.getRequestDispatcher("/user/ModifyPassword.jsp").forward(request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/user/ModifyPassword.jsp").forward(request, response);
	}

}
