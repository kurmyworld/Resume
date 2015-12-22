package com.chioy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Question;
import com.chioy.exception.QuestionException;
import com.chioy.service.QuestionService;

import fr.chioy.utils.CommonUtils;

public class QuestionServlet extends BaseServlet {


	private static final long serialVersionUID = 1L;

	public String getlist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("post")){
			QuestionService service = new QuestionService();
			List<Question> qs = service.selectAll(); 
			request.setAttribute("qs", qs);
			return "f:/WEB-INF/ajax/questionlist.jsp";
		}
		return null;
	}
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("admin")==null){
			return null;
		}
		if(request.getMethod().equalsIgnoreCase("get")){
			return null;
		}
		QuestionService service = new QuestionService();
		Question form = CommonUtils.toBean(request.getParameterMap(), Question.class);
		try {
			Question q = service.addQuestion(form);
			String info = "<tr><td>"+q.getQid()+"</td><td>"+q.getQuestion()+"</td></tr>";
			request.setAttribute("msg",info);
			return "f:/WEB-INF/ajax/msg.jsp";
		} catch (QuestionException e) {
			request.setAttribute("msg","0");
			return "f:/WEB-INF/ajax/msg.jsp";
		}
	}
}
