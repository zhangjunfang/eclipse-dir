package cn.newcapec.foundation.ecardcity.makecard.util;
/**
 * 封装卡片相关的信息
 * @author wulimo
 *
 */
public class CardInfoForm{

	private String appinfoId;
	private String oddfare;//卡余额
	private String customerid;
	private String citycardno;//市民卡卡号（手工编号）
	private String asn16;//业务系统生成的应用序列号，洗卡时产生。16进制(前端读卡使用的)
	private String asn;//业务系统生成的应用序列号，洗卡时产生。10进制(与库中一致)
	private String scardsnr;//卡厂商生成的卡唯一号，不会发生变化
	private Long cardsn;//持卡序号
	private String cardkind;//卡种类【原：卡种类 1：M1卡 2：CPU卡】
	private String cardtype;//卡类型
	private String cardstatus;//卡状态 【原：0：睡眠、1：正常、3：挂失】
	private String wallettype;//钱包类型
	private String opcount;//消费操作计数
	private String saveopcount;//加款操作计数
	
	public CardInfoForm() {
		super();
	}

	public String getAsn16() {
		return asn16;
	}

	public void setAsn16(String asn16) {
		this.asn16 = asn16;
	}

	public String getAppinfoId() {
		return appinfoId;
	}

	public void setAppinfoId(String appinfoId) {
		this.appinfoId = appinfoId;
	}

	public String getOddfare() {
		return oddfare;
	}

	public void setOddfare(String oddfare) {
		this.oddfare = oddfare;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCitycardno() {
		return citycardno;
	}

	public void setCitycardno(String citycardno) {
		this.citycardno = citycardno;
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

	public String getWallettype() {
		return wallettype;
	}

	public void setWallettype(String wallettype) {
		this.wallettype = wallettype;
	}

	public String getOpcount() {
		return opcount;
	}

	public void setOpcount(String opcount) {
		this.opcount = opcount;
	}

	public String getSaveopcount() {
		return saveopcount;
	}

	public void setSaveopcount(String saveopcount) {
		this.saveopcount = saveopcount;
	}

	public Long getCardsn() {
		return cardsn;
	}

	public void setCardsn(Long cardsn) {
		this.cardsn = cardsn;
	}
	

}
