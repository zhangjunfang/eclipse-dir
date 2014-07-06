package com.ocean.test;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


public class Test implements Serializable {
  
	private static final long serialVersionUID = 2511421890988112572L;

	private String username;
	
	private Date date;
	
	private Integer[]  testArray;
	
	private Map<String, String> testMap;
	
	private Address  address;
	
	//private Address  address=new  Address();

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer[] getTestArray() {
		return testArray;
	}

	public void setTestArray(Integer[] testArray) {
		this.testArray = testArray;
	}

	public Map<String, String> getTestMap() {
		return testMap;
	}

	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
