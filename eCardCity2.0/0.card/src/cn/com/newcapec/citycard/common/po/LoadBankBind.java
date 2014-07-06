package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseLoadBankBind;



public class LoadBankBind extends BaseLoadBankBind {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LoadBankBind () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LoadBankBind (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LoadBankBind (
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
		java.lang.String signWay,
		java.lang.String editPerson,
		java.util.Date editDate) {

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
			signWay,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}