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
 * @category 打印模板类
 * @version 1.0
 * @date 2014年4月14日 下午5:18:59
 */
@Table(name = "base_print_template")
@Entity
public class PrintTemplate extends CommonModel{
    private static final long serialVersionUID = -7092620195082075093L;
    @Column(name = "template_name", length = 25)
    private String template_name;
    @Column(name = "template_type", length = 32)
    private String template_type;
    @Column(name = "netsiteid", length = 32)
    private String netsiteid;
    @Column(name = "line_no", length = 4)
    private Integer line_no;
    @Column(name = "control_symbol", length = 4)
    private String control_symbol;
    @Column(name = "print_title", length = 30)
    private String print_title;
    @Column(name = "print_param", length = 32)
    private String print_param;
    /**
     * @return the template_name
     */
    public String getTemplate_name() {
        return template_name;
    }
    /**
     * @param template_name the template_name to set
     */
    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }
    /**
     * @return the template_type
     */
    public String getTemplate_type() {
        return template_type;
    }
    /**
     * @param template_type the template_type to set
     */
    public void setTemplate_type(String template_type) {
        this.template_type = template_type;
    }
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
     * @return the line_no
     */
    public Integer getLine_no() {
        return line_no;
    }
    /**
     * @param line_no the line_no to set
     */
    public void setLine_no(Integer line_no) {
        this.line_no = line_no;
    }
    /**
     * @return the control_symbol
     */
    public String getControl_symbol() {
        return control_symbol;
    }
    /**
     * @param control_symbol the control_symbol to set
     */
    public void setControl_symbol(String control_symbol) {
        this.control_symbol = control_symbol;
    }
    /**
     * @return the print_title
     */
    public String getPrint_title() {
        return print_title;
    }
    /**
     * @param print_title the print_title to set
     */
    public void setPrint_title(String print_title) {
        this.print_title = print_title;
    }
    /**
     * @return the print_param
     */
    public String getPrint_param() {
        return print_param;
    }
    /**
     * @param print_param the print_param to set
     */
    public void setPrint_param(String print_param) {
        this.print_param = print_param;
    }
}
