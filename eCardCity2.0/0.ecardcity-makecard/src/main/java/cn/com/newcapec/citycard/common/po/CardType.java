package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCardType;



public class CardType extends BaseCardType {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CardType () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CardType (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CardType (
		java.lang.String id,
		java.lang.String groupid,
		java.lang.String cardtypename,
		java.lang.Integer ver,
		java.lang.String paramgroupid) {

		super (
			id,
			groupid,
			cardtypename,
			ver,
			paramgroupid);
	}

/*[CONSTRUCTOR MARKER END]*/


}