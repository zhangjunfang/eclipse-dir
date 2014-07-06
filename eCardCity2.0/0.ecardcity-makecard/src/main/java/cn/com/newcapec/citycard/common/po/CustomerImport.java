package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCustomerImport;



public class CustomerImport extends BaseCustomerImport {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CustomerImport () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CustomerImport (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CustomerImport (
		java.lang.Integer id,
		java.util.Date importdate,
		java.lang.Integer sex,
		java.lang.String name,
		java.lang.String idcardno) {

		super (
			id,
			importdate,
			sex,
			name,
			idcardno);
	}

/*[CONSTRUCTOR MARKER END]*/


}