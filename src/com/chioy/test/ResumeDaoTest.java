package com.chioy.test;

import java.util.List;

import org.junit.Test;

import com.chioy.dao.ResumeDao;
import com.chioy.domain.Resume;

public class ResumeDaoTest {
	@Test
	public void testSelectAll(){
		ResumeDao dao = new ResumeDao();
		List<Resume> resumes = dao.selectAll();
		for(Resume r : resumes){
			System.out.println(r);
		}
	}
	@Test
	public void testAddResume(){
		ResumeDao dao = new ResumeDao();
		Resume resume = new Resume(2, "头像url", "名字", 0, 0, "software", "fr", "meiyoa", "个人简介");
		int add = dao.addResume(resume);
		System.out.println(resume);
		System.out.println(add);
	}
	@Test
	public void testUpdateResume(){
		ResumeDao dao = new ResumeDao();
		Resume resume = new Resume(2, "头像的url", "邱成龙", 20, 0, "software", "fr", "没工作经验", "个人简介什么不要了");
		resume.setAddr("address");
		resume.setTel("asdf");
		int update = dao.updateResume(resume);
		System.out.println(update);
	}
	@Test
	public void testSelectByUid(){
		ResumeDao dao = new ResumeDao();
		Resume resume = dao.selectByUid(3);
		System.out.println(resume);
	}

}
