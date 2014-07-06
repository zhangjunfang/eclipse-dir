package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeProcessedSuccessed;



public class ConsumeProcessedSuccessed extends BaseConsumeProcessedSuccessed {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeProcessedSuccessed () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeProcessedSuccessed (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeProcessedSuccessed (
		java.lang.String id,
		java.lang.String cousumeProcessedId,
		java.lang.String industrycode,
		java.lang.String adjustflag,
		java.lang.String acccode) {

		super (
			id,
			cousumeProcessedId,
			industrycode,
			adjustflag,
			acccode);
	}

/*[CONSTRUCTOR MARKER END]*/


}