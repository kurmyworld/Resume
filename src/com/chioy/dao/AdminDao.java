package com.chioy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chioy.domain.Admin;
import com.chioy.domain.ConditionUser;
import com.chioy.domain.User;
import com.chioy.mybatis.MybatisUtils;


public class AdminDao {
	private String op = "com.chioy.mybatis.AdminMapper.";
	public Admin selectByUsername(String username){
		SqlSession session = MybatisUtils.getSqlSession();
		String alter = "selectByUsername";
		String statment = op + alter;
		Admin admin = session.selectOne(statment, username);
		return admin;
	}
	public List<User> selectUser(ConditionUser form){
		SqlSession session = MybatisUtils.getSqlSession();
		String alter = "selectUser";
		String statment = op+alter;
		List<User> users =  session.selectList(statment, form);
		return users;
	}
}
