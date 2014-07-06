package com.googlecode.common.remote.pool.resource.example.two;


public class Resource {

	private String user;
	private String password;
	private String domain;
	private String outboundProxy;

	public Resource(){

	}

	public Resource(String user, String password, String domain, String outboundProxy) {
		this.user = user;
		this.password = password;
		this.domain = domain;
		this.outboundProxy = outboundProxy;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getDomain() {
		return domain;
	}

	public String getOutboundProxy() {
		return outboundProxy;
	}


	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setOutboundProxy(String outboundProxy) {
		this.outboundProxy = outboundProxy;
	}

	@Override
	public String toString() {
		return "Resource [user=" + user + ", password=" + password + ", domain=" + domain + ", outboundProxy="
				+ outboundProxy + "]";
	}

}