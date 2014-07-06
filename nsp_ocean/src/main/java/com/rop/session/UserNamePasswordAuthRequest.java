package com.rop.session;

/**
 * 基础用户名及密码的认证
 */
public class UserNamePasswordAuthRequest extends AbstractAuthRequest {

    private String userName;

    private String password;

    public UserNamePasswordAuthRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Object getPrincipal() {
        return userName;
    }

    @Override
    public Object getCredential() {
        return password;
    }
}
