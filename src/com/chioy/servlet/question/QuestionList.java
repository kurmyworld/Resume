package com.chioy.servlet.question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Question;
import com.chioy.service.QuestionService;

public class QuestionList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset='UTF-8'");
		request.setCharacterEncoding("UTF-8");
		
		QuestionService service = new QuestionService();
		List<Question> qs = service.selectAll(); 
		request.setAttribute("qs", qs);
		request.getRequestDispatcher("/question/questionlist.jsp").forward(request, response);
	}

}
