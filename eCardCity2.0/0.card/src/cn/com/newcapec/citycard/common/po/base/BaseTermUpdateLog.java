package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TERM_UPDATE_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TERM_UPDATE_LOG"
 */

public abstract class BaseTermUpdateLog  implements Comparable, Serializable {

	public static String REF = "TermUpdateLog";
	public static String PROP_FILEID = "fileid";
	public static String PROP_VER = "ver";
	public static String PROP_STATUS = "status";
	public static String PROP_ISERASUREFLASH = "iserasureflash";
	public static String PROP_SYSTYPE = "systype";
	public static String PROP_APPVER = "appver";
	public static String PROP_UPGRADEENDTIME = "upgradeendtime";
	public static String PROP_ID = "id";
	public static String PROP_FILEVER = "filever";
	public static String PROP_PROGRESS = "progress";
	public static String PROP_CREATEDATE = "createdate";
	public static String PROP_POSCODE = "poscode";


	// constructors
	public BaseTermUpdateLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTermUpdateLog (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTermUpdateLog (
		java.lang.String id,
		java.lang.String poscode,
		java.lang.String fileid,
		java.lang.String status,
		java.lang.String iserasureflash,
		java.lang.String filever,
		java.lang.String systype,
		java.lang.Integer appver) {

		this.setId(id);
		this.setPoscode(poscode);
		this.setFileid(fileid);
		this.setStatus(status);
		this.setIserasureflash(iserasureflash);
		this.setFilever(filever);
		this.setSystype(systype);
		this.setAppver(appver);
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
	private java.util.Date createdate;
	private java.lang.String iserasureflash;
	private java.lang.String filever;
	private java.lang.String systype;
	private java.lang.String progress;
	private java.lang.Integer appver;



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
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
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
	 * Return the value associated with the column: FILEVER
	 */
	public java.lang.String getFilever () {
		return filever;
	}

	/**
	 * Set the value related to the column: FILEVER
	 * @param filever the FILEVER value
	 */
	public void setFilever (java.lang.String filever) {
		this.filever = filever;
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



	/**
	 * Return the value associated with the column: PROGRESS
	 */
	public java.lang.String getProgress () {
		return progress;
	}

	/**
	 * Set the value related to the column: PROGRESS
	 * @param progress the PROGRESS value
	 */
	public void setProgress (java.lang.String progress) {
		this.progress = progress;
	}



	/**
	 * Return the value associated with the column: APPVER
	 */
	public java.lang.Integer getAppver () {
		return appver;
	}

	/**
	 * Set the value related to the column: APPVER
	 * @param appver the APPVER value
	 */
	public void setAppver (java.lang.Integer appver) {
		this.appver = appver;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TermUpdateLog)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TermUpdateLog termUpdateLog = (cn.com.newcapec.citycard.common.po.TermUpdateLog) obj;
			if (null == this.getId() || null == termUpdateLog.getId()) return false;
			else return (this.getId().equals(termUpdateLog.getId()));
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