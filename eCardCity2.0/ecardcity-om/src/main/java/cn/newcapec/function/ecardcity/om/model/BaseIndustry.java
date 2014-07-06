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
 * @category 基础行业信息Model
 * @version 1.0
 * @date 2014年5月4日 下午4:33:30
 */
@Table(name = "base_industry")
@Entity
public class BaseIndustry extends CommonModel {
    private static final long serialVersionUID = -6057985115088707361L;
    
    @Column(name = "industrycode", length = 8)
    private String industrycode;
    @Column(name = "industryname", length = 25)
    private String industryname;
    @Column(name = "jpdm", length = 6)
    private String jpdm;
    @Column(name = "industrygrade", length = 30)
    private String industrygrade;
    @Column(name = "industry_p", length = 8)
    private String industry_p;
    @Column(name = "reserved", length = 1)
    private String reserved;
    @Column(name = "acccode", length = 10)
    private String acccode;
    @Column(name = "isshow", length = 1)
    private Integer isshow;
    
    /**
     * @return the industrycode
     */
    public String getIndustrycode() {
        return industrycode;
    }
    /**
     * @param industrycode the industrycode to set
     */
    public void setIndustrycode(String industrycode) {
        this.industrycode = industrycode;
    }
    /**
     * @return the industryname
     */
    public String getIndustryname() {
        return industryname;
    }
    /**
     * @param industryname the industryname to set
     */
    public void setIndustryname(String industryname) {
        this.industryname = industryname;
    }
    /**
     * @return the jpdm
     */
    public String getJpdm() {
        return jpdm;
    }
    /**
     * @param jpdm the jpdm to set
     */
    public void setJpdm(String jpdm) {
        this.jpdm = jpdm;
    }
    /**
     * @return the industrygrade
     */
    public String getIndustrygrade() {
        return industrygrade;
    }
    /**
     * @param industrygrade the industrygrade to set
     */
    public void setIndustrygrade(String industrygrade) {
        this.industrygrade = industrygrade;
    }
    /**
     * @return the industry_p
     */
    public String getIndustry_p() {
        return industry_p;
    }
    /**
     * @param industry_p the industry_p to set
     */
    public void setIndustry_p(String industry_p) {
        this.industry_p = industry_p;
    }
    /**
     * @return the reserved
     */
    public String getReserved() {
        return reserved;
    }
    /**
     * @param reserved the reserved to set
     */
    public void setReserved(String reserved) {
        this.reserved = reserved;
    }
    /**
     * @return the acccode
     */
    public String getAcccode() {
        return acccode;
    }
    /**
     * @param acccode the acccode to set
     */
    public void setAcccode(String acccode) {
        this.acccode = acccode;
    }
    /**
     * @return the isshow
     */
    public Integer getIsshow() {
        return isshow;
    }
    /**
     * @param isshow the isshow to set
     */
    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }
}
