package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the MONEY_DRAW_APPLY_STATUS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MONEY_DRAW_APPLY_STATUS"
 */

public abstract class BaseMoneyDrawApplyStatus  implements Comparable, Serializable {

	public static String REF = "MoneyDrawApplyStatus";
	public static String PROP_OLDAFFAIRSTATUS = "oldaffairstatus";
	public static String PROP_SAVEOPCOUNT = "saveopcount";
	public static String PROP_CARDSN = "cardsn";
	public static String PROP_OLDSTATE = "oldstate";
	public static String PROP_REASONCODE = "reasoncode";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_PLANID = "planid";
	public static String PROP_OPCOUNT = "opcount";
	public static String PROP_NEWSTATE = "newstate";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_NEWAFFAIRSTATUS = "newaffairstatus";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_WALLETTYPE = "wallettype";
	public static String PROP_BUSINESSTYPE = "businesstype";
	public static String PROP_ID = "id";
	public static String PROP_POSCODE = "poscode";
	public static String PROP_REASON = "reason";


	// constructors
	public BaseMoneyDrawApplyStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMoneyDrawApplyStatus (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMoneyDrawApplyStatus (
		java.lang.String id,
		java.lang.String oldstate,
		java.lang.String newstate,
		java.lang.String oldaffairstatus,
		java.lang.String newaffairstatus,
		java.lang.String reason,
		java.lang.Integer reasoncode,
		java.lang.Integer saveopcount,
		java.lang.Integer opcount,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setOldstate(oldstate);
		this.setNewstate(newstate);
		this.setOldaffairstatus(oldaffairstatus);
		this.setNewaffairstatus(newaffairstatus);
		this.setReason(reason);
		this.setReasoncode(reasoncode);
		this.setSaveopcount(saveopcount);
		this.setOpcount(opcount);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String planid;
	private java.lang.String oldstate;
	private java.lang.String newstate;
	private java.lang.String oldaffairstatus;
	private java.lang.String newaffairstatus;
	private java.lang.String reason;
	private java.lang.Integer reasoncode;
	private java.lang.Integer asn;
	private java.lang.Integer cardsn;
	private java.lang.String customerid;
	private java.lang.String poscode;
	private java.lang.String businesstype;
	private java.lang.String wallettype;
	private java.lang.Integer saveopcount;
	private java.lang.Integer opcount;
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
	 * Return the value associated with the column: PLANID
	 */
	public java.lang.String getPlanid () {
		return planid;
	}

	/**
	 * Set the value related to the column: PLANID
	 * @param planid the PLANID value
	 */
	public void setPlanid (java.lang.String planid) {
		this.planid = planid;
	}



	/**
	 * Return the value associated with the column: OLDSTATE
	 */
	public java.lang.String getOldstate () {
		return oldstate;
	}

	/**
	 * Set the value related to the column: OLDSTATE
	 * @param oldstate the OLDSTATE value
	 */
	public void setOldstate (java.lang.String oldstate) {
		this.oldstate = oldstate;
	}



	/**
	 * Return the value associated with the column: NEWSTATE
	 */
	public java.lang.String getNewstate () {
		return newstate;
	}

	/**
	 * Set the value related to the column: NEWSTATE
	 * @param newstate the NEWSTATE value
	 */
	public void setNewstate (java.lang.String newstate) {
		this.newstate = newstate;
	}



	/**
	 * Return the value associated with the column: OLDAFFAIRSTATUS
	 */
	public java.lang.String getOldaffairstatus () {
		return oldaffairstatus;
	}

	/**
	 * Set the value related to the column: OLDAFFAIRSTATUS
	 * @param oldaffairstatus the OLDAFFAIRSTATUS value
	 */
	public void setOldaffairstatus (java.lang.String oldaffairstatus) {
		this.oldaffairstatus = oldaffairstatus;
	}



	/**
	 * Return the value associated with the column: NEWAFFAIRSTATUS
	 */
	public java.lang.String getNewaffairstatus () {
		return newaffairstatus;
	}

	/**
	 * Set the value related to the column: NEWAFFAIRSTATUS
	 * @param newaffairstatus the NEWAFFAIRSTATUS value
	 */
	public void setNewaffairstatus (java.lang.String newaffairstatus) {
		this.newaffairstatus = newaffairstatus;
	}



	/**
	 * Return the value associated with the column: REASON
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: REASON
	 * @param reason the REASON value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: REASONCODE
	 */
	public java.lang.Integer getReasoncode () {
		return reasoncode;
	}

	/**
	 * Set the value related to the column: REASONCODE
	 * @param reasoncode the REASONCODE value
	 */
	public void setReasoncode (java.lang.Integer reasoncode) {
		this.reasoncode = reasoncode;
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
	 * Return the value associated with the column: CARDSN
	 */
	public java.lang.Integer getCardsn () {
		return cardsn;
	}

	/**
	 * Set the value related to the column: CARDSN
	 * @param cardsn the CARDSN value
	 */
	public void setCardsn (java.lang.Integer cardsn) {
		this.cardsn = cardsn;
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
	 * Return the value associated with the column: BUSINESSTYPE
	 */
	public java.lang.String getBusinesstype () {
		return businesstype;
	}

	/**
	 * Set the value related to the column: BUSINESSTYPE
	 * @param businesstype the BUSINESSTYPE value
	 */
	public void setBusinesstype (java.lang.String businesstype) {
		this.businesstype = businesstype;
	}



	/**
	 * Return the value associated with the column: WALLETTYPE
	 */
	public java.lang.String getWallettype () {
		return wallettype;
	}

	/**
	 * Set the value related to the column: WALLETTYPE
	 * @param wallettype the WALLETTYPE value
	 */
	public void setWallettype (java.lang.String wallettype) {
		this.wallettype = wallettype;
	}



	/**
	 * Return the value associated with the column: SAVEOPCOUNT
	 */
	public java.lang.Integer getSaveopcount () {
		return saveopcount;
	}

	/**
	 * Set the value related to the column: SAVEOPCOUNT
	 * @param saveopcount the SAVEOPCOUNT value
	 */
	public void setSaveopcount (java.lang.Integer saveopcount) {
		this.saveopcount = saveopcount;
	}



	/**
	 * Return the value associated with the column: OPCOUNT
	 */
	public java.lang.Integer getOpcount () {
		return opcount;
	}

	/**
	 * Set the value related to the column: OPCOUNT
	 * @param opcount the OPCOUNT value
	 */
	public void setOpcount (java.lang.Integer opcount) {
		this.opcount = opcount;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.MoneyDrawApplyStatus)) return false;
		else {
			cn.com.newcapec.citycard.common.po.MoneyDrawApplyStatus moneyDrawApplyStatus = (cn.com.newcapec.citycard.common.po.MoneyDrawApplyStatus) obj;
			if (null == this.getId() || null == moneyDrawApplyStatus.getId()) return false;
			else return (this.getId().equals(moneyDrawApplyStatus.getId()));
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