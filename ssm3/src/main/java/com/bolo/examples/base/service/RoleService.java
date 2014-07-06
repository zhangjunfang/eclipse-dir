package com.bolo.examples.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.base.entity.Role;
import com.bolo.orm.mybatis.MyBatisDao;

/**
 * 
 * @author ocean
 * date : 2014-4-14 上午09:26:18
 * email : zhangjunfang0505@163.com
 * Copyright : newcapec zhengzhou
 */
@Service
public class RoleService {

	@Autowired
	private MyBatisDao myBatisDao;
	
	public List<Role> getRoles(){
		return myBatisDao.getList("roleMapper.selectByEntity");
	}
	
	public Role getRole(Serializable id){
		return myBatisDao.get("roleMapper.selectByPrimaryKey",id);
	}
	
	public void save(Role role){
		if(role.getId() == null)
			myBatisDao.save("roleMapper.insert", role);
		else
			myBatisDao.save("roleMapper.update", role);
	}
	
	public void delete(Serializable id){
		myBatisDao.delete("roleMapper.delete", id);
	}
}
