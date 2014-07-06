package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeProcessedException;



public class ConsumeProcessedException extends BaseConsumeProcessedException {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeProcessedException () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeProcessedException (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeProcessedException (
		java.lang.String id,
		java.lang.String cousumeProcessedId,
		java.lang.String industrycode) {

		super (
			id,
			cousumeProcessedId,
			industrycode);
	}

/*[CONSTRUCTOR MARKER END]*/


}