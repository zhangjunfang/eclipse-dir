package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTOrgMapRolePermission;



public class TOrgMapRolePermission extends BaseTOrgMapRolePermission {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TOrgMapRolePermission () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TOrgMapRolePermission (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TOrgMapRolePermission (
		java.lang.Integer id,
		java.lang.Integer fkRole,
		java.lang.Integer fkPermission) {

		super (
			id,
			fkRole,
			fkPermission);
	}

/*[CONSTRUCTOR MARKER END]*/


}