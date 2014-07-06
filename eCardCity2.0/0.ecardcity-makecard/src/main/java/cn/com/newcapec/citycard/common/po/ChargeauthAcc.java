package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseChargeauthAcc;



public class ChargeauthAcc extends BaseChargeauthAcc {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ChargeauthAcc () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ChargeauthAcc (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ChargeauthAcc (
		java.lang.String id,
		java.lang.String netsiteid,
		java.math.BigDecimal curoddfare,
		java.math.BigDecimal lastoddfare,
		java.math.BigDecimal opfare,
		java.math.BigDecimal allowoverdraftfare,
		java.lang.Integer maxlimitdate,
		java.lang.String isuse,
		java.lang.String customerunitcode,
		java.lang.String dir,
		java.lang.String flag,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			netsiteid,
			curoddfare,
			lastoddfare,
			opfare,
			allowoverdraftfare,
			maxlimitdate,
			isuse,
			customerunitcode,
			dir,
			flag,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}