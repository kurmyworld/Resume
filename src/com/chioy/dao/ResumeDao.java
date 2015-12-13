package com.chioy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chioy.domain.Resume;
import com.chioy.mybatis.MybatisUtils;

public class ResumeDao {
	private String op="com.chioy.mybatis.ResumeMapper.";
	public List<Resume> selectAll(){
		String alter="selectAll";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = op+alter;
		List<Resume> resumes = session.selectList(statement, Resume.class);
		session.close();
		return resumes;		
	}
	public Resume selectByRid(int rid){
		String alter="selectByRid";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = op+alter;
		Resume resume = session.selectOne(statement);
		return resume;
	}
	public Resume selectByUid(int uid){
		String alter="selectByUid";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = op+alter;
		Resume resume = session.selectOne(statement, uid);
		session.close();
		return resume;
	}
	public int addResume(Resume resume){
		String alter="addResume";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = op+alter;
		int add = session.insert(statement, resume);
		return add;
	}
	public int updateResume(Resume resume){
		String alter="updateResume";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = op+alter;
		int update = session.update(statement, resume);
		return update;
	}
	
}
