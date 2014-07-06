package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CARD_EMPLOYEE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CARD_EMPLOYEE"
 */

public abstract class BaseCardEmployee  implements Comparable, Serializable {

	public static String REF = "CardEmployee";
	public static String PROP_CARDSN = "cardsn";
	public static String PROP_CARDTYPE = "cardtype";
	public static String PROP_CARDFLAG = "cardflag";
	public static String PROP_PWD = "pwd";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_EXPIRY_DATE = "expiryDate";
	public static String PROP_VER = "ver";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_SCARDSNR = "scardsnr";
	public static String PROP_LOSS_DATE = "lossDate";
	public static String PROP_ID = "id";
	public static String PROP_EMPID = "empid";
	public static String PROP_CARDSTATUS = "cardstatus";


	// constructors
	public BaseCardEmployee () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCardEmployee (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCardEmployee (
		java.lang.String id,
		java.lang.String empid,
		java.lang.Integer asn,
		java.lang.String scardsnr,
		java.lang.Integer cardsn,
		java.lang.String cardtype,
		java.lang.String cardstatus,
		java.lang.String cardflag,
		java.lang.String pwd,
		java.util.Date expiryDate,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setEmpid(empid);
		this.setAsn(asn);
		this.setScardsnr(scardsnr);
		this.setCardsn(cardsn);
		this.setCardtype(cardtype);
		this.setCardstatus(cardstatus);
		this.setCardflag(cardflag);
		this.setPwd(pwd);
		this.setExpiryDate(expiryDate);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String empid;
	private java.lang.Integer asn;
	private java.lang.String scardsnr;
	private java.lang.Integer cardsn;
	private java.lang.String cardtype;
	private java.lang.String cardstatus;
	private java.lang.String cardflag;
	private java.lang.String pwd;
	private java.util.Date expiryDate;
	private java.util.Date lossDate;
	private java.lang.Integer ver;
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
	 * Return the value associated with the column: EMPID
	 */
	public java.lang.String getEmpid () {
		return empid;
	}

	/**
	 * Set the value related to the column: EMPID
	 * @param empid the EMPID value
	 */
	public void setEmpid (java.lang.String empid) {
		this.empid = empid;
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
	 * Return the value associated with the column: CARDSTATUS
	 */
	public java.lang.String getCardstatus () {
		return cardstatus;
	}

	/**
	 * Set the value related to the column: CARDSTATUS
	 * @param cardstatus the CARDSTATUS value
	 */
	public void setCardstatus (java.lang.String cardstatus) {
		this.cardstatus = cardstatus;
	}



	/**
	 * Return the value associated with the column: CARDFLAG
	 */
	public java.lang.String getCardflag () {
		return cardflag;
	}

	/**
	 * Set the value related to the column: CARDFLAG
	 * @param cardflag the CARDFLAG value
	 */
	public void setCardflag (java.lang.String cardflag) {
		this.cardflag = cardflag;
	}



	/**
	 * Return the value associated with the column: PWD
	 */
	public java.lang.String getPwd () {
		return pwd;
	}

	/**
	 * Set the value related to the column: PWD
	 * @param pwd the PWD value
	 */
	public void setPwd (java.lang.String pwd) {
		this.pwd = pwd;
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
	 * Return the value associated with the column: LOSS_DATE
	 */
	public java.util.Date getLossDate () {
		return lossDate;
	}

	/**
	 * Set the value related to the column: LOSS_DATE
	 * @param lossDate the LOSS_DATE value
	 */
	public void setLossDate (java.util.Date lossDate) {
		this.lossDate = lossDate;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CardEmployee)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CardEmployee cardEmployee = (cn.com.newcapec.citycard.common.po.CardEmployee) obj;
			if (null == this.getId() || null == cardEmployee.getId()) return false;
			else return (this.getId().equals(cardEmployee.getId()));
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