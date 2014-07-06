package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseBaseEmployee;



public class BaseEmployee extends BaseBaseEmployee {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BaseEmployee () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployee (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEmployee (
		java.lang.String id,
		java.lang.String netsiteid,
		java.lang.String bankid,
		java.lang.String saleCardtype,
		java.lang.String cashCardtype,
		java.lang.String privilegeCashin,
		java.lang.String privilegeCashout,
		java.lang.String privilegePos,
		java.lang.String privilegeLogin) {

		super (
			id,
			netsiteid,
			bankid,
			saleCardtype,
			cashCardtype,
			privilegeCashin,
			privilegeCashout,
			privilegePos,
			privilegeLogin);
	}

/*[CONSTRUCTOR MARKER END]*/


}