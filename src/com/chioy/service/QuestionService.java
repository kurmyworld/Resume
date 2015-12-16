package com.chioy.service;

import java.util.List;

import com.chioy.dao.QuestionDao;
import com.chioy.domain.Question;
import com.chioy.exception.QuestionException;

public class QuestionService {
	private QuestionDao dao = new QuestionDao();
	/**
	 * 添加问题
	 * @param form
	 * @return
	 * @throws QuestionException
	 */
	public int addQuestion(Question form) throws QuestionException{
		int add=0;
		if(form.getQuestion() == null){
			throw new QuestionException("问题不能为空！");
		}
		if(dao.existQuestion(form)!=null){
			throw new QuestionException("问题已存在！");
		}
		return add;
	}
	/**
	 * 返回所有问题List对象
	 * @return
	 */
	public List<Question> selectAll(){
		List<Question> qs = dao.selectAll();
		return qs;
	}
	/**
	 * 通过问题ID查询问题，返回问题对象
	 * @param qid
	 * @return
	 * @throws QuestionException
	 */
	public Question selectById(int qid) throws QuestionException{
		Question q = dao.selectById(qid);
		if(q == null){
			throw new QuestionException("该问题不存在！");
		}
		return q;
	}
	/**
	 * 如果存在该问题，返回该问题对象
	 * @param question
	 * @return
	 */
	public Question existQuestion(Question question){
		Question q = dao.existQuestion(question);
		return q;
	}
}
