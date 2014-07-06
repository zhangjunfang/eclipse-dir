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
 * @category 终端Model
 * @version 1.0
 * @date 2014年4月22日 上午10:41:12
 */
@Table(name = "term_info")
@Entity
public class TermInfo extends CommonModel {
    private static final long serialVersionUID = -1249076382645733703L;

    @Column(name = "termname", length = 20)
    private String termname;
    @Column(name = "merchantcode", length = 8)
    private String merchantcode;
    @Column(name = "poscode", length = 20)
    private String poscode;
    @Column(name = "isuse", length = 1)
    private String isuse;
    @Column(name = "paramgroupid", length = 32)
    private String paramgroupid;
    @Column(name = "typeid", length = 32)
    private String typeid;
    @Column(name = "status", length = 1)
    private String status;
    @Column(name = "psamcardno", length = 38)
    private Integer psamcardno;
    @Column(name = "collectid", length = 12)
    private String collectid;
    @Column(name = "siteid", length = 32)
    private String siteid;
    @Column(name = "isauth", length = 1)
    private String isauth;
    @Column(name = "workingkey", length = 16)
    private String workingkey;
    @Column(name = "kekcode", length = 16)
    private String kekcode;
    @Column(name = "appid", length = 5)
    private Integer appid;
    @Column(name = "kekencryptkey", length = 16)
    private String kekencryptkey;
    @Column(name = "isdelete", length = 1)
    private String isdelete;
    @Column(name = "ver", length = 5)
    private Integer ver;
    @JsonSerialize(using=CustomDateSerializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="lastcollectdate")
    private Date lastcollectdate;
    @JsonSerialize(using=CustomDateSerializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="lastupdatedate")
    private Date lastupdatedate;
    /**
     * @return the termname
     */
    public String getTermname() {
        return termname;
    }
    /**
     * @param termname the termname to set
     */
    public void setTermname(String termname) {
        this.termname = termname;
    }
    /**
     * @return the merchantcode
     */
    public String getMerchantcode() {
        return merchantcode;
    }
    /**
     * @param merchantcode the merchantcode to set
     */
    public void setMerchantcode(String merchantcode) {
        this.merchantcode = merchantcode;
    }
    /**
     * @return the poscode
     */
    public String getPoscode() {
        return poscode;
    }
    /**
     * @param poscode the poscode to set
     */
    public void setPoscode(String poscode) {
        this.poscode = poscode;
    }
    /**
     * @return the isuse
     */
    public String getIsuse() {
        return isuse;
    }
    /**
     * @param isuse the isuse to set
     */
    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }
    /**
     * @return the paramgroupid
     */
    public String getParamgroupid() {
        return paramgroupid;
    }
    /**
     * @param paramgroupid the paramgroupid to set
     */
    public void setParamgroupid(String paramgroupid) {
        this.paramgroupid = paramgroupid;
    }
    /**
     * @return the typeid
     */
    public String getTypeid() {
        return typeid;
    }
    /**
     * @param typeid the typeid to set
     */
    public void setTypeid(String typeid) {
        this.typeid = typeid;
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
     * @return the psamcardno
     */
    public Integer getPsamcardno() {
        return psamcardno;
    }
    /**
     * @param psamcardno the psamcardno to set
     */
    public void setPsamcardno(Integer psamcardno) {
        this.psamcardno = psamcardno;
    }
    /**
     * @return the collectid
     */
    public String getCollectid() {
        return collectid;
    }
    /**
     * @param collectid the collectid to set
     */
    public void setCollectid(String collectid) {
        this.collectid = collectid;
    }
    /**
     * @return the siteid
     */
    public String getSiteid() {
        return siteid;
    }
    /**
     * @param siteid the siteid to set
     */
    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }
    /**
     * @return the isauth
     */
    public String getIsauth() {
        return isauth;
    }
    /**
     * @param isauth the isauth to set
     */
    public void setIsauth(String isauth) {
        this.isauth = isauth;
    }
    /**
     * @return the workingkey
     */
    public String getWorkingkey() {
        return workingkey;
    }
    /**
     * @param workingkey the workingkey to set
     */
    public void setWorkingkey(String workingkey) {
        this.workingkey = workingkey;
    }
    /**
     * @return the kekcode
     */
    public String getKekcode() {
        return kekcode;
    }
    /**
     * @param kekcode the kekcode to set
     */
    public void setKekcode(String kekcode) {
        this.kekcode = kekcode;
    }
    /**
     * @return the appid
     */
    public Integer getAppid() {
        return appid;
    }
    /**
     * @param appid the appid to set
     */
    public void setAppid(Integer appid) {
        this.appid = appid;
    }
    /**
     * @return the kekencryptkey
     */
    public String getKekencryptkey() {
        return kekencryptkey;
    }
    /**
     * @param kekencryptkey the kekencryptkey to set
     */
    public void setKekencryptkey(String kekencryptkey) {
        this.kekencryptkey = kekencryptkey;
    }
    /**
     * @return the isdelete
     */
    public String getIsdelete() {
        return isdelete;
    }
    /**
     * @param isdelete the isdelete to set
     */
    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
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
     * @return the lastcollectdate
     */
    public Date getLastcollectdate() {
        return lastcollectdate;
    }
    /**
     * @param lastcollectdate the lastcollectdate to set
     */
    @JsonDeserialize(using=CustomDateDeserializer.class)
    public void setLastcollectdate(Date lastcollectdate) {
        this.lastcollectdate = lastcollectdate;
    }
    /**
     * @return the lastupdatedate
     */
    public Date getLastupdatedate() {
        return lastupdatedate;
    }
    /**
     * @param lastupdatedate the lastupdatedate to set
     */
    @JsonDeserialize(using=CustomDateDeserializer.class)
    public void setLastupdatedate(Date lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }

}
