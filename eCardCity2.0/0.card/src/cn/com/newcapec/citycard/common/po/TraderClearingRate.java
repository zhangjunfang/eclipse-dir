package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTraderClearingRate;



public class TraderClearingRate extends BaseTraderClearingRate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TraderClearingRate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TraderClearingRate (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TraderClearingRate (
		java.lang.String id,
		java.lang.String merchantcode,
		java.math.BigDecimal feepersale,
		java.math.BigDecimal currencyrates,
		java.math.BigDecimal transferratesofbank,
		java.lang.String flag,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			merchantcode,
			feepersale,
			currencyrates,
			transferratesofbank,
			flag,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}