package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTermUpdateLog;



public class TermUpdateLog extends BaseTermUpdateLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TermUpdateLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TermUpdateLog (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TermUpdateLog (
		java.lang.String id,
		java.lang.String poscode,
		java.lang.String fileid,
		java.lang.String status,
		java.lang.String iserasureflash,
		java.lang.String filever,
		java.lang.String systype,
		java.lang.Integer appver) {

		super (
			id,
			poscode,
			fileid,
			status,
			iserasureflash,
			filever,
			systype,
			appver);
	}

/*[CONSTRUCTOR MARKER END]*/


}