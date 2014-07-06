package cn.newcapec.foundation.ecardcity.makecard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.newcapec.framework.core.handler.springDatebind.CustomDateSerializer;
import cn.newcapec.framework.core.model.CommonModel;

/**
 * 
 * @Description: 网点信息 实体类
 * @author 高崇飞
 * @date 2014-4-23 下午01:33:13
 * @version V1.0
 */
@Table(name = "net_site")
@Entity
public class NetSite extends CommonModel {
	private static final long serialVersionUID = -3347324002396153840L;
	// 网点ID
	@Column(name = "netid", length = 12)
	private String netid;
	// 网点名称
	@Column(name = "netname", length = 25)
	private String netname;
	// 网点简称
	@Column(name = "netjp", length = 15)
	private String netjp;
	// 网点状态 0：停用、1：正常
	@Column(name = "netstatus", length = 1)
	private String netstatus;
	// 网点类型（0：充值网点:1：综合网点）
	@Column(name = "nettype", length = 1)
	private String nettype;
	// 行业代码
	@Column(name = "industry_code", length = 8)
	private String industry_code;
	// 邮编
	@Column(name = "postcode", length = 6)
	private String postcode;
	// 排序号
	@Column(name = "sort_num")
	Integer sort_num;

	// 联系电话
	@Column(name = "phone", length = 11)
	private String phone;
	// 地址
	@Column(name = "address", length = 50)
	private String address;
	// 传真
	@Column(name = "fax", length = 13)
	private String fax;
	// 板本号
	@Column(name = "ver", length = 5)
	private Integer ver;
	// 上级代码
	@Column(name = "netid_p", length = 12)
	private String netid_p;
	// 网点种类，0直属，1代理（代理网点记账方式不同）
	@Column(name = "netkind", length = 1)
	private String netkind;
	// 更新用户
	@Column(name = "edit_person", length = 32)
	private String edit_person;
	// 更新日期
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edit_date")
	private Date edit_date;

	public Date getEdit_date() {
		return edit_date;
	}

	public String getIndustry_code() {
		return industry_code;
	}

	public void setIndustry_code(String industry_code) {
		this.industry_code = industry_code;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Integer getSort_num() {
		return sort_num;
	}

	public void setSort_num(Integer sort_num) {
		this.sort_num = sort_num;
	}

	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getNetname() {
		return netname;
	}

	public void setNetname(String netname) {
		this.netname = netname;
	}

	public String getNetjp() {
		return netjp;
	}

	public void setNetjp(String netjp) {
		this.netjp = netjp;
	}

	public String getNetstatus() {
		return netstatus;
	}

	public void setNetstatus(String netstatus) {
		this.netstatus = netstatus;
	}

	public String getNettype() {
		return nettype;
	}

	public void setNettype(String nettype) {
		this.nettype = nettype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getVer() {
		return ver;
	}

	public void setVer(Integer ver) {
		this.ver = ver;
	}

	public String getNetid_p() {
		return netid_p;
	}

	public void setNetid_p(String netid_p) {
		this.netid_p = netid_p;
	}

	public String getNetkind() {
		return netkind;
	}

	public void setNetkind(String netkind) {
		this.netkind = netkind;
	}

	public String getEdit_person() {
		return edit_person;
	}

	public void setEdit_person(String edit_person) {
		this.edit_person = edit_person;
	}
}
