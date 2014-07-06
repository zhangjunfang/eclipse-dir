package com.bolo.examples.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.base.entity.User;
import com.bolo.orm.mybatis.MyBatisDao;

/**
 * 
 * @author ocean
 * date : 2014-4-14 上午09:26:13
 * email : zhangjunfang0505@163.com
 * Copyright : newcapec zhengzhou
 */
@Service
public class UserService {

	@Autowired
	private MyBatisDao myBatisDao;
	
	/**
	 * 根据条件查询
	 */
	@SuppressWarnings({  "rawtypes" })
	public List queryResult(User user){
		return myBatisDao.getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return myBatisDao.get("userMapper.selectByPrimaryKey",id);
	}
}
