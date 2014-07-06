package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseMoneyDrawApplySuccessed;



public class MoneyDrawApplySuccessed extends BaseMoneyDrawApplySuccessed {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MoneyDrawApplySuccessed () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MoneyDrawApplySuccessed (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MoneyDrawApplySuccessed (
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
		java.lang.String poscode,
		java.lang.Integer psamcardno,
		java.lang.Integer postradeno,
		java.lang.Integer samtradeno,
		java.lang.Integer presaveopcount,
		java.lang.Integer saveopcount,
		java.lang.Integer businesstype,
		java.lang.String acccode,
		java.lang.String netid,
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
			poscode,
			psamcardno,
			postradeno,
			samtradeno,
			presaveopcount,
			saveopcount,
			businesstype,
			acccode,
			netid,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}