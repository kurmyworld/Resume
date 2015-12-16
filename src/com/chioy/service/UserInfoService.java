package com.chioy.service;

import java.util.List;

import com.chioy.dao.UserInfoDao;
import com.chioy.domain.UserInfo;
import com.chioy.exception.UserInfoException;

public class UserInfoService {
	UserInfoDao dao = new UserInfoDao();
	public UserInfo selectById(int uid) throws UserInfoException{
		UserInfo userInfo = new UserInfo();
		userInfo = dao.selectById(uid);
		if(userInfo == null){
			throw new UserInfoException("找不到该用户！");
		}
		return userInfo;
	}
	public List<UserInfo> selectAll(){
		List<UserInfo> userInfos = dao.selectAll();
		return userInfos;
	}
}
