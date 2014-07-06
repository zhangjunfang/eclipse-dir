package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTContent;



public class TContent extends BaseTContent {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TContent () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TContent (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TContent (
		java.lang.Integer id,
		java.lang.String ctitle,
		java.lang.String state,
		java.lang.Integer channelId,
		java.lang.String updateuser,
		java.util.Date updatetime) {

		super (
			id,
			ctitle,
			state,
			channelId,
			updateuser,
			updatetime);
	}

/*[CONSTRUCTOR MARKER END]*/


}