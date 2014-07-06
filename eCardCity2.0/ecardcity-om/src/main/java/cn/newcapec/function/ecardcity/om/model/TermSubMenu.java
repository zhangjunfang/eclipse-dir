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
 * @category 终端扩展子菜单Model
 * @version 1.0
 * @date 2014年4月22日 上午10:41:12
 */
@Table(name = "term_menu_sub")
@Entity
public class TermSubMenu extends CommonModel {
    private static final long serialVersionUID = 6578803854842639373L;
    
    @Column(name = "main_id", length = 32)
    private String main_id;
    @Column(name = "sub_id", length = 2)
    private String sub_id;
    @Column(name = "sub_menu", length = 8)
    private String sub_menu;
    @Column(name = "sub_trade_type", length = 2)
    private String sub_trade_type;
    @Column(name = "sub_acl_location", length = 2)
    private String sub_acl_location;
    @Column(name = "sub_acl_setting", length = 1)
    private String sub_acl_setting;
    
    /**
     * @return the main_id
     */
    public String getMain_id() {
        return main_id;
    }
    /**
     * @param main_id the main_id to set
     */
    public void setMain_id(String main_id) {
        this.main_id = main_id;
    }
    /**
     * @return the sub_id
     */
    public String getSub_id() {
        return sub_id;
    }
    /**
     * @param sub_id the sub_id to set
     */
    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }
    /**
     * @return the sub_menu
     */
    public String getSub_menu() {
        return sub_menu;
    }
    /**
     * @param sub_menu the sub_menu to set
     */
    public void setSub_menu(String sub_menu) {
        this.sub_menu = sub_menu;
    }
    /**
     * @return the sub_trade_type
     */
    public String getSub_trade_type() {
        return sub_trade_type;
    }
    /**
     * @param sub_trade_type the sub_trade_type to set
     */
    public void setSub_trade_type(String sub_trade_type) {
        this.sub_trade_type = sub_trade_type;
    }
    /**
     * @return the sub_acl_location
     */
    public String getSub_acl_location() {
        return sub_acl_location;
    }
    /**
     * @param sub_acl_location the sub_acl_location to set
     */
    public void setSub_acl_location(String sub_acl_location) {
        this.sub_acl_location = sub_acl_location;
    }
    /**
     * @return the sub_acl_setting
     */
    public String getSub_acl_setting() {
        return sub_acl_setting;
    }
    /**
     * @param sub_acl_setting the sub_acl_setting to set
     */
    public void setSub_acl_setting(String sub_acl_setting) {
        this.sub_acl_setting = sub_acl_setting;
    }
}
