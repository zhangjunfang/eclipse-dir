package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the INTERFACE_PACKAGE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="INTERFACE_PACKAGE"
 */

public abstract class BaseInterfacePackage  implements Comparable, Serializable {

	public static String REF = "InterfacePackage";
	public static String PROP_FILEID = "fileid";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_LINENO = "lineno";
	public static String PROP_FILENAME = "filename";
	public static String PROP_MERCHANTCODE = "merchantcode";
	public static String PROP_OWNERCITYCODE = "ownercitycode";
	public static String PROP_LOCALCSTACCFC = "localcstaccfc";
	public static String PROP_TRADECITYCODE = "tradecitycode";
	public static String PROP_TESTFLAG = "testflag";
	public static String PROP_BUSINESSTYPE = "businesstype";
	public static String PROP_ID = "id";
	public static String PROP_OPDT = "opdt";
	public static String PROP_RESPCODE = "respcode";
	public static String PROP_ACCOUNTDATE = "accountdate";


	// constructors
	public BaseInterfacePackage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInterfacePackage (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer fileid;
	private java.lang.Integer localcstaccfc;
	private java.lang.String filename;
	private java.lang.Integer respcode;
	private java.lang.String merchantcode;
	private java.lang.String tradecitycode;
	private java.lang.String ownercitycode;
	private java.lang.String industrycode;
	private java.lang.String testflag;
	private java.lang.String businesstype;
	private java.util.Date opdt;
	private java.lang.Integer lineno;
	private java.util.Date accountdate;



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
	 * Return the value associated with the column: FILENAME
	 */
	public java.lang.String getFilename () {
		return filename;
	}

	/**
	 * Set the value related to the column: FILENAME
	 * @param filename the FILENAME value
	 */
	public void setFilename (java.lang.String filename) {
		this.filename = filename;
	}



	/**
	 * Return the value associated with the column: RESPCODE
	 */
	public java.lang.Integer getRespcode () {
		return respcode;
	}

	/**
	 * Set the value related to the column: RESPCODE
	 * @param respcode the RESPCODE value
	 */
	public void setRespcode (java.lang.Integer respcode) {
		this.respcode = respcode;
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
	 * Return the value associated with the column: TESTFLAG
	 */
	public java.lang.String getTestflag () {
		return testflag;
	}

	/**
	 * Set the value related to the column: TESTFLAG
	 * @param testflag the TESTFLAG value
	 */
	public void setTestflag (java.lang.String testflag) {
		this.testflag = testflag;
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
	 * Return the value associated with the column: LINENO
	 */
	public java.lang.Integer getLineno () {
		return lineno;
	}

	/**
	 * Set the value related to the column: LINENO
	 * @param lineno the LINENO value
	 */
	public void setLineno (java.lang.Integer lineno) {
		this.lineno = lineno;
	}



	/**
	 * Return the value associated with the column: ACCOUNTDATE
	 */
	public java.util.Date getAccountdate () {
		return accountdate;
	}

	/**
	 * Set the value related to the column: ACCOUNTDATE
	 * @param accountdate the ACCOUNTDATE value
	 */
	public void setAccountdate (java.util.Date accountdate) {
		this.accountdate = accountdate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.InterfacePackage)) return false;
		else {
			cn.com.newcapec.citycard.common.po.InterfacePackage interfacePackage = (cn.com.newcapec.citycard.common.po.InterfacePackage) obj;
			if (null == this.getId() || null == interfacePackage.getId()) return false;
			else return (this.getId().equals(interfacePackage.getId()));
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