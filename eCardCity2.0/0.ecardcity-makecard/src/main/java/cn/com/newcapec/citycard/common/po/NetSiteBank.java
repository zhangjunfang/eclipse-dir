package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseNetSiteBank;



public class NetSiteBank extends BaseNetSiteBank {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public NetSiteBank () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public NetSiteBank (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public NetSiteBank (
		java.lang.String id,
		java.lang.String netsiteid,
		java.lang.String bankname,
		java.lang.String openAccount,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			netsiteid,
			bankname,
			openAccount,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}