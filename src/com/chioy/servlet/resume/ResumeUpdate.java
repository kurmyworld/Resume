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

import fr.chioy.utils.CommonUtils;

public class ResumeUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset='UTF-8'");
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user"); 
		if(user == null){
			response.sendRedirect(request.getContextPath()+"/Login");
			return ;
		}
		
		Resume form = CommonUtils.toBean(request.getParameterMap(), Resume.class);
		Resume resume = new Resume();
		form.setUid(user.getUid());
		ResumeService service = new ResumeService();
		service.update(form);
		request.setAttribute("msg", "修改完成！");
		try {
			resume = service.selectByUid(user.getUid());
			request.getSession().setAttribute("resume", resume);
			request.getRequestDispatcher("/resume/EditMyResume.jsp").forward(request, response);
		} catch (ResumeException e) {
			response.sendRedirect(request.getContextPath()+"/Login");
		}
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset='utf-8'");
		request.getRequestDispatcher("/resume/EditMyResume.jsp").forward(request, response);
	}
	

}
