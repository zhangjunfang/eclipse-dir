package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the LOAD_REQUEST table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="LOAD_REQUEST"
 */

public abstract class BaseLoadRequest  implements Comparable, Serializable {

	public static String REF = "LoadRequest";
	public static String PROP_STATUS = "status";
	public static String PROP_BANKCARDNO = "bankcardno";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_BANKRECNO = "bankrecno";
	public static String PROP_SIGN_TYPE = "signType";
	public static String PROP_ACCCODE = "acccode";
	public static String PROP_FUNDS_WAY = "fundsWay";
	public static String PROP_ID = "id";
	public static String PROP_OPFARE = "opfare";
	public static String PROP_ASN = "asn";
	public static String PROP_CUSTOMERID = "customerid";


	// constructors
	public BaseLoadRequest () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLoadRequest (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLoadRequest (
		java.lang.String id,
		java.lang.Integer bankrecno,
		java.lang.String customerid,
		java.lang.Integer asn,
		java.lang.String fundsWay,
		java.lang.String bankcardno,
		java.math.BigDecimal opfare,
		java.lang.String acccode,
		java.lang.String signType,
		java.util.Date editDate) {

		this.setId(id);
		this.setBankrecno(bankrecno);
		this.setCustomerid(customerid);
		this.setAsn(asn);
		this.setFundsWay(fundsWay);
		this.setBankcardno(bankcardno);
		this.setOpfare(opfare);
		this.setAcccode(acccode);
		this.setSignType(signType);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer bankrecno;
	private java.lang.String customerid;
	private java.lang.Integer asn;
	private java.lang.String fundsWay;
	private java.lang.String bankcardno;
	private java.math.BigDecimal opfare;
	private java.lang.String acccode;
	private java.lang.String signType;
	private java.lang.String status;
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
	 * Return the value associated with the column: BANKRECNO
	 */
	public java.lang.Integer getBankrecno () {
		return bankrecno;
	}

	/**
	 * Set the value related to the column: BANKRECNO
	 * @param bankrecno the BANKRECNO value
	 */
	public void setBankrecno (java.lang.Integer bankrecno) {
		this.bankrecno = bankrecno;
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
	 * Return the value associated with the column: BANKCARDNO
	 */
	public java.lang.String getBankcardno () {
		return bankcardno;
	}

	/**
	 * Set the value related to the column: BANKCARDNO
	 * @param bankcardno the BANKCARDNO value
	 */
	public void setBankcardno (java.lang.String bankcardno) {
		this.bankcardno = bankcardno;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.LoadRequest)) return false;
		else {
			cn.com.newcapec.citycard.common.po.LoadRequest loadRequest = (cn.com.newcapec.citycard.common.po.LoadRequest) obj;
			if (null == this.getId() || null == loadRequest.getId()) return false;
			else return (this.getId().equals(loadRequest.getId()));
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