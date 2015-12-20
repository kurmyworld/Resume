package com.chioy.test;

import org.junit.Test;

import com.chioy.domain.Admin;
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
}
