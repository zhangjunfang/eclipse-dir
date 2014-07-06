package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTOrgDept;



public class TOrgDept extends BaseTOrgDept {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TOrgDept () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TOrgDept (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TOrgDept (
		java.lang.Integer id,
		java.lang.String deptName,
		java.lang.String code,
		java.lang.Integer pid) {

		super (
			id,
			deptName,
			code,
			pid);
	}

/*[CONSTRUCTOR MARKER END]*/


}