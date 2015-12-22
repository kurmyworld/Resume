package com.chioy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Admin;
import com.chioy.domain.ConditionUser;
import com.chioy.domain.Question;
import com.chioy.domain.User;
import com.chioy.exception.AdminException;
import com.chioy.exception.UserException;
import com.chioy.service.AdminService;
import com.chioy.service.QuestionService;
import com.chioy.service.UserService;

import fr.chioy.utils.CommonUtils;

public class AdminServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("get")){			
			return "/WEB-INF/admin/login.jsp";
		}
		Admin admin = null;
		Admin form = CommonUtils.toBean(request.getParameterMap(), Admin.class);
		AdminService service = new AdminService();
		try {
			admin = service.login(form);
			request.getSession().setAttribute("admin", admin);
			return "r:/admin?method=umgr";
		} catch (AdminException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/WEB-INF/admin/login.jsp";
		}
	}

	public String umgr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("admin")==null){
			request.setAttribute("msg", "请先登陆！");
			return "/WEB-INF/admin/login.jsp";
		}
		return "/WEB-INF/admin/umgr.jsp";
	}
	public String qmgr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("admin")==null){
			request.setAttribute("msg", "请先登陆！");
			return "/WEB-INF/admin/login.jsp";
		}
		QuestionService service = new QuestionService();
		List<Question> qs = service.selectAll();
		request.setAttribute("qs", qs);
		return "/WEB-INF/admin/qmgr.jsp";
	}
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = null;
		if(request.getSession().getAttribute("admin")==null){
			request.setAttribute("users", users);
			return "f:/WEB-INF/ajax/query.jsp";
		}
		if(request.getMethod().equalsIgnoreCase("get")){
			return "r:/admin?method=umgr";
		}
		AdminService adminService = new AdminService();
		ConditionUser form = CommonUtils.toBean(request.getParameterMap(), ConditionUser.class);
		users = adminService.selectUser(form);
		request.setAttribute("users", users);
		return "f:/WEB-INF/ajax/query.jsp";
	}
	public String deluser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException,UserException{
		if(request.getSession().getAttribute("admin") == null){
			request.setAttribute("msg","您貌似没登录？");
			return "/WEB-INF/ajax/msg.jsp";
		}
		
		int id = Integer.valueOf(request.getParameter("id"));
		UserService userService = new UserService();
		int del;
		try {
			del = userService.deleteById(id);
			request.setAttribute("msg","已删除" + del+"名用户！");
			return "/WEB-INF/ajax/msg.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			return "/WEB-INF/ajax/msg.jsp";
		}
		
	}

}
