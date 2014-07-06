package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CARD_ANNUAL_INSPECTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CARD_ANNUAL_INSPECTION"
 */

public abstract class BaseCardAnnualInspection  implements Comparable, Serializable {

	public static String REF = "CardAnnualInspection";
	public static String PROP_PRE_ANNUAL_INSPECTION_END = "preAnnualInspectionEnd";
	public static String PROP_PRE_ANNUAL_INSPECTION_START = "preAnnualInspectionStart";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_ANNUAL_INSPECTION_RESULT = "annualInspectionResult";
	public static String PROP_ID = "id";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_POSCODE = "poscode";


	// constructors
	public BaseCardAnnualInspection () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCardAnnualInspection (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCardAnnualInspection (
		java.lang.String id,
		java.lang.Integer asn,
		java.util.Date preAnnualInspectionStart,
		java.util.Date preAnnualInspectionEnd,
		java.lang.String annualInspectionResult,
		java.lang.String poscode,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setAsn(asn);
		this.setPreAnnualInspectionStart(preAnnualInspectionStart);
		this.setPreAnnualInspectionEnd(preAnnualInspectionEnd);
		this.setAnnualInspectionResult(annualInspectionResult);
		this.setPoscode(poscode);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer asn;
	private java.util.Date preAnnualInspectionStart;
	private java.util.Date preAnnualInspectionEnd;
	private java.lang.String annualInspectionResult;
	private java.lang.String poscode;
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
	 * Return the value associated with the column: PRE_ANNUAL_INSPECTION_START
	 */
	public java.util.Date getPreAnnualInspectionStart () {
		return preAnnualInspectionStart;
	}

	/**
	 * Set the value related to the column: PRE_ANNUAL_INSPECTION_START
	 * @param preAnnualInspectionStart the PRE_ANNUAL_INSPECTION_START value
	 */
	public void setPreAnnualInspectionStart (java.util.Date preAnnualInspectionStart) {
		this.preAnnualInspectionStart = preAnnualInspectionStart;
	}



	/**
	 * Return the value associated with the column: PRE_ANNUAL_INSPECTION_END
	 */
	public java.util.Date getPreAnnualInspectionEnd () {
		return preAnnualInspectionEnd;
	}

	/**
	 * Set the value related to the column: PRE_ANNUAL_INSPECTION_END
	 * @param preAnnualInspectionEnd the PRE_ANNUAL_INSPECTION_END value
	 */
	public void setPreAnnualInspectionEnd (java.util.Date preAnnualInspectionEnd) {
		this.preAnnualInspectionEnd = preAnnualInspectionEnd;
	}



	/**
	 * Return the value associated with the column: ANNUAL_INSPECTION_RESULT
	 */
	public java.lang.String getAnnualInspectionResult () {
		return annualInspectionResult;
	}

	/**
	 * Set the value related to the column: ANNUAL_INSPECTION_RESULT
	 * @param annualInspectionResult the ANNUAL_INSPECTION_RESULT value
	 */
	public void setAnnualInspectionResult (java.lang.String annualInspectionResult) {
		this.annualInspectionResult = annualInspectionResult;
	}



	/**
	 * Return the value associated with the column: POSCODE
	 */
	public java.lang.String getPoscode () {
		return poscode;
	}

	/**
	 * Set the value related to the column: POSCODE
	 * @param poscode the POSCODE value
	 */
	public void setPoscode (java.lang.String poscode) {
		this.poscode = poscode;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CardAnnualInspection)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CardAnnualInspection cardAnnualInspection = (cn.com.newcapec.citycard.common.po.CardAnnualInspection) obj;
			if (null == this.getId() || null == cardAnnualInspection.getId()) return false;
			else return (this.getId().equals(cardAnnualInspection.getId()));
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