package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_APP_ACCESS_INDUSTRY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_APP_ACCESS_INDUSTRY"
 */

public abstract class BaseBaseAppAccessIndustry  implements Comparable, Serializable {

	public static String REF = "BaseAppAccessIndustry";
	public static String PROP_IP = "ip";
	public static String PROP_PORT = "port";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_ALLOWABLE_IP = "allowableIp";
	public static String PROP_ID = "id";
	public static String PROP_INDUSTRYTYPE = "industrytype";
	public static String PROP_LOCALPASS = "localpass";
	public static String PROP_REMOTEPASS = "remotepass";


	// constructors
	public BaseBaseAppAccessIndustry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseAppAccessIndustry (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String industrycode;
	private java.lang.String ip;
	private java.lang.String port;
	private java.lang.String remotepass;
	private java.lang.String localpass;
	private java.lang.String allowableIp;
	private java.lang.String industrytype;



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
	 * Return the value associated with the column: IP
	 */
	public java.lang.String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: IP
	 * @param ip the IP value
	 */
	public void setIp (java.lang.String ip) {
		this.ip = ip;
	}



	/**
	 * Return the value associated with the column: PORT
	 */
	public java.lang.String getPort () {
		return port;
	}

	/**
	 * Set the value related to the column: PORT
	 * @param port the PORT value
	 */
	public void setPort (java.lang.String port) {
		this.port = port;
	}



	/**
	 * Return the value associated with the column: REMOTEPASS
	 */
	public java.lang.String getRemotepass () {
		return remotepass;
	}

	/**
	 * Set the value related to the column: REMOTEPASS
	 * @param remotepass the REMOTEPASS value
	 */
	public void setRemotepass (java.lang.String remotepass) {
		this.remotepass = remotepass;
	}



	/**
	 * Return the value associated with the column: LOCALPASS
	 */
	public java.lang.String getLocalpass () {
		return localpass;
	}

	/**
	 * Set the value related to the column: LOCALPASS
	 * @param localpass the LOCALPASS value
	 */
	public void setLocalpass (java.lang.String localpass) {
		this.localpass = localpass;
	}



	/**
	 * Return the value associated with the column: ALLOWABLE_IP
	 */
	public java.lang.String getAllowableIp () {
		return allowableIp;
	}

	/**
	 * Set the value related to the column: ALLOWABLE_IP
	 * @param allowableIp the ALLOWABLE_IP value
	 */
	public void setAllowableIp (java.lang.String allowableIp) {
		this.allowableIp = allowableIp;
	}



	/**
	 * Return the value associated with the column: INDUSTRYTYPE
	 */
	public java.lang.String getIndustrytype () {
		return industrytype;
	}

	/**
	 * Set the value related to the column: INDUSTRYTYPE
	 * @param industrytype the INDUSTRYTYPE value
	 */
	public void setIndustrytype (java.lang.String industrytype) {
		this.industrytype = industrytype;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseAppAccessIndustry)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseAppAccessIndustry baseAppAccessIndustry = (cn.com.newcapec.citycard.common.po.BaseAppAccessIndustry) obj;
			if (null == this.getId() || null == baseAppAccessIndustry.getId()) return false;
			else return (this.getId().equals(baseAppAccessIndustry.getId()));
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