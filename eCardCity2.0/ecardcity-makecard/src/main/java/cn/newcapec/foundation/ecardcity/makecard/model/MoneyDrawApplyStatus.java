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
 * 领款充值申请计划状态变化表
 * @author wulimo
 *
 */
@Table(name = "money_draw_apply_status")
@Entity
public class MoneyDrawApplyStatus extends CommonModel{
	private static final long serialVersionUID = 4680731472443879539L;
	@Column(name="customerid",length=32)
	private String customerid;//客户账户
	@Column(name="planid",length=32)
	private String planid;//申请计划流水号，和领款表中的id对应
	@Column(name="oldstate",length=1)
	private String oldstate;//状态迁移前补助状态
	@Column(name="newstate",length=1)
	private String newstate;//迁移到的补助状态
	
	@Column(name="oldaffairstatus",length=1)
	private String oldaffairstatus;//状态迁移前事务状态
	@Column(name="newaffairstatus",length=1)
	private String newaffairstatus;//当前事务状态
	
	@Column(name="reason",length=1)
	private String reason;//迁移原因
	@Column(name="reasoncode")
	private Long reasoncode;//状态迁移原因代码（0－人工处理）
	
	@Column(name="asn")
	private Long asn;//卡应用序列号
	@Column(name="cardsn")
	private Long cardsn;//持卡序号
	
	@Column(name="poscode",length=20)
	private String poscode;//终端唯一编码
	@Column(name="businesstype",length=1)
	private String businesstype;//交易种类:1:消费;2:存款;3:取款;
	@Column(name="wallettype",length=1)
	private String wallettype;//钱包类型
	@Column(name="opcount")
	private Long opcount;//消费交易计数
	@Column(name="saveopcount")
	private Long saveopcount;//充值交易计数
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
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	public String getOldstate() {
		return oldstate;
	}
	public void setOldstate(String oldstate) {
		this.oldstate = oldstate;
	}
	public String getNewstate() {
		return newstate;
	}
	public void setNewstate(String newstate) {
		this.newstate = newstate;
	}
	public String getOldaffairstatus() {
		return oldaffairstatus;
	}
	public void setOldaffairstatus(String oldaffairstatus) {
		this.oldaffairstatus = oldaffairstatus;
	}
	public String getNewaffairstatus() {
		return newaffairstatus;
	}
	public void setNewaffairstatus(String newaffairstatus) {
		this.newaffairstatus = newaffairstatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Long getReasoncode() {
		return reasoncode;
	}
	public void setReasoncode(Long reasoncode) {
		this.reasoncode = reasoncode;
	}
	public Long getAsn() {
		return asn;
	}
	public void setAsn(Long asn) {
		this.asn = asn;
	}
	public Long getCardsn() {
		return cardsn;
	}
	public void setCardsn(Long cardsn) {
		this.cardsn = cardsn;
	}
	public String getPoscode() {
		return poscode;
	}
	public void setPoscode(String poscode) {
		this.poscode = poscode;
	}
	public String getBusinesstype() {
		return businesstype;
	}
	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
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
