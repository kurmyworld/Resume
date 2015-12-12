package com.chioy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chioy.domain.UserInfo;
import com.chioy.mybatis.MybatisUtils;

public class UserInfoDao {
	public UserInfo selectById(int uid){
		String alter = "selectById";
		String statement = "com.chioy.mybatis.UserInfoMapper."+alter;
		SqlSession session = MybatisUtils.getSqlSession();
		UserInfo userInfo = session.selectOne(statement, uid);
		session.close();
		return userInfo;
	}
	public List<UserInfo> selectAll(){
		String alter = "selectAll";
		String statement = "com.chioy.mybatis.UserInfoMapper."+alter;
		SqlSession session = MybatisUtils.getSqlSession();
		List<UserInfo> userInfo = session.selectList(statement, UserInfo.class);
		session.close();
		return userInfo;
	}
}
