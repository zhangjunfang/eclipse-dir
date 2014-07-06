package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseFareComplexPay;



public class FareComplexPay extends BaseFareComplexPay {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FareComplexPay () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FareComplexPay (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FareComplexPay (
		java.lang.String id,
		java.lang.String billno,
		java.lang.String measure,
		java.lang.String unitprice,
		java.lang.String mustpayprice,
		java.lang.String paytp,
		java.lang.String payresult,
		java.lang.String tradeno,
		java.lang.String termid,
		java.lang.String tac,
		java.math.BigDecimal recordstatus,
		java.lang.String realitypay) {

		super (
			id,
			billno,
			measure,
			unitprice,
			mustpayprice,
			paytp,
			payresult,
			tradeno,
			termid,
			tac,
			recordstatus,
			realitypay);
	}

/*[CONSTRUCTOR MARKER END]*/


}