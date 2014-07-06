package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeOtherplaceDoubt;



public class ConsumeOtherplaceDoubt extends BaseConsumeOtherplaceDoubt {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeOtherplaceDoubt () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeOtherplaceDoubt (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeOtherplaceDoubt (
		java.lang.String id,
		java.lang.Integer cstaccfc,
		java.lang.String localcstaccfc,
		java.lang.String tradekind,
		java.lang.Integer lockcardflag,
		java.lang.String tradecitycode,
		java.lang.String ownercitycode,
		java.lang.Integer asn,
		java.lang.Integer opcount,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal opfare,
		java.lang.String opdate,
		java.lang.String optime,
		java.lang.String tac,
		java.lang.String cardversion,
		java.lang.String centeraccountdate,
		java.lang.Integer testflag) {

		super (
			id,
			cstaccfc,
			localcstaccfc,
			tradekind,
			lockcardflag,
			tradecitycode,
			ownercitycode,
			asn,
			opcount,
			oddfare,
			opfare,
			opdate,
			optime,
			tac,
			cardversion,
			centeraccountdate,
			testflag);
	}

/*[CONSTRUCTOR MARKER END]*/


}