package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the ADDRESS_NET_SITE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ADDRESS_NET_SITE"
 */

public abstract class BaseAddressNetSite  implements Comparable, Serializable {

	public static String REF = "AddressNetSite";
	public static String PROP_PHONE = "phone";
	public static String PROP_NETID_P = "netidP";
	public static String PROP_NETJP = "netjp";
	public static String PROP_FAX = "fax";
	public static String PROP_NETTYPE = "nettype";
	public static String PROP_NETNAME = "netname";
	public static String PROP_LIKEMAN = "likeman";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_NETID = "netid";
	public static String PROP_VER = "ver";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_ADDRESS = "address";
	public static String PROP_NETSTATUS = "netstatus";
	public static String PROP_ID = "id";
	public static String PROP_NETKIND = "netkind";


	// constructors
	public BaseAddressNetSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAddressNetSite (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAddressNetSite (
		java.lang.String id,
		java.lang.String netid,
		java.lang.String netname,
		java.lang.String netstatus,
		java.lang.String nettype,
		java.lang.Integer ver,
		java.lang.String netidP,
		java.lang.String netkind,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setNetid(netid);
		this.setNetname(netname);
		this.setNetstatus(netstatus);
		this.setNettype(nettype);
		this.setVer(ver);
		this.setNetidP(netidP);
		this.setNetkind(netkind);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String netid;
	private java.lang.String netname;
	private java.lang.String netjp;
	private java.lang.String netstatus;
	private java.lang.String nettype;
	private java.lang.String likeman;
	private java.lang.String phone;
	private java.lang.String address;
	private java.lang.String fax;
	private java.lang.Integer ver;
	private java.lang.String netidP;
	private java.lang.String netkind;
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
	 * Return the value associated with the column: NETID
	 */
	public java.lang.String getNetid () {
		return netid;
	}

	/**
	 * Set the value related to the column: NETID
	 * @param netid the NETID value
	 */
	public void setNetid (java.lang.String netid) {
		this.netid = netid;
	}



	/**
	 * Return the value associated with the column: NETNAME
	 */
	public java.lang.String getNetname () {
		return netname;
	}

	/**
	 * Set the value related to the column: NETNAME
	 * @param netname the NETNAME value
	 */
	public void setNetname (java.lang.String netname) {
		this.netname = netname;
	}



	/**
	 * Return the value associated with the column: NETJP
	 */
	public java.lang.String getNetjp () {
		return netjp;
	}

	/**
	 * Set the value related to the column: NETJP
	 * @param netjp the NETJP value
	 */
	public void setNetjp (java.lang.String netjp) {
		this.netjp = netjp;
	}



	/**
	 * Return the value associated with the column: NETSTATUS
	 */
	public java.lang.String getNetstatus () {
		return netstatus;
	}

	/**
	 * Set the value related to the column: NETSTATUS
	 * @param netstatus the NETSTATUS value
	 */
	public void setNetstatus (java.lang.String netstatus) {
		this.netstatus = netstatus;
	}



	/**
	 * Return the value associated with the column: NETTYPE
	 */
	public java.lang.String getNettype () {
		return nettype;
	}

	/**
	 * Set the value related to the column: NETTYPE
	 * @param nettype the NETTYPE value
	 */
	public void setNettype (java.lang.String nettype) {
		this.nettype = nettype;
	}



	/**
	 * Return the value associated with the column: LIKEMAN
	 */
	public java.lang.String getLikeman () {
		return likeman;
	}

	/**
	 * Set the value related to the column: LIKEMAN
	 * @param likeman the LIKEMAN value
	 */
	public void setLikeman (java.lang.String likeman) {
		this.likeman = likeman;
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
	 * Return the value associated with the column: NETID_P
	 */
	public java.lang.String getNetidP () {
		return netidP;
	}

	/**
	 * Set the value related to the column: NETID_P
	 * @param netidP the NETID_P value
	 */
	public void setNetidP (java.lang.String netidP) {
		this.netidP = netidP;
	}



	/**
	 * Return the value associated with the column: NETKIND
	 */
	public java.lang.String getNetkind () {
		return netkind;
	}

	/**
	 * Set the value related to the column: NETKIND
	 * @param netkind the NETKIND value
	 */
	public void setNetkind (java.lang.String netkind) {
		this.netkind = netkind;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.AddressNetSite)) return false;
		else {
			cn.com.newcapec.citycard.common.po.AddressNetSite addressNetSite = (cn.com.newcapec.citycard.common.po.AddressNetSite) obj;
			if (null == this.getId() || null == addressNetSite.getId()) return false;
			else return (this.getId().equals(addressNetSite.getId()));
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