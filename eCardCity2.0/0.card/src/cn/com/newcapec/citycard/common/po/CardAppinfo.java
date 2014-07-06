package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCardAppinfo;



public class CardAppinfo extends BaseCardAppinfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CardAppinfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CardAppinfo (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CardAppinfo (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String citycardno,
		java.lang.String scardsnr,
		java.lang.Integer cardsn,
		java.lang.String cardkind,
		java.lang.String cardtype,
		java.lang.String cardstatus,
		java.lang.String flag,
		java.lang.String cardflag,
		java.lang.String pwd,
		java.lang.String markName,
		boolean annualInspection,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			customerid,
			asn,
			citycardno,
			scardsnr,
			cardsn,
			cardkind,
			cardtype,
			cardstatus,
			flag,
			cardflag,
			pwd,
			markName,
			annualInspection,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}