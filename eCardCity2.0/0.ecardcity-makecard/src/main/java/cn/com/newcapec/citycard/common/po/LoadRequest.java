package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseLoadRequest;



public class LoadRequest extends BaseLoadRequest {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LoadRequest () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LoadRequest (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LoadRequest (
		java.lang.String id,
		java.lang.Integer bankrecno,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String fundsWay,
		java.lang.String bankcardno,
		java.math.BigDecimal opfare,
		java.lang.String acccode,
		java.lang.String signType,
		java.util.Date editDate) {

		super (
			id,
			bankrecno,
			customerid,
			asn,
			fundsWay,
			bankcardno,
			opfare,
			acccode,
			signType,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}