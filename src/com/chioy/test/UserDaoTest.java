package com.chioy.test;

import java.util.List;

import org.junit.Test;

import com.chioy.dao.UserDao;
import com.chioy.domain.User;


public class UserDaoTest {
	@Test
	public void testAddUser(){
		UserDao userDao = new UserDao();
		User user = new User("chioy@foxmail.com", "choy", "chioy@test", 1, "i don't know");
		int add = userDao.add(user);
		System.out.println(add);
	}
	@Test
	public void testGetAllUser(){
		UserDao userDao = new UserDao();
		List<User> U = userDao.selectAll();
		for(User u:U){
			System.out.println(u);
		}
	}
	@Test
	public void testUpdateUser(){
		UserDao userDao = new UserDao();
		User user = userDao.selectById(1);
		user.setEmail("chioy@teslot.cn");
		int update = userDao.update(user);
		System.out.println(update);
	}
	@Test
	public void testSelectById(){
		UserDao userDao = new UserDao();
		User user = userDao.selectById(1);
		System.out.println(user);
	}
	
}
