package com.chioy.test;

import java.util.List;

import org.junit.Test;

import com.chioy.dao.QuestionDao;
import com.chioy.domain.Question;

public class QuestionDaoTest {
	@Test
	public void testSelectAll(){
		QuestionDao dao = new QuestionDao();
		List<Question> questions = dao.selectAll();
		for(Question q : questions){
			System.out.println(q);
		}
	}
	@Test
	public void testSelectById(){
		QuestionDao dao = new QuestionDao();
		Question q = dao.selectById(3);
		System.out.println(q);
	}
	@Test
	public void testSelectByQuestion(){
		QuestionDao dao = new QuestionDao();
		Question qs = new Question("我的小学名称？");
		Question q = dao.existQuestion(qs);
		System.out.println(q);
	}
	@Test
	public void testAddQuestion(){
		QuestionDao dao = new QuestionDao();
		Question question = new Question("你不爱我吗？");
		int add = dao.add(question);
		System.out.println(add);
	}
}
