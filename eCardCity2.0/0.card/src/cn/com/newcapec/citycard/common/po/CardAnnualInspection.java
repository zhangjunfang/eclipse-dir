package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseCardAnnualInspection;



public class CardAnnualInspection extends BaseCardAnnualInspection {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CardAnnualInspection () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CardAnnualInspection (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CardAnnualInspection (
		java.lang.String id,
		java.lang.Integer asn,
		java.util.Date preAnnualInspectionStart,
		java.util.Date preAnnualInspectionEnd,
		java.lang.String annualInspectionResult,
		java.lang.String poscode,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			asn,
			preAnnualInspectionStart,
			preAnnualInspectionEnd,
			annualInspectionResult,
			poscode,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}