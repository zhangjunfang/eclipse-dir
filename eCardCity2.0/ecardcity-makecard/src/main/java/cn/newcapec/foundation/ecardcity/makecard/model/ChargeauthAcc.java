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
 * 授权余额变更表
 * @author wulimo
 *
 */
@Table(name = "chargeauth_acc")
@Entity
public class ChargeauthAcc extends CommonModel{
	private static final long serialVersionUID = -743909869722577871L;
	@Column(name="netsiteid",length=32)
	private String netsiteid;//网点id
	@Column(name="curoddfare")
	private Double curoddfare;//当前授权额度
	@Column(name="lastoddfare")
	private Double lastoddfare;//授权前余额
	@Column(name="opfare")
	private Double opfare;//本次操作金额
	@Column(name="allowoverdraftfare")
	private Double allowoverdraftfare;//允许透支金额
	@Column(name="maxlimitdate")
	private Long maxlimitdate;//最大逾期（天）
	@Column(name="isuse",length=1)
	private String isuse;//是否启用充值授权额度，0：不启用，1：启用
	@Column(name="sumfare")
	private Double sumfare;//授权额度累计
	@Column(name="customerunitcode",length=12)
	private String customerunitcode;//客户代码
	@Column(name="dir",length=2)
	private String dir;//变化标识：-1 减少   0 不变   1 增加
	@Column(name="flag",length=1)
	private String flag;//授权标识：0 增加授权额操作 1 额度上下级分配操作
	@Column(name="changedptcode",length=9)
	private String changedptcode;//部门编码：该字段配合dir和flag标记使用，当flag标记是1时，dir=0的表示额度分配增加额度的部门，dir=1的表示额度分配减少额度的部门  如果flag=0的话，changedptcode和dptcode一致
	@Column(name="typeflag",length=1)
	private String typeflag;//业务类型：（和dir字段配合使用） 0 授权额度变化   1 最大授权额度变化   2透支额度变化   3最大逾期变化
	@Column(name="maxlimitfare")
	private Double maxlimitfare;//最大授权额度（上级网点对下级网点授权金额）
	@Column(name="edit_person",length=32)
	private String edit_person;//更新用户
    @JsonSerialize(using = CustomDateSerializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "edit_date")
	private Date edit_date;//更新日期
	public String getNetsiteid() {
		return netsiteid;
	}
	public void setNetsiteid(String netsiteid) {
		this.netsiteid = netsiteid;
	}
	public Double getCuroddfare() {
		return curoddfare;
	}
	public void setCuroddfare(Double curoddfare) {
		this.curoddfare = curoddfare;
	}
	public Double getLastoddfare() {
		return lastoddfare;
	}
	public void setLastoddfare(Double lastoddfare) {
		this.lastoddfare = lastoddfare;
	}
	public Double getOpfare() {
		return opfare;
	}
	public void setOpfare(Double opfare) {
		this.opfare = opfare;
	}
	public Double getAllowoverdraftfare() {
		return allowoverdraftfare;
	}
	public void setAllowoverdraftfare(Double allowoverdraftfare) {
		this.allowoverdraftfare = allowoverdraftfare;
	}
	public Long getMaxlimitdate() {
		return maxlimitdate;
	}
	public void setMaxlimitdate(Long maxlimitdate) {
		this.maxlimitdate = maxlimitdate;
	}
	public String getIsuse() {
		return isuse;
	}
	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}
	public Double getSumfare() {
		return sumfare;
	}
	public void setSumfare(Double sumfare) {
		this.sumfare = sumfare;
	}
	public String getCustomerunitcode() {
		return customerunitcode;
	}
	public void setCustomerunitcode(String customerunitcode) {
		this.customerunitcode = customerunitcode;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getChangedptcode() {
		return changedptcode;
	}
	public void setChangedptcode(String changedptcode) {
		this.changedptcode = changedptcode;
	}
	public String getTypeflag() {
		return typeflag;
	}
	public void setTypeflag(String typeflag) {
		this.typeflag = typeflag;
	}
	public Double getMaxlimitfare() {
		return maxlimitfare;
	}
	public void setMaxlimitfare(Double maxlimitfare) {
		this.maxlimitfare = maxlimitfare;
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
