package com.chioy.servlet.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chioy.domain.Question;
import com.chioy.exception.QuestionException;
import com.chioy.service.QuestionService;

import fr.chioy.utils.CommonUtils;

public class QuestionAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset='UTF-8'");
		request.setCharacterEncoding("UTF-8");
		
		QuestionService service = new QuestionService();
		Question form = CommonUtils.toBean(request.getParameterMap(), Question.class);
		
		try {
			service.addQuestion(form);
			request.setAttribute("msg","添加成功！");
			request.getRequestDispatcher("/question/questionadd.jsp").forward(request, response);
		} catch (QuestionException e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("/question/questionadd.jsp").forward(request, response);
		}

	}

}
