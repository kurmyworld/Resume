package com.chioy.service;

import com.chioy.dao.AdminDao;
import com.chioy.domain.Admin;
import com.chioy.exception.AdminException;

public class AdminService {
	private AdminDao dao = new AdminDao();
	public Admin login(Admin form) throws AdminException{
		if(form.getUsername() == null || form.getUsername().trim().isEmpty())
		{
			throw new AdminException("用户名不能为空！");
		}
		if(form.getUserpswd() == null || form.getUserpswd().trim().isEmpty())
		{
			throw new AdminException("密码不能为空！");
		}
		Admin admin = dao.selectByUsername(form.getUsername());
		if(admin == null){
			throw new AdminException("该用户不是管理员！");
		}
		if(!form.getUserpswd().equals(admin.getUserpswd())){
			throw new AdminException("密码错误！");
		}
		return admin;
	}
}
