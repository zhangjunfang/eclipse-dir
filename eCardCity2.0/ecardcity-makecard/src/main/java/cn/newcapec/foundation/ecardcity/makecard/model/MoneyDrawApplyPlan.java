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
 * 领款充值申请计划表
 * @author wulimo
 *
 */
@Table(name = "money_draw_apply_plan")
@Entity
public class MoneyDrawApplyPlan extends CommonModel{
	private static final long serialVersionUID = -3786464377151972557L;
	@Column(name="customerid",length=32)
	private String customerid;//账号
	@Column(name="asn")
	private Long asn;//应用序列号，洗卡时产生。
	@Column(name="wallettype",length=1)
	private String wallettype;//钱包类型
	@Column(name="cardsn")
	private Long cardsn;//持卡序号
	@Column(name="cardkind",length=1)
	private String cardkind;//卡类型 1：m1   2：cpu卡
	@Column(name="cardtype",length=32)
	private String cardtype;//当前卡类型：指a卡、b卡、ab卡等
	@Column(name="oddfare")
	private Double oddfare;//卡余额（交易前）
	@Column(name="opfare")
	private Double opfare;//交易金额
	@Column(name="opcount")
	private Long opcount;//交易计数（交易前）
	@Column(name="status",length=1)
	private String status;//0:准备状态，1：允许发放，2：停止发放
	@Column(name="affairstatus",length=1)
	private String affairstatus;//事务状态：0：初始状态，1：申请状态，2：提交，3：回滚，4：挂起
	@Column(name="descrition",length=50)
	private String descrition;//描述
	@Column(name="poscode",length=20)
	private String poscode;//设备唯一编号
	@Column(name="psamcardno")
	private Long psamcardno;//psam卡号
	@Column(name="tac",length=16)
	private String tac;//tac验证码
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "firstdt")
	private Date firstdt;//第一次领款时间
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdt")
	private Date createdt;//准备日期
	@JsonSerialize(using = CustomDateSerializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "oppzwdate")
	private Date oppzwdate;//第三方账务日期
	@Column(name="oppaccfc")
	private Long oppaccfc;//第三方流水
	@Column(name="presaveopcount")
	private Long presaveopcount;//申请操作计数
	@Column(name="saveopcount")
	private Long saveopcount;//提交操作计数
	@Column(name="businesstype",length=1)
	private String businesstype;//交易种类:1:消费;2:存款;3:取款;
	@Column(name="acccode",length=10)
	private String acccode;//交易科目
	@Column(name="transbatno")
	private Long transbatno;//签到批次号
	@Column(name="correct",length=1)
	private String correct;//撤销标识，0-未撤销1-已撤销
	@Column(name="cstaccfc",length=32)
	private String cstaccfc;//消费流水
	@Column(name="edit_person",length=32)
	private String edit_person;//更新用户
    @JsonSerialize(using = CustomDateSerializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "edit_date")
	private Date edit_date;//更新日期
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
	public String getWallettype() {
		return wallettype;
	}
	public void setWallettype(String wallettype) {
		this.wallettype = wallettype;
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
	public Double getOddfare() {
		return oddfare;
	}
	public void setOddfare(Double oddfare) {
		this.oddfare = oddfare;
	}
	public Double getOpfare() {
		return opfare;
	}
	public void setOpfare(Double opfare) {
		this.opfare = opfare;
	}
	public Long getOpcount() {
		return opcount;
	}
	public void setOpcount(Long opcount) {
		this.opcount = opcount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAffairstatus() {
		return affairstatus;
	}
	public void setAffairstatus(String affairstatus) {
		this.affairstatus = affairstatus;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getPoscode() {
		return poscode;
	}
	public void setPoscode(String poscode) {
		this.poscode = poscode;
	}
	public Long getPsamcardno() {
		return psamcardno;
	}
	public void setPsamcardno(Long psamcardno) {
		this.psamcardno = psamcardno;
	}
	public String getTac() {
		return tac;
	}
	public void setTac(String tac) {
		this.tac = tac;
	}
	public Date getFirstdt() {
		return firstdt;
	}
	public void setFirstdt(Date firstdt) {
		this.firstdt = firstdt;
	}
	public Date getCreatedt() {
		return createdt;
	}
	public void setCreatedt(Date createdt) {
		this.createdt = createdt;
	}
	public Date getOppzwdate() {
		return oppzwdate;
	}
	public void setOppzwdate(Date oppzwdate) {
		this.oppzwdate = oppzwdate;
	}
	public Long getOppaccfc() {
		return oppaccfc;
	}
	public void setOppaccfc(Long oppaccfc) {
		this.oppaccfc = oppaccfc;
	}
	public Long getPresaveopcount() {
		return presaveopcount;
	}
	public void setPresaveopcount(Long presaveopcount) {
		this.presaveopcount = presaveopcount;
	}
	public Long getSaveopcount() {
		return saveopcount;
	}
	public void setSaveopcount(Long saveopcount) {
		this.saveopcount = saveopcount;
	}
	public String getBusinesstype() {
		return businesstype;
	}
	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}
	public String getAcccode() {
		return acccode;
	}
	public void setAcccode(String acccode) {
		this.acccode = acccode;
	}
	public Long getTransbatno() {
		return transbatno;
	}
	public void setTransbatno(Long transbatno) {
		this.transbatno = transbatno;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public String getCstaccfc() {
		return cstaccfc;
	}
	public void setCstaccfc(String cstaccfc) {
		this.cstaccfc = cstaccfc;
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
