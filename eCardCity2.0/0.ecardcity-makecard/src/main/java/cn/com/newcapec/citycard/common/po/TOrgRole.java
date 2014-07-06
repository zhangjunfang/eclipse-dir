package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTOrgRole;



public class TOrgRole extends BaseTOrgRole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TOrgRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TOrgRole (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TOrgRole (
		java.lang.Integer id,
		java.lang.String roleName,
		java.lang.String remark) {

		super (
			id,
			roleName,
			remark);
	}

/*[CONSTRUCTOR MARKER END]*/


}