package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CARD_MONEY_SUM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CARD_MONEY_SUM"
 */

public abstract class BaseCardMoneySum  implements Comparable, Serializable {

	public static String REF = "CardMoneySum";
	public static String PROP_SUMLOAD = "sumload";
	public static String PROP_SUMSAVE = "sumsave";
	public static String PROP_SAVEOPCOUNT = "saveopcount";
	public static String PROP_SUMCONSUMEFARE = "sumconsumefare";
	public static String PROP_ODDFAREACC = "oddfareacc";
	public static String PROP_WALLETTYPE = "wallettype";
	public static String PROP_APPINFO_ID = "appinfoId";
	public static String PROP_SUMADDFARE = "sumaddfare";
	public static String PROP_ID = "id";
	public static String PROP_ODDFARE = "oddfare";
	public static String PROP_SUMQC = "sumqc";
	public static String PROP_OPCOUNT = "opcount";


	// constructors
	public BaseCardMoneySum () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCardMoneySum (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCardMoneySum (
		java.lang.String id,
		java.lang.String appinfoId,
		java.lang.String wallettype,
		java.lang.Integer opcount,
		java.lang.Integer saveopcount,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal oddfareacc,
		java.math.BigDecimal sumconsumefare,
		java.math.BigDecimal sumaddfare,
		java.math.BigDecimal sumqc,
		java.math.BigDecimal sumload,
		java.math.BigDecimal sumsave) {

		this.setId(id);
		this.setAppinfoId(appinfoId);
		this.setWallettype(wallettype);
		this.setOpcount(opcount);
		this.setSaveopcount(saveopcount);
		this.setOddfare(oddfare);
		this.setOddfareacc(oddfareacc);
		this.setSumconsumefare(sumconsumefare);
		this.setSumaddfare(sumaddfare);
		this.setSumqc(sumqc);
		this.setSumload(sumload);
		this.setSumsave(sumsave);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String appinfoId;
	private java.lang.String wallettype;
	private java.lang.Integer opcount;
	private java.lang.Integer saveopcount;
	private java.math.BigDecimal oddfare;
	private java.math.BigDecimal oddfareacc;
	private java.math.BigDecimal sumconsumefare;
	private java.math.BigDecimal sumaddfare;
	private java.math.BigDecimal sumqc;
	private java.math.BigDecimal sumload;
	private java.math.BigDecimal sumsave;



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
	 * Return the value associated with the column: APPINFO_ID
	 */
	public java.lang.String getAppinfoId () {
		return appinfoId;
	}

	/**
	 * Set the value related to the column: APPINFO_ID
	 * @param appinfoId the APPINFO_ID value
	 */
	public void setAppinfoId (java.lang.String appinfoId) {
		this.appinfoId = appinfoId;
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
	 * Return the value associated with the column: SAVEOPCOUNT
	 */
	public java.lang.Integer getSaveopcount () {
		return saveopcount;
	}

	/**
	 * Set the value related to the column: SAVEOPCOUNT
	 * @param saveopcount the SAVEOPCOUNT value
	 */
	public void setSaveopcount (java.lang.Integer saveopcount) {
		this.saveopcount = saveopcount;
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
	 * Return the value associated with the column: ODDFAREACC
	 */
	public java.math.BigDecimal getOddfareacc () {
		return oddfareacc;
	}

	/**
	 * Set the value related to the column: ODDFAREACC
	 * @param oddfareacc the ODDFAREACC value
	 */
	public void setOddfareacc (java.math.BigDecimal oddfareacc) {
		this.oddfareacc = oddfareacc;
	}



	/**
	 * Return the value associated with the column: SUMCONSUMEFARE
	 */
	public java.math.BigDecimal getSumconsumefare () {
		return sumconsumefare;
	}

	/**
	 * Set the value related to the column: SUMCONSUMEFARE
	 * @param sumconsumefare the SUMCONSUMEFARE value
	 */
	public void setSumconsumefare (java.math.BigDecimal sumconsumefare) {
		this.sumconsumefare = sumconsumefare;
	}



	/**
	 * Return the value associated with the column: SUMADDFARE
	 */
	public java.math.BigDecimal getSumaddfare () {
		return sumaddfare;
	}

	/**
	 * Set the value related to the column: SUMADDFARE
	 * @param sumaddfare the SUMADDFARE value
	 */
	public void setSumaddfare (java.math.BigDecimal sumaddfare) {
		this.sumaddfare = sumaddfare;
	}



	/**
	 * Return the value associated with the column: SUMQC
	 */
	public java.math.BigDecimal getSumqc () {
		return sumqc;
	}

	/**
	 * Set the value related to the column: SUMQC
	 * @param sumqc the SUMQC value
	 */
	public void setSumqc (java.math.BigDecimal sumqc) {
		this.sumqc = sumqc;
	}



	/**
	 * Return the value associated with the column: SUMLOAD
	 */
	public java.math.BigDecimal getSumload () {
		return sumload;
	}

	/**
	 * Set the value related to the column: SUMLOAD
	 * @param sumload the SUMLOAD value
	 */
	public void setSumload (java.math.BigDecimal sumload) {
		this.sumload = sumload;
	}



	/**
	 * Return the value associated with the column: SUMSAVE
	 */
	public java.math.BigDecimal getSumsave () {
		return sumsave;
	}

	/**
	 * Set the value related to the column: SUMSAVE
	 * @param sumsave the SUMSAVE value
	 */
	public void setSumsave (java.math.BigDecimal sumsave) {
		this.sumsave = sumsave;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CardMoneySum)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CardMoneySum cardMoneySum = (cn.com.newcapec.citycard.common.po.CardMoneySum) obj;
			if (null == this.getId() || null == cardMoneySum.getId()) return false;
			else return (this.getId().equals(cardMoneySum.getId()));
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