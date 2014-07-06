package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the MONEY_SAVE_REPEAT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MONEY_SAVE_REPEAT"
 */

public abstract class BaseMoneySaveRepeat  implements Comparable, Serializable {

	public static String REF = "MoneySaveRepeat";
	public static String PROP_CARDKIND = "cardkind";
	public static String PROP_DSCRP = "dscrp";
	public static String PROP_CARDTYPE = "cardtype";
	public static String PROP_OPFARE = "opfare";
	public static String PROP_SAMTRADENO = "samtradeno";
	public static String PROP_PLANID = "planid";
	public static String PROP_OPCOUNT = "opcount";
	public static String PROP_SAMCARDNO = "samcardno";
	public static String PROP_POSTRADENO = "postradeno";
	public static String PROP_TAC = "tac";
	public static String PROP_ODDFARE = "oddfare";
	public static String PROP_RECORDSTATUS = "recordstatus";
	public static String PROP_STATDATE = "statdate";
	public static String PROP_COLLECTDT = "collectdt";
	public static String PROP_SAVEOPCONT = "saveopcont";
	public static String PROP_CARDSN = "cardsn";
	public static String PROP_TRANSBATNO = "transbatno";
	public static String PROP_ASN = "asn";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_VER = "ver";
	public static String PROP_WALLETTYPE = "wallettype";
	public static String PROP_UPLOADDATE = "uploaddate";
	public static String PROP_ACCCODE = "acccode";
	public static String PROP_BUSINESSTYPE = "businesstype";
	public static String PROP_ID = "id";
	public static String PROP_OPDT = "opdt";
	public static String PROP_POSCODE = "poscode";


	// constructors
	public BaseMoneySaveRepeat () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMoneySaveRepeat (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMoneySaveRepeat (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String wallettype,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal opfare,
		java.lang.Integer cardsn,
		java.lang.Integer opcount,
		java.lang.Integer saveopcont,
		java.util.Date opdt,
		java.util.Date collectdt,
		java.util.Date uploaddate,
		java.lang.Integer samcardno,
		java.lang.Integer samtradeno,
		java.lang.Integer recordstatus,
		java.lang.Integer postradeno,
		java.lang.String poscode,
		java.lang.String businesstype,
		java.lang.Integer transbatno,
		java.lang.String cardtype,
		java.lang.String acccode) {

		this.setId(id);
		this.setCustomerid(customerid);
		this.setAsn(asn);
		this.setWallettype(wallettype);
		this.setOddfare(oddfare);
		this.setOpfare(opfare);
		this.setCardsn(cardsn);
		this.setOpcount(opcount);
		this.setSaveopcont(saveopcont);
		this.setOpdt(opdt);
		this.setCollectdt(collectdt);
		this.setUploaddate(uploaddate);
		this.setSamcardno(samcardno);
		this.setSamtradeno(samtradeno);
		this.setRecordstatus(recordstatus);
		this.setPostradeno(postradeno);
		this.setPoscode(poscode);
		this.setBusinesstype(businesstype);
		this.setTransbatno(transbatno);
		this.setCardtype(cardtype);
		this.setAcccode(acccode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String customerid;
	private java.lang.Integer asn;
	private java.lang.String wallettype;
	private java.math.BigDecimal oddfare;
	private java.math.BigDecimal opfare;
	private java.lang.Integer cardsn;
	private java.lang.Integer opcount;
	private java.lang.Integer saveopcont;
	private java.util.Date opdt;
	private java.util.Date collectdt;
	private java.util.Date statdate;
	private java.util.Date uploaddate;
	private java.lang.Integer ver;
	private java.lang.Integer samcardno;
	private java.lang.String tac;
	private java.lang.Integer samtradeno;
	private java.lang.String dscrp;
	private java.lang.String planid;
	private java.lang.Integer recordstatus;
	private java.lang.Integer postradeno;
	private java.lang.String poscode;
	private java.lang.String businesstype;
	private java.lang.Integer transbatno;
	private java.lang.String cardtype;
	private java.lang.String cardkind;
	private java.lang.String acccode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="ID"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
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
	public java.lang.String getWallettype () {
		return wallettype;
	}

	/**
	 * Set the value related to the column: WALLETTYPE
	 * @param wallettype the WALLETTYPE value
	 */
	public void setWallettype (java.lang.String wallettype) {
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
	 * Return the value associated with the column: CARDSN
	 */
	public java.lang.Integer getCardsn () {
		return cardsn;
	}

	/**
	 * Set the value related to the column: CARDSN
	 * @param cardsn the CARDSN value
	 */
	public void setCardsn (java.lang.Integer cardsn) {
		this.cardsn = cardsn;
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
	 * Return the value associated with the column: SAVEOPCONT
	 */
	public java.lang.Integer getSaveopcont () {
		return saveopcont;
	}

	/**
	 * Set the value related to the column: SAVEOPCONT
	 * @param saveopcont the SAVEOPCONT value
	 */
	public void setSaveopcont (java.lang.Integer saveopcont) {
		this.saveopcont = saveopcont;
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
	 * Return the value associated with the column: STATDATE
	 */
	public java.util.Date getStatdate () {
		return statdate;
	}

	/**
	 * Set the value related to the column: STATDATE
	 * @param statdate the STATDATE value
	 */
	public void setStatdate (java.util.Date statdate) {
		this.statdate = statdate;
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
	 * Return the value associated with the column: VER
	 */
	public java.lang.Integer getVer () {
		return ver;
	}

	/**
	 * Set the value related to the column: VER
	 * @param ver the VER value
	 */
	public void setVer (java.lang.Integer ver) {
		this.ver = ver;
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
	 * Return the value associated with the column: DSCRP
	 */
	public java.lang.String getDscrp () {
		return dscrp;
	}

	/**
	 * Set the value related to the column: DSCRP
	 * @param dscrp the DSCRP value
	 */
	public void setDscrp (java.lang.String dscrp) {
		this.dscrp = dscrp;
	}



	/**
	 * Return the value associated with the column: PLANID
	 */
	public java.lang.String getPlanid () {
		return planid;
	}

	/**
	 * Set the value related to the column: PLANID
	 * @param planid the PLANID value
	 */
	public void setPlanid (java.lang.String planid) {
		this.planid = planid;
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
	 * Return the value associated with the column: BUSINESSTYPE
	 */
	public java.lang.String getBusinesstype () {
		return businesstype;
	}

	/**
	 * Set the value related to the column: BUSINESSTYPE
	 * @param businesstype the BUSINESSTYPE value
	 */
	public void setBusinesstype (java.lang.String businesstype) {
		this.businesstype = businesstype;
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
	 * Return the value associated with the column: CARDTYPE
	 */
	public java.lang.String getCardtype () {
		return cardtype;
	}

	/**
	 * Set the value related to the column: CARDTYPE
	 * @param cardtype the CARDTYPE value
	 */
	public void setCardtype (java.lang.String cardtype) {
		this.cardtype = cardtype;
	}



	/**
	 * Return the value associated with the column: CARDKIND
	 */
	public java.lang.String getCardkind () {
		return cardkind;
	}

	/**
	 * Set the value related to the column: CARDKIND
	 * @param cardkind the CARDKIND value
	 */
	public void setCardkind (java.lang.String cardkind) {
		this.cardkind = cardkind;
	}



	/**
	 * Return the value associated with the column: ACCCODE
	 */
	public java.lang.String getAcccode () {
		return acccode;
	}

	/**
	 * Set the value related to the column: ACCCODE
	 * @param acccode the ACCCODE value
	 */
	public void setAcccode (java.lang.String acccode) {
		this.acccode = acccode;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.MoneySaveRepeat)) return false;
		else {
			cn.com.newcapec.citycard.common.po.MoneySaveRepeat moneySaveRepeat = (cn.com.newcapec.citycard.common.po.MoneySaveRepeat) obj;
			if (null == this.getId() || null == moneySaveRepeat.getId()) return false;
			else return (this.getId().equals(moneySaveRepeat.getId()));
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