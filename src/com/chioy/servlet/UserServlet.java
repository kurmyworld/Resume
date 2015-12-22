package com.chioy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.User;
import com.chioy.domain.UserInfo;
import com.chioy.exception.UserException;
import com.chioy.exception.UserInfoException;
import com.chioy.service.UserInfoService;
import com.chioy.service.UserService;

import fr.chioy.utils.CommonUtils;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "f:/WEB-INF/user/login.jsp";
		if (request.getMethod().equalsIgnoreCase("get")) {
			return path;
		}
		UserService userService = new UserService();
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("user", user);
			path = "r:/resume?method=myResume";
			return path;
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			path = "f:/WEB-INF/user/login.jsp";
			return path;
		}

	}

	public String regist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		if (request.getMethod().equalsIgnoreCase("get")) {
			return path;
		}

		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		String svcode = (String) request.getSession().getAttribute("vCode");
		String uvcode = request.getParameter("vCode");
		if (uvcode == null || !svcode.equalsIgnoreCase(uvcode)) {
			request.setAttribute("msg", "验证码错误！");
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

	public String modifypassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String path = "/WEB-INF/user/modifyPassword.jsp";
		if (request.getMethod().equalsIgnoreCase("get")) {
			return path;
		}

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请先登录！");
			return "/index.jsp";
		}
		String oldpswd = user.getUserpswd();
		String oldpswd2 = request.getParameter("oldpswd");
		String newpswd = request.getParameter("newpswd");
		if (oldpswd.equals(oldpswd2)) {
			user.setUserpswd(newpswd);
			UserService userService = new UserService();
			userService.update(user);
			request.setAttribute("msg", " 更改密码成功！");
		} else {
			request.setAttribute("msg", "旧密码错误！");
		}
		return path;

	}

	public String forgotten_step1(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (request.getMethod().equalsIgnoreCase("get")) {
			return "f:/WEB-INF/user/forgotten_step1.jsp";
		}
		String email = null;
		email = request.getParameter("email");
		if (email == null || email.trim().isEmpty()) {
			return "f:/WEB-INF/user/forgotten_step1.jsp";
		}
		UserInfoService userInfoService = new UserInfoService();
		try {
			UserInfo userInfo = userInfoService.selectByEmail(email);
			request.getSession().setAttribute("userInfo", userInfo);
			return "r:/user?method=forgotten_step2";
		} catch (UserInfoException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/WEB-INF/user/forgotten_step1.jsp";
		}

	}

	public String forgotten_step2(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
			UserException {
		if (request.getMethod().equalsIgnoreCase("get")) {
			return "f:/WEB-INF/user/forgotten_step2.jsp";
		}
		UserService userService = new UserService();
		UserInfo form = null;
		User user = null;
		form = CommonUtils.toBean(request.getParameterMap(), UserInfo.class);
		if (form == null) {
			return "r:/user?method=forgotten_step1";
		}
		try {
			
			user = userService.selectByEmail(form.getEmail());
			if (!form.getAnswer().equals(user.getAnswer())) {
				request.setAttribute("msg", "问题答案不正确！");
				return "f:/WEB-INF/user/forgotten_step2.jsp";
			}
			request.getSession().setAttribute("tempuser", user);
			return "r:/user?method=resetPassword";
		} catch (UserException e) {
			throw e;
		}
	}

	public String resetpassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (request.getMethod().equalsIgnoreCase("get")) {
			return "f:/WEB-INF/user/resetPassword.jsp";
		}
		User user = (User) request.getSession().getAttribute("tempuser");
		if(user==null){
			return "r:/user?method=forgotten_step1";
		}
		try {
			String newpswd = request.getParameter("newpswd");
			if (newpswd == null || newpswd.trim().isEmpty()) {
				return "r:/user?method=resetPassword";
			}
			user.setUserpswd(newpswd);
			UserService userService = new UserService();
			userService.update(user);
			request.setAttribute("msg", "修改完成！");
			return "f:/WEB-INF/user/resetPassword.jsp";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
