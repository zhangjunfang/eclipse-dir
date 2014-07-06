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
 * 卡应用信息
 * 
 * @author wulimo
 * 
 */
@Table(name = "card_appinfo")
@Entity
public class CardAppinfo extends CommonModel {
	private static final long serialVersionUID = -3347324002396153840L;
	@Column(name = "customerid", length = 32)
	private String customerid;
	@Column(name = "asn")
	private Long asn;
	@Column(name = "citycardno", length = 20)
	private String citycardno;
	@Column(name = "scardsnr", length = 16)
	private String scardsnr;
	@Column(name = "cardsn")
	private Long cardsn;
	@Column(name = "cardkind", length = 32)
	private String cardkind;
	@Column(name = "cardtype", length = 32)
	private String cardtype;
	@Column(name = "cardstatus", length = 1)
	private String cardstatus;
	@Column(name = "flag", length = 1)
	private String flag;
	@Column(name = "cardflag", length = 1)
	private String cardflag;
	@Column(name = "carduse")
	private Long carduse;
	@Column(name = "pwd", length = 32)
	private String pwd;
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lossdt")
	private Date lossdt;
	@Column(name = "searchpwd", length = 32)
	private String searchpwd;
	@Column(name = "ver")
	private Long ver;
	@Column(name = "mark_name", length = 1)
	private String mark_name;
	@Column(name = "is_annual_inspection", length = 1)
	private String is_annual_inspection;
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "annual_inspection_start")
	private Date annual_inspection_start;
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "annual_inspection_end")
	private Date annual_inspection_end;
	@Column(name = "edit_person", length = 32)
	private String edit_person;
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edit_date")
	private Date edit_date;

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

	public String getCitycardno() {
		return citycardno;
	}

	public void setCitycardno(String citycardno) {
		this.citycardno = citycardno;
	}

	public String getScardsnr() {
		return scardsnr;
	}

	public void setScardsnr(String scardsnr) {
		this.scardsnr = scardsnr;
	}

	public Long getCardsn() {
		return cardsn;
	}

	public void setCardsn(Long cardsn) {
		this.cardsn = cardsn;
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

	public String getCardstatus() {
		return cardstatus;
	}

	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCardflag() {
		return cardflag;
	}

	public void setCardflag(String cardflag) {
		this.cardflag = cardflag;
	}

	public Long getCarduse() {
		return carduse;
	}

	public void setCarduse(Long carduse) {
		this.carduse = carduse;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getLossdt() {
		return lossdt;
	}

	public void setLossdt(Date lossdt) {
		this.lossdt = lossdt;
	}

	public String getSearchpwd() {
		return searchpwd;
	}

	public void setSearchpwd(String searchpwd) {
		this.searchpwd = searchpwd;
	}

	public Long getVer() {
		return ver;
	}

	public void setVer(Long ver) {
		this.ver = ver;
	}

	public String getMark_name() {
		return mark_name;
	}

	public void setMark_name(String mark_name) {
		this.mark_name = mark_name;
	}

	public String getIs_annual_inspection() {
		return is_annual_inspection;
	}

	public void setIs_annual_inspection(String is_annual_inspection) {
		this.is_annual_inspection = is_annual_inspection;
	}

	public Date getAnnual_inspection_start() {
		return annual_inspection_start;
	}

	public void setAnnual_inspection_start(Date annual_inspection_start) {
		this.annual_inspection_start = annual_inspection_start;
	}

	public Date getAnnual_inspection_end() {
		return annual_inspection_end;
	}

	public void setAnnual_inspection_end(Date annual_inspection_end) {
		this.annual_inspection_end = annual_inspection_end;
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
