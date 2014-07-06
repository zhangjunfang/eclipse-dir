package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the ADDRESS_COLLECT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ADDRESS_COLLECT"
 */

public abstract class BaseAddressCollect  implements Comparable, Serializable {

	public static String REF = "AddressCollect";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_COLLECTID = "collectid";
	public static String PROP_ADDRESS = "address";
	public static String PROP_COLLECTJP = "collectjp";
	public static String PROP_ID = "id";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_COLLECTTYPE = "collecttype";
	public static String PROP_COLLECTSTATUS = "collectstatus";
	public static String PROP_COLLECTNAME = "collectname";


	// constructors
	public BaseAddressCollect () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAddressCollect (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAddressCollect (
		java.lang.String id,
		java.lang.String collectid,
		java.lang.String collectname,
		java.lang.String collectstatus,
		java.lang.String collecttype,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setCollectid(collectid);
		this.setCollectname(collectname);
		this.setCollectstatus(collectstatus);
		this.setCollecttype(collecttype);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String collectid;
	private java.lang.String collectname;
	private java.lang.String collectjp;
	private java.lang.String collectstatus;
	private java.lang.String collecttype;
	private java.lang.String address;
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
	 * Return the value associated with the column: COLLECTID
	 */
	public java.lang.String getCollectid () {
		return collectid;
	}

	/**
	 * Set the value related to the column: COLLECTID
	 * @param collectid the COLLECTID value
	 */
	public void setCollectid (java.lang.String collectid) {
		this.collectid = collectid;
	}



	/**
	 * Return the value associated with the column: COLLECTNAME
	 */
	public java.lang.String getCollectname () {
		return collectname;
	}

	/**
	 * Set the value related to the column: COLLECTNAME
	 * @param collectname the COLLECTNAME value
	 */
	public void setCollectname (java.lang.String collectname) {
		this.collectname = collectname;
	}



	/**
	 * Return the value associated with the column: COLLECTJP
	 */
	public java.lang.String getCollectjp () {
		return collectjp;
	}

	/**
	 * Set the value related to the column: COLLECTJP
	 * @param collectjp the COLLECTJP value
	 */
	public void setCollectjp (java.lang.String collectjp) {
		this.collectjp = collectjp;
	}



	/**
	 * Return the value associated with the column: COLLECTSTATUS
	 */
	public java.lang.String getCollectstatus () {
		return collectstatus;
	}

	/**
	 * Set the value related to the column: COLLECTSTATUS
	 * @param collectstatus the COLLECTSTATUS value
	 */
	public void setCollectstatus (java.lang.String collectstatus) {
		this.collectstatus = collectstatus;
	}



	/**
	 * Return the value associated with the column: COLLECTTYPE
	 */
	public java.lang.String getCollecttype () {
		return collecttype;
	}

	/**
	 * Set the value related to the column: COLLECTTYPE
	 * @param collecttype the COLLECTTYPE value
	 */
	public void setCollecttype (java.lang.String collecttype) {
		this.collecttype = collecttype;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.AddressCollect)) return false;
		else {
			cn.com.newcapec.citycard.common.po.AddressCollect addressCollect = (cn.com.newcapec.citycard.common.po.AddressCollect) obj;
			if (null == this.getId() || null == addressCollect.getId()) return false;
			else return (this.getId().equals(addressCollect.getId()));
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