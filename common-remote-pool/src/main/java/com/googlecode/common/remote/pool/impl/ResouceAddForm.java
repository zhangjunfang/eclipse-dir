package com.googlecode.common.remote.pool.impl;

import javax.ws.rs.FormParam;

public class ResouceAddForm {

    public ResouceAddForm() {
    }

    private String jsonContent;

    public String getJsonContent() {
        return jsonContent;
    }

    @FormParam("jsonContent")
    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

}