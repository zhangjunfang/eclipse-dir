package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCustomerFingerprint;



public class CustomerFingerprint extends BaseCustomerFingerprint {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CustomerFingerprint () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CustomerFingerprint (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CustomerFingerprint (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.String firstfinger,
		java.lang.String secondfinger,
		java.lang.Integer fingercount,
		java.util.Date fingerdate) {

		super (
			id,
			customerid,
			firstfinger,
			secondfinger,
			fingercount,
			fingerdate);
	}

/*[CONSTRUCTOR MARKER END]*/


}