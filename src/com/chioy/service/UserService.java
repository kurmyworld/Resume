package com.chioy.service;

import java.util.List;

import com.chioy.dao.UserDao;
import com.chioy.domain.User;
import com.chioy.exception.UserException;

public class UserService {
	private UserDao userDao = new UserDao();
	public User login(User form) throws UserException{
		User user = null;
		if(form.getEmail()==null||form.getUserpswd()==null){
			throw new UserException("邮箱或密码不能为空！");
		}
		user = userDao.selectByEmail(form.getEmail());
		if(user == null){
			user = userDao.selectByUsername(form.getEmail());
			if(user == null){
				throw new UserException("用户"+form.getEmail()+"未注册");
			}
		}
		if(!user.getUserpswd().equals(form.getUserpswd())){
			throw new UserException("用户名或密码错误！");
		}
		return user;
	}
	public int regist(User form) throws UserException{
		if(form.getEmail()==null||form.getUserpswd()==null){
			throw new UserException("用户名或密码不能为空！");
		}
		if(userDao.selectByEmail(form.getEmail())!=null || userDao.selectByUsername(form.getUsername())!=null){
			throw new UserException("该用户已被注册！");
		}
		int add = userDao.add(form);
		return add;
	}
	public int delete(User user){
		int delete = userDao.deleteById(user.getUid());
		return delete;
	}
	public int update(User user){
		int update = userDao.update(user);
		return update;
	}
	public List<User> getAll(){
		List<User> users = userDao.selectAll();
		return users;
	}
	public User selectByUsername(String username) throws UserException{
		User user = userDao.selectByUsername(username);
		if(user == null){
			throw new UserException("找不到此人");
		}
		return user;
	}
	public User selectByEmail(String email) throws UserException{
		if(email==null||email.trim().isEmpty()){
			throw new UserException("查询条件不能为空！");
		}
		User user = userDao.selectByEmail(email);
		if(user == null){
			throw new UserException("找不到此人");
		}
		return user;
	}
	public int deleteByUsername(String username) throws UserException{
		if(username==null||username.trim().isEmpty()){
			throw new UserException("啥啥啥？你要删除谁？？");
		}
		int del = userDao.deleteByUsername(username);
		if(del == 0){
			throw new UserException("没这个人，白做了！");
		}else{
			return del;
		}
	}
	public int deleteById(int id) throws UserException{
		if(id==0){
			throw new UserException("啥啥啥？你要删除谁？？");
		}
		int del = userDao.deleteById(id);
		if(del == 0){
			throw new UserException("没这个人，白做了！");
		}else{
			return del;
		}
	}
	
}
