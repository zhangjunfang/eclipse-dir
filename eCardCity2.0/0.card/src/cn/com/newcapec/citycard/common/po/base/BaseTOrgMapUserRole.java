package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_ORG_MAP_USER_ROLE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_ORG_MAP_USER_ROLE"
 */

public abstract class BaseTOrgMapUserRole  implements Comparable, Serializable {

	public static String REF = "TOrgMapUserRole";
	public static String PROP_FK_ROLE = "fkRole";
	public static String PROP_ID = "id";
	public static String PROP_FK_USER = "fkUser";


	// constructors
	public BaseTOrgMapUserRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTOrgMapUserRole (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTOrgMapUserRole (
		java.lang.Integer id,
		java.lang.Integer fkUser,
		java.lang.Integer fkRole) {

		this.setId(id);
		this.setFkUser(fkUser);
		this.setFkRole(fkRole);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer fkUser;
	private java.lang.Integer fkRole;



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
	 * Return the value associated with the column: FK_USER
	 */
	public java.lang.Integer getFkUser () {
		return fkUser;
	}

	/**
	 * Set the value related to the column: FK_USER
	 * @param fkUser the FK_USER value
	 */
	public void setFkUser (java.lang.Integer fkUser) {
		this.fkUser = fkUser;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TOrgMapUserRole)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TOrgMapUserRole tOrgMapUserRole = (cn.com.newcapec.citycard.common.po.TOrgMapUserRole) obj;
			if (null == this.getId() || null == tOrgMapUserRole.getId()) return false;
			else return (this.getId().equals(tOrgMapUserRole.getId()));
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