package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseLoadDetailRecord;



public class LoadDetailRecord extends BaseLoadDetailRecord {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LoadDetailRecord () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LoadDetailRecord (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LoadDetailRecord (
		java.lang.String id,
		java.lang.Integer bankrecno,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.math.BigDecimal opfare,
		java.lang.String fundsWay,
		java.lang.String bankcardno,
		java.lang.String acccode,
		java.lang.Integer termid,
		java.lang.Integer termtradeno,
		java.lang.String signWay,
		java.util.Date editDate) {

		super (
			id,
			bankrecno,
			customerid,
			asn,
			opfare,
			fundsWay,
			bankcardno,
			acccode,
			termid,
			termtradeno,
			signWay,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}