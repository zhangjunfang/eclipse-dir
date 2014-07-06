package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTOrgUser;



public class TOrgUser extends BaseTOrgUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TOrgUser () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TOrgUser (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TOrgUser (
		java.lang.Integer id,
		java.lang.String userName,
		java.lang.String code,
		java.lang.String password,
		java.lang.String name,
		java.lang.Integer fkDep,
		java.lang.String valid) {

		super (
			id,
			userName,
			code,
			password,
			name,
			fkDep,
			valid);
	}

/*[CONSTRUCTOR MARKER END]*/


}