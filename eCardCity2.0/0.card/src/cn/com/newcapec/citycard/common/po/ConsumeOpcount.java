package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeOpcount;



public class ConsumeOpcount extends BaseConsumeOpcount {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeOpcount () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeOpcount (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeOpcount (
		java.lang.String id,
		java.lang.Integer asn,
		java.lang.Integer opcount,
		java.lang.String wallettype) {

		super (
			id,
			asn,
			opcount,
			wallettype);
	}

/*[CONSTRUCTOR MARKER END]*/


}