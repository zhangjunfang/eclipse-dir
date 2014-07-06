package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCardEmployee;



public class CardEmployee extends BaseCardEmployee {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CardEmployee () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CardEmployee (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CardEmployee (
		java.lang.String id,
		java.lang.String empid,
		java.lang.Integer asn,
		java.lang.String scardsnr,
		java.lang.Integer cardsn,
		java.lang.String cardtype,
		java.lang.String cardstatus,
		java.lang.String cardflag,
		java.lang.String pwd,
		java.util.Date expiryDate,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			empid,
			asn,
			scardsnr,
			cardsn,
			cardtype,
			cardstatus,
			cardflag,
			pwd,
			expiryDate,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}