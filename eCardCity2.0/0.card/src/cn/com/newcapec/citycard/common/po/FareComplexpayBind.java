package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseFareComplexpayBind;



public class FareComplexpayBind extends BaseFareComplexpayBind {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FareComplexpayBind () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FareComplexpayBind (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FareComplexpayBind (
		java.lang.String id,
		java.lang.Integer empcardno,
		java.lang.String termid,
		java.util.Date allowbinddt,
		java.util.Date submitdt,
		java.lang.Integer mngfare,
		java.lang.Integer trcflg,
		java.lang.Integer serverid,
		java.lang.Integer recordstatus,
		java.lang.Integer tradetype,
		java.lang.Integer testflag,
		java.lang.String industrycode) {

		super (
			id,
			empcardno,
			termid,
			allowbinddt,
			submitdt,
			mngfare,
			trcflg,
			serverid,
			recordstatus,
			tradetype,
			testflag,
			industrycode);
	}

/*[CONSTRUCTOR MARKER END]*/


}