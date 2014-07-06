package cn.newcapec.foundation.ecardcity.makecard.util;

/**
 * 封装充值员、终端网点及授权信息
 * 
 * @author wulimo
 * 
 */
public class ACUserNetInfoForm {

	private String userId;// 用户
	private String userName;// 名称
	private String loginName;// 登录账号
	private String empId;// base_employee.ID
	private String deptId;// 部门Id
	private String deptCode;// 部门Code
	private String deptName;// 部门名称
	private String address;//
	// 终端
	private String termId;// 终端ID
	private String termname;// 终端名称
	private String merchantcode;// 商户代码
	private String poscode;// 上层指定的终端唯一编号
	/**
	 * 终端类型：1 读卡器 2 出纳机 3 圈存机 4 营业机 5 综合缴费
	 */
	private String typeid;// 终端类型编号
	private String siteid;// 网点编号
	// PSAM卡信息
	private String psamcardid;// PSAM卡ID
	private Long psamcardno;// PSAM卡号
	private String samcardname;// PSAM卡原始编号
	private Long samcardsn;// PSAM卡密钥系统卡序号
	private String samcardsnr;// PSAM卡应用系统的编号
	// 网点
	private String netid;// 网点编号
	private String netname;// 网点名称
	private String netjp;// 网点简称
	private String netstatus;// 网点状态 0：停用、1：正常
	private String nettype;// 网点类型（0：充值网点:1：综合网点）
	private String netkind;// 网点种类，0直属，1代理（代理网点记账方式不同）
	// 授权额度
	private String isuseauth;// 是否启用授权额度
	private String curoddfare;// 当前授权余额
	private String sumfare;// 累计授权额度
	private String bankId;// 账号

	public ACUserNetInfoForm() {
		super();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getTermname() {
		return termname;
	}

	public void setTermname(String termname) {
		this.termname = termname;
	}

	public String getMerchantcode() {
		return merchantcode;
	}

	public void setMerchantcode(String merchantcode) {
		this.merchantcode = merchantcode;
	}

	public String getPoscode() {
		return poscode;
	}

	public void setPoscode(String poscode) {
		this.poscode = poscode;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public Long getPsamcardno() {
		return psamcardno;
	}

	public void setPsamcardno(Long psamcardno) {
		this.psamcardno = psamcardno;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getNetname() {
		return netname;
	}

	public void setNetname(String netname) {
		this.netname = netname;
	}

	public String getNetjp() {
		return netjp;
	}

	public void setNetjp(String netjp) {
		this.netjp = netjp;
	}

	public String getNetstatus() {
		return netstatus;
	}

	public void setNetstatus(String netstatus) {
		this.netstatus = netstatus;
	}

	public String getNettype() {
		return nettype;
	}

	public void setNettype(String nettype) {
		this.nettype = nettype;
	}

	public String getNetkind() {
		return netkind;
	}

	public void setNetkind(String netkind) {
		this.netkind = netkind;
	}

	public String getIsuseauth() {
		return isuseauth;
	}

	public void setIsuseauth(String isuseauth) {
		this.isuseauth = isuseauth;
	}

	public String getCuroddfare() {
		return curoddfare;
	}

	public void setCuroddfare(String curoddfare) {
		this.curoddfare = curoddfare;
	}

	public String getSumfare() {
		return sumfare;
	}

	public void setSumfare(String sumfare) {
		this.sumfare = sumfare;
	}

	public String getPsamcardid() {
		return psamcardid;
	}

	public void setPsamcardid(String psamcardid) {
		this.psamcardid = psamcardid;
	}

	public String getSamcardname() {
		return samcardname;
	}

	public void setSamcardname(String samcardname) {
		this.samcardname = samcardname;
	}

	public Long getSamcardsn() {
		return samcardsn;
	}

	public void setSamcardsn(Long samcardsn) {
		this.samcardsn = samcardsn;
	}

	public String getSamcardsnr() {
		return samcardsnr;
	}

	public void setSamcardsnr(String samcardsnr) {
		this.samcardsnr = samcardsnr;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

}
