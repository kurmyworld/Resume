package com.chioy.servlet.resume;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Resume;
import com.chioy.domain.User;
import com.chioy.exception.ResumeException;
import com.chioy.service.ResumeService;

public class MyResume extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset='UTF-8'");
		request.setCharacterEncoding("UTF-8");
		ResumeService service = new ResumeService();
		Resume resume = new Resume();
		User user = (User) request.getSession().getAttribute("user");
		try {
			resume = service.selectByUid(user.getUid());
			request.getSession().setAttribute("resume", resume);
			request.getRequestDispatcher("/resume/MyResume.jsp").forward(request, response);
		} catch (ResumeException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/resume/MyResume.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
