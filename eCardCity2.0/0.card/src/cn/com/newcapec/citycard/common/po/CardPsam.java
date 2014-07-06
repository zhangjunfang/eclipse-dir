package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCardPsam;



public class CardPsam extends BaseCardPsam {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CardPsam () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CardPsam (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CardPsam (
		java.lang.String id,
		java.lang.Integer samcardno,
		java.lang.Integer samcardsn,
		java.lang.String samcardsnr,
		java.lang.String state,
		java.util.Date startdate,
		java.util.Date enddate,
		java.util.Date lastupdate,
		java.util.Date createdate,
		java.lang.Integer ver,
		java.lang.String addtype,
		java.lang.String samcardtype,
		java.lang.String printcode) {

		super (
			id,
			samcardno,
			samcardsn,
			samcardsnr,
			state,
			startdate,
			enddate,
			lastupdate,
			createdate,
			ver,
			addtype,
			samcardtype,
			printcode);
	}

/*[CONSTRUCTOR MARKER END]*/


}