package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeProcessedRepeat;



public class ConsumeProcessedRepeat extends BaseConsumeProcessedRepeat {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeProcessedRepeat () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeProcessedRepeat (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeProcessedRepeat (
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