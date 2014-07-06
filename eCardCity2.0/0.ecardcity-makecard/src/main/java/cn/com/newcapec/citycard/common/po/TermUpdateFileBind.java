package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTermUpdateFileBind;



public class TermUpdateFileBind extends BaseTermUpdateFileBind {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TermUpdateFileBind () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TermUpdateFileBind (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TermUpdateFileBind (
		java.lang.String id,
		java.lang.String poscode,
		java.lang.String fileid,
		java.lang.String status,
		java.lang.String iserasureflash,
		java.lang.String systype) {

		super (
			id,
			poscode,
			fileid,
			status,
			iserasureflash,
			systype);
	}

/*[CONSTRUCTOR MARKER END]*/


}