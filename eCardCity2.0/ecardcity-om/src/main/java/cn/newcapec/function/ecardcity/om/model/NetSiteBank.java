/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.newcapec.framework.core.handler.springDatebind.CustomDateDeserializer;
import cn.newcapec.framework.core.handler.springDatebind.CustomDateSerializer;
import cn.newcapec.framework.core.model.CommonModel;

/**
 * @author wj
 * @category 网点账号模型
 * @version 1.0
 * @date 2014年5月12日 上午11:39:42
 */
@Table(name = "net_site_bank")
@Entity
public class NetSiteBank extends CommonModel {
    private static final long serialVersionUID = 8137891154182606395L;
    @Column(name = "netsiteid", length = 32)
    private String netsiteid;
    @Column(name = "bankname", length = 32)
    private String bankname;
    @Column(name = "open_account", length = 32)
    private String open_account;
    @Column(name = "transfer_account", length = 32)
    private String transfer_account;
    @Column(name = "public_account", length = 1)
    private String public_account;
    @Column(name = "edit_person", length = 32)
    private String edit_person;
    @JsonSerialize(using=CustomDateSerializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="edit_date")
    private Date edit_date;

    /**
     * @return the netsiteid
     */
    public String getNetsiteid() {
        return netsiteid;
    }



    /**
     * @param netsiteid the netsiteid to set
     */
    public void setNetsiteid(String netsiteid) {
        this.netsiteid = netsiteid;
    }



    /**
     * @return the bankname
     */
    public String getBankname() {
        return bankname;
    }



    /**
     * @param bankname the bankname to set
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }



    /**
     * @return the open_account
     */
    public String getOpen_account() {
        return open_account;
    }



    /**
     * @param open_account the open_account to set
     */
    public void setOpen_account(String open_account) {
        this.open_account = open_account;
    }



    /**
     * @return the transfer_account
     */
    public String getTransfer_account() {
        return transfer_account;
    }



    /**
     * @param transfer_account the transfer_account to set
     */
    public void setTransfer_account(String transfer_account) {
        this.transfer_account = transfer_account;
    }



    /**
     * @return the public_account
     */
    public String getPublic_account() {
        return public_account;
    }



    /**
     * @param public_account the public_account to set
     */
    public void setPublic_account(String public_account) {
        this.public_account = public_account;
    }



    /**
     * @return the edit_person
     */
    public String getEdit_person() {
        return edit_person;
    }



    /**
     * @param edit_person the edit_person to set
     */
    public void setEdit_person(String edit_person) {
        this.edit_person = edit_person;
    }



    /**
     * @return the edit_date
     */
    public Date getEdit_date() {
        return edit_date;
    }



    /**
     * @param edit_date the edit_date to set
     */
    @JsonDeserialize(using=CustomDateDeserializer.class)
    public void setEdit_date(Date edit_date) {
        this.edit_date = edit_date;
    }
    
}
