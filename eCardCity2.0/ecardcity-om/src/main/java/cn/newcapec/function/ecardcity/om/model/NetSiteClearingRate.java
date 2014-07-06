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
 * @category 网点结算费率设置模型
 * @version 1.0
 * @date 2014年5月15日 上午11:39:42
 */
@Table(name = "net_site_clearing_rate")
@Entity
public class NetSiteClearingRate extends CommonModel {
    private static final long serialVersionUID = -4746164993409618269L;
    @Column(name = "netsiteid", length = 32)
    private String netsiteid;
    @Column(name = "feepersale", length = 20)
    private String feepersale;
    @Column(name = "currencyrates", length = 5)
    private String currencyrates;
    @Column(name = "transferratesofbank", length = 5)
    private String transferratesofbank;
    @Column(name = "flag", length = 1)
    private String flag;
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
     * @return the feepersale
     */
    public String getFeepersale() {
        return feepersale;
    }

    /**
     * @param feepersale the feepersale to set
     */
    public void setFeepersale(String feepersale) {
        this.feepersale = feepersale;
    }

    /**
     * @return the currencyrates
     */
    public String getCurrencyrates() {
        return currencyrates;
    }

    /**
     * @param currencyrates the currencyrates to set
     */
    public void setCurrencyrates(String currencyrates) {
        this.currencyrates = currencyrates;
    }

    /**
     * @return the transferratesofbank
     */
    public String getTransferratesofbank() {
        return transferratesofbank;
    }

    /**
     * @param transferratesofbank the transferratesofbank to set
     */
    public void setTransferratesofbank(String transferratesofbank) {
        this.transferratesofbank = transferratesofbank;
    }

    /**
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(String flag) {
        this.flag = flag;
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
