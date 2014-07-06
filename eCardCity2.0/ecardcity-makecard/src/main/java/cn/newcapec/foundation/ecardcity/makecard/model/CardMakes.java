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
 * 制卡信息(发卡信息)
 * 
 * @author wulimo
 * 
 */
@Table(name = "card_makes")
@Entity
public class CardMakes extends CommonModel {
	private static final long serialVersionUID = -7841205034141946843L;
	@Column(name = "customerid", length = 32)
	private String customerid;
	@Column(name = "asn")
	private Long asn;
	@Column(name = "old_asn")
	private Long old_asn;
	@Column(name = "cardsn")
	private Long cardsn;
	@Column(name = "scardsnr", length = 16)
	private String scardsnr;
	@Column(name = "pty", length = 1)
	private String pty;
	@Column(name = "wallettype", length = 1)
	private String wallettype;
	@Column(name = "cardkind", length = 32)
	private String cardkind;
	@Column(name = "cardtype", length = 32)
	private String cardtype;
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

	public Long getOld_asn() {
		return old_asn;
	}

	public void setOld_asn(Long old_asn) {
		this.old_asn = old_asn;
	}

	public Long getCardsn() {
		return cardsn;
	}

	public void setCardsn(Long cardsn) {
		this.cardsn = cardsn;
	}

	public String getScardsnr() {
		return scardsnr;
	}

	public void setScardsnr(String scardsnr) {
		this.scardsnr = scardsnr;
	}

	public String getPty() {
		return pty;
	}

	public void setPty(String pty) {
		this.pty = pty;
	}

	public String getWallettype() {
		return wallettype;
	}

	public void setWallettype(String wallettype) {
		this.wallettype = wallettype;
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
