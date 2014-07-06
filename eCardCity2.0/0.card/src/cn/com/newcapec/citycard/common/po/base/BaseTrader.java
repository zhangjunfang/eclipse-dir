package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TRADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TRADER"
 */

public abstract class BaseTrader  implements Comparable, Serializable {

	public static String REF = "Trader";
	public static String PROP_PHONE = "phone";
	public static String PROP_BANKID = "bankid";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_FAX = "fax";
	public static String PROP_MERCHATNTSTATUS = "merchatntstatus";
	public static String PROP_SORT_NUM = "sortNum";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_TRANSACCOUNTID = "transaccountid";
	public static String PROP_ACCOUNTID = "accountid";
	public static String PROP_POSTCODE = "postcode";
	public static String PROP_MERCHANTCODE = "merchantcode";
	public static String PROP_MERCHANTNAME = "merchantname";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_ADDRESS = "address";
	public static String PROP_LINKMAN = "linkman";
	public static String PROP_ID = "id";
	public static String PROP_DPJM = "dpjm";
	public static String PROP_MERCHANTTYPE = "merchanttype";
	public static String PROP_MERCHANT_P = "merchantP";


	// constructors
	public BaseTrader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTrader (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTrader (
		java.lang.String id,
		java.lang.String merchantcode,
		java.lang.String merchantname,
		java.lang.Integer sortNum,
		java.lang.String industrycode,
		java.lang.String accountid,
		java.lang.String merchanttype,
		java.lang.String merchatntstatus,
		java.lang.Integer bankid,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setMerchantcode(merchantcode);
		this.setMerchantname(merchantname);
		this.setSortNum(sortNum);
		this.setIndustrycode(industrycode);
		this.setAccountid(accountid);
		this.setMerchanttype(merchanttype);
		this.setMerchatntstatus(merchatntstatus);
		this.setBankid(bankid);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String merchantcode;
	private java.lang.String merchantname;
	private java.lang.String merchantP;
	private java.lang.Integer sortNum;
	private java.lang.String industrycode;
	private java.lang.String dpjm;
	private java.lang.String accountid;
	private java.lang.String linkman;
	private java.lang.String phone;
	private java.lang.String fax;
	private java.lang.String merchanttype;
	private java.lang.String merchatntstatus;
	private java.lang.String address;
	private java.lang.String postcode;
	private java.lang.Integer bankid;
	private java.lang.String transaccountid;
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
	 * Return the value associated with the column: MERCHANTCODE
	 */
	public java.lang.String getMerchantcode () {
		return merchantcode;
	}

	/**
	 * Set the value related to the column: MERCHANTCODE
	 * @param merchantcode the MERCHANTCODE value
	 */
	public void setMerchantcode (java.lang.String merchantcode) {
		this.merchantcode = merchantcode;
	}



	/**
	 * Return the value associated with the column: MERCHANTNAME
	 */
	public java.lang.String getMerchantname () {
		return merchantname;
	}

	/**
	 * Set the value related to the column: MERCHANTNAME
	 * @param merchantname the MERCHANTNAME value
	 */
	public void setMerchantname (java.lang.String merchantname) {
		this.merchantname = merchantname;
	}



	/**
	 * Return the value associated with the column: MERCHANT_P
	 */
	public java.lang.String getMerchantP () {
		return merchantP;
	}

	/**
	 * Set the value related to the column: MERCHANT_P
	 * @param merchantP the MERCHANT_P value
	 */
	public void setMerchantP (java.lang.String merchantP) {
		this.merchantP = merchantP;
	}



	/**
	 * Return the value associated with the column: SORT_NUM
	 */
	public java.lang.Integer getSortNum () {
		return sortNum;
	}

	/**
	 * Set the value related to the column: SORT_NUM
	 * @param sortNum the SORT_NUM value
	 */
	public void setSortNum (java.lang.Integer sortNum) {
		this.sortNum = sortNum;
	}



	/**
	 * Return the value associated with the column: INDUSTRYCODE
	 */
	public java.lang.String getIndustrycode () {
		return industrycode;
	}

	/**
	 * Set the value related to the column: INDUSTRYCODE
	 * @param industrycode the INDUSTRYCODE value
	 */
	public void setIndustrycode (java.lang.String industrycode) {
		this.industrycode = industrycode;
	}



	/**
	 * Return the value associated with the column: DPJM
	 */
	public java.lang.String getDpjm () {
		return dpjm;
	}

	/**
	 * Set the value related to the column: DPJM
	 * @param dpjm the DPJM value
	 */
	public void setDpjm (java.lang.String dpjm) {
		this.dpjm = dpjm;
	}



	/**
	 * Return the value associated with the column: ACCOUNTID
	 */
	public java.lang.String getAccountid () {
		return accountid;
	}

	/**
	 * Set the value related to the column: ACCOUNTID
	 * @param accountid the ACCOUNTID value
	 */
	public void setAccountid (java.lang.String accountid) {
		this.accountid = accountid;
	}



	/**
	 * Return the value associated with the column: LINKMAN
	 */
	public java.lang.String getLinkman () {
		return linkman;
	}

	/**
	 * Set the value related to the column: LINKMAN
	 * @param linkman the LINKMAN value
	 */
	public void setLinkman (java.lang.String linkman) {
		this.linkman = linkman;
	}



	/**
	 * Return the value associated with the column: PHONE
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: PHONE
	 * @param phone the PHONE value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: FAX
	 */
	public java.lang.String getFax () {
		return fax;
	}

	/**
	 * Set the value related to the column: FAX
	 * @param fax the FAX value
	 */
	public void setFax (java.lang.String fax) {
		this.fax = fax;
	}



	/**
	 * Return the value associated with the column: MERCHANTTYPE
	 */
	public java.lang.String getMerchanttype () {
		return merchanttype;
	}

	/**
	 * Set the value related to the column: MERCHANTTYPE
	 * @param merchanttype the MERCHANTTYPE value
	 */
	public void setMerchanttype (java.lang.String merchanttype) {
		this.merchanttype = merchanttype;
	}



	/**
	 * Return the value associated with the column: MERCHATNTSTATUS
	 */
	public java.lang.String getMerchatntstatus () {
		return merchatntstatus;
	}

	/**
	 * Set the value related to the column: MERCHATNTSTATUS
	 * @param merchatntstatus the MERCHATNTSTATUS value
	 */
	public void setMerchatntstatus (java.lang.String merchatntstatus) {
		this.merchatntstatus = merchatntstatus;
	}



	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: POSTCODE
	 */
	public java.lang.String getPostcode () {
		return postcode;
	}

	/**
	 * Set the value related to the column: POSTCODE
	 * @param postcode the POSTCODE value
	 */
	public void setPostcode (java.lang.String postcode) {
		this.postcode = postcode;
	}



	/**
	 * Return the value associated with the column: BANKID
	 */
	public java.lang.Integer getBankid () {
		return bankid;
	}

	/**
	 * Set the value related to the column: BANKID
	 * @param bankid the BANKID value
	 */
	public void setBankid (java.lang.Integer bankid) {
		this.bankid = bankid;
	}



	/**
	 * Return the value associated with the column: TRANSACCOUNTID
	 */
	public java.lang.String getTransaccountid () {
		return transaccountid;
	}

	/**
	 * Set the value related to the column: TRANSACCOUNTID
	 * @param transaccountid the TRANSACCOUNTID value
	 */
	public void setTransaccountid (java.lang.String transaccountid) {
		this.transaccountid = transaccountid;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.Trader)) return false;
		else {
			cn.com.newcapec.citycard.common.po.Trader trader = (cn.com.newcapec.citycard.common.po.Trader) obj;
			if (null == this.getId() || null == trader.getId()) return false;
			else return (this.getId().equals(trader.getId()));
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