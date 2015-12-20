package com.chioy.test;

import org.junit.Test;

import com.chioy.domain.User;
import com.chioy.exception.UserException;
import com.chioy.service.UserService;

public class UserServiceTest {
	UserService service = new UserService();
	@Test
	public void testRegistUser(){
		User form = new User( "chioy@test.co", "chioyisme", "chioyisme!!!", 2, "www");

			try {
				int a = service.regist(form);
				System.out.println(a);
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Test
	public void testLoginUser(){
		User form = new User("chioy@test.co", "chioyisme", "chioyisme!!!");
		try {
			System.out.println(service.login(form));
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSelectByEmail(){
		User user;
		try {
			user = service.selectByEmail("s");
			System.out.println(user);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
	}
}
