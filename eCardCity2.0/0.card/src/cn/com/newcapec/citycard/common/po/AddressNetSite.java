package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseAddressNetSite;



public class AddressNetSite extends BaseAddressNetSite {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AddressNetSite () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AddressNetSite (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AddressNetSite (
		java.lang.String id,
		java.lang.String netid,
		java.lang.String netname,
		java.lang.String netstatus,
		java.lang.String nettype,
		java.lang.Integer ver,
		java.lang.String netidP,
		java.lang.String netkind,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			netid,
			netname,
			netstatus,
			nettype,
			ver,
			netidP,
			netkind,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}