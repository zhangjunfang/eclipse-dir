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
 * 手续费(发卡信息)
 * 
 * @author wulimo
 * 
 */
@Table(name = "fare_cost")
@Entity
public class FareCost extends CommonModel {
	private static final long serialVersionUID = 1768252843099106127L;
	@Column(name = "customerid", length = 32)
	private String customerid;
	@Column(name = "asn")
	private Long asn;
	@Column(name = "opfare")
	private Double opfare;// 交易金额
	@Column(name = "acccode", length = 10)
	private String acccode;// 科目代码
	@Column(name = "dscrp", length = 20)
	private String dscrp;// 代码描述
	@Column(name = "hasreturn", length = 1)
	private String hasreturn;// 是否已退卡成本 0：初始值 2：已退
	@Column(name = "cardkind", length = 32)
	private String cardkind;
	@Column(name = "cardtype", length = 32)
	private String cardtype;
	@Column(name = "opfare")
	private Double accfare;// 应收金额
	@Column(name = "accfare", length = 1)
	private String ischarge;// 是否收费，0系统规定不收费，1收费 2 出纳员不收费
	@Column(name = "edit_person", length = 32)
	private String edit_person;
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edit_date")
	private Date edit_date;

	public Double getOpfare() {
		return opfare;
	}

	public void setOpfare(Double opfare) {
		this.opfare = opfare;
	}

	public String getAcccode() {
		return acccode;
	}

	public void setAcccode(String acccode) {
		this.acccode = acccode;
	}

	public String getDscrp() {
		return dscrp;
	}

	public void setDscrp(String dscrp) {
		this.dscrp = dscrp;
	}

	public String getHasreturn() {
		return hasreturn;
	}

	public void setHasreturn(String hasreturn) {
		this.hasreturn = hasreturn;
	}

	public Double getAccfare() {
		return accfare;
	}

	public void setAccfare(Double accfare) {
		this.accfare = accfare;
	}

	public String getIscharge() {
		return ischarge;
	}

	public void setIscharge(String ischarge) {
		this.ischarge = ischarge;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public Long getAsn() {
		return asn;
	}

	public void setAsn(Long asn) {
		this.asn = asn;
	}

	public String getCardkind() {
		return cardkind;
	}

	public void setCardkind(String cardkind) {
		this.cardkind = cardkind;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
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
