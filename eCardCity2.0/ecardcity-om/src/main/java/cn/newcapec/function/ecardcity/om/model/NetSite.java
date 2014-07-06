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
 * @category 网点（商户）模型
 * @version 1.0
 * @date 2014年4月17日 上午11:39:42
 */
@Table(name = "net_site")
@Entity
public class NetSite extends CommonModel {
    private static final long serialVersionUID = 7058051423092498651L;

    @Column(name = "netid", length = 12)
    private String netid;
    @Column(name = "netname", length = 25)
    private String netname;
    @Column(name = "netjp", length = 15)
    private String netjp;
    @Column(name = "netstatus", length = 1)
    private String netstatus;
    @Column(name = "nettype", length = 1)
    private String nettype;
    @Column(name = "linkman", length = 10)
    private String linkman;
    @Column(name = "phone", length = 13)
    private String phone;
    @Column(name = "address", length = 50)
    private String address;
    @Column(name = "fax", length = 13)
    private String fax;
    @Column(name = "ver", length = 5)
    private Integer ver;
    @Column(name = "netid_p", length = 12)
    private String netid_p;
    @Column(name = "netkind", length = 1)
    private String netkind;
    @Column(name = "edit_person", length = 13)
    private String edit_person;
    @Column(name = "induscode_code", length = 8)
    private String induscode_code;
    @Column(name = "postcode", length = 6)
    private String postcode;
    @Column(name = "sort_num", length = 8)
    private Integer sort_num;
    @Column(name = "status", length = 1)
    private String status;
    @JsonSerialize(using=CustomDateSerializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="edit_date")
    private Date edit_date;

    /**
     * @return the netid
     */
    public String getNetid() {
        return netid;
    }

    /**
     * @param netid the netid to set
     */
    public void setNetid(String netid) {
        this.netid = netid;
    }

    /**
     * @return the netname
     */
    public String getNetname() {
        return netname;
    }

    /**
     * @param netname the netname to set
     */
    public void setNetname(String netname) {
        this.netname = netname;
    }

    /**
     * @return the netjp
     */
    public String getNetjp() {
        return netjp;
    }

    /**
     * @param netjp the netjp to set
     */
    public void setNetjp(String netjp) {
        this.netjp = netjp;
    }

    /**
     * @return the netstatus
     */
    public String getNetstatus() {
        return netstatus;
    }

    /**
     * @param netstatus the netstatus to set
     */
    public void setNetstatus(String netstatus) {
        this.netstatus = netstatus;
    }

    /**
     * @return the nettype
     */
    public String getNettype() {
        return nettype;
    }

    /**
     * @param nettype the nettype to set
     */
    public void setNettype(String nettype) {
        this.nettype = nettype;
    }

    /**
     * @return the linkman
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * @param linkman the linkman to set
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
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
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * @return the netid_p
     */
    public String getNetid_p() {
        return netid_p;
    }

    /**
     * @param netid_p the netid_p to set
     */
    public void setNetid_p(String netid_p) {
        this.netid_p = netid_p;
    }

    /**
     * @return the netkind
     */
    public String getNetkind() {
        return netkind;
    }

    /**
     * @param netkind the netkind to set
     */
    public void setNetkind(String netkind) {
        this.netkind = netkind;
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

    /**
     * @return the induscode_code
     */
    public String getInduscode_code() {
        return induscode_code;
    }

    /**
     * @param induscode_code the induscode_code to set
     */
    public void setInduscode_code(String induscode_code) {
        this.induscode_code = induscode_code;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
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
