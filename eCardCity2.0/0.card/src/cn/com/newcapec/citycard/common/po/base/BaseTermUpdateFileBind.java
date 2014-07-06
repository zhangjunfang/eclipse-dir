package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TERM_UPDATE_FILE_BIND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TERM_UPDATE_FILE_BIND"
 */

public abstract class BaseTermUpdateFileBind  implements Comparable, Serializable {

	public static String REF = "TermUpdateFileBind";
	public static String PROP_FILEID = "fileid";
	public static String PROP_VER = "ver";
	public static String PROP_STATUS = "status";
	public static String PROP_ISERASUREFLASH = "iserasureflash";
	public static String PROP_SYSTYPE = "systype";
	public static String PROP_UPGRADEENDTIME = "upgradeendtime";
	public static String PROP_ID = "id";
	public static String PROP_OPDT = "opdt";
	public static String PROP_APPLICATIONVER = "applicationver";
	public static String PROP_POSCODE = "poscode";


	// constructors
	public BaseTermUpdateFileBind () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTermUpdateFileBind (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTermUpdateFileBind (
		java.lang.String id,
		java.lang.String poscode,
		java.lang.String fileid,
		java.lang.String status,
		java.lang.String iserasureflash,
		java.lang.String systype) {

		this.setId(id);
		this.setPoscode(poscode);
		this.setFileid(fileid);
		this.setStatus(status);
		this.setIserasureflash(iserasureflash);
		this.setSystype(systype);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String poscode;
	private java.lang.String fileid;
	private java.util.Date upgradeendtime;
	private java.lang.String status;
	private java.lang.Integer ver;
	private java.util.Date opdt;
	private java.lang.String iserasureflash;
	private java.lang.String applicationver;
	private java.lang.String systype;



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
	 * Return the value associated with the column: POSCODE
	 */
	public java.lang.String getPoscode () {
		return poscode;
	}

	/**
	 * Set the value related to the column: POSCODE
	 * @param poscode the POSCODE value
	 */
	public void setPoscode (java.lang.String poscode) {
		this.poscode = poscode;
	}



	/**
	 * Return the value associated with the column: FILEID
	 */
	public java.lang.String getFileid () {
		return fileid;
	}

	/**
	 * Set the value related to the column: FILEID
	 * @param fileid the FILEID value
	 */
	public void setFileid (java.lang.String fileid) {
		this.fileid = fileid;
	}



	/**
	 * Return the value associated with the column: UPGRADEENDTIME
	 */
	public java.util.Date getUpgradeendtime () {
		return upgradeendtime;
	}

	/**
	 * Set the value related to the column: UPGRADEENDTIME
	 * @param upgradeendtime the UPGRADEENDTIME value
	 */
	public void setUpgradeendtime (java.util.Date upgradeendtime) {
		this.upgradeendtime = upgradeendtime;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: ISERASUREFLASH
	 */
	public java.lang.String getIserasureflash () {
		return iserasureflash;
	}

	/**
	 * Set the value related to the column: ISERASUREFLASH
	 * @param iserasureflash the ISERASUREFLASH value
	 */
	public void setIserasureflash (java.lang.String iserasureflash) {
		this.iserasureflash = iserasureflash;
	}



	/**
	 * Return the value associated with the column: APPLICATIONVER
	 */
	public java.lang.String getApplicationver () {
		return applicationver;
	}

	/**
	 * Set the value related to the column: APPLICATIONVER
	 * @param applicationver the APPLICATIONVER value
	 */
	public void setApplicationver (java.lang.String applicationver) {
		this.applicationver = applicationver;
	}



	/**
	 * Return the value associated with the column: SYSTYPE
	 */
	public java.lang.String getSystype () {
		return systype;
	}

	/**
	 * Set the value related to the column: SYSTYPE
	 * @param systype the SYSTYPE value
	 */
	public void setSystype (java.lang.String systype) {
		this.systype = systype;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TermUpdateFileBind)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TermUpdateFileBind termUpdateFileBind = (cn.com.newcapec.citycard.common.po.TermUpdateFileBind) obj;
			if (null == this.getId() || null == termUpdateFileBind.getId()) return false;
			else return (this.getId().equals(termUpdateFileBind.getId()));
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