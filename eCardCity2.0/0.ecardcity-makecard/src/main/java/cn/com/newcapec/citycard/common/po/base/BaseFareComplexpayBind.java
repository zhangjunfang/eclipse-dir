package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the FARE_COMPLEXPAY_BIND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FARE_COMPLEXPAY_BIND"
 */

public abstract class BaseFareComplexpayBind  implements Comparable, Serializable {

	public static String REF = "FareComplexpayBind";
	public static String PROP_SUBMITDT = "submitdt";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_EMPCARDNO = "empcardno";
	public static String PROP_CITYCARDNO = "citycardno";
	public static String PROP_TRCFLG = "trcflg";
	public static String PROP_TRADETYPE = "tradetype";
	public static String PROP_MERCHANTCODE = "merchantcode";
	public static String PROP_PROFESSIONCITYCODE = "professioncitycode";
	public static String PROP_TRADENO = "tradeno";
	public static String PROP_VER = "ver";
	public static String PROP_ISCANUSE = "iscanuse";
	public static String PROP_ALLOWBINDDT = "allowbinddt";
	public static String PROP_RECNO = "recno";
	public static String PROP_ISAUTOPAYFOR = "isautopayfor";
	public static String PROP_MEMO = "memo";
	public static String PROP_MNGFARE = "mngfare";
	public static String PROP_OLINENO = "olineno";
	public static String PROP_TESTFLAG = "testflag";
	public static String PROP_ID = "id";
	public static String PROP_TAC = "tac";
	public static String PROP_RECORDSTATUS = "recordstatus";
	public static String PROP_TERMID = "termid";
	public static String PROP_SERVERID = "serverid";


	// constructors
	public BaseFareComplexpayBind () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFareComplexpayBind (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFareComplexpayBind (
		java.lang.String id,
		java.lang.Integer empcardno,
		java.lang.String termid,
		java.util.Date allowbinddt,
		java.util.Date submitdt,
		java.lang.Integer mngfare,
		java.lang.Integer trcflg,
		java.lang.Integer serverid,
		java.lang.Integer recordstatus,
		java.lang.Integer tradetype,
		java.lang.Integer testflag,
		java.lang.String industrycode) {

		this.setId(id);
		this.setEmpcardno(empcardno);
		this.setTermid(termid);
		this.setAllowbinddt(allowbinddt);
		this.setSubmitdt(submitdt);
		this.setMngfare(mngfare);
		this.setTrcflg(trcflg);
		this.setServerid(serverid);
		this.setRecordstatus(recordstatus);
		this.setTradetype(tradetype);
		this.setTestflag(testflag);
		this.setIndustrycode(industrycode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer empcardno;
	private java.lang.String termid;
	private java.util.Date allowbinddt;
	private java.util.Date submitdt;
	private java.lang.Integer recno;
	private java.lang.Integer ver;
	private java.lang.String memo;
	private java.lang.Integer mngfare;
	private java.lang.Integer trcflg;
	private java.lang.Integer serverid;
	private java.lang.Integer tac;
	private java.lang.String merchantcode;
	private java.lang.String professioncitycode;
	private java.lang.Integer recordstatus;
	private java.lang.Integer tradetype;
	private java.lang.Integer testflag;
	private java.lang.Integer iscanuse;
	private java.lang.Integer isautopayfor;
	private java.lang.String tradeno;
	private java.lang.String citycardno;
	private java.lang.String industrycode;
	private java.lang.String olineno;



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
	 * Return the value associated with the column: EMPCARDNO
	 */
	public java.lang.Integer getEmpcardno () {
		return empcardno;
	}

	/**
	 * Set the value related to the column: EMPCARDNO
	 * @param empcardno the EMPCARDNO value
	 */
	public void setEmpcardno (java.lang.Integer empcardno) {
		this.empcardno = empcardno;
	}



	/**
	 * Return the value associated with the column: TERMID
	 */
	public java.lang.String getTermid () {
		return termid;
	}

	/**
	 * Set the value related to the column: TERMID
	 * @param termid the TERMID value
	 */
	public void setTermid (java.lang.String termid) {
		this.termid = termid;
	}



	/**
	 * Return the value associated with the column: ALLOWBINDDT
	 */
	public java.util.Date getAllowbinddt () {
		return allowbinddt;
	}

	/**
	 * Set the value related to the column: ALLOWBINDDT
	 * @param allowbinddt the ALLOWBINDDT value
	 */
	public void setAllowbinddt (java.util.Date allowbinddt) {
		this.allowbinddt = allowbinddt;
	}



	/**
	 * Return the value associated with the column: SUBMITDT
	 */
	public java.util.Date getSubmitdt () {
		return submitdt;
	}

	/**
	 * Set the value related to the column: SUBMITDT
	 * @param submitdt the SUBMITDT value
	 */
	public void setSubmitdt (java.util.Date submitdt) {
		this.submitdt = submitdt;
	}



	/**
	 * Return the value associated with the column: RECNO
	 */
	public java.lang.Integer getRecno () {
		return recno;
	}

	/**
	 * Set the value related to the column: RECNO
	 * @param recno the RECNO value
	 */
	public void setRecno (java.lang.Integer recno) {
		this.recno = recno;
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
	 * Return the value associated with the column: MEMO
	 */
	public java.lang.String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: MEMO
	 * @param memo the MEMO value
	 */
	public void setMemo (java.lang.String memo) {
		this.memo = memo;
	}



	/**
	 * Return the value associated with the column: MNGFARE
	 */
	public java.lang.Integer getMngfare () {
		return mngfare;
	}

	/**
	 * Set the value related to the column: MNGFARE
	 * @param mngfare the MNGFARE value
	 */
	public void setMngfare (java.lang.Integer mngfare) {
		this.mngfare = mngfare;
	}



	/**
	 * Return the value associated with the column: TRCFLG
	 */
	public java.lang.Integer getTrcflg () {
		return trcflg;
	}

	/**
	 * Set the value related to the column: TRCFLG
	 * @param trcflg the TRCFLG value
	 */
	public void setTrcflg (java.lang.Integer trcflg) {
		this.trcflg = trcflg;
	}



	/**
	 * Return the value associated with the column: SERVERID
	 */
	public java.lang.Integer getServerid () {
		return serverid;
	}

	/**
	 * Set the value related to the column: SERVERID
	 * @param serverid the SERVERID value
	 */
	public void setServerid (java.lang.Integer serverid) {
		this.serverid = serverid;
	}



	/**
	 * Return the value associated with the column: TAC
	 */
	public java.lang.Integer getTac () {
		return tac;
	}

	/**
	 * Set the value related to the column: TAC
	 * @param tac the TAC value
	 */
	public void setTac (java.lang.Integer tac) {
		this.tac = tac;
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
	 * Return the value associated with the column: PROFESSIONCITYCODE
	 */
	public java.lang.String getProfessioncitycode () {
		return professioncitycode;
	}

	/**
	 * Set the value related to the column: PROFESSIONCITYCODE
	 * @param professioncitycode the PROFESSIONCITYCODE value
	 */
	public void setProfessioncitycode (java.lang.String professioncitycode) {
		this.professioncitycode = professioncitycode;
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
	 * Return the value associated with the column: TRADETYPE
	 */
	public java.lang.Integer getTradetype () {
		return tradetype;
	}

	/**
	 * Set the value related to the column: TRADETYPE
	 * @param tradetype the TRADETYPE value
	 */
	public void setTradetype (java.lang.Integer tradetype) {
		this.tradetype = tradetype;
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
	 * Return the value associated with the column: ISCANUSE
	 */
	public java.lang.Integer getIscanuse () {
		return iscanuse;
	}

	/**
	 * Set the value related to the column: ISCANUSE
	 * @param iscanuse the ISCANUSE value
	 */
	public void setIscanuse (java.lang.Integer iscanuse) {
		this.iscanuse = iscanuse;
	}



	/**
	 * Return the value associated with the column: ISAUTOPAYFOR
	 */
	public java.lang.Integer getIsautopayfor () {
		return isautopayfor;
	}

	/**
	 * Set the value related to the column: ISAUTOPAYFOR
	 * @param isautopayfor the ISAUTOPAYFOR value
	 */
	public void setIsautopayfor (java.lang.Integer isautopayfor) {
		this.isautopayfor = isautopayfor;
	}



	/**
	 * Return the value associated with the column: TRADENO
	 */
	public java.lang.String getTradeno () {
		return tradeno;
	}

	/**
	 * Set the value related to the column: TRADENO
	 * @param tradeno the TRADENO value
	 */
	public void setTradeno (java.lang.String tradeno) {
		this.tradeno = tradeno;
	}



	/**
	 * Return the value associated with the column: CITYCARDNO
	 */
	public java.lang.String getCitycardno () {
		return citycardno;
	}

	/**
	 * Set the value related to the column: CITYCARDNO
	 * @param citycardno the CITYCARDNO value
	 */
	public void setCitycardno (java.lang.String citycardno) {
		this.citycardno = citycardno;
	}



	/**
	 * Return the value associated with the column: INDUSTRYCODE
	 */
	public java.lang.String getIndustrycode () {
		return industrycode;
	}

	/**
	 * Set the value related to the column: INDUSTRYCODE
	 * @param industrycode the INDUSTRYCODE value
	 */
	public void setIndustrycode (java.lang.String industrycode) {
		this.industrycode = industrycode;
	}



	/**
	 * Return the value associated with the column: OLINENO
	 */
	public java.lang.String getOlineno () {
		return olineno;
	}

	/**
	 * Set the value related to the column: OLINENO
	 * @param olineno the OLINENO value
	 */
	public void setOlineno (java.lang.String olineno) {
		this.olineno = olineno;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.FareComplexpayBind)) return false;
		else {
			cn.com.newcapec.citycard.common.po.FareComplexpayBind fareComplexpayBind = (cn.com.newcapec.citycard.common.po.FareComplexpayBind) obj;
			if (null == this.getId() || null == fareComplexpayBind.getId()) return false;
			else return (this.getId().equals(fareComplexpayBind.getId()));
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