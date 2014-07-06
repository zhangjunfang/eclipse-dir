package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseMoneyDrawApplyStatus;



public class MoneyDrawApplyStatus extends BaseMoneyDrawApplyStatus {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MoneyDrawApplyStatus () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MoneyDrawApplyStatus (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MoneyDrawApplyStatus (
		java.lang.String id,
		java.lang.String oldstate,
		java.lang.String newstate,
		java.lang.String oldaffairstatus,
		java.lang.String newaffairstatus,
		java.lang.String reason,
		java.lang.Integer reasoncode,
		java.lang.Integer saveopcount,
		java.lang.Integer opcount,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			oldstate,
			newstate,
			oldaffairstatus,
			newaffairstatus,
			reason,
			reasoncode,
			saveopcount,
			opcount,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}