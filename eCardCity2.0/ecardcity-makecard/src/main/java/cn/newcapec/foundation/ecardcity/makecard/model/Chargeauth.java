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
 * 网点授权余额
 * 
 * @author wulimo
 * 
 */
@Table(name = "chargeauth")
@Entity
public class Chargeauth extends CommonModel {
	private static final long serialVersionUID = 530323920093867032L;
	@Column(name = "curoddfare")
	private Double curoddfare;// 当前授权额度
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "authtime")
	private Date authtime;// 授权时间（记录最近一次授权额度的操作时间）
	@Column(name = "allowoverdraftfare")
	private Double allowoverdraftfare;// 允许透支金额
	@Column(name = "maxlimitdate")
	private Long maxlimitdate;// 最大逾期（天）
	@Column(name = "isuse", length = 1)
	private String isuse;// 是否启用充值授权额度，0：不启用，1：启用
	@Column(name = "workstatus", length = 1)
	private String workstatus;// 状态：0正常状态，1透支状态
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "limitenddate")
	private Date limitenddate;// 允许透支截止日期
	@Column(name = "maxlimitfare")
	private Double maxlimitfare;// 最大授权额度（上级网点对下级网点授权金额）
	@Column(name = "sumfare")
	private Double sumfare;// 授权额度累计
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "allowoverdraftopdt")
	private Date allowoverdraftopdt;// 允许透支金额最近一次操作时间（更新透支金额最后一次操作时间）
	@Column(name = "allowoverdraftsumfare")
	private Double allowoverdraftsumfare;// 网点使用透支额度累计
	@Column(name = "netsiteid", length = 32)
	private String netsiteid;// 网点id
	@Column(name = "edit_person", length = 32)
	private String edit_person;// 更新用户
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edit_date")
	private Date edit_date;// 更新日期

	public Double getCuroddfare() {
		return curoddfare;
	}

	public void setCuroddfare(Double curoddfare) {
		this.curoddfare = curoddfare;
	}

	public Date getAuthtime() {
		return authtime;
	}

	public void setAuthtime(Date authtime) {
		this.authtime = authtime;
	}

	public Double getAllowoverdraftfare() {
		return allowoverdraftfare;
	}

	public void setAllowoverdraftfare(Double allowoverdraftfare) {
		this.allowoverdraftfare = allowoverdraftfare;
	}

	public Long getMaxlimitdate() {
		return maxlimitdate;
	}

	public void setMaxlimitdate(Long maxlimitdate) {
		this.maxlimitdate = maxlimitdate;
	}

	public String getIsuse() {
		return isuse;
	}

	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}

	public String getWorkstatus() {
		return workstatus;
	}

	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}

	public Date getLimitenddate() {
		return limitenddate;
	}

	public void setLimitenddate(Date limitenddate) {
		this.limitenddate = limitenddate;
	}

	public Double getMaxlimitfare() {
		return maxlimitfare;
	}

	public void setMaxlimitfare(Double maxlimitfare) {
		this.maxlimitfare = maxlimitfare;
	}

	public Double getSumfare() {
		return sumfare;
	}

	public void setSumfare(Double sumfare) {
		this.sumfare = sumfare;
	}

	public Date getAllowoverdraftopdt() {
		return allowoverdraftopdt;
	}

	public void setAllowoverdraftopdt(Date allowoverdraftopdt) {
		this.allowoverdraftopdt = allowoverdraftopdt;
	}

	public Double getAllowoverdraftsumfare() {
		return allowoverdraftsumfare;
	}

	public void setAllowoverdraftsumfare(Double allowoverdraftsumfare) {
		this.allowoverdraftsumfare = allowoverdraftsumfare;
	}

	public String getNetsiteid() {
		return netsiteid;
	}

	public void setNetsiteid(String netsiteid) {
		this.netsiteid = netsiteid;
	}

	public String getEdit_person() {
		return edit_person;
	}

	public void setEdit_person(String edit_person) {
		this.edit_person = edit_person;
	}

	public Date getEdit_date() {
		return edit_date;
	}

	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}

}
