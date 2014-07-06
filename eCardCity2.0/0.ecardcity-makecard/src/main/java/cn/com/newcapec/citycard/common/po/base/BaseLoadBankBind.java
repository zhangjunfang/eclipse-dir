package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the LOAD_BANK_BIND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="LOAD_BANK_BIND"
 */

public abstract class BaseLoadBankBind  implements Comparable, Serializable {

	public static String REF = "LoadBankBind";
	public static String PROP_BEGIN_DATE = "beginDate";
	public static String PROP_BANK_CARD_NUMBER = "bankCardNumber";
	public static String PROP_SIGN_TYPE = "signType";
	public static String PROP_MIN_MONEY_LOAD = "minMoneyLoad";
	public static String PROP_FUNDS_WAY = "fundsWay";
	public static String PROP_IDENTIFICATION_TYPE = "identificationType";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_NOTES = "notes";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_SIGN_WAY = "signWay";
	public static String PROP_ACCCODE = "acccode";
	public static String PROP_ID = "id";
	public static String PROP_TRADE_MONEY = "tradeMoney";
	public static String PROP_IDENTIFICATION_NUMBER = "identificationNumber";


	// constructors
	public BaseLoadBankBind () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLoadBankBind (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLoadBankBind (
		java.lang.String id,
		java.lang.String acccode,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String signType,
		java.lang.String fundsWay,
		java.lang.String bankCardNumber,
		java.math.BigDecimal tradeMoney,
		java.math.BigDecimal minMoneyLoad,
		java.lang.String identificationType,
		java.lang.String identificationNumber,
		java.lang.String signWay,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setAcccode(acccode);
		this.setCustomerid(customerid);
		this.setAsn(asn);
		this.setSignType(signType);
		this.setFundsWay(fundsWay);
		this.setBankCardNumber(bankCardNumber);
		this.setTradeMoney(tradeMoney);
		this.setMinMoneyLoad(minMoneyLoad);
		this.setIdentificationType(identificationType);
		this.setIdentificationNumber(identificationNumber);
		this.setSignWay(signWay);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String acccode;
	private java.lang.String customerid;
	private java.lang.Integer asn;
	private java.lang.String signType;
	private java.lang.String fundsWay;
	private java.lang.String bankCardNumber;
	private java.math.BigDecimal tradeMoney;
	private java.math.BigDecimal minMoneyLoad;
	private java.util.Date beginDate;
	private java.util.Date endDate;
	private java.lang.String identificationType;
	private java.lang.String identificationNumber;
	private java.lang.String signWay;
	private java.lang.String notes;
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
	 * Return the value associated with the column: SIGN_TYPE
	 */
	public java.lang.String getSignType () {
		return signType;
	}

	/**
	 * Set the value related to the column: SIGN_TYPE
	 * @param signType the SIGN_TYPE value
	 */
	public void setSignType (java.lang.String signType) {
		this.signType = signType;
	}



	/**
	 * Return the value associated with the column: FUNDS_WAY
	 */
	public java.lang.String getFundsWay () {
		return fundsWay;
	}

	/**
	 * Set the value related to the column: FUNDS_WAY
	 * @param fundsWay the FUNDS_WAY value
	 */
	public void setFundsWay (java.lang.String fundsWay) {
		this.fundsWay = fundsWay;
	}



	/**
	 * Return the value associated with the column: BANK_CARD_NUMBER
	 */
	public java.lang.String getBankCardNumber () {
		return bankCardNumber;
	}

	/**
	 * Set the value related to the column: BANK_CARD_NUMBER
	 * @param bankCardNumber the BANK_CARD_NUMBER value
	 */
	public void setBankCardNumber (java.lang.String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}



	/**
	 * Return the value associated with the column: TRADE_MONEY
	 */
	public java.math.BigDecimal getTradeMoney () {
		return tradeMoney;
	}

	/**
	 * Set the value related to the column: TRADE_MONEY
	 * @param tradeMoney the TRADE_MONEY value
	 */
	public void setTradeMoney (java.math.BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}



	/**
	 * Return the value associated with the column: MIN_MONEY_LOAD
	 */
	public java.math.BigDecimal getMinMoneyLoad () {
		return minMoneyLoad;
	}

	/**
	 * Set the value related to the column: MIN_MONEY_LOAD
	 * @param minMoneyLoad the MIN_MONEY_LOAD value
	 */
	public void setMinMoneyLoad (java.math.BigDecimal minMoneyLoad) {
		this.minMoneyLoad = minMoneyLoad;
	}



	/**
	 * Return the value associated with the column: BEGIN_DATE
	 */
	public java.util.Date getBeginDate () {
		return beginDate;
	}

	/**
	 * Set the value related to the column: BEGIN_DATE
	 * @param beginDate the BEGIN_DATE value
	 */
	public void setBeginDate (java.util.Date beginDate) {
		this.beginDate = beginDate;
	}



	/**
	 * Return the value associated with the column: END_DATE
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: END_DATE
	 * @param endDate the END_DATE value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
	}



	/**
	 * Return the value associated with the column: IDENTIFICATION_TYPE
	 */
	public java.lang.String getIdentificationType () {
		return identificationType;
	}

	/**
	 * Set the value related to the column: IDENTIFICATION_TYPE
	 * @param identificationType the IDENTIFICATION_TYPE value
	 */
	public void setIdentificationType (java.lang.String identificationType) {
		this.identificationType = identificationType;
	}



	/**
	 * Return the value associated with the column: IDENTIFICATION_NUMBER
	 */
	public java.lang.String getIdentificationNumber () {
		return identificationNumber;
	}

	/**
	 * Set the value related to the column: IDENTIFICATION_NUMBER
	 * @param identificationNumber the IDENTIFICATION_NUMBER value
	 */
	public void setIdentificationNumber (java.lang.String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}



	/**
	 * Return the value associated with the column: SIGN_WAY
	 */
	public java.lang.String getSignWay () {
		return signWay;
	}

	/**
	 * Set the value related to the column: SIGN_WAY
	 * @param signWay the SIGN_WAY value
	 */
	public void setSignWay (java.lang.String signWay) {
		this.signWay = signWay;
	}



	/**
	 * Return the value associated with the column: NOTES
	 */
	public java.lang.String getNotes () {
		return notes;
	}

	/**
	 * Set the value related to the column: NOTES
	 * @param notes the NOTES value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.LoadBankBind)) return false;
		else {
			cn.com.newcapec.citycard.common.po.LoadBankBind loadBankBind = (cn.com.newcapec.citycard.common.po.LoadBankBind) obj;
			if (null == this.getId() || null == loadBankBind.getId()) return false;
			else return (this.getId().equals(loadBankBind.getId()));
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