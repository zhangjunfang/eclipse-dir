package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the SYSTEM_DB_UPDATE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYSTEM_DB_UPDATE"
 */

public abstract class BaseSystemDbUpdate  implements Comparable, Serializable {

	public static String REF = "SystemDbUpdate";
	public static String PROP_DBVER = "dbver";
	public static String PROP_INNERVERNO = "innerverno";
	public static String PROP_APPINNERVER = "appinnerver";
	public static String PROP_PUBLISHDATE = "publishdate";
	public static String PROP_APPVER = "appver";
	public static String PROP_UPDATEDATE = "updatedate";
	public static String PROP_ID = "id";
	public static String PROP_NOTE = "note";
	public static String PROP_VERSIONNUMBER = "versionnumber";
	public static String PROP_LASTNUMBER = "lastnumber";


	// constructors
	public BaseSystemDbUpdate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystemDbUpdate (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String versionnumber;
	private java.lang.String note;
	private java.util.Date publishdate;
	private java.lang.Integer lastnumber;
	private java.util.Date updatedate;
	private java.lang.Integer innerverno;
	private java.lang.String dbver;
	private java.lang.String appver;
	private java.lang.String appinnerver;



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
	 * Return the value associated with the column: VERSIONNUMBER
	 */
	public java.lang.String getVersionnumber () {
		return versionnumber;
	}

	/**
	 * Set the value related to the column: VERSIONNUMBER
	 * @param versionnumber the VERSIONNUMBER value
	 */
	public void setVersionnumber (java.lang.String versionnumber) {
		this.versionnumber = versionnumber;
	}



	/**
	 * Return the value associated with the column: NOTE
	 */
	public java.lang.String getNote () {
		return note;
	}

	/**
	 * Set the value related to the column: NOTE
	 * @param note the NOTE value
	 */
	public void setNote (java.lang.String note) {
		this.note = note;
	}



	/**
	 * Return the value associated with the column: PUBLISHDATE
	 */
	public java.util.Date getPublishdate () {
		return publishdate;
	}

	/**
	 * Set the value related to the column: PUBLISHDATE
	 * @param publishdate the PUBLISHDATE value
	 */
	public void setPublishdate (java.util.Date publishdate) {
		this.publishdate = publishdate;
	}



	/**
	 * Return the value associated with the column: LASTNUMBER
	 */
	public java.lang.Integer getLastnumber () {
		return lastnumber;
	}

	/**
	 * Set the value related to the column: LASTNUMBER
	 * @param lastnumber the LASTNUMBER value
	 */
	public void setLastnumber (java.lang.Integer lastnumber) {
		this.lastnumber = lastnumber;
	}



	/**
	 * Return the value associated with the column: UPDATEDATE
	 */
	public java.util.Date getUpdatedate () {
		return updatedate;
	}

	/**
	 * Set the value related to the column: UPDATEDATE
	 * @param updatedate the UPDATEDATE value
	 */
	public void setUpdatedate (java.util.Date updatedate) {
		this.updatedate = updatedate;
	}



	/**
	 * Return the value associated with the column: INNERVERNO
	 */
	public java.lang.Integer getInnerverno () {
		return innerverno;
	}

	/**
	 * Set the value related to the column: INNERVERNO
	 * @param innerverno the INNERVERNO value
	 */
	public void setInnerverno (java.lang.Integer innerverno) {
		this.innerverno = innerverno;
	}



	/**
	 * Return the value associated with the column: DBVER
	 */
	public java.lang.String getDbver () {
		return dbver;
	}

	/**
	 * Set the value related to the column: DBVER
	 * @param dbver the DBVER value
	 */
	public void setDbver (java.lang.String dbver) {
		this.dbver = dbver;
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
	 * Return the value associated with the column: APPINNERVER
	 */
	public java.lang.String getAppinnerver () {
		return appinnerver;
	}

	/**
	 * Set the value related to the column: APPINNERVER
	 * @param appinnerver the APPINNERVER value
	 */
	public void setAppinnerver (java.lang.String appinnerver) {
		this.appinnerver = appinnerver;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.SystemDbUpdate)) return false;
		else {
			cn.com.newcapec.citycard.common.po.SystemDbUpdate systemDbUpdate = (cn.com.newcapec.citycard.common.po.SystemDbUpdate) obj;
			if (null == this.getId() || null == systemDbUpdate.getId()) return false;
			else return (this.getId().equals(systemDbUpdate.getId()));
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