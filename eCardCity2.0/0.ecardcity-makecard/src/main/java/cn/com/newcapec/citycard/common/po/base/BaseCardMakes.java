package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CARD_MAKES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CARD_MAKES"
 */

public abstract class BaseCardMakes  implements Comparable, Serializable {

	public static String REF = "CardMakes";
	public static String PROP_CARDKIND = "cardkind";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_CARDSN = "cardsn";
	public static String PROP_CARDTYPE = "cardtype";
	public static String PROP_WALLETTYPE = "wallettype";
	public static String PROP_SCARDSNR = "scardsnr";
	public static String PROP_ID = "id";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_OLD_ASN = "oldAsn";
	public static String PROP_PTY = "pty";
	public static String PROP_CUSTOMERID = "customerid";


	// constructors
	public BaseCardMakes () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCardMakes (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCardMakes (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.Integer cardsn,
		java.lang.String scardsnr,
		java.lang.String pty,
		java.lang.String wallettype,
		java.lang.String cardkind,
		java.lang.String cardtype,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setCustomerid(customerid);
		this.setAsn(asn);
		this.setCardsn(cardsn);
		this.setScardsnr(scardsnr);
		this.setPty(pty);
		this.setWallettype(wallettype);
		this.setCardkind(cardkind);
		this.setCardtype(cardtype);
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
	private java.lang.Integer oldAsn;
	private java.lang.Integer cardsn;
	private java.lang.String scardsnr;
	private java.lang.String pty;
	private java.lang.String wallettype;
	private java.lang.String cardkind;
	private java.lang.String cardtype;
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
	 * Return the value associated with the column: OLD_ASN
	 */
	public java.lang.Integer getOldAsn () {
		return oldAsn;
	}

	/**
	 * Set the value related to the column: OLD_ASN
	 * @param oldAsn the OLD_ASN value
	 */
	public void setOldAsn (java.lang.Integer oldAsn) {
		this.oldAsn = oldAsn;
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
	 * Return the value associated with the column: SCARDSNR
	 */
	public java.lang.String getScardsnr () {
		return scardsnr;
	}

	/**
	 * Set the value related to the column: SCARDSNR
	 * @param scardsnr the SCARDSNR value
	 */
	public void setScardsnr (java.lang.String scardsnr) {
		this.scardsnr = scardsnr;
	}



	/**
	 * Return the value associated with the column: PTY
	 */
	public java.lang.String getPty () {
		return pty;
	}

	/**
	 * Set the value related to the column: PTY
	 * @param pty the PTY value
	 */
	public void setPty (java.lang.String pty) {
		this.pty = pty;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CardMakes)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CardMakes cardMakes = (cn.com.newcapec.citycard.common.po.CardMakes) obj;
			if (null == this.getId() || null == cardMakes.getId()) return false;
			else return (this.getId().equals(cardMakes.getId()));
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