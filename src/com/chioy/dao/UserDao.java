package com.chioy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chioy.domain.User;
import com.chioy.mybatis.MybatisUtils;

public class UserDao {
	public int add(User user){
		String alter = "addUser";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.UserMapper."+alter;
		int add = session.insert(statement, user);
		session.close();
		return add;
	}
	public User selectById(int uid){
		String alter = "selectById";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.UserMapper."+alter;
		User user = session.selectOne(statement, uid);
		session.close();
		return user;
	}
	public User selectByEmail(String email){
		String alter = "selectByEmail";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.UserMapper."+alter;
		User user = session.selectOne(statement, email);
		session.close();
		return user;
	}
	public List<User> selectAll(){
		String alter = "selectAll";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.UserMapper."+alter;
		List<User> users = session.selectList(statement, User.class);
		session.close();
		return users;
	}
	public int deleteById(int uid){
		String alter = "deleteById";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.UserMapper."+alter;
		int delete = session.delete(statement, uid);
		session.close();
		return delete;
	}
	public int update(User user){
		String alter = "updateUser";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.UserMapper."+alter;
		int update = session.update(statement, user);
		session.close();
		return update;
	}
	public User selectByUsername(String username){
		String alter = "selectByUsername";
		SqlSession session = MybatisUtils.getSqlSession();
		String statement = "com.chioy.mybatis.UserMapper."+alter;
		User user = session.selectOne(statement, username);
		session.close();
		return user;
	}
}
