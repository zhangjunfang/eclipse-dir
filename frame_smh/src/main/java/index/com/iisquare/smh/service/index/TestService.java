package com.iisquare.smh.service.index;

import java.util.List;

import org.hibernate.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisquare.smh.dao.index.TestDao;
import com.iisquare.smh.domain.index.Test;

@Service
public class TestService {
	@Autowired
	public TestDao testDao;
	
	public TestService() {}
	
	public List<Test> getList() {
		return testDao.queryList();
	}
	
	public Test getById(Object id) {
		return testDao.queryObjectById(id, "parent", FetchMode.JOIN);
	}
	
	public List<Test> getListByIds(String ids) {
		return testDao.queryListByIds("id", ids, "name", "parent", FetchMode.JOIN);
	}
	
	public Object account() {
		String hql = "select sum(id), count(*) from Test";
		return testDao.createQuery(hql, null).uniqueResult();
	}
	
	public String conflict() {
		return "I'm in index module.";
	}
}
