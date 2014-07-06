package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the FARE_COMPLEX_AUTOPAY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FARE_COMPLEX_AUTOPAY"
 */

public abstract class BaseFareComplexAutopay  implements Comparable, Serializable {

	public static String REF = "FareComplexAutopay";
	public static String PROP_TRADENO = "tradeno";
	public static String PROP_BINDCSTACCFC = "bindcstaccfc";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_EMPCARDNO = "empcardno";
	public static String PROP_OLINENO = "olineno";
	public static String PROP_ID = "id";
	public static String PROP_LASTPAYDT = "lastpaydt";


	// constructors
	public BaseFareComplexAutopay () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFareComplexAutopay (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFareComplexAutopay (
		java.lang.String id,
		java.lang.Integer bindcstaccfc,
		java.lang.String olineno,
		java.lang.String industrycode,
		java.lang.String tradeno) {

		this.setId(id);
		this.setBindcstaccfc(bindcstaccfc);
		this.setOlineno(olineno);
		this.setIndustrycode(industrycode);
		this.setTradeno(tradeno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer bindcstaccfc;
	private java.lang.Integer empcardno;
	private java.lang.String olineno;
	private java.lang.String industrycode;
	private java.lang.String tradeno;
	private java.util.Date lastpaydt;



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
	 * Return the value associated with the column: BINDCSTACCFC
	 */
	public java.lang.Integer getBindcstaccfc () {
		return bindcstaccfc;
	}

	/**
	 * Set the value related to the column: BINDCSTACCFC
	 * @param bindcstaccfc the BINDCSTACCFC value
	 */
	public void setBindcstaccfc (java.lang.Integer bindcstaccfc) {
		this.bindcstaccfc = bindcstaccfc;
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
	 * Return the value associated with the column: LASTPAYDT
	 */
	public java.util.Date getLastpaydt () {
		return lastpaydt;
	}

	/**
	 * Set the value related to the column: LASTPAYDT
	 * @param lastpaydt the LASTPAYDT value
	 */
	public void setLastpaydt (java.util.Date lastpaydt) {
		this.lastpaydt = lastpaydt;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.FareComplexAutopay)) return false;
		else {
			cn.com.newcapec.citycard.common.po.FareComplexAutopay fareComplexAutopay = (cn.com.newcapec.citycard.common.po.FareComplexAutopay) obj;
			if (null == this.getId() || null == fareComplexAutopay.getId()) return false;
			else return (this.getId().equals(fareComplexAutopay.getId()));
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