package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TERM_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TERM_INFO"
 */

public abstract class BaseTermInfo  implements Comparable, Serializable {

	public static String REF = "TermInfo";
	public static String PROP_LASTUPDATEDATE = "lastupdatedate";
	public static String PROP_SITEID = "siteid";
	public static String PROP_KEKENCRYPTKEY = "kekencryptkey";
	public static String PROP_ISUSE = "isuse";
	public static String PROP_MERCHANTCODE = "merchantcode";
	public static String PROP_LASTCOLLECTDATE = "lastcollectdate";
	public static String PROP_VER = "ver";
	public static String PROP_STATUS = "status";
	public static String PROP_APPID = "appid";
	public static String PROP_COLLECTID = "collectid";
	public static String PROP_TYPEID = "typeid";
	public static String PROP_PSAMCARDNO = "psamcardno";
	public static String PROP_ISAUTH = "isauth";
	public static String PROP_ID = "id";
	public static String PROP_ISDELETE = "isdelete";
	public static String PROP_WORKINGKEY = "workingkey";
	public static String PROP_PARAMGROUPID = "paramgroupid";
	public static String PROP_KEKCODE = "kekcode";
	public static String PROP_TERMNAME = "termname";
	public static String PROP_POSCODE = "poscode";


	// constructors
	public BaseTermInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTermInfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTermInfo (
		java.lang.String id,
		java.lang.String termname,
		java.lang.String isuse,
		java.lang.String typeid,
		java.lang.Integer psamcardno,
		java.lang.String workingkey,
		java.lang.String kekcode,
		java.lang.Integer appid,
		java.lang.String kekencryptkey,
		java.lang.String isdelete,
		java.lang.Integer ver) {

		this.setId(id);
		this.setTermname(termname);
		this.setIsuse(isuse);
		this.setTypeid(typeid);
		this.setPsamcardno(psamcardno);
		this.setWorkingkey(workingkey);
		this.setKekcode(kekcode);
		this.setAppid(appid);
		this.setKekencryptkey(kekencryptkey);
		this.setIsdelete(isdelete);
		this.setVer(ver);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String termname;
	private java.lang.String merchantcode;
	private java.lang.String poscode;
	private java.lang.String isuse;
	private java.lang.String paramgroupid;
	private java.lang.String typeid;
	private java.lang.String status;
	private java.util.Date lastcollectdate;
	private java.lang.Integer psamcardno;
	private java.util.Date lastupdatedate;
	private java.lang.String collectid;
	private java.lang.String siteid;
	private java.lang.Integer isauth;
	private java.lang.String workingkey;
	private java.lang.String kekcode;
	private java.lang.Integer appid;
	private java.lang.String kekencryptkey;
	private java.lang.String isdelete;
	private java.lang.Integer ver;



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
	 * Return the value associated with the column: TERMNAME
	 */
	public java.lang.String getTermname () {
		return termname;
	}

	/**
	 * Set the value related to the column: TERMNAME
	 * @param termname the TERMNAME value
	 */
	public void setTermname (java.lang.String termname) {
		this.termname = termname;
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
	 * Return the value associated with the column: ISUSE
	 */
	public java.lang.String getIsuse () {
		return isuse;
	}

	/**
	 * Set the value related to the column: ISUSE
	 * @param isuse the ISUSE value
	 */
	public void setIsuse (java.lang.String isuse) {
		this.isuse = isuse;
	}



	/**
	 * Return the value associated with the column: PARAMGROUPID
	 */
	public java.lang.String getParamgroupid () {
		return paramgroupid;
	}

	/**
	 * Set the value related to the column: PARAMGROUPID
	 * @param paramgroupid the PARAMGROUPID value
	 */
	public void setParamgroupid (java.lang.String paramgroupid) {
		this.paramgroupid = paramgroupid;
	}



	/**
	 * Return the value associated with the column: TYPEID
	 */
	public java.lang.String getTypeid () {
		return typeid;
	}

	/**
	 * Set the value related to the column: TYPEID
	 * @param typeid the TYPEID value
	 */
	public void setTypeid (java.lang.String typeid) {
		this.typeid = typeid;
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
	 * Return the value associated with the column: LASTCOLLECTDATE
	 */
	public java.util.Date getLastcollectdate () {
		return lastcollectdate;
	}

	/**
	 * Set the value related to the column: LASTCOLLECTDATE
	 * @param lastcollectdate the LASTCOLLECTDATE value
	 */
	public void setLastcollectdate (java.util.Date lastcollectdate) {
		this.lastcollectdate = lastcollectdate;
	}



	/**
	 * Return the value associated with the column: PSAMCARDNO
	 */
	public java.lang.Integer getPsamcardno () {
		return psamcardno;
	}

	/**
	 * Set the value related to the column: PSAMCARDNO
	 * @param psamcardno the PSAMCARDNO value
	 */
	public void setPsamcardno (java.lang.Integer psamcardno) {
		this.psamcardno = psamcardno;
	}



	/**
	 * Return the value associated with the column: LASTUPDATEDATE
	 */
	public java.util.Date getLastupdatedate () {
		return lastupdatedate;
	}

	/**
	 * Set the value related to the column: LASTUPDATEDATE
	 * @param lastupdatedate the LASTUPDATEDATE value
	 */
	public void setLastupdatedate (java.util.Date lastupdatedate) {
		this.lastupdatedate = lastupdatedate;
	}



	/**
	 * Return the value associated with the column: COLLECTID
	 */
	public java.lang.String getCollectid () {
		return collectid;
	}

	/**
	 * Set the value related to the column: COLLECTID
	 * @param collectid the COLLECTID value
	 */
	public void setCollectid (java.lang.String collectid) {
		this.collectid = collectid;
	}



	/**
	 * Return the value associated with the column: SITEID
	 */
	public java.lang.String getSiteid () {
		return siteid;
	}

	/**
	 * Set the value related to the column: SITEID
	 * @param siteid the SITEID value
	 */
	public void setSiteid (java.lang.String siteid) {
		this.siteid = siteid;
	}



	/**
	 * Return the value associated with the column: ISAUTH
	 */
	public java.lang.Integer getIsauth () {
		return isauth;
	}

	/**
	 * Set the value related to the column: ISAUTH
	 * @param isauth the ISAUTH value
	 */
	public void setIsauth (java.lang.Integer isauth) {
		this.isauth = isauth;
	}



	/**
	 * Return the value associated with the column: WORKINGKEY
	 */
	public java.lang.String getWorkingkey () {
		return workingkey;
	}

	/**
	 * Set the value related to the column: WORKINGKEY
	 * @param workingkey the WORKINGKEY value
	 */
	public void setWorkingkey (java.lang.String workingkey) {
		this.workingkey = workingkey;
	}



	/**
	 * Return the value associated with the column: KEKCODE
	 */
	public java.lang.String getKekcode () {
		return kekcode;
	}

	/**
	 * Set the value related to the column: KEKCODE
	 * @param kekcode the KEKCODE value
	 */
	public void setKekcode (java.lang.String kekcode) {
		this.kekcode = kekcode;
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
	 * Return the value associated with the column: KEKENCRYPTKEY
	 */
	public java.lang.String getKekencryptkey () {
		return kekencryptkey;
	}

	/**
	 * Set the value related to the column: KEKENCRYPTKEY
	 * @param kekencryptkey the KEKENCRYPTKEY value
	 */
	public void setKekencryptkey (java.lang.String kekencryptkey) {
		this.kekencryptkey = kekencryptkey;
	}



	/**
	 * Return the value associated with the column: ISDELETE
	 */
	public java.lang.String getIsdelete () {
		return isdelete;
	}

	/**
	 * Set the value related to the column: ISDELETE
	 * @param isdelete the ISDELETE value
	 */
	public void setIsdelete (java.lang.String isdelete) {
		this.isdelete = isdelete;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TermInfo)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TermInfo termInfo = (cn.com.newcapec.citycard.common.po.TermInfo) obj;
			if (null == this.getId() || null == termInfo.getId()) return false;
			else return (this.getId().equals(termInfo.getId()));
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