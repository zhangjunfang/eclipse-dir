package com.rop.session;


@SuppressWarnings("all")
public abstract class AbstractAuthRequest implements AuthRequest {

    private Object detail;

    @Override
    public Object getDetail() {
        return null;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

}
