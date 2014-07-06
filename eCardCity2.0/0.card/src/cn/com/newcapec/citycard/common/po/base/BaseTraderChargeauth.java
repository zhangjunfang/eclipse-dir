package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TRADER_CHARGEAUTH table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TRADER_CHARGEAUTH"
 */

public abstract class BaseTraderChargeauth  implements Comparable, Serializable {

	public static String REF = "TraderChargeauth";
	public static String PROP_LIMITENDDATE = "limitenddate";
	public static String PROP_SUMFARE = "sumfare";
	public static String PROP_WORKSTATUS = "workstatus";
	public static String PROP_AUTHTIME = "authtime";
	public static String PROP_ISUSE = "isuse";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_ALLOWOVERDRAFTSUMFARE = "allowoverdraftsumfare";
	public static String PROP_MAXLIMITDATE = "maxlimitdate";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_CURODDFARE = "curoddfare";
	public static String PROP_ID = "id";
	public static String PROP_AUTHCODE = "authcode";
	public static String PROP_BUSINESSPOINT = "businesspoint";
	public static String PROP_MAXLIMITFARE = "maxlimitfare";
	public static String PROP_ALLOWOVERDRAFTOPDT = "allowoverdraftopdt";
	public static String PROP_ALLOWOVERDRAFTFARE = "allowoverdraftfare";


	// constructors
	public BaseTraderChargeauth () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTraderChargeauth (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTraderChargeauth (
		java.lang.String id,
		java.lang.String authcode,
		java.lang.String businesspoint,
		java.math.BigDecimal curoddfare,
		java.math.BigDecimal allowoverdraftfare,
		java.lang.Integer maxlimitdate,
		java.lang.String isuse,
		java.lang.String workstatus,
		java.math.BigDecimal maxlimitfare,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setAuthcode(authcode);
		this.setBusinesspoint(businesspoint);
		this.setCuroddfare(curoddfare);
		this.setAllowoverdraftfare(allowoverdraftfare);
		this.setMaxlimitdate(maxlimitdate);
		this.setIsuse(isuse);
		this.setWorkstatus(workstatus);
		this.setMaxlimitfare(maxlimitfare);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String authcode;
	private java.lang.String businesspoint;
	private java.math.BigDecimal curoddfare;
	private java.util.Date authtime;
	private java.math.BigDecimal allowoverdraftfare;
	private java.lang.Integer maxlimitdate;
	private java.lang.String isuse;
	private java.lang.String workstatus;
	private java.util.Date limitenddate;
	private java.math.BigDecimal maxlimitfare;
	private java.math.BigDecimal sumfare;
	private java.util.Date allowoverdraftopdt;
	private java.math.BigDecimal allowoverdraftsumfare;
	private java.lang.String editPerson;
	private java.util.Date editDate;



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
	 * Return the value associated with the column: AUTHCODE
	 */
	public java.lang.String getAuthcode () {
		return authcode;
	}

	/**
	 * Set the value related to the column: AUTHCODE
	 * @param authcode the AUTHCODE value
	 */
	public void setAuthcode (java.lang.String authcode) {
		this.authcode = authcode;
	}



	/**
	 * Return the value associated with the column: BUSINESSPOINT
	 */
	public java.lang.String getBusinesspoint () {
		return businesspoint;
	}

	/**
	 * Set the value related to the column: BUSINESSPOINT
	 * @param businesspoint the BUSINESSPOINT value
	 */
	public void setBusinesspoint (java.lang.String businesspoint) {
		this.businesspoint = businesspoint;
	}



	/**
	 * Return the value associated with the column: CURODDFARE
	 */
	public java.math.BigDecimal getCuroddfare () {
		return curoddfare;
	}

	/**
	 * Set the value related to the column: CURODDFARE
	 * @param curoddfare the CURODDFARE value
	 */
	public void setCuroddfare (java.math.BigDecimal curoddfare) {
		this.curoddfare = curoddfare;
	}



	/**
	 * Return the value associated with the column: AUTHTIME
	 */
	public java.util.Date getAuthtime () {
		return authtime;
	}

	/**
	 * Set the value related to the column: AUTHTIME
	 * @param authtime the AUTHTIME value
	 */
	public void setAuthtime (java.util.Date authtime) {
		this.authtime = authtime;
	}



	/**
	 * Return the value associated with the column: ALLOWOVERDRAFTFARE
	 */
	public java.math.BigDecimal getAllowoverdraftfare () {
		return allowoverdraftfare;
	}

	/**
	 * Set the value related to the column: ALLOWOVERDRAFTFARE
	 * @param allowoverdraftfare the ALLOWOVERDRAFTFARE value
	 */
	public void setAllowoverdraftfare (java.math.BigDecimal allowoverdraftfare) {
		this.allowoverdraftfare = allowoverdraftfare;
	}



	/**
	 * Return the value associated with the column: MAXLIMITDATE
	 */
	public java.lang.Integer getMaxlimitdate () {
		return maxlimitdate;
	}

	/**
	 * Set the value related to the column: MAXLIMITDATE
	 * @param maxlimitdate the MAXLIMITDATE value
	 */
	public void setMaxlimitdate (java.lang.Integer maxlimitdate) {
		this.maxlimitdate = maxlimitdate;
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
	 * Return the value associated with the column: WORKSTATUS
	 */
	public java.lang.String getWorkstatus () {
		return workstatus;
	}

	/**
	 * Set the value related to the column: WORKSTATUS
	 * @param workstatus the WORKSTATUS value
	 */
	public void setWorkstatus (java.lang.String workstatus) {
		this.workstatus = workstatus;
	}



	/**
	 * Return the value associated with the column: LIMITENDDATE
	 */
	public java.util.Date getLimitenddate () {
		return limitenddate;
	}

	/**
	 * Set the value related to the column: LIMITENDDATE
	 * @param limitenddate the LIMITENDDATE value
	 */
	public void setLimitenddate (java.util.Date limitenddate) {
		this.limitenddate = limitenddate;
	}



	/**
	 * Return the value associated with the column: MAXLIMITFARE
	 */
	public java.math.BigDecimal getMaxlimitfare () {
		return maxlimitfare;
	}

	/**
	 * Set the value related to the column: MAXLIMITFARE
	 * @param maxlimitfare the MAXLIMITFARE value
	 */
	public void setMaxlimitfare (java.math.BigDecimal maxlimitfare) {
		this.maxlimitfare = maxlimitfare;
	}



	/**
	 * Return the value associated with the column: SUMFARE
	 */
	public java.math.BigDecimal getSumfare () {
		return sumfare;
	}

	/**
	 * Set the value related to the column: SUMFARE
	 * @param sumfare the SUMFARE value
	 */
	public void setSumfare (java.math.BigDecimal sumfare) {
		this.sumfare = sumfare;
	}



	/**
	 * Return the value associated with the column: ALLOWOVERDRAFTOPDT
	 */
	public java.util.Date getAllowoverdraftopdt () {
		return allowoverdraftopdt;
	}

	/**
	 * Set the value related to the column: ALLOWOVERDRAFTOPDT
	 * @param allowoverdraftopdt the ALLOWOVERDRAFTOPDT value
	 */
	public void setAllowoverdraftopdt (java.util.Date allowoverdraftopdt) {
		this.allowoverdraftopdt = allowoverdraftopdt;
	}



	/**
	 * Return the value associated with the column: ALLOWOVERDRAFTSUMFARE
	 */
	public java.math.BigDecimal getAllowoverdraftsumfare () {
		return allowoverdraftsumfare;
	}

	/**
	 * Set the value related to the column: ALLOWOVERDRAFTSUMFARE
	 * @param allowoverdraftsumfare the ALLOWOVERDRAFTSUMFARE value
	 */
	public void setAllowoverdraftsumfare (java.math.BigDecimal allowoverdraftsumfare) {
		this.allowoverdraftsumfare = allowoverdraftsumfare;
	}



	/**
	 * Return the value associated with the column: EDIT_PERSON
	 */
	public java.lang.String getEditPerson () {
		return editPerson;
	}

	/**
	 * Set the value related to the column: EDIT_PERSON
	 * @param editPerson the EDIT_PERSON value
	 */
	public void setEditPerson (java.lang.String editPerson) {
		this.editPerson = editPerson;
	}



	/**
	 * Return the value associated with the column: EDIT_DATE
	 */
	public java.util.Date getEditDate () {
		return editDate;
	}

	/**
	 * Set the value related to the column: EDIT_DATE
	 * @param editDate the EDIT_DATE value
	 */
	public void setEditDate (java.util.Date editDate) {
		this.editDate = editDate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TraderChargeauth)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TraderChargeauth traderChargeauth = (cn.com.newcapec.citycard.common.po.TraderChargeauth) obj;
			if (null == this.getId() || null == traderChargeauth.getId()) return false;
			else return (this.getId().equals(traderChargeauth.getId()));
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