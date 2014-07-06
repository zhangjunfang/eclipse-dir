package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCardPsamLog;



public class CardPsamLog extends BaseCardPsamLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CardPsamLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CardPsamLog (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CardPsamLog (
		java.lang.String id,
		java.lang.Integer samcardno,
		java.lang.String state,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			samcardno,
			state,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}