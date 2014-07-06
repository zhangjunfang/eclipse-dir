package com.bolo.examples.base.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bolo.examples.base.entity.Role;
/**
 * 
 * @author ocean
 * date : 2014-4-14 上午09:27:36
 * email : zhangjunfang0505@163.com
 * Copyright : newcapec zhengzhou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:service-context.xml")
public class RoleServiceTest {

	@Autowired
	private RoleService roleService;
	
	@Test
	public void getRolesTest(){
		List<Role> list = roleService.getRoles();
		Assert.assertEquals(2, list.size());
	}
	
	@Test
	public void getRoleTest(){
		Role role = roleService.getRole(1);
		Assert.assertEquals("超级管理员", role.getName());
	}
	
}


