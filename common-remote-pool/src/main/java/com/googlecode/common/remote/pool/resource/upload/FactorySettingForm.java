package com.googlecode.common.remote.pool.resource.upload;

import javax.ws.rs.FormParam;

public class FactorySettingForm {

    public FactorySettingForm() {
    }

     private String fileName;

    public String getFileName() {
        return fileName;
    }

    @FormParam("fileName")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}