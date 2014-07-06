package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_ORG_DEPT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_ORG_DEPT"
 */

public abstract class BaseTOrgDept  implements Comparable, Serializable {

	public static String REF = "TOrgDept";
	public static String PROP_EXPIRY_DATE = "expiryDate";
	public static String PROP_PHONE = "phone";
	public static String PROP_LOGIN_IP = "loginIp";
	public static String PROP_DEPT_NAME = "deptName";
	public static String PROP_EMAIL = "email";
	public static String PROP_ADDRESS = "address";
	public static String PROP_VALID = "valid";
	public static String PROP_ID = "id";
	public static String PROP_REMARK = "remark";
	public static String PROP_PID = "pid";
	public static String PROP_CODE = "code";


	// constructors
	public BaseTOrgDept () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTOrgDept (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTOrgDept (
		java.lang.Integer id,
		java.lang.String deptName,
		java.lang.String code,
		java.lang.Integer pid) {

		this.setId(id);
		this.setDeptName(deptName);
		this.setCode(code);
		this.setPid(pid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deptName;
	private java.lang.String code;
	private java.lang.Integer pid;
	private java.lang.String remark;
	private java.lang.String address;
	private java.lang.String phone;
	private java.lang.String email;
	private java.lang.String valid;
	private java.util.Date expiryDate;
	private java.lang.String loginIp;



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
	 * Return the value associated with the column: DEPT_NAME
	 */
	public java.lang.String getDeptName () {
		return deptName;
	}

	/**
	 * Set the value related to the column: DEPT_NAME
	 * @param deptName the DEPT_NAME value
	 */
	public void setDeptName (java.lang.String deptName) {
		this.deptName = deptName;
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



	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
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
	 * Return the value associated with the column: EXPIRY_DATE
	 */
	public java.util.Date getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: EXPIRY_DATE
	 * @param expiryDate the EXPIRY_DATE value
	 */
	public void setExpiryDate (java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: LOGIN_IP
	 */
	public java.lang.String getLoginIp () {
		return loginIp;
	}

	/**
	 * Set the value related to the column: LOGIN_IP
	 * @param loginIp the LOGIN_IP value
	 */
	public void setLoginIp (java.lang.String loginIp) {
		this.loginIp = loginIp;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TOrgDept)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TOrgDept tOrgDept = (cn.com.newcapec.citycard.common.po.TOrgDept) obj;
			if (null == this.getId() || null == tOrgDept.getId()) return false;
			else return (this.getId().equals(tOrgDept.getId()));
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