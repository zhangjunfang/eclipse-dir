package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseAddressCollect;



public class AddressCollect extends BaseAddressCollect {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AddressCollect () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AddressCollect (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AddressCollect (
		java.lang.String id,
		java.lang.String collectid,
		java.lang.String collectname,
		java.lang.String collectstatus,
		java.lang.String collecttype,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			collectid,
			collectname,
			collectstatus,
			collecttype,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}