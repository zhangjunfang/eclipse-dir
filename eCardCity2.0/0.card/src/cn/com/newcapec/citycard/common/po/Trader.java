package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTrader;



public class Trader extends BaseTrader {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Trader () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Trader (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Trader (
		java.lang.String id,
		java.lang.String merchantcode,
		java.lang.String merchantname,
		java.lang.Integer sortNum,
		java.lang.String industrycode,
		java.lang.String accountid,
		java.lang.String merchanttype,
		java.lang.String merchatntstatus,
		java.lang.Integer bankid,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			merchantcode,
			merchantname,
			sortNum,
			industrycode,
			accountid,
			merchanttype,
			merchatntstatus,
			bankid,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}