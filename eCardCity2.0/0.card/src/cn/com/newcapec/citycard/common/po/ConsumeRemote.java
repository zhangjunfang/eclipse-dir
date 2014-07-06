package cn.com.newcapec.citycard.common.po;

import cn.com.newcapec.citycard.common.po.base.BaseConsumeRemote;



public class ConsumeRemote extends BaseConsumeRemote {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConsumeRemote () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConsumeRemote (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConsumeRemote (
		java.lang.String id,
		java.lang.Integer cstaccfc,
		java.lang.Integer customerid,
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
		java.lang.Integer businesstype,
		java.lang.Integer testflag,
		java.lang.Integer fileid,
		java.lang.Integer transbatno,
		java.lang.Integer favouredfare,
		java.lang.Integer recordtype,
		java.lang.Integer transflag,
		java.lang.String opdate,
		java.lang.String optime,
		java.lang.String centerresult) {

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
			businesstype,
			testflag,
			fileid,
			transbatno,
			favouredfare,
			recordtype,
			transflag,
			opdate,
			optime,
			centerresult);
	}

/*[CONSTRUCTOR MARKER END]*/


}