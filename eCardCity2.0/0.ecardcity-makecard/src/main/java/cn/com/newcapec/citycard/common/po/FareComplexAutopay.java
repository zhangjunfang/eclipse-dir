package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseFareComplexAutopay;



public class FareComplexAutopay extends BaseFareComplexAutopay {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FareComplexAutopay () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FareComplexAutopay (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FareComplexAutopay (
		java.lang.String id,
		java.lang.Integer bindcstaccfc,
		java.lang.String olineno,
		java.lang.String industrycode,
		java.lang.String tradeno) {

		super (
			id,
			bindcstaccfc,
			olineno,
			industrycode,
			tradeno);
	}

/*[CONSTRUCTOR MARKER END]*/


}