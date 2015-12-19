package com.chioy.servlet.resume;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Resume;
import com.chioy.domain.User;
import com.chioy.exception.ResumeException;
import com.chioy.service.ResumeService;
import com.chioy.servlet.common.BaseServlet;

import fr.chioy.utils.CommonUtils;

public class ResumeServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public String myResume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/resume/myResume.jsp";
		
		response.setContentType("text/html;charset='UTF-8'");
		request.setCharacterEncoding("UTF-8");
		ResumeService service = new ResumeService();
		Resume resume = new Resume();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null){
			request.setAttribute("msg", "请先登录！");
			return "f:/user/login.jsp";
		}
		try {
			resume = service.selectByUid(user.getUid());
			request.getSession().setAttribute("resume", resume);
			return path;
		} catch (ResumeException e) {
			request.setAttribute("msg", e.getMessage());
			return path;
		}
		
	}

	public String editResume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/resume/editMyResume.jsp";
		
		response.setContentType("text/html;charset='UTF-8'");
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user"); 
		if(user == null){
			return "r:/user/login.jsp";
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
			return path;
		} catch (ResumeException e) {
			request.setAttribute("msg", e.getMessage());
			return "/user/login.jsp";
		}
		
	}
	
	public void shareResume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
