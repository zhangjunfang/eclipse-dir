package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTPicture;



public class TPicture extends BaseTPicture {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TPicture () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TPicture (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TPicture (
		java.lang.Integer id,
		java.lang.String guid,
		java.lang.String category,
		java.lang.String picurl,
		java.lang.String updateuser,
		java.util.Date updatetime) {

		super (
			id,
			guid,
			category,
			picurl,
			updateuser,
			updatetime);
	}

/*[CONSTRUCTOR MARKER END]*/


}