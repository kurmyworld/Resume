package com.chioy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Resume;
import com.chioy.domain.User;
import com.chioy.service.ResumeService;
import com.chioy.service.UserService;

public class Share extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset='UTF-8'");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("u");
		UserService userService = new UserService();
		ResumeService resumeService = new ResumeService();
		try {
			User user = userService.selectByUsername(username);
			Resume resume = resumeService.selectByUid(user.getUid());
			request.setAttribute("resume", resume);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/resume/Share.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/resume/Share.jsp").forward(request, response);
		}
		
	}

}
