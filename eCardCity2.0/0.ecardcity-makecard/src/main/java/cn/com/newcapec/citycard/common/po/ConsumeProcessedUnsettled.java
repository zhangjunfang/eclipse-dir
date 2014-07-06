package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeProcessedUnsettled;



public class ConsumeProcessedUnsettled extends BaseConsumeProcessedUnsettled {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeProcessedUnsettled () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeProcessedUnsettled (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeProcessedUnsettled (
		java.lang.String id,
		java.lang.String cousumeProcessedId,
		java.lang.String industrycode,
		java.lang.String doubtid) {

		super (
			id,
			cousumeProcessedId,
			industrycode,
			doubtid);
	}

/*[CONSTRUCTOR MARKER END]*/


}