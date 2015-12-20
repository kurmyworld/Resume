package com.chioy.test;

import org.junit.Test;

import com.chioy.dao.AdminDao;
import com.chioy.domain.Admin;

public class AdminDaoTest {
	@Test
	public void testSelectByUsername(){
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.selectByUsername("asdf");
		System.out.println(admin);
	}
}
