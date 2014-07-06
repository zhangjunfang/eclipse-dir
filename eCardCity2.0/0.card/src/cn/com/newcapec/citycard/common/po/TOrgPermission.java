package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTOrgPermission;



public class TOrgPermission extends BaseTOrgPermission {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TOrgPermission () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TOrgPermission (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TOrgPermission (
		java.lang.Integer id,
		java.lang.String permName,
		java.lang.String permUrl,
		java.lang.Integer pid,
		java.lang.String remark) {

		super (
			id,
			permName,
			permUrl,
			pid,
			remark);
	}

/*[CONSTRUCTOR MARKER END]*/


}