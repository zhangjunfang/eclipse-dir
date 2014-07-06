package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TRADER_CLEARING_RATE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TRADER_CLEARING_RATE"
 */

public abstract class BaseTraderClearingRate  implements Comparable, Serializable {

	public static String REF = "TraderClearingRate";
	public static String PROP_TRANSFERRATESOFBANK = "transferratesofbank";
	public static String PROP_MERCHANTCODE = "merchantcode";
	public static String PROP_FLAG = "flag";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_CURRENCYRATES = "currencyrates";
	public static String PROP_ID = "id";
	public static String PROP_FEEPERSALE = "feepersale";
	public static String PROP_EDIT_PERSON = "editPerson";


	// constructors
	public BaseTraderClearingRate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTraderClearingRate (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTraderClearingRate (
		java.lang.String id,
		java.lang.String merchantcode,
		java.math.BigDecimal feepersale,
		java.math.BigDecimal currencyrates,
		java.math.BigDecimal transferratesofbank,
		java.lang.String flag,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setMerchantcode(merchantcode);
		this.setFeepersale(feepersale);
		this.setCurrencyrates(currencyrates);
		this.setTransferratesofbank(transferratesofbank);
		this.setFlag(flag);
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
	private java.math.BigDecimal feepersale;
	private java.math.BigDecimal currencyrates;
	private java.math.BigDecimal transferratesofbank;
	private java.lang.String flag;
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
	 * Return the value associated with the column: FEEPERSALE
	 */
	public java.math.BigDecimal getFeepersale () {
		return feepersale;
	}

	/**
	 * Set the value related to the column: FEEPERSALE
	 * @param feepersale the FEEPERSALE value
	 */
	public void setFeepersale (java.math.BigDecimal feepersale) {
		this.feepersale = feepersale;
	}



	/**
	 * Return the value associated with the column: CURRENCYRATES
	 */
	public java.math.BigDecimal getCurrencyrates () {
		return currencyrates;
	}

	/**
	 * Set the value related to the column: CURRENCYRATES
	 * @param currencyrates the CURRENCYRATES value
	 */
	public void setCurrencyrates (java.math.BigDecimal currencyrates) {
		this.currencyrates = currencyrates;
	}



	/**
	 * Return the value associated with the column: TRANSFERRATESOFBANK
	 */
	public java.math.BigDecimal getTransferratesofbank () {
		return transferratesofbank;
	}

	/**
	 * Set the value related to the column: TRANSFERRATESOFBANK
	 * @param transferratesofbank the TRANSFERRATESOFBANK value
	 */
	public void setTransferratesofbank (java.math.BigDecimal transferratesofbank) {
		this.transferratesofbank = transferratesofbank;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TraderClearingRate)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TraderClearingRate traderClearingRate = (cn.com.newcapec.citycard.common.po.TraderClearingRate) obj;
			if (null == this.getId() || null == traderClearingRate.getId()) return false;
			else return (this.getId().equals(traderClearingRate.getId()));
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