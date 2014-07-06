package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_ORG_ROLE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_ORG_ROLE"
 */

public abstract class BaseTOrgRole  implements Comparable, Serializable {

	public static String REF = "TOrgRole";
	public static String PROP_ROLE_NAME = "roleName";
	public static String PROP_ID = "id";
	public static String PROP_REMARK = "remark";


	// constructors
	public BaseTOrgRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTOrgRole (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTOrgRole (
		java.lang.Integer id,
		java.lang.String roleName,
		java.lang.String remark) {

		this.setId(id);
		this.setRoleName(roleName);
		this.setRemark(remark);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String roleName;
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
	 * Return the value associated with the column: ROLE_NAME
	 */
	public java.lang.String getRoleName () {
		return roleName;
	}

	/**
	 * Set the value related to the column: ROLE_NAME
	 * @param roleName the ROLE_NAME value
	 */
	public void setRoleName (java.lang.String roleName) {
		this.roleName = roleName;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TOrgRole)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TOrgRole tOrgRole = (cn.com.newcapec.citycard.common.po.TOrgRole) obj;
			if (null == this.getId() || null == tOrgRole.getId()) return false;
			else return (this.getId().equals(tOrgRole.getId()));
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