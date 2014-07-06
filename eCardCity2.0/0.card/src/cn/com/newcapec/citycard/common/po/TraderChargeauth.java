package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTraderChargeauth;



public class TraderChargeauth extends BaseTraderChargeauth {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TraderChargeauth () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TraderChargeauth (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TraderChargeauth (
		java.lang.String id,
		java.lang.String authcode,
		java.lang.String businesspoint,
		java.math.BigDecimal curoddfare,
		java.math.BigDecimal allowoverdraftfare,
		java.lang.Integer maxlimitdate,
		java.lang.String isuse,
		java.lang.String workstatus,
		java.math.BigDecimal maxlimitfare,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			authcode,
			businesspoint,
			curoddfare,
			allowoverdraftfare,
			maxlimitdate,
			isuse,
			workstatus,
			maxlimitfare,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}