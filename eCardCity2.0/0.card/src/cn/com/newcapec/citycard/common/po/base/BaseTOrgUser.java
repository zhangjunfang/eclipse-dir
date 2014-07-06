package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_ORG_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_ORG_USER"
 */

public abstract class BaseTOrgUser  implements Comparable, Serializable {

	public static String REF = "TOrgUser";
	public static String PROP_NAME = "name";
	public static String PROP_PHONE = "phone";
	public static String PROP_EMAIL = "email";
	public static String PROP_FK_DEP = "fkDep";
	public static String PROP_DEPT = "dept";
	public static String PROP_PASSWORD = "password";
	public static String PROP_VALID = "valid";
	public static String PROP_ID = "id";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_REMARK = "remark";
	public static String PROP_CODE = "code";


	// constructors
	public BaseTOrgUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTOrgUser (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTOrgUser (
		java.lang.Integer id,
		java.lang.String userName,
		java.lang.String code,
		java.lang.String password,
		java.lang.String name,
		java.lang.Integer fkDep,
		java.lang.String valid) {

		this.setId(id);
		this.setUserName(userName);
		this.setCode(code);
		this.setPassword(password);
		this.setName(name);
		this.setFkDep(fkDep);
		this.setValid(valid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userName;
	private java.lang.String code;
	private java.lang.String password;
	private java.lang.String name;
	private java.lang.String phone;
	private java.lang.String email;
	private java.lang.Integer fkDep;
	private java.lang.String valid;
	private java.lang.String remark;

	// many to one
	private cn.com.newcapec.citycard.common.po.TOrgDept dept;



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
	 * Return the value associated with the column: USER_NAME
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: USER_NAME
	 * @param userName the USER_NAME value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: CODE
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
	}



	/**
	 * Return the value associated with the column: PASSWORD
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: PASSWORD
	 * @param password the PASSWORD value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: PHONE
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: PHONE
	 * @param phone the PHONE value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param email the EMAIL value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: FK_DEP
	 */
	public java.lang.Integer getFkDep () {
		return fkDep;
	}

	/**
	 * Set the value related to the column: FK_DEP
	 * @param fkDep the FK_DEP value
	 */
	public void setFkDep (java.lang.Integer fkDep) {
		this.fkDep = fkDep;
	}



	/**
	 * Return the value associated with the column: VALID
	 */
	public java.lang.String getValid () {
		return valid;
	}

	/**
	 * Set the value related to the column: VALID
	 * @param valid the VALID value
	 */
	public void setValid (java.lang.String valid) {
		this.valid = valid;
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



	/**
	 * Return the value associated with the column: FK_DEP
	 */
	public cn.com.newcapec.citycard.common.po.TOrgDept getDept () {
		return dept;
	}

	/**
	 * Set the value related to the column: FK_DEP
	 * @param dept the FK_DEP value
	 */
	public void setDept (cn.com.newcapec.citycard.common.po.TOrgDept dept) {
		this.dept = dept;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TOrgUser)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TOrgUser tOrgUser = (cn.com.newcapec.citycard.common.po.TOrgUser) obj;
			if (null == this.getId() || null == tOrgUser.getId()) return false;
			else return (this.getId().equals(tOrgUser.getId()));
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