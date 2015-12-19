package com.chioy.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.User;
import com.chioy.exception.UserException;
import com.chioy.service.UserService;
import com.chioy.servlet.common.BaseServlet;

import fr.chioy.utils.CommonUtils;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "f:/user/login.jsp";
		if(request.getMethod().equalsIgnoreCase("get")){
			return path;
		}
		UserService userService = new UserService();
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("user", user);
			path ="r:/resume?method=myResume";
			return path;
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			path = "f:/user/login.jsp";
			return path;
		}
		
	}

	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		if(request.getMethod().equalsIgnoreCase("get")){
			return path;
		}

		User form = CommonUtils.toBean(request.getParameterMap(),User.class);
		String svcode = (String) request.getSession().getAttribute("vCode");
		String uvcode = request.getParameter("vCode");
		if(uvcode == null|| !svcode.equalsIgnoreCase(uvcode)){
			request.setAttribute("msg","验证码错误！");
			return path;
		}
		UserService userService = new UserService();
		try {
			userService.regist(form);
			request.getSession().setAttribute("user", form);
			request.getSession().setAttribute("msg", "注册成功！请登陆！");
			return path;
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			return path;
		}
	}
	
	
	public String modifyPassword(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		String path = "/user/modifyPassword.jsp";
		if(request.getMethod().equalsIgnoreCase("get")){
			return path;
		}
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			request.setAttribute("msg", "请先登录！");
			return "/index.jsp";
		}
		String oldpswd = user.getUserpswd();
		String oldpswd2 = request.getParameter("oldpswd");
		String newpswd = request.getParameter("newpswd");
		if(oldpswd.equals(oldpswd2)){
			user.setUserpswd(newpswd);
			UserService userService = new UserService();
			userService.update(user);
			request.setAttribute("msg", " 更改密码成功！");
		}else{
			request.setAttribute("msg", "旧密码错误！");
		}
		return path;
		
	}

}
