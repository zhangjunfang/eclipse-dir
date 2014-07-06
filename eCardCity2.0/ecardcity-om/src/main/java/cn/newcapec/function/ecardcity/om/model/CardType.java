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
 * @category 卡类型Model
 * @version 1.0
 * @date 2014年4月4日 上午11:45:00
 */
@Table(name = "card_type")
@Entity
public class CardType extends CommonModel {
    private static final long serialVersionUID = -281909926276619821L;
    @Column(name = "groupid", length = 32)
    private String groupid;
    @Column(name = "cardtypename", length = 10)
    private String cardtypename;
    @Column(name = "typeid", length = 20)
    private Long typeid;
    @Column(name = "sort_num", length = 6)
    private Integer sort_num;
    @Column(name = "ver", length = 5)
    private Integer ver;
    @Column(name = "description", length = 100)
    private String description;
    
    /**
     * @return the groupid
     */
    public String getGroupid() {
        return groupid;
    }
    /**
     * @param groupid the groupid to set
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    /**
     * @return the cardtypename
     */
    public String getCardtypename() {
        return cardtypename;
    }
    /**
     * @param cardtypename the cardtypename to set
     */
    public void setCardtypename(String cardtypename) {
        this.cardtypename = cardtypename;
    }
    /**
     * @return the typeid
     */
    public Long getTypeid() {
        return typeid;
    }
    /**
     * @param typeid the typeid to set
     */
    public void setTypeid(Long typeid) {
        this.typeid = typeid;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
