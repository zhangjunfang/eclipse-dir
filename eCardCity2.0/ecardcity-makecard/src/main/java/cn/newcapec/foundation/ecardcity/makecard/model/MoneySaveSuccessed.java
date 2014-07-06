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
 * 存款记录成功表
 * 
 * @author wulimo
 * 
 */
@Table(name = "money_save_successed")
@Entity
public class MoneySaveSuccessed extends CommonModel {
	private static final long serialVersionUID = -3473026768205488937L;
	@Column(name = "planid", length = 32)
	private String planid;// 计划流水号
	@Column(name = "customerid", length = 32)
	private String customerid;// 账号
	@Column(name = "asn")
	private Long asn;// 应用序列号，洗卡时产生。
	@Column(name = "wallettype", length = 1)
	private String wallettype;// 钱包类型
	@Column(name = "cardsn")
	private Long cardsn;// 持卡序号
	@Column(name = "cardkind", length = 1)
	private String cardkind;// 卡类型 1：m1 2：cpu卡
	@Column(name = "cardtype", length = 32)
	private String cardtype;// 当前卡类型：指a卡、b卡、ab卡等
	@Column(name = "oddfare")
	private Double oddfare;// 卡余额（交易前）
	@Column(name = "opfare")
	private Double opfare;// 交易金额
	@Column(name = "opcount")
	private Long opcount;// 交易计数（交易前）
	@Column(name = "saveopcount")
	private Long saveopcount;// 存款交易计数
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "opdt")
	private Date opdt;// 交易时间
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "collectdt")
	private Date collectdt;// 采集时间
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statdate")
	private Date statdate;// 统计时间
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "uploaddate")
	private Date uploaddate;// 上传时间
	@Column(name = "transbatno")
	private Long transbatno;// 签到批次号（交易批次号）
	@Column(name = "correct", length = 1)
	private String correct;// 撤销标识，0-未撤销1-已撤销
	@Column(name = "recordstatus", length = 6)
	private String recordstatus; // 记录状态
									// 正常、灰色、MAC错误，支持8个。0x00：正常记录；0x01灰色记录；0x02MAC校验错
	@Column(name = "samtradeno")
	private Long samtradeno;// PSAM交易序号
	@Column(name = "postradeno")
	private Long postradeno;// 终端产生的，交易记录流水号，用于后期分析是否丢失记录
	@Column(name = "ver")
	private Long ver;//
	@Column(name = "netid", length = 12)
	private String netid; //
	@Column(name = "dscrp", length = 20)
	private String dscrp;// 描述
	@Column(name = "poscode", length = 20)
	private String poscode;// 设备唯一编号
	@Column(name = "samcardno")
	private Long samcardno;// psam卡号
	@Column(name = "tac", length = 16)
	private String tac;// tac验证码
	@Column(name = "businesstype", length = 1)
	private String businesstype;// 交易种类:1:消费;2:存款;3:取款;
	@Column(name = "acccode", length = 10)
	private String acccode;// 交易科目

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
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

	public Long getSaveopcount() {
		return saveopcount;
	}

	public void setSaveopcount(Long saveopcount) {
		this.saveopcount = saveopcount;
	}

	public Date getOpdt() {
		return opdt;
	}

	public void setOpdt(Date opdt) {
		this.opdt = opdt;
	}

	public Date getCollectdt() {
		return collectdt;
	}

	public void setCollectdt(Date collectdt) {
		this.collectdt = collectdt;
	}

	public Date getStatdate() {
		return statdate;
	}

	public void setStatdate(Date statdate) {
		this.statdate = statdate;
	}

	public Date getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
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

	public String getRecordstatus() {
		return recordstatus;
	}

	public void setRecordstatus(String recordstatus) {
		this.recordstatus = recordstatus;
	}

	public Long getSamtradeno() {
		return samtradeno;
	}

	public void setSamtradeno(Long samtradeno) {
		this.samtradeno = samtradeno;
	}

	public Long getPostradeno() {
		return postradeno;
	}

	public void setPostradeno(Long postradeno) {
		this.postradeno = postradeno;
	}

	public Long getVer() {
		return ver;
	}

	public void setVer(Long ver) {
		this.ver = ver;
	}

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getDscrp() {
		return dscrp;
	}

	public void setDscrp(String dscrp) {
		this.dscrp = dscrp;
	}

	public String getPoscode() {
		return poscode;
	}

	public void setPoscode(String poscode) {
		this.poscode = poscode;
	}

	public Long getSamcardno() {
		return samcardno;
	}

	public void setSamcardno(Long samcardno) {
		this.samcardno = samcardno;
	}

	public String getTac() {
		return tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
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

}
