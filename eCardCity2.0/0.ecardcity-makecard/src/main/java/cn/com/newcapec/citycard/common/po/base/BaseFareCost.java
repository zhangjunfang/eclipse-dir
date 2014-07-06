package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the FARE_COST table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FARE_COST"
 */

public abstract class BaseFareCost  implements Comparable, Serializable {

	public static String REF = "FareCost";
	public static String PROP_CARDKIND = "cardkind";
	public static String PROP_DSCRP = "dscrp";
	public static String PROP_CARDTYPE = "cardtype";
	public static String PROP_OPFARE = "opfare";
	public static String PROP_ISCHARGE = "ischarge";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_ACCCODE = "acccode";
	public static String PROP_HASRETURN = "hasreturn";
	public static String PROP_NOTFARECAUSE = "notfarecause";
	public static String PROP_ID = "id";
	public static String PROP_ACCFARE = "accfare";


	// constructors
	public BaseFareCost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFareCost (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFareCost (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.math.BigDecimal opfare,
		java.lang.String acccode,
		java.lang.String cardkind,
		java.lang.String cardtype,
		java.math.BigDecimal accfare,
		java.lang.String ischarge,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setCustomerid(customerid);
		this.setAsn(asn);
		this.setOpfare(opfare);
		this.setAcccode(acccode);
		this.setCardkind(cardkind);
		this.setCardtype(cardtype);
		this.setAccfare(accfare);
		this.setIscharge(ischarge);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String customerid;
	private java.lang.Integer asn;
	private java.math.BigDecimal opfare;
	private java.lang.String acccode;
	private java.lang.String dscrp;
	private java.lang.String hasreturn;
	private java.lang.String notfarecause;
	private java.lang.String cardkind;
	private java.lang.String cardtype;
	private java.math.BigDecimal accfare;
	private java.lang.String ischarge;
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
	 * Return the value associated with the column: CUSTOMERID
	 */
	public java.lang.String getCustomerid () {
		return customerid;
	}

	/**
	 * Set the value related to the column: CUSTOMERID
	 * @param customerid the CUSTOMERID value
	 */
	public void setCustomerid (java.lang.String customerid) {
		this.customerid = customerid;
	}



	/**
	 * Return the value associated with the column: ASN
	 */
	public java.lang.Integer getAsn () {
		return asn;
	}

	/**
	 * Set the value related to the column: ASN
	 * @param asn the ASN value
	 */
	public void setAsn (java.lang.Integer asn) {
		this.asn = asn;
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
	 * Return the value associated with the column: ACCCODE
	 */
	public java.lang.String getAcccode () {
		return acccode;
	}

	/**
	 * Set the value related to the column: ACCCODE
	 * @param acccode the ACCCODE value
	 */
	public void setAcccode (java.lang.String acccode) {
		this.acccode = acccode;
	}



	/**
	 * Return the value associated with the column: DSCRP
	 */
	public java.lang.String getDscrp () {
		return dscrp;
	}

	/**
	 * Set the value related to the column: DSCRP
	 * @param dscrp the DSCRP value
	 */
	public void setDscrp (java.lang.String dscrp) {
		this.dscrp = dscrp;
	}



	/**
	 * Return the value associated with the column: HASRETURN
	 */
	public java.lang.String getHasreturn () {
		return hasreturn;
	}

	/**
	 * Set the value related to the column: HASRETURN
	 * @param hasreturn the HASRETURN value
	 */
	public void setHasreturn (java.lang.String hasreturn) {
		this.hasreturn = hasreturn;
	}



	/**
	 * Return the value associated with the column: NOTFARECAUSE
	 */
	public java.lang.String getNotfarecause () {
		return notfarecause;
	}

	/**
	 * Set the value related to the column: NOTFARECAUSE
	 * @param notfarecause the NOTFARECAUSE value
	 */
	public void setNotfarecause (java.lang.String notfarecause) {
		this.notfarecause = notfarecause;
	}



	/**
	 * Return the value associated with the column: CARDKIND
	 */
	public java.lang.String getCardkind () {
		return cardkind;
	}

	/**
	 * Set the value related to the column: CARDKIND
	 * @param cardkind the CARDKIND value
	 */
	public void setCardkind (java.lang.String cardkind) {
		this.cardkind = cardkind;
	}



	/**
	 * Return the value associated with the column: CARDTYPE
	 */
	public java.lang.String getCardtype () {
		return cardtype;
	}

	/**
	 * Set the value related to the column: CARDTYPE
	 * @param cardtype the CARDTYPE value
	 */
	public void setCardtype (java.lang.String cardtype) {
		this.cardtype = cardtype;
	}



	/**
	 * Return the value associated with the column: ACCFARE
	 */
	public java.math.BigDecimal getAccfare () {
		return accfare;
	}

	/**
	 * Set the value related to the column: ACCFARE
	 * @param accfare the ACCFARE value
	 */
	public void setAccfare (java.math.BigDecimal accfare) {
		this.accfare = accfare;
	}



	/**
	 * Return the value associated with the column: ISCHARGE
	 */
	public java.lang.String getIscharge () {
		return ischarge;
	}

	/**
	 * Set the value related to the column: ISCHARGE
	 * @param ischarge the ISCHARGE value
	 */
	public void setIscharge (java.lang.String ischarge) {
		this.ischarge = ischarge;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.FareCost)) return false;
		else {
			cn.com.newcapec.citycard.common.po.FareCost fareCost = (cn.com.newcapec.citycard.common.po.FareCost) obj;
			if (null == this.getId() || null == fareCost.getId()) return false;
			else return (this.getId().equals(fareCost.getId()));
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