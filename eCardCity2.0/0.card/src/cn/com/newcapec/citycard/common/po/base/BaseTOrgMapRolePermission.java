package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_ORG_MAP_ROLE_PERMISSION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_ORG_MAP_ROLE_PERMISSION"
 */

public abstract class BaseTOrgMapRolePermission  implements Comparable, Serializable {

	public static String REF = "TOrgMapRolePermission";
	public static String PROP_FK_ROLE = "fkRole";
	public static String PROP_FK_PERMISSION = "fkPermission";
	public static String PROP_ID = "id";


	// constructors
	public BaseTOrgMapRolePermission () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTOrgMapRolePermission (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTOrgMapRolePermission (
		java.lang.Integer id,
		java.lang.Integer fkRole,
		java.lang.Integer fkPermission) {

		this.setId(id);
		this.setFkRole(fkRole);
		this.setFkPermission(fkPermission);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer fkRole;
	private java.lang.Integer fkPermission;



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
	 * Return the value associated with the column: FK_ROLE
	 */
	public java.lang.Integer getFkRole () {
		return fkRole;
	}

	/**
	 * Set the value related to the column: FK_ROLE
	 * @param fkRole the FK_ROLE value
	 */
	public void setFkRole (java.lang.Integer fkRole) {
		this.fkRole = fkRole;
	}



	/**
	 * Return the value associated with the column: FK_PERMISSION
	 */
	public java.lang.Integer getFkPermission () {
		return fkPermission;
	}

	/**
	 * Set the value related to the column: FK_PERMISSION
	 * @param fkPermission the FK_PERMISSION value
	 */
	public void setFkPermission (java.lang.Integer fkPermission) {
		this.fkPermission = fkPermission;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TOrgMapRolePermission)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TOrgMapRolePermission tOrgMapRolePermission = (cn.com.newcapec.citycard.common.po.TOrgMapRolePermission) obj;
			if (null == this.getId() || null == tOrgMapRolePermission.getId()) return false;
			else return (this.getId().equals(tOrgMapRolePermission.getId()));
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