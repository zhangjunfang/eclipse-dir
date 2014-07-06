package com.iisquare.smh.dao.index;

import org.springframework.stereotype.Repository;

import com.iisquare.smh.domain.index.Test;
import com.iisquare.smh.frame.hibernate.DaoBase;

@Repository
public class TestDao extends DaoBase<Test> {

	public TestDao() {
		super(Test.class);
	}

}
