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
	public Question addQuestion(Question form) throws QuestionException{
		Question add=null;
		if(form.getQuestion() == null){
			throw new QuestionException("问题不能为空！");
		}
		if(dao.selectByQuestion(form)!=null){
			throw new QuestionException("问题已存在！");
		}
		dao.add(form);
		add = selectByQuestion(form);
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
	public Question selectByQuestion(Question question){
		Question q = dao.selectByQuestion(question);
		return q;
	}
}
