package com.chioy.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Admin;
import com.chioy.exception.AdminException;
import com.chioy.service.AdminService;
import com.chioy.servlet.common.BaseServlet;

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
			return "r:/admin?method=panel";
		} catch (AdminException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/WEB-INF/admin/login.jsp";
		}
	}

	public String panel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("get")){
			return "f:/WEB-INF/admin/panel.jsp";
		}
		return "/WEB-INF/admin/panel.jsp";
	}

}
