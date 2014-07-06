package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTermInfoParam;



public class TermInfoParam extends BaseTermInfoParam {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TermInfoParam () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TermInfoParam (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TermInfoParam (
		java.lang.String id,
		java.lang.String poscode,
		java.lang.Integer typecode,
		java.lang.String datatype,
		java.lang.String content) {

		super (
			id,
			poscode,
			typecode,
			datatype,
			content);
	}

/*[CONSTRUCTOR MARKER END]*/


}