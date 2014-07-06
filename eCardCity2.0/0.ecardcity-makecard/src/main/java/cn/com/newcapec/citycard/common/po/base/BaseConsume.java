package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CONSUME table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CONSUME"
 */

public abstract class BaseConsume  implements Comparable, Serializable {

	public static String REF = "Consume";
	public static String PROP_FILEID = "fileid";
	public static String PROP_CARDKIND = "cardkind";
	public static String PROP_OPFARE = "opfare";
	public static String PROP_SAMTRADENO = "samtradeno";
	public static String PROP_OPCOUNT = "opcount";
	public static String PROP_SAMCARDNO = "samcardno";
	public static String PROP_OWNERCITYCODE = "ownercitycode";
	public static String PROP_POSTRADENO = "postradeno";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_RECORDTYPE = "recordtype";
	public static String PROP_FAVOUREDFARE = "favouredfare";
	public static String PROP_LOCALCSTACCFC = "localcstaccfc";
	public static String PROP_TRADECITYCODE = "tradecitycode";
	public static String PROP_TESTFLAG = "testflag";
	public static String PROP_TAC = "tac";
	public static String PROP_ODDFARE = "oddfare";
	public static String PROP_RECORDSTATUS = "recordstatus";
	public static String PROP_COLLECTDT = "collectdt";
	public static String PROP_MAINCARDTYPE = "maincardtype";
	public static String PROP_CARDVERSION = "cardversion";
	public static String PROP_ASSOCARDTYPE = "assocardtype";
	public static String PROP_TRANSBATNO = "transbatno";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_TRADEKIND = "tradekind";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_MERCHANTCODE = "merchantcode";
	public static String PROP_LOCKCARDFLAG = "lockcardflag";
	public static String PROP_WALLETTYPE = "wallettype";
	public static String PROP_UPLOADDATE = "uploaddate";
	public static String PROP_ID = "id";
	public static String PROP_OPDT = "opdt";
	public static String PROP_POSCODE = "poscode";


	// constructors
	public BaseConsume () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseConsume (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseConsume (
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

		this.setId(id);
		this.setCustomerid(customerid);
		this.setCardkind(cardkind);
		this.setAsn(asn);
		this.setWallettype(wallettype);
		this.setOddfare(oddfare);
		this.setOpfare(opfare);
		this.setOpcount(opcount);
		this.setOpdt(opdt);
		this.setUploaddate(uploaddate);
		this.setCollectdt(collectdt);
		this.setLocalcstaccfc(localcstaccfc);
		this.setMerchantcode(merchantcode);
		this.setTradecitycode(tradecitycode);
		this.setOwnercitycode(ownercitycode);
		this.setPoscode(poscode);
		this.setPostradeno(postradeno);
		this.setSamcardno(samcardno);
		this.setSamtradeno(samtradeno);
		this.setRecordstatus(recordstatus);
		this.setMaincardtype(maincardtype);
		this.setCardversion(cardversion);
		this.setTradekind(tradekind);
		this.setTestflag(testflag);
		this.setFileid(fileid);
		this.setTransbatno(transbatno);
		this.setFavouredfare(favouredfare);
		this.setRecordtype(recordtype);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String customerid;
	private java.lang.Integer cardkind;
	private java.lang.Integer asn;
	private java.lang.Integer wallettype;
	private java.math.BigDecimal oddfare;
	private java.math.BigDecimal opfare;
	private java.lang.Integer opcount;
	private java.util.Date opdt;
	private java.util.Date uploaddate;
	private java.util.Date collectdt;
	private java.lang.String tac;
	private java.lang.Integer localcstaccfc;
	private java.lang.String merchantcode;
	private java.lang.String tradecitycode;
	private java.lang.String ownercitycode;
	private java.lang.String poscode;
	private java.lang.Integer postradeno;
	private java.lang.Integer samcardno;
	private java.lang.Integer samtradeno;
	private java.lang.Integer recordstatus;
	private java.lang.Integer maincardtype;
	private java.lang.Integer assocardtype;
	private java.lang.Integer cardversion;
	private java.lang.String tradekind;
	private java.lang.Integer testflag;
	private java.lang.Integer fileid;
	private java.lang.Integer lockcardflag;
	private java.lang.Integer transbatno;
	private java.lang.Integer favouredfare;
	private java.lang.String recordtype;
	private java.lang.String editPerson;
	private java.util.Date editDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CUSTOMERID
	 */
	public java.lang.String getCustomerid () {
		return customerid;
	}

	/**
	 * Set the value related to the column: CUSTOMERID
	 * @param customerid the CUSTOMERID value
	 */
	public void setCustomerid (java.lang.String customerid) {
		this.customerid = customerid;
	}



	/**
	 * Return the value associated with the column: CARDKIND
	 */
	public java.lang.Integer getCardkind () {
		return cardkind;
	}

	/**
	 * Set the value related to the column: CARDKIND
	 * @param cardkind the CARDKIND value
	 */
	public void setCardkind (java.lang.Integer cardkind) {
		this.cardkind = cardkind;
	}



	/**
	 * Return the value associated with the column: ASN
	 */
	public java.lang.Integer getAsn () {
		return asn;
	}

	/**
	 * Set the value related to the column: ASN
	 * @param asn the ASN value
	 */
	public void setAsn (java.lang.Integer asn) {
		this.asn = asn;
	}



	/**
	 * Return the value associated with the column: WALLETTYPE
	 */
	public java.lang.Integer getWallettype () {
		return wallettype;
	}

	/**
	 * Set the value related to the column: WALLETTYPE
	 * @param wallettype the WALLETTYPE value
	 */
	public void setWallettype (java.lang.Integer wallettype) {
		this.wallettype = wallettype;
	}



	/**
	 * Return the value associated with the column: ODDFARE
	 */
	public java.math.BigDecimal getOddfare () {
		return oddfare;
	}

	/**
	 * Set the value related to the column: ODDFARE
	 * @param oddfare the ODDFARE value
	 */
	public void setOddfare (java.math.BigDecimal oddfare) {
		this.oddfare = oddfare;
	}



	/**
	 * Return the value associated with the column: OPFARE
	 */
	public java.math.BigDecimal getOpfare () {
		return opfare;
	}

	/**
	 * Set the value related to the column: OPFARE
	 * @param opfare the OPFARE value
	 */
	public void setOpfare (java.math.BigDecimal opfare) {
		this.opfare = opfare;
	}



	/**
	 * Return the value associated with the column: OPCOUNT
	 */
	public java.lang.Integer getOpcount () {
		return opcount;
	}

	/**
	 * Set the value related to the column: OPCOUNT
	 * @param opcount the OPCOUNT value
	 */
	public void setOpcount (java.lang.Integer opcount) {
		this.opcount = opcount;
	}



	/**
	 * Return the value associated with the column: OPDT
	 */
	public java.util.Date getOpdt () {
		return opdt;
	}

	/**
	 * Set the value related to the column: OPDT
	 * @param opdt the OPDT value
	 */
	public void setOpdt (java.util.Date opdt) {
		this.opdt = opdt;
	}



	/**
	 * Return the value associated with the column: UPLOADDATE
	 */
	public java.util.Date getUploaddate () {
		return uploaddate;
	}

	/**
	 * Set the value related to the column: UPLOADDATE
	 * @param uploaddate the UPLOADDATE value
	 */
	public void setUploaddate (java.util.Date uploaddate) {
		this.uploaddate = uploaddate;
	}



	/**
	 * Return the value associated with the column: COLLECTDT
	 */
	public java.util.Date getCollectdt () {
		return collectdt;
	}

	/**
	 * Set the value related to the column: COLLECTDT
	 * @param collectdt the COLLECTDT value
	 */
	public void setCollectdt (java.util.Date collectdt) {
		this.collectdt = collectdt;
	}



	/**
	 * Return the value associated with the column: TAC
	 */
	public java.lang.String getTac () {
		return tac;
	}

	/**
	 * Set the value related to the column: TAC
	 * @param tac the TAC value
	 */
	public void setTac (java.lang.String tac) {
		this.tac = tac;
	}



	/**
	 * Return the value associated with the column: LOCALCSTACCFC
	 */
	public java.lang.Integer getLocalcstaccfc () {
		return localcstaccfc;
	}

	/**
	 * Set the value related to the column: LOCALCSTACCFC
	 * @param localcstaccfc the LOCALCSTACCFC value
	 */
	public void setLocalcstaccfc (java.lang.Integer localcstaccfc) {
		this.localcstaccfc = localcstaccfc;
	}



	/**
	 * Return the value associated with the column: MERCHANTCODE
	 */
	public java.lang.String getMerchantcode () {
		return merchantcode;
	}

	/**
	 * Set the value related to the column: MERCHANTCODE
	 * @param merchantcode the MERCHANTCODE value
	 */
	public void setMerchantcode (java.lang.String merchantcode) {
		this.merchantcode = merchantcode;
	}



	/**
	 * Return the value associated with the column: TRADECITYCODE
	 */
	public java.lang.String getTradecitycode () {
		return tradecitycode;
	}

	/**
	 * Set the value related to the column: TRADECITYCODE
	 * @param tradecitycode the TRADECITYCODE value
	 */
	public void setTradecitycode (java.lang.String tradecitycode) {
		this.tradecitycode = tradecitycode;
	}



	/**
	 * Return the value associated with the column: OWNERCITYCODE
	 */
	public java.lang.String getOwnercitycode () {
		return ownercitycode;
	}

	/**
	 * Set the value related to the column: OWNERCITYCODE
	 * @param ownercitycode the OWNERCITYCODE value
	 */
	public void setOwnercitycode (java.lang.String ownercitycode) {
		this.ownercitycode = ownercitycode;
	}



	/**
	 * Return the value associated with the column: POSCODE
	 */
	public java.lang.String getPoscode () {
		return poscode;
	}

	/**
	 * Set the value related to the column: POSCODE
	 * @param poscode the POSCODE value
	 */
	public void setPoscode (java.lang.String poscode) {
		this.poscode = poscode;
	}



	/**
	 * Return the value associated with the column: POSTRADENO
	 */
	public java.lang.Integer getPostradeno () {
		return postradeno;
	}

	/**
	 * Set the value related to the column: POSTRADENO
	 * @param postradeno the POSTRADENO value
	 */
	public void setPostradeno (java.lang.Integer postradeno) {
		this.postradeno = postradeno;
	}



	/**
	 * Return the value associated with the column: SAMCARDNO
	 */
	public java.lang.Integer getSamcardno () {
		return samcardno;
	}

	/**
	 * Set the value related to the column: SAMCARDNO
	 * @param samcardno the SAMCARDNO value
	 */
	public void setSamcardno (java.lang.Integer samcardno) {
		this.samcardno = samcardno;
	}



	/**
	 * Return the value associated with the column: SAMTRADENO
	 */
	public java.lang.Integer getSamtradeno () {
		return samtradeno;
	}

	/**
	 * Set the value related to the column: SAMTRADENO
	 * @param samtradeno the SAMTRADENO value
	 */
	public void setSamtradeno (java.lang.Integer samtradeno) {
		this.samtradeno = samtradeno;
	}



	/**
	 * Return the value associated with the column: RECORDSTATUS
	 */
	public java.lang.Integer getRecordstatus () {
		return recordstatus;
	}

	/**
	 * Set the value related to the column: RECORDSTATUS
	 * @param recordstatus the RECORDSTATUS value
	 */
	public void setRecordstatus (java.lang.Integer recordstatus) {
		this.recordstatus = recordstatus;
	}



	/**
	 * Return the value associated with the column: MAINCARDTYPE
	 */
	public java.lang.Integer getMaincardtype () {
		return maincardtype;
	}

	/**
	 * Set the value related to the column: MAINCARDTYPE
	 * @param maincardtype the MAINCARDTYPE value
	 */
	public void setMaincardtype (java.lang.Integer maincardtype) {
		this.maincardtype = maincardtype;
	}



	/**
	 * Return the value associated with the column: ASSOCARDTYPE
	 */
	public java.lang.Integer getAssocardtype () {
		return assocardtype;
	}

	/**
	 * Set the value related to the column: ASSOCARDTYPE
	 * @param assocardtype the ASSOCARDTYPE value
	 */
	public void setAssocardtype (java.lang.Integer assocardtype) {
		this.assocardtype = assocardtype;
	}



	/**
	 * Return the value associated with the column: CARDVERSION
	 */
	public java.lang.Integer getCardversion () {
		return cardversion;
	}

	/**
	 * Set the value related to the column: CARDVERSION
	 * @param cardversion the CARDVERSION value
	 */
	public void setCardversion (java.lang.Integer cardversion) {
		this.cardversion = cardversion;
	}



	/**
	 * Return the value associated with the column: TRADEKIND
	 */
	public java.lang.String getTradekind () {
		return tradekind;
	}

	/**
	 * Set the value related to the column: TRADEKIND
	 * @param tradekind the TRADEKIND value
	 */
	public void setTradekind (java.lang.String tradekind) {
		this.tradekind = tradekind;
	}



	/**
	 * Return the value associated with the column: TESTFLAG
	 */
	public java.lang.Integer getTestflag () {
		return testflag;
	}

	/**
	 * Set the value related to the column: TESTFLAG
	 * @param testflag the TESTFLAG value
	 */
	public void setTestflag (java.lang.Integer testflag) {
		this.testflag = testflag;
	}



	/**
	 * Return the value associated with the column: FILEID
	 */
	public java.lang.Integer getFileid () {
		return fileid;
	}

	/**
	 * Set the value related to the column: FILEID
	 * @param fileid the FILEID value
	 */
	public void setFileid (java.lang.Integer fileid) {
		this.fileid = fileid;
	}



	/**
	 * Return the value associated with the column: LOCKCARDFLAG
	 */
	public java.lang.Integer getLockcardflag () {
		return lockcardflag;
	}

	/**
	 * Set the value related to the column: LOCKCARDFLAG
	 * @param lockcardflag the LOCKCARDFLAG value
	 */
	public void setLockcardflag (java.lang.Integer lockcardflag) {
		this.lockcardflag = lockcardflag;
	}



	/**
	 * Return the value associated with the column: TRANSBATNO
	 */
	public java.lang.Integer getTransbatno () {
		return transbatno;
	}

	/**
	 * Set the value related to the column: TRANSBATNO
	 * @param transbatno the TRANSBATNO value
	 */
	public void setTransbatno (java.lang.Integer transbatno) {
		this.transbatno = transbatno;
	}



	/**
	 * Return the value associated with the column: FAVOUREDFARE
	 */
	public java.lang.Integer getFavouredfare () {
		return favouredfare;
	}

	/**
	 * Set the value related to the column: FAVOUREDFARE
	 * @param favouredfare the FAVOUREDFARE value
	 */
	public void setFavouredfare (java.lang.Integer favouredfare) {
		this.favouredfare = favouredfare;
	}



	/**
	 * Return the value associated with the column: RECORDTYPE
	 */
	public java.lang.String getRecordtype () {
		return recordtype;
	}

	/**
	 * Set the value related to the column: RECORDTYPE
	 * @param recordtype the RECORDTYPE value
	 */
	public void setRecordtype (java.lang.String recordtype) {
		this.recordtype = recordtype;
	}



	/**
	 * Return the value associated with the column: EDIT_PERSON
	 */
	public java.lang.String getEditPerson () {
		return editPerson;
	}

	/**
	 * Set the value related to the column: EDIT_PERSON
	 * @param editPerson the EDIT_PERSON value
	 */
	public void setEditPerson (java.lang.String editPerson) {
		this.editPerson = editPerson;
	}



	/**
	 * Return the value associated with the column: EDIT_DATE
	 */
	public java.util.Date getEditDate () {
		return editDate;
	}

	/**
	 * Set the value related to the column: EDIT_DATE
	 * @param editDate the EDIT_DATE value
	 */
	public void setEditDate (java.util.Date editDate) {
		this.editDate = editDate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.Consume)) return false;
		else {
			cn.com.newcapec.citycard.common.po.Consume consume = (cn.com.newcapec.citycard.common.po.Consume) obj;
			if (null == this.getId() || null == consume.getId()) return false;
			else return (this.getId().equals(consume.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}