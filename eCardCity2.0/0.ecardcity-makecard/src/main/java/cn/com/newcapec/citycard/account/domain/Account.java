package cn.com.newcapec.citycard.account.domain;

import java.io.Serializable;

/**
 * 登录帐号信息
 * <p/>
 * User: Wangjian Date: 2008-04-30 Time: 09:12:58 Version:1.0
 */
public class Account implements Serializable {
	private static final long serialVersionUID = -5026486427237367684L;

	private String username;// 用户名
	private String password;// 密码
	private String prompt;// 错误提示
	private String rand;// 验证码

	public Account() {
	}

	public String getUsername() {
		return username;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
}
