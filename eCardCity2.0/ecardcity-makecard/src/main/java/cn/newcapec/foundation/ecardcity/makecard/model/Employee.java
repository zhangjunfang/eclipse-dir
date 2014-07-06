package cn.newcapec.foundation.ecardcity.makecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.newcapec.framework.core.model.CommonModel;

/**
 * 
 * @Description: 操作员 实体
 * @author  高崇飞
 * @date 2014-4-21 下午02:46:41
 * @version V1.0
 */
@Entity
@Table(name = "base_employee")
public class Employee extends CommonModel{

	private static final long serialVersionUID = -693841966186554489L;
	/* 网点ID */
	@Column(name = "netsite_id", length = 12)
	private String netsite_id;
	/* 银行账户ID */
	@Column(name = "bank_id", length = 12)
	private String bank_id;
	/* 允许销售卡类型，用英文逗号分隔的类型ID */
	@Column(name = "sale_cardtype", length = 2000)
	private String sale_cardtype;
	/* 允许充值卡类型，用英文逗号分隔的类型ID */
	@Column(name = "cash_cardtype", length = 2000)
	private String cash_cardtype;
	/* 存款权限（0：无存款权限 1：有存款权限） */
	@Column(name = "privilege_cashin")
	private String privilege_cashin;
	/* 取款权限（0：无取款权限 1：有取款权限） */
	@Column(name = "privilege_cashout")
	private String privilege_cashout;
	/* POS机操作权限（0：无  1：有） */
	@Column(name = "privilege_pos")
	private String privilege_pos;
	/* 登录权限（0：无  1：有） */
	@Column(name = "privilege_login")
	private String privilege_login;
	/* 版本记录号 */
	@Column(name = "ver", length = 5)
	private String ver;
	/* 职员ID */
	@Column(name = "empid", length = 10)
	private String empid;
	/* 状态标记1-删除  0-正常*/
	@Column(name = "status", length = 2)
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getNetsite_id() {
		return netsite_id;
	}
	public void setNetsite_id(String netsite_id) {
		this.netsite_id = netsite_id;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getCash_cardtype() {
		return cash_cardtype;
	}
	public void setCash_cardtype(String cash_cardtype) {
		this.cash_cardtype = cash_cardtype;
	}
	public String getPrivilege_cashin() {
		return privilege_cashin;
	}
	public void setPrivilege_cashin(String privilege_cashin) {
		this.privilege_cashin = privilege_cashin;
	}
	public String getPrivilege_cashout() {
		return privilege_cashout;
	}
	public void setPrivilege_cashout(String privilege_cashout) {
		this.privilege_cashout = privilege_cashout;
	}
	public String getPrivilege_pos() {
		return privilege_pos;
	}
	public void setPrivilege_pos(String privilege_pos) {
		this.privilege_pos = privilege_pos;
	}
	public String getPrivilege_login() {
		return privilege_login;
	}
	public void setPrivilege_login(String privilege_login) {
		this.privilege_login = privilege_login;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getSale_cardtype() {
		return sale_cardtype;
	}
	public void setSale_cardtype(String sale_cardtype) {
		this.sale_cardtype = sale_cardtype;
	}
	
}