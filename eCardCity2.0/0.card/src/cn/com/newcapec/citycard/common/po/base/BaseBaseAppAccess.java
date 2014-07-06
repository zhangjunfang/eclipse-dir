package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_APP_ACCESS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_APP_ACCESS"
 */

public abstract class BaseBaseAppAccess  implements Comparable, Serializable {

	public static String REF = "BaseAppAccess";
	public static String PROP_VER = "ver";
	public static String PROP_IPADDESS = "ipaddess";
	public static String PROP_APPID = "appid";
	public static String PROP_APPVER = "appver";
	public static String PROP_MEMO = "memo";
	public static String PROP_APPNAME = "appname";
	public static String PROP_ID = "id";
	public static String PROP_SALTKEY = "saltkey";
	public static String PROP_SECRETKEY = "secretkey";
	public static String PROP_ISUSED = "isused";


	// constructors
	public BaseBaseAppAccess () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseAppAccess (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer appid;
	private java.lang.String appname;
	private java.lang.String ipaddess;
	private java.lang.String appver;
	private java.lang.String saltkey;
	private java.lang.Integer isused;
	private java.lang.String memo;
	private java.lang.Integer ver;
	private java.lang.String secretkey;



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
	 * Return the value associated with the column: APPID
	 */
	public java.lang.Integer getAppid () {
		return appid;
	}

	/**
	 * Set the value related to the column: APPID
	 * @param appid the APPID value
	 */
	public void setAppid (java.lang.Integer appid) {
		this.appid = appid;
	}



	/**
	 * Return the value associated with the column: APPNAME
	 */
	public java.lang.String getAppname () {
		return appname;
	}

	/**
	 * Set the value related to the column: APPNAME
	 * @param appname the APPNAME value
	 */
	public void setAppname (java.lang.String appname) {
		this.appname = appname;
	}



	/**
	 * Return the value associated with the column: IPADDESS
	 */
	public java.lang.String getIpaddess () {
		return ipaddess;
	}

	/**
	 * Set the value related to the column: IPADDESS
	 * @param ipaddess the IPADDESS value
	 */
	public void setIpaddess (java.lang.String ipaddess) {
		this.ipaddess = ipaddess;
	}



	/**
	 * Return the value associated with the column: APPVER
	 */
	public java.lang.String getAppver () {
		return appver;
	}

	/**
	 * Set the value related to the column: APPVER
	 * @param appver the APPVER value
	 */
	public void setAppver (java.lang.String appver) {
		this.appver = appver;
	}



	/**
	 * Return the value associated with the column: SALTKEY
	 */
	public java.lang.String getSaltkey () {
		return saltkey;
	}

	/**
	 * Set the value related to the column: SALTKEY
	 * @param saltkey the SALTKEY value
	 */
	public void setSaltkey (java.lang.String saltkey) {
		this.saltkey = saltkey;
	}



	/**
	 * Return the value associated with the column: ISUSED
	 */
	public java.lang.Integer getIsused () {
		return isused;
	}

	/**
	 * Set the value related to the column: ISUSED
	 * @param isused the ISUSED value
	 */
	public void setIsused (java.lang.Integer isused) {
		this.isused = isused;
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
	 * Return the value associated with the column: SECRETKEY
	 */
	public java.lang.String getSecretkey () {
		return secretkey;
	}

	/**
	 * Set the value related to the column: SECRETKEY
	 * @param secretkey the SECRETKEY value
	 */
	public void setSecretkey (java.lang.String secretkey) {
		this.secretkey = secretkey;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseAppAccess)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseAppAccess baseAppAccess = (cn.com.newcapec.citycard.common.po.BaseAppAccess) obj;
			if (null == this.getId() || null == baseAppAccess.getId()) return false;
			else return (this.getId().equals(baseAppAccess.getId()));
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