package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCustomer;



public class Customer extends BaseCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customer (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Customer (
		java.lang.String id,
		java.lang.String status,
		java.lang.String sex,
		java.lang.String name,
		java.lang.String nation,
		java.lang.String certificateid,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			status,
			sex,
			name,
			nation,
			certificateid,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}