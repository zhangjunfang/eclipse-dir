package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTLog;



public class TLog extends BaseTLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TLog (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TLog (
		java.lang.Integer id,
		java.lang.String operator,
		java.lang.String module,
		java.lang.String action,
		java.lang.String logContent,
		java.util.Date logDate) {

		super (
			id,
			operator,
			module,
			action,
			logContent,
			logDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}