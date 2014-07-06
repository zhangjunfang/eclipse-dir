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
 * @category 部门映射类
 * @version 1.0
 * @date 2014年3月18日 上午11:54:27
 */
@Table(name = "base_dept_mapping")
@Entity
public class DepartmentMapping extends CommonModel {
    private static final long serialVersionUID = 2355654133362840229L;
    @Column(name = "dept_id", length = 32)
    private String dept_id;
    @Column(name = "user_id", length = 32)
    private String user_id;
    @Column(name = "login_name", length = 25)
    private String login_name;
    @Column(name = "user_name", length = 25)
    private String user_name;
    /**
     * @return the dept_id
     */
    public String getDept_id() {
        return dept_id;
    }
    /**
     * @param dept_id the dept_id to set
     */
    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }
    /**
     * @return the user_id
     */
    public String getUser_id() {
        return user_id;
    }
    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    /**
     * @return the login_name
     */
    public String getLogin_name() {
        return login_name;
    }
    /**
     * @param login_name the login_name to set
     */
    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }
    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }
    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
