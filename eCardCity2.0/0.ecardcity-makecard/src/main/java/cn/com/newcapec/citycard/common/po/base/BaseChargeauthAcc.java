package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CHARGEAUTH_ACC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CHARGEAUTH_ACC"
 */

public abstract class BaseChargeauthAcc  implements Comparable, Serializable {

	public static String REF = "ChargeauthAcc";
	public static String PROP_DIR = "dir";
	public static String PROP_NETSITEID = "netsiteid";
	public static String PROP_FLAG = "flag";
	public static String PROP_TYPEFLAG = "typeflag";
	public static String PROP_CUSTOMERUNITCODE = "customerunitcode";
	public static String PROP_OPFARE = "opfare";
	public static String PROP_SUMFARE = "sumfare";
	public static String PROP_ISUSE = "isuse";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_LASTODDFARE = "lastoddfare";
	public static String PROP_MAXLIMITDATE = "maxlimitdate";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_CURODDFARE = "curoddfare";
	public static String PROP_ID = "id";
	public static String PROP_MAXLIMITFARE = "maxlimitfare";
	public static String PROP_ALLOWOVERDRAFTFARE = "allowoverdraftfare";
	public static String PROP_CHANGEDPTCODE = "changedptcode";


	// constructors
	public BaseChargeauthAcc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseChargeauthAcc (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseChargeauthAcc (
		java.lang.String id,
		java.lang.String netsiteid,
		java.math.BigDecimal curoddfare,
		java.math.BigDecimal lastoddfare,
		java.math.BigDecimal opfare,
		java.math.BigDecimal allowoverdraftfare,
		java.lang.Integer maxlimitdate,
		java.lang.String isuse,
		java.lang.String customerunitcode,
		java.lang.String dir,
		java.lang.String flag,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setNetsiteid(netsiteid);
		this.setCuroddfare(curoddfare);
		this.setLastoddfare(lastoddfare);
		this.setOpfare(opfare);
		this.setAllowoverdraftfare(allowoverdraftfare);
		this.setMaxlimitdate(maxlimitdate);
		this.setIsuse(isuse);
		this.setCustomerunitcode(customerunitcode);
		this.setDir(dir);
		this.setFlag(flag);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.math.BigDecimal allowoverdraftfare;
	private java.lang.String changedptcode;
	private java.math.BigDecimal curoddfare;
	private java.lang.String customerunitcode;
	private java.lang.String dir;
	private java.util.Date editDate;
	private java.lang.String editPerson;
	private java.lang.String flag;
	private java.lang.String isuse;
	private java.math.BigDecimal lastoddfare;
	private java.lang.Integer maxlimitdate;
	private java.math.BigDecimal maxlimitfare;
	private java.lang.String netsiteid;
	private java.math.BigDecimal opfare;
	private java.math.BigDecimal sumfare;
	private java.lang.String typeflag;



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
	 * Return the value associated with the column: CHANGEDPTCODE
	 */
	public java.lang.String getChangedptcode () {
		return changedptcode;
	}

	/**
	 * Set the value related to the column: CHANGEDPTCODE
	 * @param changedptcode the CHANGEDPTCODE value
	 */
	public void setChangedptcode (java.lang.String changedptcode) {
		this.changedptcode = changedptcode;
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
	 * Return the value associated with the column: CUSTOMERUNITCODE
	 */
	public java.lang.String getCustomerunitcode () {
		return customerunitcode;
	}

	/**
	 * Set the value related to the column: CUSTOMERUNITCODE
	 * @param customerunitcode the CUSTOMERUNITCODE value
	 */
	public void setCustomerunitcode (java.lang.String customerunitcode) {
		this.customerunitcode = customerunitcode;
	}



	/**
	 * Return the value associated with the column: DIR
	 */
	public java.lang.String getDir () {
		return dir;
	}

	/**
	 * Set the value related to the column: DIR
	 * @param dir the DIR value
	 */
	public void setDir (java.lang.String dir) {
		this.dir = dir;
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
	 * Return the value associated with the column: FLAG
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: FLAG
	 * @param flag the FLAG value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
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
	 * Return the value associated with the column: LASTODDFARE
	 */
	public java.math.BigDecimal getLastoddfare () {
		return lastoddfare;
	}

	/**
	 * Set the value related to the column: LASTODDFARE
	 * @param lastoddfare the LASTODDFARE value
	 */
	public void setLastoddfare (java.math.BigDecimal lastoddfare) {
		this.lastoddfare = lastoddfare;
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
	 * Return the value associated with the column: OPFARE
	 */
	public java.math.BigDecimal getOpfare () {
		return opfare;
	}

	/**
	 * Set the value related to the column: OPFARE
	 * @param opfare the OPFARE value
	 */
	public void setOpfare (java.math.BigDecimal opfare) {
		this.opfare = opfare;
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
	 * Return the value associated with the column: TYPEFLAG
	 */
	public java.lang.String getTypeflag () {
		return typeflag;
	}

	/**
	 * Set the value related to the column: TYPEFLAG
	 * @param typeflag the TYPEFLAG value
	 */
	public void setTypeflag (java.lang.String typeflag) {
		this.typeflag = typeflag;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.ChargeauthAcc)) return false;
		else {
			cn.com.newcapec.citycard.common.po.ChargeauthAcc chargeauthAcc = (cn.com.newcapec.citycard.common.po.ChargeauthAcc) obj;
			if (null == this.getId() || null == chargeauthAcc.getId()) return false;
			else return (this.getId().equals(chargeauthAcc.getId()));
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