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
 * @category 终端扩展主菜单Model
 * @version 1.0
 * @date 2014年4月22日 上午10:41:12
 */
@Table(name = "term_menu_main")
@Entity
public class TermMainMenu extends CommonModel {
    private static final long serialVersionUID = 6578803854842639373L;
    
    @Column(name = "termid", length = 32)
    private String termid;
    @Column(name = "main_menu", length = 8)
    private String main_menu;
    @Column(name = "main_menu_key1", length = 2)
    private String main_menu_key1;    
    @Column(name = "main_menu_key2", length = 2)
    private String main_menu_key2;
    @Column(name = "main_menu_key3", length = 2)
    private String main_menu_key3;
    @Column(name = "main_menu_key4", length = 2)
    private String main_menu_key4;
    @Column(name = "main_menu_key5", length = 2)
    private String main_menu_key5;
    @Column(name = "main_menu_key6", length = 2)
    private String main_menu_key6;
    @Column(name = "main_menu_key7", length = 2)
    private String main_menu_key7;
    @Column(name = "main_menu_key8", length = 2)
    private String main_menu_key8;
    @Column(name = "param_ver", length = 3)
    private String param_ver;
    @JsonSerialize(using=CustomDateSerializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ver_time")
    private Date ver_time;
    /**
     * @return the termid
     */
    public String getTermid() {
        return termid;
    }
    /**
     * @param termid the termid to set
     */
    public void setTermid(String termid) {
        this.termid = termid;
    }
    /**
     * @return the main_menu
     */
    public String getMain_menu() {
        return main_menu;
    }
    /**
     * @param main_menu the main_menu to set
     */
    public void setMain_menu(String main_menu) {
        this.main_menu = main_menu;
    }
    /**
     * @return the main_menu_key1
     */
    public String getMain_menu_key1() {
        return main_menu_key1;
    }
    /**
     * @param main_menu_key1 the main_menu_key1 to set
     */
    public void setMain_menu_key1(String main_menu_key1) {
        this.main_menu_key1 = main_menu_key1;
    }
    /**
     * @return the main_menu_key2
     */
    public String getMain_menu_key2() {
        return main_menu_key2;
    }
    /**
     * @param main_menu_key2 the main_menu_key2 to set
     */
    public void setMain_menu_key2(String main_menu_key2) {
        this.main_menu_key2 = main_menu_key2;
    }
    /**
     * @return the main_menu_key3
     */
    public String getMain_menu_key3() {
        return main_menu_key3;
    }
    /**
     * @param main_menu_key3 the main_menu_key3 to set
     */
    public void setMain_menu_key3(String main_menu_key3) {
        this.main_menu_key3 = main_menu_key3;
    }
    /**
     * @return the main_menu_key4
     */
    public String getMain_menu_key4() {
        return main_menu_key4;
    }
    /**
     * @param main_menu_key4 the main_menu_key4 to set
     */
    public void setMain_menu_key4(String main_menu_key4) {
        this.main_menu_key4 = main_menu_key4;
    }
    /**
     * @return the main_menu_key5
     */
    public String getMain_menu_key5() {
        return main_menu_key5;
    }
    /**
     * @param main_menu_key5 the main_menu_key5 to set
     */
    public void setMain_menu_key5(String main_menu_key5) {
        this.main_menu_key5 = main_menu_key5;
    }
    /**
     * @return the main_menu_key6
     */
    public String getMain_menu_key6() {
        return main_menu_key6;
    }
    /**
     * @param main_menu_key6 the main_menu_key6 to set
     */
    public void setMain_menu_key6(String main_menu_key6) {
        this.main_menu_key6 = main_menu_key6;
    }
    /**
     * @return the main_menu_key7
     */
    public String getMain_menu_key7() {
        return main_menu_key7;
    }
    /**
     * @param main_menu_key7 the main_menu_key7 to set
     */
    public void setMain_menu_key7(String main_menu_key7) {
        this.main_menu_key7 = main_menu_key7;
    }
    /**
     * @return the main_menu_key8
     */
    public String getMain_menu_key8() {
        return main_menu_key8;
    }
    /**
     * @param main_menu_key8 the main_menu_key8 to set
     */
    public void setMain_menu_key8(String main_menu_key8) {
        this.main_menu_key8 = main_menu_key8;
    }
    /**
     * @return the param_ver
     */
    public String getParam_ver() {
        return param_ver;
    }
    /**
     * @param param_ver the param_ver to set
     */
    public void setParam_ver(String param_ver) {
        this.param_ver = param_ver;
    }
    /**
     * @return the ver_time
     */
    public Date getVer_time() {
        return ver_time;
    }
    /**
     * @param ver_time the ver_time to set
     */
    @JsonDeserialize(using=CustomDateDeserializer.class)
    public void setVer_time(Date ver_time) {
        this.ver_time = ver_time;
    }
}
