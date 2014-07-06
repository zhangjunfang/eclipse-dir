package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCustomerPhoto;



public class CustomerPhoto extends BaseCustomerPhoto {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CustomerPhoto () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CustomerPhoto (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CustomerPhoto (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.String photoid,
		byte[] photo) {

		super (
			id,
			customerid,
			photoid,
			photo);
	}

/*[CONSTRUCTOR MARKER END]*/


}