package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCardMakes;



public class CardMakes extends BaseCardMakes {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CardMakes () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CardMakes (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CardMakes (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.Integer cardsn,
		java.lang.String scardsnr,
		java.lang.String pty,
		java.lang.String wallettype,
		java.lang.String cardkind,
		java.lang.String cardtype,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			customerid,
			asn,
			cardsn,
			scardsnr,
			pty,
			wallettype,
			cardkind,
			cardtype,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}