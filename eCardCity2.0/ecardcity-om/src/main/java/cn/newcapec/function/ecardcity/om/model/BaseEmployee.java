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
 * @category 网点操作员模型
 * @version 1.0
 * @date 2014年5月13日 下午1:39:42
 */
@Table(name = "base_employee")
@Entity
public class BaseEmployee extends CommonModel {
    private static final long serialVersionUID = 8999755174119573488L;
    @Column(name = "user_id", length = 32)
    private String user_id;
    @Column(name = "netsite_id", length = 32)
    private String netsite_id;
    @Column(name = "bank_id", length = 32)
    private String bank_id;
    @Column(name = "empid", length = 8)
    private Integer empid;
    @Column(name = "sale_cardtype", length = 4000)
    private String sale_cardtype;
    @Column(name = "cash_cardtype", length = 4000)
    private String cash_cardtype;
    @Column(name = "privilege_cashin", length = 1)
    private String privilege_cashin;
    @Column(name = "privilege_cashout", length = 1)
    private String privilege_cashout;
    @Column(name = "privilege_pos", length = 1)
    private String privilege_pos;
    @Column(name = "privilege_login", length = 1)
    private String privilege_login;
    @Column(name = "ver", length = 5)
    private Integer ver;
    @Column(name = "status", length = 1)
    private String status;
    
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
     * @return the netsite_id
     */
    public String getNetsite_id() {
        return netsite_id;
    }
    /**
     * @param netsite_id the netsite_id to set
     */
    public void setNetsite_id(String netsite_id) {
        this.netsite_id = netsite_id;
    }
    /**
     * @return the bank_id
     */
    public String getBank_id() {
        return bank_id;
    }
    /**
     * @param bank_id the bank_id to set
     */
    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }
    /**
     * @return the empid
     */
    public Integer getEmpid() {
        return empid;
    }
    /**
     * @param empid the empid to set
     */
    public void setEmpid(Integer empid) {
        this.empid = empid;
    }
    /**
     * @return the sale_cardtype
     */
    public String getSale_cardtype() {
        return sale_cardtype;
    }
    /**
     * @param sale_cardtype the sale_cardtype to set
     */
    public void setSale_cardtype(String sale_cardtype) {
        this.sale_cardtype = sale_cardtype;
    }
    /**
     * @return the cash_cardtype
     */
    public String getCash_cardtype() {
        return cash_cardtype;
    }
    /**
     * @param cash_cardtype the cash_cardtype to set
     */
    public void setCash_cardtype(String cash_cardtype) {
        this.cash_cardtype = cash_cardtype;
    }
    /**
     * @return the privilege_cashin
     */
    public String getPrivilege_cashin() {
        return privilege_cashin;
    }
    /**
     * @param privilege_cashin the privilege_cashin to set
     */
    public void setPrivilege_cashin(String privilege_cashin) {
        this.privilege_cashin = privilege_cashin;
    }
    /**
     * @return the privilege_cashout
     */
    public String getPrivilege_cashout() {
        return privilege_cashout;
    }
    /**
     * @param privilege_cashout the privilege_cashout to set
     */
    public void setPrivilege_cashout(String privilege_cashout) {
        this.privilege_cashout = privilege_cashout;
    }
    /**
     * @return the privilege_pos
     */
    public String getPrivilege_pos() {
        return privilege_pos;
    }
    /**
     * @param privilege_pos the privilege_pos to set
     */
    public void setPrivilege_pos(String privilege_pos) {
        this.privilege_pos = privilege_pos;
    }
    /**
     * @return the privilege_login
     */
    public String getPrivilege_login() {
        return privilege_login;
    }
    /**
     * @param privilege_login the privilege_login to set
     */
    public void setPrivilege_login(String privilege_login) {
        this.privilege_login = privilege_login;
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
    
}
