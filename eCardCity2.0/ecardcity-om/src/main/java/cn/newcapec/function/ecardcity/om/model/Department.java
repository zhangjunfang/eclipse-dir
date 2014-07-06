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
 * @category 部门Model
 * @version 1.0
 * @date 2014年3月18日 上午11:33:30
 */
@Table(name = "base_dept")
@Entity
public class Department extends CommonModel {
    private static final long serialVersionUID = 5310985798148944182L;
    @Column(name = "dept_name", length = 25)
    private String dept_name;
    @Column(name = "code", length = 25)
    private String code;
    @Column(name = "pid", length = 32)
    private String pid;
    @Column(name = "address", length = 50)
    private String address;
    @Column(name = "phone", length = 20)
    private String phone;
    @Column(name = "email", length = 20)
    private String email;
    @Column(name = "valid", length = 1)
    private String valid;
    @Column(name = "remark", length = 100)
    private String remark;
    @Column(name = "ver", length = 5)
    private Integer ver;
    /**
     * @return the dept_name
     */
    public String getDept_name() {
        return dept_name;
    }
    /**
     * @param dept_name the dept_name to set
     */
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }
    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the valid
     */
    public String getValid() {
        return valid;
    }
    /**
     * @param valid the valid to set
     */
    public void setValid(String valid) {
        this.valid = valid;
    }
    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }
    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * @return the ver
     */
    public Integer getVer() {
        return ver;
    }
    /**
     * @param ver the ver to set
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }    
    
}
