package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeProcessed;



public class ConsumeProcessed extends BaseConsumeProcessed {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeProcessed () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeProcessed (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeProcessed (
		java.lang.String id,
		java.lang.Integer cstaccfc,
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
			cstaccfc,
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