package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseNetSiteClearingRate;



public class NetSiteClearingRate extends BaseNetSiteClearingRate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public NetSiteClearingRate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public NetSiteClearingRate (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public NetSiteClearingRate (
		java.lang.String id,
		java.lang.String netsiteid,
		java.math.BigDecimal feepersale,
		java.math.BigDecimal currencyrates,
		java.math.BigDecimal transferratesofbank,
		java.lang.String flag,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			netsiteid,
			feepersale,
			currencyrates,
			transferratesofbank,
			flag,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}