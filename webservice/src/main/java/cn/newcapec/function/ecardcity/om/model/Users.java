package cn.newcapec.function.ecardcity.om.model;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
 
/**
 * <b>function:</b> Users Entity
 * @author hoojo
 * @createDate 2011-3-18 上午09:27:31
 * @file Users.java
 * @package com.hoo.entity
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@XmlRootElement(name = "UserInfos")
public class Users {
    private List<User> users;
    
    private User[] userArr;
    
    private HashMap<String, User> maps;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User[] getUserArr() {
		return userArr;
	}

	public void setUserArr(User[] userArr) {
		this.userArr = userArr;
	}

	public HashMap<String, User> getMaps() {
		return maps;
	}

	public void setMaps(HashMap<String, User> maps) {
		this.maps = maps;
	}
    
    
}