package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseMoneyDrawApplyFailure;



public class MoneyDrawApplyFailure extends BaseMoneyDrawApplyFailure {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MoneyDrawApplyFailure () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MoneyDrawApplyFailure (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MoneyDrawApplyFailure (
		java.lang.String id,
		java.lang.String planid,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String wallettype,
		java.lang.Integer cardsn,
		java.lang.String cardkind,
		java.lang.String cardtype,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal opfare,
		java.lang.Integer opcount,
		java.lang.String status,
		java.lang.String affairstatus,
		java.lang.String recordstatus,
		java.lang.String isdelete,
		java.lang.String poscode,
		java.lang.Integer psamcardno,
		java.lang.Integer postradeno,
		java.lang.Integer samtradeno,
		java.lang.Integer presaveopcount,
		java.lang.Integer saveopcount,
		java.lang.String businesstype,
		java.lang.String acccode,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			planid,
			customerid,
			asn,
			wallettype,
			cardsn,
			cardkind,
			cardtype,
			oddfare,
			opfare,
			opcount,
			status,
			affairstatus,
			recordstatus,
			isdelete,
			poscode,
			psamcardno,
			postradeno,
			samtradeno,
			presaveopcount,
			saveopcount,
			businesstype,
			acccode,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}