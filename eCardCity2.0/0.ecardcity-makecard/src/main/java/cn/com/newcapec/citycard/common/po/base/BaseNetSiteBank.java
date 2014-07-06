package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the NET_SITE_BANK table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="NET_SITE_BANK"
 */

public abstract class BaseNetSiteBank  implements Comparable, Serializable {

	public static String REF = "NetSiteBank";
	public static String PROP_BANKNAME = "bankname";
	public static String PROP_NETSITEID = "netsiteid";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_TRANSFER_ACCOUNT = "transferAccount";
	public static String PROP_ID = "id";
	public static String PROP_OPEN_ACCOUNT = "openAccount";
	public static String PROP_EDIT_PERSON = "editPerson";


	// constructors
	public BaseNetSiteBank () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNetSiteBank (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseNetSiteBank (
		java.lang.String id,
		java.lang.String netsiteid,
		java.lang.String bankname,
		java.lang.String openAccount,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setNetsiteid(netsiteid);
		this.setBankname(bankname);
		this.setOpenAccount(openAccount);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String bankname;
	private java.util.Date editDate;
	private java.lang.String editPerson;
	private java.lang.String netsiteid;
	private java.lang.String openAccount;
	private java.lang.String transferAccount;



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
	 * Return the value associated with the column: BANKNAME
	 */
	public java.lang.String getBankname () {
		return bankname;
	}

	/**
	 * Set the value related to the column: BANKNAME
	 * @param bankname the BANKNAME value
	 */
	public void setBankname (java.lang.String bankname) {
		this.bankname = bankname;
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
	 * Return the value associated with the column: NETSITEID
	 */
	public java.lang.String getNetsiteid () {
		return netsiteid;
	}

	/**
	 * Set the value related to the column: NETSITEID
	 * @param netsiteid the NETSITEID value
	 */
	public void setNetsiteid (java.lang.String netsiteid) {
		this.netsiteid = netsiteid;
	}



	/**
	 * Return the value associated with the column: OPEN_ACCOUNT
	 */
	public java.lang.String getOpenAccount () {
		return openAccount;
	}

	/**
	 * Set the value related to the column: OPEN_ACCOUNT
	 * @param openAccount the OPEN_ACCOUNT value
	 */
	public void setOpenAccount (java.lang.String openAccount) {
		this.openAccount = openAccount;
	}



	/**
	 * Return the value associated with the column: TRANSFER_ACCOUNT
	 */
	public java.lang.String getTransferAccount () {
		return transferAccount;
	}

	/**
	 * Set the value related to the column: TRANSFER_ACCOUNT
	 * @param transferAccount the TRANSFER_ACCOUNT value
	 */
	public void setTransferAccount (java.lang.String transferAccount) {
		this.transferAccount = transferAccount;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.NetSiteBank)) return false;
		else {
			cn.com.newcapec.citycard.common.po.NetSiteBank netSiteBank = (cn.com.newcapec.citycard.common.po.NetSiteBank) obj;
			if (null == this.getId() || null == netSiteBank.getId()) return false;
			else return (this.getId().equals(netSiteBank.getId()));
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