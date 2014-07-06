/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.newcapec.framework.core.model.CommonModel;

/**
 * @author wj
 * @category 字典类
 * @version 1.0
 * @date 2014年4月10日 上午9:21:10
 */
@Table(name = "base_dict")
@Entity
public class Dict extends CommonModel {

    private static final long serialVersionUID = -9101012965412906672L;
    @Column(name = "c_code", length = 6)
    private String c_code;
    @Column(name = "d_code", length = 60)
    private String d_code;
    @Column(name = "d_desc1", length = 100)
    private String d_desc1;
    @Column(name = "d_desc2", length = 100)
    private String d_desc2;
    @Column(name = "d_desc3", length = 100)
    private String d_desc3;
    @Column(name = "d_desc4", length = 100)
    private String d_desc4;
    @Column(name = "d_desc5", length = 100)
    private String d_desc5;
    @Column(name = "status", length = 1)
    private String status;
    @Column(name = "allow_edit", length = 1)
    private String allow_edit;
    @Column(name = "sort_num", length = 6)
    private Integer sort_num;
    @Column(name = "notes", length = 100)
    private String notes;
    @Column(name = "version", length = 5)
    private Integer version;
    /**
     * @return the c_code
     */
    public String getC_code() {
        return c_code;
    }
    /**
     * @param c_code the c_code to set
     */
    public void setC_code(String c_code) {
        this.c_code = c_code;
    }
    /**
     * @return the d_code
     */
    public String getD_code() {
        return d_code;
    }
    /**
     * @param d_code the d_code to set
     */
    public void setD_code(String d_code) {
        this.d_code = d_code;
    }
    /**
     * @return the d_desc1
     */
    public String getD_desc1() {
        return d_desc1;
    }
    /**
     * @param d_desc1 the d_desc1 to set
     */
    public void setD_desc1(String d_desc1) {
        this.d_desc1 = d_desc1;
    }
    /**
     * @return the d_desc2
     */
    public String getD_desc2() {
        return d_desc2;
    }
    /**
     * @param d_desc2 the d_desc2 to set
     */
    public void setD_desc2(String d_desc2) {
        this.d_desc2 = d_desc2;
    }
    /**
     * @return the d_desc3
     */
    public String getD_desc3() {
        return d_desc3;
    }
    /**
     * @param d_desc3 the d_desc3 to set
     */
    public void setD_desc3(String d_desc3) {
        this.d_desc3 = d_desc3;
    }
    /**
     * @return the d_desc4
     */
    public String getD_desc4() {
        return d_desc4;
    }
    /**
     * @param d_desc4 the d_desc4 to set
     */
    public void setD_desc4(String d_desc4) {
        this.d_desc4 = d_desc4;
    }
    /**
     * @return the d_desc5
     */
    public String getD_desc5() {
        return d_desc5;
    }
    /**
     * @param d_desc5 the d_desc5 to set
     */
    public void setD_desc5(String d_desc5) {
        this.d_desc5 = d_desc5;
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return the allow_edit
     */
    public String getAllow_edit() {
        return allow_edit;
    }
    /**
     * @param allow_edit the allow_edit to set
     */
    public void setAllow_edit(String allow_edit) {
        this.allow_edit = allow_edit;
    }
    /**
     * @return the sort_num
     */
    public Integer getSort_num() {
        return sort_num;
    }
    /**
     * @param sort_num the sort_num to set
     */
    public void setSort_num(Integer sort_num) {
        this.sort_num = sort_num;
    }
    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }
    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
    /**
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }
    /**
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
