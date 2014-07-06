package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseMoneyDrawApplyPlan;



public class MoneyDrawApplyPlan extends BaseMoneyDrawApplyPlan {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MoneyDrawApplyPlan () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MoneyDrawApplyPlan (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MoneyDrawApplyPlan (
		java.lang.String id,
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
		java.lang.String descrition,
		java.lang.String poscode,
		java.lang.Integer psamcardno,
		java.lang.Integer presaveopcount,
		java.lang.Integer saveopcount,
		java.lang.String businesstype,
		java.lang.String acccode,
		java.lang.Integer transbatno,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
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
			descrition,
			poscode,
			psamcardno,
			presaveopcount,
			saveopcount,
			businesstype,
			acccode,
			transbatno,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}