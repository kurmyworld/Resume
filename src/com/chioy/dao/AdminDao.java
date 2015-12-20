package com.chioy.dao;

import org.apache.ibatis.session.SqlSession;

import com.chioy.domain.Admin;
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
}
