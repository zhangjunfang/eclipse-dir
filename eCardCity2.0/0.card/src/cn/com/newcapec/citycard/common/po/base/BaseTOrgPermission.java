package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_ORG_PERMISSION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_ORG_PERMISSION"
 */

public abstract class BaseTOrgPermission  implements Comparable, Serializable {

	public static String REF = "TOrgPermission";
	public static String PROP_ID = "id";
	public static String PROP_PERM_NAME = "permName";
	public static String PROP_REMARK = "remark";
	public static String PROP_PERM_URL = "permUrl";
	public static String PROP_PID = "pid";


	// constructors
	public BaseTOrgPermission () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTOrgPermission (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTOrgPermission (
		java.lang.Integer id,
		java.lang.String permName,
		java.lang.String permUrl,
		java.lang.Integer pid,
		java.lang.String remark) {

		this.setId(id);
		this.setPermName(permName);
		this.setPermUrl(permUrl);
		this.setPid(pid);
		this.setRemark(remark);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String permName;
	private java.lang.String permUrl;
	private java.lang.Integer pid;
	private java.lang.String remark;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: PERM_NAME
	 */
	public java.lang.String getPermName () {
		return permName;
	}

	/**
	 * Set the value related to the column: PERM_NAME
	 * @param permName the PERM_NAME value
	 */
	public void setPermName (java.lang.String permName) {
		this.permName = permName;
	}



	/**
	 * Return the value associated with the column: PERM_URL
	 */
	public java.lang.String getPermUrl () {
		return permUrl;
	}

	/**
	 * Set the value related to the column: PERM_URL
	 * @param permUrl the PERM_URL value
	 */
	public void setPermUrl (java.lang.String permUrl) {
		this.permUrl = permUrl;
	}



	/**
	 * Return the value associated with the column: PID
	 */
	public java.lang.Integer getPid () {
		return pid;
	}

	/**
	 * Set the value related to the column: PID
	 * @param pid the PID value
	 */
	public void setPid (java.lang.Integer pid) {
		this.pid = pid;
	}



	/**
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TOrgPermission)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TOrgPermission tOrgPermission = (cn.com.newcapec.citycard.common.po.TOrgPermission) obj;
			if (null == this.getId() || null == tOrgPermission.getId()) return false;
			else return (this.getId().equals(tOrgPermission.getId()));
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