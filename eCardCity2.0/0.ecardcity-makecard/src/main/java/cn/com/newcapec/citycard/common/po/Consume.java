package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsume;



public class Consume extends BaseConsume {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Consume () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Consume (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Consume (
		java.lang.Integer id,
		java.lang.String customerid,
		java.lang.Integer cardkind,
		java.lang.Integer asn,
		java.lang.Integer wallettype,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal opfare,
		java.lang.Integer opcount,
		java.util.Date opdt,
		java.util.Date uploaddate,
		java.util.Date collectdt,
		java.lang.Integer localcstaccfc,
		java.lang.String merchantcode,
		java.lang.String tradecitycode,
		java.lang.String ownercitycode,
		java.lang.String poscode,
		java.lang.Integer postradeno,
		java.lang.Integer samcardno,
		java.lang.Integer samtradeno,
		java.lang.Integer recordstatus,
		java.lang.Integer maincardtype,
		java.lang.Integer cardversion,
		java.lang.String tradekind,
		java.lang.Integer testflag,
		java.lang.Integer fileid,
		java.lang.Integer transbatno,
		java.lang.Integer favouredfare,
		java.lang.String recordtype,
		java.lang.String editPerson,
		java.util.Date editDate) {

		super (
			id,
			customerid,
			cardkind,
			asn,
			wallettype,
			oddfare,
			opfare,
			opcount,
			opdt,
			uploaddate,
			collectdt,
			localcstaccfc,
			merchantcode,
			tradecitycode,
			ownercitycode,
			poscode,
			postradeno,
			samcardno,
			samtradeno,
			recordstatus,
			maincardtype,
			cardversion,
			tradekind,
			testflag,
			fileid,
			transbatno,
			favouredfare,
			recordtype,
			editPerson,
			editDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}