package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTermInfoStatus;



public class TermInfoStatus extends BaseTermInfoStatus {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TermInfoStatus () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TermInfoStatus (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TermInfoStatus (
		java.lang.String id,
		java.lang.String termid,
		java.lang.String poscode,
		java.lang.Integer transbatno,
		java.lang.String applicationver,
		java.lang.Integer blacklistver,
		java.lang.Integer grantlistver,
		java.lang.Integer signinstatus,
		java.util.Date signdate) {

		super (
			id,
			termid,
			poscode,
			transbatno,
			applicationver,
			blacklistver,
			grantlistver,
			signinstatus,
			signdate);
	}

/*[CONSTRUCTOR MARKER END]*/


}