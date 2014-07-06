package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_APP_ACCREDIT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_APP_ACCREDIT"
 */

public abstract class BaseBaseAppAccredit  implements Comparable, Serializable {

	public static String REF = "BaseAppAccredit";
	public static String PROP_ROUTERULE = "routerule";
	public static String PROP_VER = "ver";
	public static String PROP_IP = "ip";
	public static String PROP_EXCHANGETIMEOUT = "exchangetimeout";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_SYSCODE = "syscode";
	public static String PROP_WEBPATH = "webpath";
	public static String PROP_AREAID = "areaid";
	public static String PROP_ID = "id";
	public static String PROP_ACCREDITEDCODE = "accreditedcode";
	public static String PROP_EMPID = "empid";
	public static String PROP_ISHOST = "ishost";


	// constructors
	public BaseBaseAppAccredit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseAppAccredit (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String syscode;
	private java.lang.String accreditedcode;
	private java.lang.String ip;
	private java.lang.String description;
	private java.lang.Integer ishost;
	private java.lang.String empid;
	private java.lang.String webpath;
	private java.lang.String routerule;
	private java.lang.Integer areaid;
	private java.lang.Integer exchangetimeout;
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
	 * Return the value associated with the column: SYSCODE
	 */
	public java.lang.String getSyscode () {
		return syscode;
	}

	/**
	 * Set the value related to the column: SYSCODE
	 * @param syscode the SYSCODE value
	 */
	public void setSyscode (java.lang.String syscode) {
		this.syscode = syscode;
	}



	/**
	 * Return the value associated with the column: ACCREDITEDCODE
	 */
	public java.lang.String getAccreditedcode () {
		return accreditedcode;
	}

	/**
	 * Set the value related to the column: ACCREDITEDCODE
	 * @param accreditedcode the ACCREDITEDCODE value
	 */
	public void setAccreditedcode (java.lang.String accreditedcode) {
		this.accreditedcode = accreditedcode;
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
	 * Return the value associated with the column: DESCRIPTION
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: ISHOST
	 */
	public java.lang.Integer getIshost () {
		return ishost;
	}

	/**
	 * Set the value related to the column: ISHOST
	 * @param ishost the ISHOST value
	 */
	public void setIshost (java.lang.Integer ishost) {
		this.ishost = ishost;
	}



	/**
	 * Return the value associated with the column: EMPID
	 */
	public java.lang.String getEmpid () {
		return empid;
	}

	/**
	 * Set the value related to the column: EMPID
	 * @param empid the EMPID value
	 */
	public void setEmpid (java.lang.String empid) {
		this.empid = empid;
	}



	/**
	 * Return the value associated with the column: WEBPATH
	 */
	public java.lang.String getWebpath () {
		return webpath;
	}

	/**
	 * Set the value related to the column: WEBPATH
	 * @param webpath the WEBPATH value
	 */
	public void setWebpath (java.lang.String webpath) {
		this.webpath = webpath;
	}



	/**
	 * Return the value associated with the column: ROUTERULE
	 */
	public java.lang.String getRouterule () {
		return routerule;
	}

	/**
	 * Set the value related to the column: ROUTERULE
	 * @param routerule the ROUTERULE value
	 */
	public void setRouterule (java.lang.String routerule) {
		this.routerule = routerule;
	}



	/**
	 * Return the value associated with the column: AREAID
	 */
	public java.lang.Integer getAreaid () {
		return areaid;
	}

	/**
	 * Set the value related to the column: AREAID
	 * @param areaid the AREAID value
	 */
	public void setAreaid (java.lang.Integer areaid) {
		this.areaid = areaid;
	}



	/**
	 * Return the value associated with the column: EXCHANGETIMEOUT
	 */
	public java.lang.Integer getExchangetimeout () {
		return exchangetimeout;
	}

	/**
	 * Set the value related to the column: EXCHANGETIMEOUT
	 * @param exchangetimeout the EXCHANGETIMEOUT value
	 */
	public void setExchangetimeout (java.lang.Integer exchangetimeout) {
		this.exchangetimeout = exchangetimeout;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseAppAccredit)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseAppAccredit baseAppAccredit = (cn.com.newcapec.citycard.common.po.BaseAppAccredit) obj;
			if (null == this.getId() || null == baseAppAccredit.getId()) return false;
			else return (this.getId().equals(baseAppAccredit.getId()));
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