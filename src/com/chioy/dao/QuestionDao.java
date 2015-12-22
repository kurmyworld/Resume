package com.chioy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chioy.domain.Question;
import com.chioy.mybatis.MybatisUtils;

public class QuestionDao {
	
	public int add(Question question){
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.QuestionMapper.addQuestion";
		int add = session.insert(statement, question);
		session.close();
		return add;
	}
	public Question selectById(int qid){
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.QuestionMapper.selectById";
		Question q = session.selectOne(statement, qid);
		session.close();
		return q;
	} 
	public List<Question> selectAll(){
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.QuestionMapper.selectAll";
		List<Question> Q = session.selectList(statement, Question.class);
		session.close();
		return Q;
	}
	public Question selectByQuestion(Question question){
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.QuestionMapper.selectByQuestion";
		Question q = session.selectOne(statement, question);
		session.close();
		return q;
	} 
}
