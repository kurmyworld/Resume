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

public class Regist extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setContentType("text/html;charset='utf-8'");
		request.setCharacterEncoding("UTF-8");
		User form = CommonUtils.toBean(request.getParameterMap(),User.class);
		String svcode = (String) request.getSession().getAttribute("vCode");
		String uvcode = request.getParameter("vCode");
		if(uvcode == null|| !svcode.equalsIgnoreCase(uvcode)){
			request.setAttribute("msg","验证码错误！");
			request.getRequestDispatcher("/").forward(request, response);
			return ;
		}
		UserService userService = new UserService();
		try {
			userService.regist(form);
			request.getSession().setAttribute("user", form);
			request.getSession().setAttribute("msg", "注册成功！请登陆！");
			response.sendRedirect(request.getContextPath()+"/");
		} catch (UserException e) {
			request.getSession().setAttribute("msg", e.getMessage());
			response.sendRedirect(request.getContextPath()+"/");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/");
	}

}
