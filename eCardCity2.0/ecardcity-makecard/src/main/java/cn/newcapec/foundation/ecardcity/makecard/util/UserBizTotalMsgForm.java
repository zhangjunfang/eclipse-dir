package cn.newcapec.foundation.ecardcity.makecard.util;

/**
 * 封装充值员业务统计信息
 * 
 * @author wulimo
 * 
 */
public class UserBizTotalMsgForm {
	private String userId;// 用户
	private String userName;// 名称
	private String loginName;// 登录账号
	private String empId;// base_employee.ID
	private String deptId;// 部门Id
	private String deptCode;// 部门Code
	private String deptName;// 部门名称
	private String address;//
	private String saleCardtype;// 售卡的小类型
	private String cashCardtype;// 充值的卡小类型
	private String isCanLogin;// 是否可登陆

	// 授权额度
	private String bankId;// 账号
	private String isUseAuth;// 是否启用授权额度
	private String currOddFare; // 当前授权余额
	private String currCntIn; // 总收入金额
	private String currCntOut; // 总支出金额
	private String currSellCardNum;// 售卡张数：0
	private String currAddChargeNum;// 钱包充值张数：0
	private String currUnAddChargeNum;// 充值撤销张数：0
	private String currPutRightNum;// 消费纠错张数：0
	private String currPutRightCash;// 消费纠错金额：0.00
	private String currRenewCardNum;// 补卡张数：0
	private String currCardLossNum;// 挂失张数：0
	private String currHasCardLogoutNum;// 有卡销户张数：0
	private String currNoCardLogoutNum;// 无卡销户张数：0
	private String currSellCardCash;// 售卡收费金额：0.00
	private String currAddChargeCash;// 钱包充值金额：0.00
	private String currUnAddChargeCash;// 充值撤销金额：0.00
	private String currGetFrozenCash;// 领取冻结金额：0.00
	private String currCardUnLossNum;// 解挂张数：0
	private String currHasCardLogoutCash;// 有卡销户金额：0.00
	private String currNoCardLogoutCash;// 无卡销户金额：0.00

	public String getCurrPutRightNum() {
		return currPutRightNum;
	}

	public String getIsCanLogin() {
		return isCanLogin;
	}

	public void setIsCanLogin(String isCanLogin) {
		this.isCanLogin = isCanLogin;
	}

	public String getSaleCardtype() {
		return saleCardtype;
	}

	public void setSaleCardtype(String saleCardtype) {
		this.saleCardtype = saleCardtype;
	}

	public String getCashCardtype() {
		return cashCardtype;
	}

	public void setCashCardtype(String cashCardtype) {
		this.cashCardtype = cashCardtype;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
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

	public void setCurrPutRightNum(String currPutRightNum) {
		this.currPutRightNum = currPutRightNum;
	}

	public String getCurrPutRightCash() {
		return currPutRightCash;
	}

	public void setCurrPutRightCash(String currPutRightCash) {
		this.currPutRightCash = currPutRightCash;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getIsUseAuth() {
		return isUseAuth;
	}

	public void setIsUseAuth(String isUseAuth) {
		this.isUseAuth = isUseAuth;
	}

	public String getCurrOddFare() {
		return currOddFare;
	}

	public void setCurrOddFare(String currOddFare) {
		this.currOddFare = currOddFare;
	}

	public String getCurrCntIn() {
		return currCntIn;
	}

	public void setCurrCntIn(String currCntIn) {
		this.currCntIn = currCntIn;
	}

	public String getCurrCntOut() {
		return currCntOut;
	}

	public void setCurrCntOut(String currCntOut) {
		this.currCntOut = currCntOut;
	}

	public String getCurrSellCardNum() {
		return currSellCardNum;
	}

	public void setCurrSellCardNum(String currSellCardNum) {
		this.currSellCardNum = currSellCardNum;
	}

	public String getCurrAddChargeNum() {
		return currAddChargeNum;
	}

	public void setCurrAddChargeNum(String currAddChargeNum) {
		this.currAddChargeNum = currAddChargeNum;
	}

	public String getCurrUnAddChargeNum() {
		return currUnAddChargeNum;
	}

	public void setCurrUnAddChargeNum(String currUnAddChargeNum) {
		this.currUnAddChargeNum = currUnAddChargeNum;
	}

	public String getCurrRenewCardNum() {
		return currRenewCardNum;
	}

	public void setCurrRenewCardNum(String currRenewCardNum) {
		this.currRenewCardNum = currRenewCardNum;
	}

	public String getCurrCardLossNum() {
		return currCardLossNum;
	}

	public void setCurrCardLossNum(String currCardLossNum) {
		this.currCardLossNum = currCardLossNum;
	}

	public String getCurrHasCardLogoutNum() {
		return currHasCardLogoutNum;
	}

	public void setCurrHasCardLogoutNum(String currHasCardLogoutNum) {
		this.currHasCardLogoutNum = currHasCardLogoutNum;
	}

	public String getCurrNoCardLogoutNum() {
		return currNoCardLogoutNum;
	}

	public void setCurrNoCardLogoutNum(String currNoCardLogoutNum) {
		this.currNoCardLogoutNum = currNoCardLogoutNum;
	}

	public String getCurrSellCardCash() {
		return currSellCardCash;
	}

	public void setCurrSellCardCash(String currSellCardCash) {
		this.currSellCardCash = currSellCardCash;
	}

	public String getCurrAddChargeCash() {
		return currAddChargeCash;
	}

	public void setCurrAddChargeCash(String currAddChargeCash) {
		this.currAddChargeCash = currAddChargeCash;
	}

	public String getCurrUnAddChargeCash() {
		return currUnAddChargeCash;
	}

	public void setCurrUnAddChargeCash(String currUnAddChargeCash) {
		this.currUnAddChargeCash = currUnAddChargeCash;
	}

	public String getCurrGetFrozenCash() {
		return currGetFrozenCash;
	}

	public void setCurrGetFrozenCash(String currGetFrozenCash) {
		this.currGetFrozenCash = currGetFrozenCash;
	}

	public String getCurrCardUnLossNum() {
		return currCardUnLossNum;
	}

	public void setCurrCardUnLossNum(String currCardUnLossNum) {
		this.currCardUnLossNum = currCardUnLossNum;
	}

	public String getCurrHasCardLogoutCash() {
		return currHasCardLogoutCash;
	}

	public void setCurrHasCardLogoutCash(String currHasCardLogoutCash) {
		this.currHasCardLogoutCash = currHasCardLogoutCash;
	}

	public String getCurrNoCardLogoutCash() {
		return currNoCardLogoutCash;
	}

	public void setCurrNoCardLogoutCash(String currNoCardLogoutCash) {
		this.currNoCardLogoutCash = currNoCardLogoutCash;
	}

	public UserBizTotalMsgForm() {
		super();
	}

}
