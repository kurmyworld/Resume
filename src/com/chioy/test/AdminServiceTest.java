package com.chioy.test;

import java.util.List;

import org.junit.Test;

import com.chioy.domain.Admin;
import com.chioy.domain.ConditionUser;
import com.chioy.domain.User;
import com.chioy.exception.AdminException;
import com.chioy.service.AdminService;

public class AdminServiceTest {
	@Test
	public void testAdminLogin(){
		AdminService service = new AdminService();
		Admin admin = null;
		Admin form = new Admin();
		form.setUsername("admin");
		form.setUserpswd("ad");
		try {
			admin = service.login(form);
			System.out.println(admin);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testSelectUser(){
		ConditionUser form = new ConditionUser();
		AdminService service = new AdminService();
		form.setEmail("coms");
		List<User> users = service.selectUser(form);
		System.out.println(users);
	}
}
