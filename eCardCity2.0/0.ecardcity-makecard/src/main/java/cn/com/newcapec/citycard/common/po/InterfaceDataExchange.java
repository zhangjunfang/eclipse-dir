package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseInterfaceDataExchange;



public class InterfaceDataExchange extends BaseInterfaceDataExchange {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InterfaceDataExchange () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InterfaceDataExchange (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public InterfaceDataExchange (
		java.lang.String id,
		java.lang.String tablename,
		java.lang.Integer ver,
		java.lang.String industrycode) {

		super (
			id,
			tablename,
			ver,
			industrycode);
	}

/*[CONSTRUCTOR MARKER END]*/


}