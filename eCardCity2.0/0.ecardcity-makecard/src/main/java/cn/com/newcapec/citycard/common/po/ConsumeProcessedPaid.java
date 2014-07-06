package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeProcessedPaid;



public class ConsumeProcessedPaid extends BaseConsumeProcessedPaid {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeProcessedPaid () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeProcessedPaid (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeProcessedPaid (
		java.lang.String id,
		java.lang.String cousumeProcessedId,
		java.lang.String industrycode,
		java.lang.String adjustflag,
		java.lang.String billno) {

		super (
			id,
			cousumeProcessedId,
			industrycode,
			adjustflag,
			billno);
	}

/*[CONSTRUCTOR MARKER END]*/


}