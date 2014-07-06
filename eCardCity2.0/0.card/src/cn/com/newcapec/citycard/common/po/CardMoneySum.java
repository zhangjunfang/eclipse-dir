package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCardMoneySum;



public class CardMoneySum extends BaseCardMoneySum {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CardMoneySum () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CardMoneySum (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CardMoneySum (
		java.lang.String id,
		java.lang.String appinfoId,
		java.lang.String wallettype,
		java.lang.Integer opcount,
		java.lang.Integer saveopcount,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal oddfareacc,
		java.math.BigDecimal sumconsumefare,
		java.math.BigDecimal sumaddfare,
		java.math.BigDecimal sumqc,
		java.math.BigDecimal sumload,
		java.math.BigDecimal sumsave) {

		super (
			id,
			appinfoId,
			wallettype,
			opcount,
			saveopcount,
			oddfare,
			oddfareacc,
			sumconsumefare,
			sumaddfare,
			sumqc,
			sumload,
			sumsave);
	}

/*[CONSTRUCTOR MARKER END]*/


}