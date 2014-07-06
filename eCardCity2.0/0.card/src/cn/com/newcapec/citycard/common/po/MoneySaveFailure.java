package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseMoneySaveFailure;



public class MoneySaveFailure extends BaseMoneySaveFailure {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MoneySaveFailure () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MoneySaveFailure (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MoneySaveFailure (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String wallettype,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal opfare,
		java.lang.Integer cardsn,
		java.lang.Integer opcount,
		java.lang.Integer saveopcont,
		java.util.Date opdt,
		java.util.Date collectdt,
		java.util.Date uploaddate,
		java.lang.Integer samcardno,
		java.lang.Integer samtradeno,
		java.lang.Integer recordstatus,
		java.lang.Integer postradeno,
		java.lang.String poscode,
		java.lang.String businesstype,
		java.lang.Integer transbatno,
		java.lang.String cardtype,
		java.lang.String acccode,
		java.lang.String badrecid) {

		super (
			id,
			customerid,
			asn,
			wallettype,
			oddfare,
			opfare,
			cardsn,
			opcount,
			saveopcont,
			opdt,
			collectdt,
			uploaddate,
			samcardno,
			samtradeno,
			recordstatus,
			postradeno,
			poscode,
			businesstype,
			transbatno,
			cardtype,
			acccode,
			badrecid);
	}

/*[CONSTRUCTOR MARKER END]*/


}