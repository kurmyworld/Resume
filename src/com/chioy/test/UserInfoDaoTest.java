package com.chioy.test;

import java.util.List;

import org.junit.Test;

import com.chioy.dao.UserInfoDao;
import com.chioy.domain.UserInfo;

public class UserInfoDaoTest {
	@Test
	public void selectByIdTest(){
		UserInfoDao dao = new UserInfoDao();
		UserInfo user = dao.selectById(1);
		System.out.println(user);
	}
	@Test
	public void selectAllTest(){
		UserInfoDao dao = new UserInfoDao();
		List<UserInfo> users = dao.selectAll();
		for(UserInfo user : users){
			System.out.println(user);
		}
	}
}
