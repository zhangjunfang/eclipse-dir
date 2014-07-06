package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTOrgMapUserRole;



public class TOrgMapUserRole extends BaseTOrgMapUserRole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TOrgMapUserRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TOrgMapUserRole (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TOrgMapUserRole (
		java.lang.Integer id,
		java.lang.Integer fkUser,
		java.lang.Integer fkRole) {

		super (
			id,
			fkUser,
			fkRole);
	}

/*[CONSTRUCTOR MARKER END]*/


}