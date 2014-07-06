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
 * 卡年检信息
 * 
 * @author wulimo
 * 
 */
@Table(name = "card_annual_inspection")
@Entity
public class CardAnnualInspection extends CommonModel {
	private static final long serialVersionUID = 2591404545418626280L;
	@Column(name = "poscode", length = 20)
	private String poscode;// POS设备唯一编号
	@Column(name = "asn")
	private Long asn;
	@Column(name = "annual_inspection_result", length = 1)
	private String annual_inspection_result;// 年检操作结果 0：失败 1：成功
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pre_annual_inspection_start")
	private Date pre_annual_inspection_start;
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pre_annual_inspection_end")
	private Date pre_annual_inspection_end;
	@Column(name = "edit_person", length = 32)
	private String edit_person;
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edit_date")
	private Date edit_date;

	public String getPoscode() {
		return poscode;
	}

	public void setPoscode(String poscode) {
		this.poscode = poscode;
	}

	public String getAnnual_inspection_result() {
		return annual_inspection_result;
	}

	public void setAnnual_inspection_result(String annual_inspection_result) {
		this.annual_inspection_result = annual_inspection_result;
	}

	public Date getPre_annual_inspection_start() {
		return pre_annual_inspection_start;
	}

	public void setPre_annual_inspection_start(Date pre_annual_inspection_start) {
		this.pre_annual_inspection_start = pre_annual_inspection_start;
	}

	public Date getPre_annual_inspection_end() {
		return pre_annual_inspection_end;
	}

	public void setPre_annual_inspection_end(Date pre_annual_inspection_end) {
		this.pre_annual_inspection_end = pre_annual_inspection_end;
	}

	public Long getAsn() {
		return asn;
	}

	public void setAsn(Long asn) {
		this.asn = asn;
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
