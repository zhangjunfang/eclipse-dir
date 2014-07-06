package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseLoadBankBindFailure;



public class LoadBankBindFailure extends BaseLoadBankBindFailure {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LoadBankBindFailure () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LoadBankBindFailure (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LoadBankBindFailure (
		java.lang.String id,
		java.lang.String acccode,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String signType,
		java.lang.String fundsWay,
		java.lang.String bankCardNumber,
		java.math.BigDecimal tradeMoney,
		java.math.BigDecimal minMoneyLoad,
		java.lang.String identificationType,
		java.lang.String identificationNumber,
		java.lang.String signWay) {

		super (
			id,
			acccode,
			customerid,
			asn,
			signType,
			fundsWay,
			bankCardNumber,
			tradeMoney,
			minMoneyLoad,
			identificationType,
			identificationNumber,
			signWay);
	}

/*[CONSTRUCTOR MARKER END]*/


}