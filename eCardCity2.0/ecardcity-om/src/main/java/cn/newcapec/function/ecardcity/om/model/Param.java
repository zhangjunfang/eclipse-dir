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
 * @category 参数模板类
 * @version 1.0
 * @date 2014年3月31日 上午11:54:27
 */
@Table(name = "base_param")
@Entity
public class Param extends CommonModel {
    private static final long serialVersionUID = -4533572683543580195L;
    @Column(name = "cardtype", length = 32)
    private String cardtype;
    @Column(name = "p_group", length = 32)
    private String p_group;
    @Column(name = "p_name", length = 25)
    private String p_name;
    @Column(name = "p_value", length = 60)
    private String p_value;
    @Column(name = "p_value_type", length = 50)
    private String p_value_type;
    @Column(name = "p_code", length = 10)
    private String p_code;
    @Column(name = "title_name", length = 50)
    private String title_name;
    @Column(name = "p_desc", length = 100)
    private String p_desc;
    @Column(name = "allow_edit", length = 1)
    private String allow_edit;
    @Column(name = "allow_visible", length = 50)
    private String allow_visible;
    @Column(name = "sort_num", length = 6)
    private int sort_num;
    @Column(name = "notes", length = 100)
    private String notes;
    @Column(name = "ver", length = 5)
    private int ver;
    
    /**
     * @return the cardtype
     */
    public String getCardtype() {
        return cardtype;
    }
    /**
     * @param cardtype the cardtype to set
     */
    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }
    /**
     * @return the p_group
     */
    public String getP_group() {
        return p_group;
    }
    /**
     * @param p_group the p_group to set
     */
    public void setP_group(String p_group) {
        this.p_group = p_group;
    }
    /**
     * @return the p_name
     */
    public String getP_name() {
        return p_name;
    }
    /**
     * @param p_name the p_name to set
     */
    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    /**
     * @return the p_value
     */
    public String getP_value() {
        return p_value;
    }
    /**
     * @param p_value the p_value to set
     */
    public void setP_value(String p_value) {
        this.p_value = p_value;
    }
    /**
     * @return the p_value_type
     */
    public String getP_value_type() {
        return p_value_type;
    }
    /**
     * @param p_value_type the p_value_type to set
     */
    public void setP_value_type(String p_value_type) {
        this.p_value_type = p_value_type;
    }
    /**
     * @return the p_code
     */
    public String getP_code() {
        return p_code;
    }
    /**
     * @param p_code the p_code to set
     */
    public void setP_code(String p_code) {
        this.p_code = p_code;
    }
    /**
     * @return the title_name
     */
    public String getTitle_name() {
        return title_name;
    }
    /**
     * @param title_name the title_name to set
     */
    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }
    /**
     * @return the p_desc
     */
    public String getP_desc() {
        return p_desc;
    }
    /**
     * @param p_desc the p_desc to set
     */
    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
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
     * @return the allow_visible
     */
    public String getAllow_visible() {
        return allow_visible;
    }
    /**
     * @param allow_visible the allow_visible to set
     */
    public void setAllow_visible(String allow_visible) {
        this.allow_visible = allow_visible;
    }
    /**
     * @return the sort_num
     */
    public int getSort_num() {
        return sort_num;
    }
    /**
     * @param sort_num the sort_num to set
     */
    public void setSort_num(int sort_num) {
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
     * @return the ver
     */
    public int getVer() {
        return ver;
    }
    /**
     * @param ver the ver to set
     */
    public void setVer(int ver) {
        this.ver = ver;
    }
}
