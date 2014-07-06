package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseChargeauth;



public class Chargeauth extends BaseChargeauth {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Chargeauth () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Chargeauth (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Chargeauth (
		java.lang.String id,
		java.lang.String authcode,
		java.math.BigDecimal curoddfare,
		java.math.BigDecimal allowoverdraftfare,
		java.lang.Integer maxlimitdate,
		java.lang.String isuse,
		java.lang.String workstatus,
		java.math.BigDecimal maxlimitfare,
		java.lang.String editPerson,
		java.util.Date editDate,
		java.lang.String netsiteid) {

		super (
			id,
			authcode,
			curoddfare,
			allowoverdraftfare,
			maxlimitdate,
			isuse,
			workstatus,
			maxlimitfare,
			editPerson,
			editDate,
			netsiteid);
	}

/*[CONSTRUCTOR MARKER END]*/


}