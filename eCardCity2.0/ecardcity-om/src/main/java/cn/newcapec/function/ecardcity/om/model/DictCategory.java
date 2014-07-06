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
@Table(name = "base_dict_category")
@Entity
public class DictCategory extends CommonModel {

    private static final long serialVersionUID = -8643028526183572063L;
    @Column(name = "c_code", length = 6)
    private String c_code;    
    @Column(name = "c_name", length = 60)
    private String c_name;    
    @Column(name = "c_type", length = 1)
    private String c_type;    
    @Column(name = "allow_edit", length = 1)
    private String allow_edit;    
    @Column(name = "allow_memory", length = 1)
    private String allow_memory;
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
     * @return the c_name
     */
    public String getC_name() {
        return c_name;
    }
    /**
     * @param c_name the c_name to set
     */
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    /**
     * @return the c_type
     */
    public String getC_type() {
        return c_type;
    }
    /**
     * @param c_type the c_type to set
     */
    public void setC_type(String c_type) {
        this.c_type = c_type;
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
     * @return the allow_memory
     */
    public String getAllow_memory() {
        return allow_memory;
    }
    /**
     * @param allow_memory the allow_memory to set
     */
    public void setAllow_memory(String allow_memory) {
        this.allow_memory = allow_memory;
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
