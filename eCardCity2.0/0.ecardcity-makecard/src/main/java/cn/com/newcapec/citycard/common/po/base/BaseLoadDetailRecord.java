package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the LOAD_DETAIL_RECORD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="LOAD_DETAIL_RECORD"
 */

public abstract class BaseLoadDetailRecord  implements Comparable, Serializable {

	public static String REF = "LoadDetailRecord";
	public static String PROP_SUCCED = "succed";
	public static String PROP_TRADESTATUS = "tradestatus";
	public static String PROP_BANKDZ = "bankdz";
	public static String PROP_PLAN_ID = "planId";
	public static String PROP_BANKRET = "bankret";
	public static String PROP_BANKTRADENO = "banktradeno";
	public static String PROP_ST_DATE = "stDate";
	public static String PROP_FUNDS_WAY = "fundsWay";
	public static String PROP_OPFARE = "opfare";
	public static String PROP_FOOTDT = "footdt";
	public static String PROP_ASN = "asn";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_NOTES = "notes";
	public static String PROP_FIXFOOTDT = "fixfootdt";
	public static String PROP_TERMTRADENO = "termtradeno";
	public static String PROP_BANKCARDNO = "bankcardno";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_SIGN_WAY = "signWay";
	public static String PROP_BANKRECNO = "bankrecno";
	public static String PROP_BANKRETDESC = "bankretdesc";
	public static String PROP_ACCCODE = "acccode";
	public static String PROP_ID = "id";
	public static String PROP_TERMID = "termid";


	// constructors
	public BaseLoadDetailRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLoadDetailRecord (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLoadDetailRecord (
		java.lang.String id,
		java.lang.Integer bankrecno,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.math.BigDecimal opfare,
		java.lang.String fundsWay,
		java.lang.String bankcardno,
		java.lang.String acccode,
		java.lang.Integer termid,
		java.lang.Integer termtradeno,
		java.lang.String signWay,
		java.util.Date editDate) {

		this.setId(id);
		this.setBankrecno(bankrecno);
		this.setCustomerid(customerid);
		this.setAsn(asn);
		this.setOpfare(opfare);
		this.setFundsWay(fundsWay);
		this.setBankcardno(bankcardno);
		this.setAcccode(acccode);
		this.setTermid(termid);
		this.setTermtradeno(termtradeno);
		this.setSignWay(signWay);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer bankrecno;
	private java.lang.String customerid;
	private java.lang.Integer asn;
	private java.math.BigDecimal opfare;
	private java.lang.Integer footdt;
	private java.lang.Integer fixfootdt;
	private java.lang.String fundsWay;
	private java.lang.String bankcardno;
	private java.lang.String banktradeno;
	private java.lang.String bankret;
	private java.lang.String bankretdesc;
	private java.lang.String bankdz;
	private java.lang.String acccode;
	private java.lang.Integer termid;
	private java.lang.Integer termtradeno;
	private java.lang.String tradestatus;
	private java.lang.String succed;
	private java.lang.String planId;
	private java.lang.String signWay;
	private java.lang.String notes;
	private java.util.Date stDate;
	private java.util.Date editDate;



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
	 * Return the value associated with the column: BANKRECNO
	 */
	public java.lang.Integer getBankrecno () {
		return bankrecno;
	}

	/**
	 * Set the value related to the column: BANKRECNO
	 * @param bankrecno the BANKRECNO value
	 */
	public void setBankrecno (java.lang.Integer bankrecno) {
		this.bankrecno = bankrecno;
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
	 * Return the value associated with the column: FOOTDT
	 */
	public java.lang.Integer getFootdt () {
		return footdt;
	}

	/**
	 * Set the value related to the column: FOOTDT
	 * @param footdt the FOOTDT value
	 */
	public void setFootdt (java.lang.Integer footdt) {
		this.footdt = footdt;
	}



	/**
	 * Return the value associated with the column: FIXFOOTDT
	 */
	public java.lang.Integer getFixfootdt () {
		return fixfootdt;
	}

	/**
	 * Set the value related to the column: FIXFOOTDT
	 * @param fixfootdt the FIXFOOTDT value
	 */
	public void setFixfootdt (java.lang.Integer fixfootdt) {
		this.fixfootdt = fixfootdt;
	}



	/**
	 * Return the value associated with the column: FUNDS_WAY
	 */
	public java.lang.String getFundsWay () {
		return fundsWay;
	}

	/**
	 * Set the value related to the column: FUNDS_WAY
	 * @param fundsWay the FUNDS_WAY value
	 */
	public void setFundsWay (java.lang.String fundsWay) {
		this.fundsWay = fundsWay;
	}



	/**
	 * Return the value associated with the column: BANKCARDNO
	 */
	public java.lang.String getBankcardno () {
		return bankcardno;
	}

	/**
	 * Set the value related to the column: BANKCARDNO
	 * @param bankcardno the BANKCARDNO value
	 */
	public void setBankcardno (java.lang.String bankcardno) {
		this.bankcardno = bankcardno;
	}



	/**
	 * Return the value associated with the column: BANKTRADENO
	 */
	public java.lang.String getBanktradeno () {
		return banktradeno;
	}

	/**
	 * Set the value related to the column: BANKTRADENO
	 * @param banktradeno the BANKTRADENO value
	 */
	public void setBanktradeno (java.lang.String banktradeno) {
		this.banktradeno = banktradeno;
	}



	/**
	 * Return the value associated with the column: BANKRET
	 */
	public java.lang.String getBankret () {
		return bankret;
	}

	/**
	 * Set the value related to the column: BANKRET
	 * @param bankret the BANKRET value
	 */
	public void setBankret (java.lang.String bankret) {
		this.bankret = bankret;
	}



	/**
	 * Return the value associated with the column: BANKRETDESC
	 */
	public java.lang.String getBankretdesc () {
		return bankretdesc;
	}

	/**
	 * Set the value related to the column: BANKRETDESC
	 * @param bankretdesc the BANKRETDESC value
	 */
	public void setBankretdesc (java.lang.String bankretdesc) {
		this.bankretdesc = bankretdesc;
	}



	/**
	 * Return the value associated with the column: BANKDZ
	 */
	public java.lang.String getBankdz () {
		return bankdz;
	}

	/**
	 * Set the value related to the column: BANKDZ
	 * @param bankdz the BANKDZ value
	 */
	public void setBankdz (java.lang.String bankdz) {
		this.bankdz = bankdz;
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



	/**
	 * Return the value associated with the column: TERMID
	 */
	public java.lang.Integer getTermid () {
		return termid;
	}

	/**
	 * Set the value related to the column: TERMID
	 * @param termid the TERMID value
	 */
	public void setTermid (java.lang.Integer termid) {
		this.termid = termid;
	}



	/**
	 * Return the value associated with the column: TERMTRADENO
	 */
	public java.lang.Integer getTermtradeno () {
		return termtradeno;
	}

	/**
	 * Set the value related to the column: TERMTRADENO
	 * @param termtradeno the TERMTRADENO value
	 */
	public void setTermtradeno (java.lang.Integer termtradeno) {
		this.termtradeno = termtradeno;
	}



	/**
	 * Return the value associated with the column: TRADESTATUS
	 */
	public java.lang.String getTradestatus () {
		return tradestatus;
	}

	/**
	 * Set the value related to the column: TRADESTATUS
	 * @param tradestatus the TRADESTATUS value
	 */
	public void setTradestatus (java.lang.String tradestatus) {
		this.tradestatus = tradestatus;
	}



	/**
	 * Return the value associated with the column: SUCCED
	 */
	public java.lang.String getSucced () {
		return succed;
	}

	/**
	 * Set the value related to the column: SUCCED
	 * @param succed the SUCCED value
	 */
	public void setSucced (java.lang.String succed) {
		this.succed = succed;
	}



	/**
	 * Return the value associated with the column: PLAN_ID
	 */
	public java.lang.String getPlanId () {
		return planId;
	}

	/**
	 * Set the value related to the column: PLAN_ID
	 * @param planId the PLAN_ID value
	 */
	public void setPlanId (java.lang.String planId) {
		this.planId = planId;
	}



	/**
	 * Return the value associated with the column: SIGN_WAY
	 */
	public java.lang.String getSignWay () {
		return signWay;
	}

	/**
	 * Set the value related to the column: SIGN_WAY
	 * @param signWay the SIGN_WAY value
	 */
	public void setSignWay (java.lang.String signWay) {
		this.signWay = signWay;
	}



	/**
	 * Return the value associated with the column: NOTES
	 */
	public java.lang.String getNotes () {
		return notes;
	}

	/**
	 * Set the value related to the column: NOTES
	 * @param notes the NOTES value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
	}



	/**
	 * Return the value associated with the column: ST_DATE
	 */
	public java.util.Date getStDate () {
		return stDate;
	}

	/**
	 * Set the value related to the column: ST_DATE
	 * @param stDate the ST_DATE value
	 */
	public void setStDate (java.util.Date stDate) {
		this.stDate = stDate;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.LoadDetailRecord)) return false;
		else {
			cn.com.newcapec.citycard.common.po.LoadDetailRecord loadDetailRecord = (cn.com.newcapec.citycard.common.po.LoadDetailRecord) obj;
			if (null == this.getId() || null == loadDetailRecord.getId()) return false;
			else return (this.getId().equals(loadDetailRecord.getId()));
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