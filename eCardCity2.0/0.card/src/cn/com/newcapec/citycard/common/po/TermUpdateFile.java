package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseTermUpdateFile;



public class TermUpdateFile extends BaseTermUpdateFile {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TermUpdateFile () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TermUpdateFile (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TermUpdateFile (
		java.lang.String id,
		java.lang.String filename,
		java.lang.String fileurl,
		java.lang.String filever,
		java.lang.String systype,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			filename,
			fileurl,
			filever,
			systype,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}