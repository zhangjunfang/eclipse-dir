package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseFareCost;



public class FareCost extends BaseFareCost {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FareCost () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FareCost (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FareCost (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.math.BigDecimal opfare,
		java.lang.String acccode,
		java.lang.String cardkind,
		java.lang.String cardtype,
		java.math.BigDecimal accfare,
		java.lang.String ischarge,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			customerid,
			asn,
			opfare,
			acccode,
			cardkind,
			cardtype,
			accfare,
			ischarge,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}