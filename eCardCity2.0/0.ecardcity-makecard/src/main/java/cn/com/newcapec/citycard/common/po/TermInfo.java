package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTermInfo;



public class TermInfo extends BaseTermInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TermInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TermInfo (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TermInfo (
		java.lang.String id,
		java.lang.String termname,
		java.lang.String isuse,
		java.lang.String typeid,
		java.lang.Integer psamcardno,
		java.lang.String workingkey,
		java.lang.String kekcode,
		java.lang.Integer appid,
		java.lang.String kekencryptkey,
		java.lang.String isdelete,
		java.lang.Integer ver) {

		super (
			id,
			termname,
			isuse,
			typeid,
			psamcardno,
			workingkey,
			kekcode,
			appid,
			kekencryptkey,
			isdelete,
			ver);
	}

/*[CONSTRUCTOR MARKER END]*/


}