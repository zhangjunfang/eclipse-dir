package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the MONEY_DRAW_APPLY_PLAN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MONEY_DRAW_APPLY_PLAN"
 */

public abstract class BaseMoneyDrawApplyPlan  implements Comparable, Serializable {

	public static String REF = "MoneyDrawApplyPlan";
	public static String PROP_CARDKIND = "cardkind";
	public static String PROP_SAVEOPCOUNT = "saveopcount";
	public static String PROP_CARDTYPE = "cardtype";
	public static String PROP_OPFARE = "opfare";
	public static String PROP_OPCOUNT = "opcount";
	public static String PROP_OPPACCFC = "oppaccfc";
	public static String PROP_OPPZWDATE = "oppzwdate";
	public static String PROP_AFFAIRSTATUS = "affairstatus";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_CREATEDT = "createdt";
	public static String PROP_CORRECT = "correct";
	public static String PROP_TAC = "tac";
	public static String PROP_ODDFARE = "oddfare";
	public static String PROP_CARDSN = "cardsn";
	public static String PROP_TRANSBATNO = "transbatno";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_FIRSTDT = "firstdt";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_STATUS = "status";
	public static String PROP_DESCRITION = "descrition";
	public static String PROP_WALLETTYPE = "wallettype";
	public static String PROP_PSAMCARDNO = "psamcardno";
	public static String PROP_BUSINESSTYPE = "businesstype";
	public static String PROP_ACCCODE = "acccode";
	public static String PROP_ID = "id";
	public static String PROP_CSTACCFC = "cstaccfc";
	public static String PROP_PRESAVEOPCOUNT = "presaveopcount";
	public static String PROP_POSCODE = "poscode";


	// constructors
	public BaseMoneyDrawApplyPlan () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMoneyDrawApplyPlan (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMoneyDrawApplyPlan (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String wallettype,
		java.lang.Integer cardsn,
		java.lang.String cardkind,
		java.lang.String cardtype,
		java.math.BigDecimal oddfare,
		java.math.BigDecimal opfare,
		java.lang.Integer opcount,
		java.lang.String status,
		java.lang.String affairstatus,
		java.lang.String descrition,
		java.lang.String poscode,
		java.lang.Integer psamcardno,
		java.lang.Integer presaveopcount,
		java.lang.Integer saveopcount,
		java.lang.String businesstype,
		java.lang.String acccode,
		java.lang.Integer transbatno,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setCustomerid(customerid);
		this.setAsn(asn);
		this.setWallettype(wallettype);
		this.setCardsn(cardsn);
		this.setCardkind(cardkind);
		this.setCardtype(cardtype);
		this.setOddfare(oddfare);
		this.setOpfare(opfare);
		this.setOpcount(opcount);
		this.setStatus(status);
		this.setAffairstatus(affairstatus);
		this.setDescrition(descrition);
		this.setPoscode(poscode);
		this.setPsamcardno(psamcardno);
		this.setPresaveopcount(presaveopcount);
		this.setSaveopcount(saveopcount);
		this.setBusinesstype(businesstype);
		this.setAcccode(acccode);
		this.setTransbatno(transbatno);
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
	private java.lang.String wallettype;
	private java.lang.Integer cardsn;
	private java.lang.String cardkind;
	private java.lang.String cardtype;
	private java.math.BigDecimal oddfare;
	private java.math.BigDecimal opfare;
	private java.lang.Integer opcount;
	private java.lang.String status;
	private java.lang.String affairstatus;
	private java.lang.String descrition;
	private java.lang.String poscode;
	private java.lang.Integer psamcardno;
	private java.lang.String tac;
	private java.util.Date firstdt;
	private java.util.Date createdt;
	private java.util.Date oppzwdate;
	private java.lang.Integer oppaccfc;
	private java.lang.Integer presaveopcount;
	private java.lang.Integer saveopcount;
	private java.lang.String businesstype;
	private java.lang.String acccode;
	private java.lang.Integer transbatno;
	private java.lang.String correct;
	private java.lang.String cstaccfc;
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
	 * Return the value associated with the column: ODDFARE
	 */
	public java.math.BigDecimal getOddfare () {
		return oddfare;
	}

	/**
	 * Set the value related to the column: ODDFARE
	 * @param oddfare the ODDFARE value
	 */
	public void setOddfare (java.math.BigDecimal oddfare) {
		this.oddfare = oddfare;
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
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: AFFAIRSTATUS
	 */
	public java.lang.String getAffairstatus () {
		return affairstatus;
	}

	/**
	 * Set the value related to the column: AFFAIRSTATUS
	 * @param affairstatus the AFFAIRSTATUS value
	 */
	public void setAffairstatus (java.lang.String affairstatus) {
		this.affairstatus = affairstatus;
	}



	/**
	 * Return the value associated with the column: DESCRITION
	 */
	public java.lang.String getDescrition () {
		return descrition;
	}

	/**
	 * Set the value related to the column: DESCRITION
	 * @param descrition the DESCRITION value
	 */
	public void setDescrition (java.lang.String descrition) {
		this.descrition = descrition;
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
	 * Return the value associated with the column: PSAMCARDNO
	 */
	public java.lang.Integer getPsamcardno () {
		return psamcardno;
	}

	/**
	 * Set the value related to the column: PSAMCARDNO
	 * @param psamcardno the PSAMCARDNO value
	 */
	public void setPsamcardno (java.lang.Integer psamcardno) {
		this.psamcardno = psamcardno;
	}



	/**
	 * Return the value associated with the column: TAC
	 */
	public java.lang.String getTac () {
		return tac;
	}

	/**
	 * Set the value related to the column: TAC
	 * @param tac the TAC value
	 */
	public void setTac (java.lang.String tac) {
		this.tac = tac;
	}



	/**
	 * Return the value associated with the column: FIRSTDT
	 */
	public java.util.Date getFirstdt () {
		return firstdt;
	}

	/**
	 * Set the value related to the column: FIRSTDT
	 * @param firstdt the FIRSTDT value
	 */
	public void setFirstdt (java.util.Date firstdt) {
		this.firstdt = firstdt;
	}



	/**
	 * Return the value associated with the column: CREATEDT
	 */
	public java.util.Date getCreatedt () {
		return createdt;
	}

	/**
	 * Set the value related to the column: CREATEDT
	 * @param createdt the CREATEDT value
	 */
	public void setCreatedt (java.util.Date createdt) {
		this.createdt = createdt;
	}



	/**
	 * Return the value associated with the column: OPPZWDATE
	 */
	public java.util.Date getOppzwdate () {
		return oppzwdate;
	}

	/**
	 * Set the value related to the column: OPPZWDATE
	 * @param oppzwdate the OPPZWDATE value
	 */
	public void setOppzwdate (java.util.Date oppzwdate) {
		this.oppzwdate = oppzwdate;
	}



	/**
	 * Return the value associated with the column: OPPACCFC
	 */
	public java.lang.Integer getOppaccfc () {
		return oppaccfc;
	}

	/**
	 * Set the value related to the column: OPPACCFC
	 * @param oppaccfc the OPPACCFC value
	 */
	public void setOppaccfc (java.lang.Integer oppaccfc) {
		this.oppaccfc = oppaccfc;
	}



	/**
	 * Return the value associated with the column: PRESAVEOPCOUNT
	 */
	public java.lang.Integer getPresaveopcount () {
		return presaveopcount;
	}

	/**
	 * Set the value related to the column: PRESAVEOPCOUNT
	 * @param presaveopcount the PRESAVEOPCOUNT value
	 */
	public void setPresaveopcount (java.lang.Integer presaveopcount) {
		this.presaveopcount = presaveopcount;
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
	 * Return the value associated with the column: TRANSBATNO
	 */
	public java.lang.Integer getTransbatno () {
		return transbatno;
	}

	/**
	 * Set the value related to the column: TRANSBATNO
	 * @param transbatno the TRANSBATNO value
	 */
	public void setTransbatno (java.lang.Integer transbatno) {
		this.transbatno = transbatno;
	}



	/**
	 * Return the value associated with the column: CORRECT
	 */
	public java.lang.String getCorrect () {
		return correct;
	}

	/**
	 * Set the value related to the column: CORRECT
	 * @param correct the CORRECT value
	 */
	public void setCorrect (java.lang.String correct) {
		this.correct = correct;
	}



	/**
	 * Return the value associated with the column: CSTACCFC
	 */
	public java.lang.String getCstaccfc () {
		return cstaccfc;
	}

	/**
	 * Set the value related to the column: CSTACCFC
	 * @param cstaccfc the CSTACCFC value
	 */
	public void setCstaccfc (java.lang.String cstaccfc) {
		this.cstaccfc = cstaccfc;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.MoneyDrawApplyPlan)) return false;
		else {
			cn.com.newcapec.citycard.common.po.MoneyDrawApplyPlan moneyDrawApplyPlan = (cn.com.newcapec.citycard.common.po.MoneyDrawApplyPlan) obj;
			if (null == this.getId() || null == moneyDrawApplyPlan.getId()) return false;
			else return (this.getId().equals(moneyDrawApplyPlan.getId()));
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