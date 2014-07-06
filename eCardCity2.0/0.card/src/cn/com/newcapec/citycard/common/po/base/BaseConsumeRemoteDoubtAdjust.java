package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CONSUME_REMOTE_DOUBT_ADJUST table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CONSUME_REMOTE_DOUBT_ADJUST"
 */

public abstract class BaseConsumeRemoteDoubtAdjust  implements Comparable, Serializable {

	public static String REF = "ConsumeRemoteDoubtAdjust";
	public static String PROP_CARDVERSION = "cardversion";
	public static String PROP_CENTERCSTACCFC = "centercstaccfc";
	public static String PROP_CENTERACCOUNTDATE = "centeraccountdate";
	public static String PROP_OPFARE = "opfare";
	public static String PROP_ASN = "asn";
	public static String PROP_TRADEKIND = "tradekind";
	public static String PROP_OPCOUNT = "opcount";
	public static String PROP_OWNERCITYCODE = "ownercitycode";
	public static String PROP_OPTIME = "optime";
	public static String PROP_LOCKCARDFLAG = "lockcardflag";
	public static String PROP_TRADECITYCODE = "tradecitycode";
	public static String PROP_TESTFLAG = "testflag";
	public static String PROP_ID = "id";
	public static String PROP_CSTACCFC = "cstaccfc";
	public static String PROP_TAC = "tac";
	public static String PROP_ODDFARE = "oddfare";
	public static String PROP_OPDATE = "opdate";


	// constructors
	public BaseConsumeRemoteDoubtAdjust () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseConsumeRemoteDoubtAdjust (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseConsumeRemoteDoubtAdjust (
		java.lang.String id,
		java.lang.Integer cstaccfc,
		java.lang.String centercstaccfc,
		java.lang.String tradekind,
		java.lang.Integer lockcardflag,
		java.lang.String tradecitycode,
		java.lang.String ownercitycode,
		java.lang.Integer asn,
		java.lang.Integer opcount,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal opfare,
		java.lang.String opdate,
		java.lang.String optime,
		java.lang.String tac,
		java.lang.String cardversion,
		java.lang.String centeraccountdate,
		java.lang.Integer testflag) {

		this.setId(id);
		this.setCstaccfc(cstaccfc);
		this.setCentercstaccfc(centercstaccfc);
		this.setTradekind(tradekind);
		this.setLockcardflag(lockcardflag);
		this.setTradecitycode(tradecitycode);
		this.setOwnercitycode(ownercitycode);
		this.setAsn(asn);
		this.setOpcount(opcount);
		this.setOddfare(oddfare);
		this.setOpfare(opfare);
		this.setOpdate(opdate);
		this.setOptime(optime);
		this.setTac(tac);
		this.setCardversion(cardversion);
		this.setCenteraccountdate(centeraccountdate);
		this.setTestflag(testflag);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer cstaccfc;
	private java.lang.String centercstaccfc;
	private java.lang.String tradekind;
	private java.lang.Integer lockcardflag;
	private java.lang.String tradecitycode;
	private java.lang.String ownercitycode;
	private java.lang.Integer asn;
	private java.lang.Integer opcount;
	private java.math.BigDecimal oddfare;
	private java.math.BigDecimal opfare;
	private java.lang.String opdate;
	private java.lang.String optime;
	private java.lang.String tac;
	private java.lang.String cardversion;
	private java.lang.String centeraccountdate;
	private java.lang.Integer testflag;



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
	 * Return the value associated with the column: CSTACCFC
	 */
	public java.lang.Integer getCstaccfc () {
		return cstaccfc;
	}

	/**
	 * Set the value related to the column: CSTACCFC
	 * @param cstaccfc the CSTACCFC value
	 */
	public void setCstaccfc (java.lang.Integer cstaccfc) {
		this.cstaccfc = cstaccfc;
	}



	/**
	 * Return the value associated with the column: CENTERCSTACCFC
	 */
	public java.lang.String getCentercstaccfc () {
		return centercstaccfc;
	}

	/**
	 * Set the value related to the column: CENTERCSTACCFC
	 * @param centercstaccfc the CENTERCSTACCFC value
	 */
	public void setCentercstaccfc (java.lang.String centercstaccfc) {
		this.centercstaccfc = centercstaccfc;
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
	 * Return the value associated with the column: OPDATE
	 */
	public java.lang.String getOpdate () {
		return opdate;
	}

	/**
	 * Set the value related to the column: OPDATE
	 * @param opdate the OPDATE value
	 */
	public void setOpdate (java.lang.String opdate) {
		this.opdate = opdate;
	}



	/**
	 * Return the value associated with the column: OPTIME
	 */
	public java.lang.String getOptime () {
		return optime;
	}

	/**
	 * Set the value related to the column: OPTIME
	 * @param optime the OPTIME value
	 */
	public void setOptime (java.lang.String optime) {
		this.optime = optime;
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
	 * Return the value associated with the column: CARDVERSION
	 */
	public java.lang.String getCardversion () {
		return cardversion;
	}

	/**
	 * Set the value related to the column: CARDVERSION
	 * @param cardversion the CARDVERSION value
	 */
	public void setCardversion (java.lang.String cardversion) {
		this.cardversion = cardversion;
	}



	/**
	 * Return the value associated with the column: CENTERACCOUNTDATE
	 */
	public java.lang.String getCenteraccountdate () {
		return centeraccountdate;
	}

	/**
	 * Set the value related to the column: CENTERACCOUNTDATE
	 * @param centeraccountdate the CENTERACCOUNTDATE value
	 */
	public void setCenteraccountdate (java.lang.String centeraccountdate) {
		this.centeraccountdate = centeraccountdate;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.ConsumeRemoteDoubtAdjust)) return false;
		else {
			cn.com.newcapec.citycard.common.po.ConsumeRemoteDoubtAdjust consumeRemoteDoubtAdjust = (cn.com.newcapec.citycard.common.po.ConsumeRemoteDoubtAdjust) obj;
			if (null == this.getId() || null == consumeRemoteDoubtAdjust.getId()) return false;
			else return (this.getId().equals(consumeRemoteDoubtAdjust.getId()));
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