package com.chioy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Resume;
import com.chioy.domain.User;
import com.chioy.exception.ResumeException;
import com.chioy.service.ResumeService;

import fr.chioy.utils.CommonUtils;

public class ResumeServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public String myresume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "/resume/myResume.jsp";
		ResumeService service = new ResumeService();
		Resume resume = new Resume();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null){
			request.setAttribute("msg", "请先登录！");
			return "f:/WEB-INF/user/login.jsp";
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

	public String editresume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "/resume/editResume.jsp";//该方法视图路径
		User user = (User) request.getSession().getAttribute("user"); 
		if(user == null){
			request.setAttribute("msg", "请先登录！");
			return "/user/login.jsp";
		}
		/*
		 * 判断调用方法，如果是get方法则加载修改页面
		 */
		if(request.getMethod().equalsIgnoreCase("get")){
			return path;
		}
		/*
		 * 判断用户是否登陆
		 */
		/*
		 * 不是get方法则提交修改
		 */
		
		
		Resume form = CommonUtils.toBean(request.getParameterMap(), Resume.class);
		Resume resume = null;
		form.setUid(user.getUid());
		ResumeService service = new ResumeService();
		try {
			service.update(form);
			request.setAttribute("msg", "修改完成！");
			resume = service.selectByUid(user.getUid());
			request.getSession().setAttribute("resume", resume);
			return path;
		} catch (ResumeException e) {
			request.setAttribute("msg", e.getMessage());
			System.out.println(e.getMessage());
			return "/WEB-INF/user/login.jsp";
		}
		
	}

}
