package cn.newcapec.foundation.ecardcity.makecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.newcapec.framework.core.model.CommonModel;

/**
 * 当前卡应用金额表
 * 
 * @author wulimo
 * 
 */
@Table(name = "card_money_sum")
@Entity
public class CardMoneySum extends CommonModel {
	private static final long serialVersionUID = -1376947193493198334L;
	@Column(name = "appinfo_id", length = 32)
	private String appinfo_id;// 卡信息表id
	@Column(name = "wallettype", length = 1)
	private String wallettype;// 钱包类型
	@Column(name = "opcount")
	private Long opcount;// 消费操作计数（交易后）
	@Column(name = "saveopcount")
	private Long saveopcount;// 存款操作计数（交易后）
	@Column(name = "oddfare")
	private Double oddfare;// 卡余额（交易后）
	@Column(name = "oddfareacc")
	private Double oddfareacc;// 系统余额
	@Column(name = "sumconsumefare")
	private Double sumconsumefare;// 消费额累加
	@Column(name = "sumaddfare")
	private Double sumaddfare;// 加款额累加
	@Column(name = "sumqc")
	private Double sumqc;// 圈存累加
	@Column(name = "sumload")
	private Double sumload;// 取款累加
	@Column(name = "sumsave")
	private Double sumsave;// 存款累加

	public String getAppinfo_id() {
		return appinfo_id;
	}

	public void setAppinfo_id(String appinfo_id) {
		this.appinfo_id = appinfo_id;
	}

	public String getWallettype() {
		return wallettype;
	}

	public void setWallettype(String wallettype) {
		this.wallettype = wallettype;
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

	public Double getOddfare() {
		return oddfare;
	}

	public void setOddfare(Double oddfare) {
		this.oddfare = oddfare;
	}

	public Double getOddfareacc() {
		return oddfareacc;
	}

	public void setOddfareacc(Double oddfareacc) {
		this.oddfareacc = oddfareacc;
	}

	public Double getSumconsumefare() {
		return sumconsumefare;
	}

	public void setSumconsumefare(Double sumconsumefare) {
		this.sumconsumefare = sumconsumefare;
	}

	public Double getSumaddfare() {
		return sumaddfare;
	}

	public void setSumaddfare(Double sumaddfare) {
		this.sumaddfare = sumaddfare;
	}

	public Double getSumqc() {
		return sumqc;
	}

	public void setSumqc(Double sumqc) {
		this.sumqc = sumqc;
	}

	public Double getSumload() {
		return sumload;
	}

	public void setSumload(Double sumload) {
		this.sumload = sumload;
	}

	public Double getSumsave() {
		return sumsave;
	}

	public void setSumsave(Double sumsave) {
		this.sumsave = sumsave;
	}

}
