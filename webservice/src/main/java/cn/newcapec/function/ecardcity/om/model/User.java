package cn.newcapec.function.ecardcity.om.model;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
 
/**
 * <b>function:</b>User Entity
 * @author hoojo
 * @createDate Dec 16, 2010 10:20:02 PM
 * @file User.java
 * @package com.hoo.entity
 * @project AxisWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@XmlRootElement(name = "UserInfo")
public class User implements Serializable {
    private static final long serialVersionUID = 677484458789332877L;
    private int id;
    private String name;
    private String email;
    private String address;
    
   
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
    public String toString() {
        return this.id + "#" + this.name + "#" + this.email + "#" + this.address;
    }
}