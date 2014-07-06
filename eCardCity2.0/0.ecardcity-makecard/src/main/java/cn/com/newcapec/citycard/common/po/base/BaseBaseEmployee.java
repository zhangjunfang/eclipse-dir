package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_EMPLOYEE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_EMPLOYEE"
 */

public abstract class BaseBaseEmployee  implements Comparable, Serializable {

	public static String REF = "BaseEmployee";
	public static String PROP_VER = "ver";
	public static String PROP_CASH_CARDTYPE = "cashCardtype";
	public static String PROP_SALE_CARDTYPE = "saleCardtype";
	public static String PROP_BANKID = "bankid";
	public static String PROP_NETSITEID = "netsiteid";
	public static String PROP_PRIVILEGE_CASHIN = "privilegeCashin";
	public static String PROP_PRIVILEGE_POS = "privilegePos";
	public static String PROP_PRIVILEGE_CASHOUT = "privilegeCashout";
	public static String PROP_ID = "id";
	public static String PROP_PRIVILEGE_LOGIN = "privilegeLogin";


	// constructors
	public BaseBaseEmployee () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseEmployee (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBaseEmployee (
		java.lang.String id,
		java.lang.String netsiteid,
		java.lang.String bankid,
		java.lang.String saleCardtype,
		java.lang.String cashCardtype,
		java.lang.String privilegeCashin,
		java.lang.String privilegeCashout,
		java.lang.String privilegePos,
		java.lang.String privilegeLogin) {

		this.setId(id);
		this.setNetsiteid(netsiteid);
		this.setBankid(bankid);
		this.setSaleCardtype(saleCardtype);
		this.setCashCardtype(cashCardtype);
		this.setPrivilegeCashin(privilegeCashin);
		this.setPrivilegeCashout(privilegeCashout);
		this.setPrivilegePos(privilegePos);
		this.setPrivilegeLogin(privilegeLogin);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String bankid;
	private java.lang.String cashCardtype;
	private java.lang.String netsiteid;
	private java.lang.String privilegeCashin;
	private java.lang.String privilegeCashout;
	private java.lang.String privilegeLogin;
	private java.lang.String privilegePos;
	private java.lang.String saleCardtype;
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
	 * Return the value associated with the column: BANKID
	 */
	public java.lang.String getBankid () {
		return bankid;
	}

	/**
	 * Set the value related to the column: BANKID
	 * @param bankid the BANKID value
	 */
	public void setBankid (java.lang.String bankid) {
		this.bankid = bankid;
	}



	/**
	 * Return the value associated with the column: CASH_CARDTYPE
	 */
	public java.lang.String getCashCardtype () {
		return cashCardtype;
	}

	/**
	 * Set the value related to the column: CASH_CARDTYPE
	 * @param cashCardtype the CASH_CARDTYPE value
	 */
	public void setCashCardtype (java.lang.String cashCardtype) {
		this.cashCardtype = cashCardtype;
	}



	/**
	 * Return the value associated with the column: NETSITEID
	 */
	public java.lang.String getNetsiteid () {
		return netsiteid;
	}

	/**
	 * Set the value related to the column: NETSITEID
	 * @param netsiteid the NETSITEID value
	 */
	public void setNetsiteid (java.lang.String netsiteid) {
		this.netsiteid = netsiteid;
	}



	/**
	 * Return the value associated with the column: PRIVILEGE_CASHIN
	 */
	public java.lang.String getPrivilegeCashin () {
		return privilegeCashin;
	}

	/**
	 * Set the value related to the column: PRIVILEGE_CASHIN
	 * @param privilegeCashin the PRIVILEGE_CASHIN value
	 */
	public void setPrivilegeCashin (java.lang.String privilegeCashin) {
		this.privilegeCashin = privilegeCashin;
	}



	/**
	 * Return the value associated with the column: PRIVILEGE_CASHOUT
	 */
	public java.lang.String getPrivilegeCashout () {
		return privilegeCashout;
	}

	/**
	 * Set the value related to the column: PRIVILEGE_CASHOUT
	 * @param privilegeCashout the PRIVILEGE_CASHOUT value
	 */
	public void setPrivilegeCashout (java.lang.String privilegeCashout) {
		this.privilegeCashout = privilegeCashout;
	}



	/**
	 * Return the value associated with the column: PRIVILEGE_LOGIN
	 */
	public java.lang.String getPrivilegeLogin () {
		return privilegeLogin;
	}

	/**
	 * Set the value related to the column: PRIVILEGE_LOGIN
	 * @param privilegeLogin the PRIVILEGE_LOGIN value
	 */
	public void setPrivilegeLogin (java.lang.String privilegeLogin) {
		this.privilegeLogin = privilegeLogin;
	}



	/**
	 * Return the value associated with the column: PRIVILEGE_POS
	 */
	public java.lang.String getPrivilegePos () {
		return privilegePos;
	}

	/**
	 * Set the value related to the column: PRIVILEGE_POS
	 * @param privilegePos the PRIVILEGE_POS value
	 */
	public void setPrivilegePos (java.lang.String privilegePos) {
		this.privilegePos = privilegePos;
	}



	/**
	 * Return the value associated with the column: SALE_CARDTYPE
	 */
	public java.lang.String getSaleCardtype () {
		return saleCardtype;
	}

	/**
	 * Set the value related to the column: SALE_CARDTYPE
	 * @param saleCardtype the SALE_CARDTYPE value
	 */
	public void setSaleCardtype (java.lang.String saleCardtype) {
		this.saleCardtype = saleCardtype;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseEmployee)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseEmployee baseEmployee = (cn.com.newcapec.citycard.common.po.BaseEmployee) obj;
			if (null == this.getId() || null == baseEmployee.getId()) return false;
			else return (this.getId().equals(baseEmployee.getId()));
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