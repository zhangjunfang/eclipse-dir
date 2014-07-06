package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CUSTOMER_FINGERPRINT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CUSTOMER_FINGERPRINT"
 */

public abstract class BaseCustomerFingerprint  implements Comparable, Serializable {

	public static String REF = "CustomerFingerprint";
	public static String PROP_FIRSTFINGER = "firstfinger";
	public static String PROP_FOURTHFINGER = "fourthfinger";
	public static String PROP_SECONDFINGER = "secondfinger";
	public static String PROP_FINGERDATE = "fingerdate";
	public static String PROP_THIRDFINGER = "thirdfinger";
	public static String PROP_ID = "id";
	public static String PROP_FINGERCOUNT = "fingercount";
	public static String PROP_CUSTOMERID = "customerid";


	// constructors
	public BaseCustomerFingerprint () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomerFingerprint (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomerFingerprint (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.String firstfinger,
		java.lang.String secondfinger,
		java.lang.Integer fingercount,
		java.util.Date fingerdate) {

		this.setId(id);
		this.setCustomerid(customerid);
		this.setFirstfinger(firstfinger);
		this.setSecondfinger(secondfinger);
		this.setFingercount(fingercount);
		this.setFingerdate(fingerdate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String customerid;
	private java.lang.String firstfinger;
	private java.lang.String secondfinger;
	private java.lang.String thirdfinger;
	private java.lang.String fourthfinger;
	private java.lang.Integer fingercount;
	private java.util.Date fingerdate;



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
	 * Return the value associated with the column: FIRSTFINGER
	 */
	public java.lang.String getFirstfinger () {
		return firstfinger;
	}

	/**
	 * Set the value related to the column: FIRSTFINGER
	 * @param firstfinger the FIRSTFINGER value
	 */
	public void setFirstfinger (java.lang.String firstfinger) {
		this.firstfinger = firstfinger;
	}



	/**
	 * Return the value associated with the column: SECONDFINGER
	 */
	public java.lang.String getSecondfinger () {
		return secondfinger;
	}

	/**
	 * Set the value related to the column: SECONDFINGER
	 * @param secondfinger the SECONDFINGER value
	 */
	public void setSecondfinger (java.lang.String secondfinger) {
		this.secondfinger = secondfinger;
	}



	/**
	 * Return the value associated with the column: THIRDFINGER
	 */
	public java.lang.String getThirdfinger () {
		return thirdfinger;
	}

	/**
	 * Set the value related to the column: THIRDFINGER
	 * @param thirdfinger the THIRDFINGER value
	 */
	public void setThirdfinger (java.lang.String thirdfinger) {
		this.thirdfinger = thirdfinger;
	}



	/**
	 * Return the value associated with the column: FOURTHFINGER
	 */
	public java.lang.String getFourthfinger () {
		return fourthfinger;
	}

	/**
	 * Set the value related to the column: FOURTHFINGER
	 * @param fourthfinger the FOURTHFINGER value
	 */
	public void setFourthfinger (java.lang.String fourthfinger) {
		this.fourthfinger = fourthfinger;
	}



	/**
	 * Return the value associated with the column: FINGERCOUNT
	 */
	public java.lang.Integer getFingercount () {
		return fingercount;
	}

	/**
	 * Set the value related to the column: FINGERCOUNT
	 * @param fingercount the FINGERCOUNT value
	 */
	public void setFingercount (java.lang.Integer fingercount) {
		this.fingercount = fingercount;
	}



	/**
	 * Return the value associated with the column: FINGERDATE
	 */
	public java.util.Date getFingerdate () {
		return fingerdate;
	}

	/**
	 * Set the value related to the column: FINGERDATE
	 * @param fingerdate the FINGERDATE value
	 */
	public void setFingerdate (java.util.Date fingerdate) {
		this.fingerdate = fingerdate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CustomerFingerprint)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CustomerFingerprint customerFingerprint = (cn.com.newcapec.citycard.common.po.CustomerFingerprint) obj;
			if (null == this.getId() || null == customerFingerprint.getId()) return false;
			else return (this.getId().equals(customerFingerprint.getId()));
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