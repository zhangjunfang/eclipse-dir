
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
 * @Description: 职员卡表实体
 * @author  高崇飞
 * @date 2014-4-21 下午02:46:41
 * @version V1.0
 */
@Entity
@Table(name = "card_employee")
public class CardEmployee extends CommonModel{

	private static final long serialVersionUID = -693841966186554489L;
	/* 职员ID */
	@Column(name = "empid")
	private String empid;
	/* ASN业务系统生成的应用序列号，洗卡时产生。 */
	@Column(name = "asn")
	private String asn;
	/* 卡厂商生成的卡唯一号，不会发生变化。 */
	@Column(name = "scardsnr")
	private String scardsnr;
	/* 持卡序号，标示用户的第几张卡。补卡换卡后加1。*/
	@Column(name = "cardsn")
	private String cardsn;
	/* CARDTYPE 卡类型*/
	@Column(name = "cardtype")
	private String cardtype;
	/* 卡状态，根据字典类别查找并引用【原：0：睡眠、1：正常、3：挂失】 */
	@Column(name = "cardstatus")
	private String cardstatus;
	/* 卡标识：0：历史 1：正常 */
	@Column(name = "cardflag")
	private String cardflag;
	/* 卡密码 */
	@Column(name = "pwd")
	private String pwd;
	/* 信息变更版本号 */
	@Column(name = "ver")
	private String ver;
	/* 更新用户 */
	@Column(name = "edit_person")
	private String edit_person;
	/* 更新日期 */
	@Column(name = "edit_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date edit_date;
	/* 失效时间 */
	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiry_date;
	/* 挂失时间 */
	@Column(name = "loss_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date loss_date;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getAsn() {
		return asn;
	}
	public void setAsn(String asn) {
		this.asn = asn;
	}
	public String getScardsnr() {
		return scardsnr;
	}
	public void setScardsnr(String scardsnr) {
		this.scardsnr = scardsnr;
	}
	public String getCardsn() {
		return cardsn;
	}
	public void setCardsn(String cardsn) {
		this.cardsn = cardsn;
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
	public String getCardflag() {
		return cardflag;
	}
	public void setCardflag(String cardflag) {
		this.cardflag = cardflag;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
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
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public Date getLoss_date() {
		return loss_date;
	}
	public void setLoss_date(Date loss_date) {
		this.loss_date = loss_date;
	}
	
}