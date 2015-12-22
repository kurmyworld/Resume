package com.chioy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Question;
import com.chioy.service.QuestionService;

public class QuestionServlet extends BaseServlet {


	private static final long serialVersionUID = 1L;

	public String getList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("post")){
			QuestionService service = new QuestionService();
			List<Question> qs = service.selectAll(); 
			request.setAttribute("qs", qs);
			return "f:/WEB-INF/ajax/questionlist.jsp";
		}
		return null;
	}


}
