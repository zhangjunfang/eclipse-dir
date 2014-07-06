package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CARD_APPINFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CARD_APPINFO"
 */

public abstract class BaseCardAppinfo  implements Comparable, Serializable {

	public static String REF = "CardAppinfo";
	public static String PROP_CARDKIND = "cardkind";
	public static String PROP_FLAG = "flag";
	public static String PROP_CARDSN = "cardsn";
	public static String PROP_CARDTYPE = "cardtype";
	public static String PROP_CITYCARDNO = "citycardno";
	public static String PROP_CARDFLAG = "cardflag";
	public static String PROP_PWD = "pwd";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_VER = "ver";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_SCARDSNR = "scardsnr";
	public static String PROP_LOSSDT = "lossdt";
	public static String PROP_SEARCHPWD = "searchpwd";
	public static String PROP_ID = "id";
	public static String PROP_ANNUAL_INSPECTION_START = "annualInspectionStart";
	public static String PROP_ANNUAL_INSPECTION = "annualInspection";
	public static String PROP_CARDUSE = "carduse";
	public static String PROP_ANNUAL_INSPECTION_END = "annualInspectionEnd";
	public static String PROP_MARK_NAME = "markName";
	public static String PROP_CARDSTATUS = "cardstatus";


	// constructors
	public BaseCardAppinfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCardAppinfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCardAppinfo (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String citycardno,
		java.lang.String scardsnr,
		java.lang.Integer cardsn,
		java.lang.String cardkind,
		java.lang.String cardtype,
		java.lang.String cardstatus,
		java.lang.String flag,
		java.lang.String cardflag,
		java.lang.String pwd,
		java.lang.String markName,
		boolean annualInspection,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setCustomerid(customerid);
		this.setAsn(asn);
		this.setCitycardno(citycardno);
		this.setScardsnr(scardsnr);
		this.setCardsn(cardsn);
		this.setCardkind(cardkind);
		this.setCardtype(cardtype);
		this.setCardstatus(cardstatus);
		this.setFlag(flag);
		this.setCardflag(cardflag);
		this.setPwd(pwd);
		this.setMarkName(markName);
		this.setAnnualInspection(annualInspection);
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
	private java.lang.String citycardno;
	private java.lang.String scardsnr;
	private java.lang.Integer cardsn;
	private java.lang.String cardkind;
	private java.lang.String cardtype;
	private java.lang.String cardstatus;
	private java.lang.String flag;
	private java.lang.String cardflag;
	private java.lang.Integer carduse;
	private java.lang.String pwd;
	private java.util.Date lossdt;
	private java.lang.String searchpwd;
	private java.lang.Integer ver;
	private java.lang.String markName;
	private boolean annualInspection;
	private java.util.Date annualInspectionStart;
	private java.util.Date annualInspectionEnd;
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
	 * Return the value associated with the column: CITYCARDNO
	 */
	public java.lang.String getCitycardno () {
		return citycardno;
	}

	/**
	 * Set the value related to the column: CITYCARDNO
	 * @param citycardno the CITYCARDNO value
	 */
	public void setCitycardno (java.lang.String citycardno) {
		this.citycardno = citycardno;
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
	 * Return the value associated with the column: CARDUSE
	 */
	public java.lang.Integer getCarduse () {
		return carduse;
	}

	/**
	 * Set the value related to the column: CARDUSE
	 * @param carduse the CARDUSE value
	 */
	public void setCarduse (java.lang.Integer carduse) {
		this.carduse = carduse;
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
	 * Return the value associated with the column: LOSSDT
	 */
	public java.util.Date getLossdt () {
		return lossdt;
	}

	/**
	 * Set the value related to the column: LOSSDT
	 * @param lossdt the LOSSDT value
	 */
	public void setLossdt (java.util.Date lossdt) {
		this.lossdt = lossdt;
	}



	/**
	 * Return the value associated with the column: SEARCHPWD
	 */
	public java.lang.String getSearchpwd () {
		return searchpwd;
	}

	/**
	 * Set the value related to the column: SEARCHPWD
	 * @param searchpwd the SEARCHPWD value
	 */
	public void setSearchpwd (java.lang.String searchpwd) {
		this.searchpwd = searchpwd;
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
	 * Return the value associated with the column: MARK_NAME
	 */
	public java.lang.String getMarkName () {
		return markName;
	}

	/**
	 * Set the value related to the column: MARK_NAME
	 * @param markName the MARK_NAME value
	 */
	public void setMarkName (java.lang.String markName) {
		this.markName = markName;
	}



	/**
	 * Return the value associated with the column: IS_ANNUAL_INSPECTION
	 */
	public boolean isAnnualInspection () {
		return annualInspection;
	}

	/**
	 * Set the value related to the column: IS_ANNUAL_INSPECTION
	 * @param annualInspection the IS_ANNUAL_INSPECTION value
	 */
	public void setAnnualInspection (boolean annualInspection) {
		this.annualInspection = annualInspection;
	}



	/**
	 * Return the value associated with the column: ANNUAL_INSPECTION_START
	 */
	public java.util.Date getAnnualInspectionStart () {
		return annualInspectionStart;
	}

	/**
	 * Set the value related to the column: ANNUAL_INSPECTION_START
	 * @param annualInspectionStart the ANNUAL_INSPECTION_START value
	 */
	public void setAnnualInspectionStart (java.util.Date annualInspectionStart) {
		this.annualInspectionStart = annualInspectionStart;
	}



	/**
	 * Return the value associated with the column: ANNUAL_INSPECTION_END
	 */
	public java.util.Date getAnnualInspectionEnd () {
		return annualInspectionEnd;
	}

	/**
	 * Set the value related to the column: ANNUAL_INSPECTION_END
	 * @param annualInspectionEnd the ANNUAL_INSPECTION_END value
	 */
	public void setAnnualInspectionEnd (java.util.Date annualInspectionEnd) {
		this.annualInspectionEnd = annualInspectionEnd;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CardAppinfo)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CardAppinfo cardAppinfo = (cn.com.newcapec.citycard.common.po.CardAppinfo) obj;
			if (null == this.getId() || null == cardAppinfo.getId()) return false;
			else return (this.getId().equals(cardAppinfo.getId()));
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