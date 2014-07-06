package cn.newcapec.foundation.ecardcity.makecard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.newcapec.framework.core.model.CommonModel;

/**
 * 
 * @Description: 卡状态变化表
 * @author 高崇飞
 * @date 2014-5-20 下午02:46:41
 * @version V1.0
 */
@Entity
@Table(name = "card_status")
public class CardStatus extends CommonModel {

	private static final long serialVersionUID = -693841966186554489L;
	/* ASN业务系统生成的应用序列号，洗卡时产生。 */
	@Column(name = "asn")
	private String asn;
	/* 持卡序号，标示用户的第几张卡。补卡换卡后加1。 */
	@Column(name = "cardsn")
	private String cardsn;
	/* 0：消费卡状态变化 1：职员卡状态变化 */
	@Column(name = "status_flag")
	private String status_flag;
	/* 当前卡余额（状态变化后）,针对消费卡 */
	@Column(name = "oddfare")
	private String oddfare;
	/* 当前卡状态（状态变化后）0：睡眠、1：正常、3：挂失、4：解挂 */
	@Column(name = "status")
	private String status;
	/* 来源IP */
	@Column(name = "sourceip")
	private String sourceip;
	/* 终端ID */
	@Column(name = "termid")
	private String termid;
	/* 更新用户 */
	@Column(name = "edit_person")
	private String edit_person;
	/* 更新日期 */
	@Column(name = "edit_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date edit_date;
	/* 是否需要置黑 0:卡损坏引起的补卡，不需要置黑；1:卡丢失引起的补卡，需要置黑 */
	@Column(name = "black_name")
	private String black_name;

	public String getAsn() {
		return asn;
	}

	public void setAsn(String asn) {
		this.asn = asn;
	}

	public String getStatus_flag() {
		return status_flag;
	}

	public void setStatus_flag(String status_flag) {
		this.status_flag = status_flag;
	}

	public String getOddfare() {
		return oddfare;
	}

	public void setOddfare(String oddfare) {
		this.oddfare = oddfare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSourceip() {
		return sourceip;
	}

	public void setSourceip(String sourceip) {
		this.sourceip = sourceip;
	}

	public String getTermid() {
		return termid;
	}

	public void setTermid(String termid) {
		this.termid = termid;
	}

	public String getBlack_name() {
		return black_name;
	}

	public void setBlack_name(String black_name) {
		this.black_name = black_name;
	}

	public String getCardsn() {
		return cardsn;
	}

	public void setCardsn(String cardsn) {
		this.cardsn = cardsn;
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