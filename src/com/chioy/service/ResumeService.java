package com.chioy.service;

import java.util.List;

import com.chioy.dao.ResumeDao;
import com.chioy.domain.Resume;
import com.chioy.exception.ResumeException;

public class ResumeService {
	ResumeDao dao = new ResumeDao();
	public Resume selectByUid(int uid) throws ResumeException{
		Resume resume = dao.selectByUid(uid);
		if(resume == null){
			throw new ResumeException("没有该用户数据！");
		}
		return resume;
	}
	public List<Resume> selectAll(){
		List<Resume> resumes = dao.selectAll();
		return resumes;
	}
	public int update(Resume resume){
		int update;
		update = dao.updateResume(resume);
		return update;
	}
	public Resume selectByRid(int rid) throws ResumeException{
		Resume resume = null;
		resume = dao.selectByRid(rid);
		if(resume == null){
			throw new ResumeException("找不到该数据！");
		}
		return resume;
	}
	public int add(Resume resume){
		int add = dao.addResume(resume);
		return add;
	}

}
