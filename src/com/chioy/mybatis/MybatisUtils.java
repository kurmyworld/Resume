package com.chioy.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	public static SqlSession getSqlSession(){
		String source = "conf.xml";
		InputStream is = MybatisUtils.class.getClassLoader().getResourceAsStream(source);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession(true);
		return session;
	}
}
