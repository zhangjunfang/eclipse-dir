package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the SYSTEM_BLACK table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYSTEM_BLACK"
 */

public abstract class BaseSystemBlack  implements Comparable, Serializable {

	public static String REF = "SystemBlack";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_LOSSCOUNT = "losscount";
	public static String PROP_STATE = "state";
	public static String PROP_NOUSEDATE = "nousedate";
	public static String PROP_SOURCETYPE = "sourcetype";
	public static String PROP_SN = "sn";
	public static String PROP_ID = "id";
	public static String PROP_SUORCEIP = "suorceip";
	public static String PROP_ASN = "asn";
	public static String PROP_EDIT_PERSON = "editPerson";


	// constructors
	public BaseSystemBlack () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystemBlack (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer sn;
	private java.lang.Integer asn;
	private java.lang.String state;
	private java.util.Date nousedate;
	private java.lang.String sourcetype;
	private java.lang.String suorceip;
	private java.util.Date losscount;
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
	 * Return the value associated with the column: SN
	 */
	public java.lang.Integer getSn () {
		return sn;
	}

	/**
	 * Set the value related to the column: SN
	 * @param sn the SN value
	 */
	public void setSn (java.lang.Integer sn) {
		this.sn = sn;
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
	 * Return the value associated with the column: STATE
	 */
	public java.lang.String getState () {
		return state;
	}

	/**
	 * Set the value related to the column: STATE
	 * @param state the STATE value
	 */
	public void setState (java.lang.String state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: NOUSEDATE
	 */
	public java.util.Date getNousedate () {
		return nousedate;
	}

	/**
	 * Set the value related to the column: NOUSEDATE
	 * @param nousedate the NOUSEDATE value
	 */
	public void setNousedate (java.util.Date nousedate) {
		this.nousedate = nousedate;
	}



	/**
	 * Return the value associated with the column: SOURCETYPE
	 */
	public java.lang.String getSourcetype () {
		return sourcetype;
	}

	/**
	 * Set the value related to the column: SOURCETYPE
	 * @param sourcetype the SOURCETYPE value
	 */
	public void setSourcetype (java.lang.String sourcetype) {
		this.sourcetype = sourcetype;
	}



	/**
	 * Return the value associated with the column: SUORCEIP
	 */
	public java.lang.String getSuorceip () {
		return suorceip;
	}

	/**
	 * Set the value related to the column: SUORCEIP
	 * @param suorceip the SUORCEIP value
	 */
	public void setSuorceip (java.lang.String suorceip) {
		this.suorceip = suorceip;
	}



	/**
	 * Return the value associated with the column: LOSSCOUNT
	 */
	public java.util.Date getLosscount () {
		return losscount;
	}

	/**
	 * Set the value related to the column: LOSSCOUNT
	 * @param losscount the LOSSCOUNT value
	 */
	public void setLosscount (java.util.Date losscount) {
		this.losscount = losscount;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.SystemBlack)) return false;
		else {
			cn.com.newcapec.citycard.common.po.SystemBlack systemBlack = (cn.com.newcapec.citycard.common.po.SystemBlack) obj;
			if (null == this.getId() || null == systemBlack.getId()) return false;
			else return (this.getId().equals(systemBlack.getId()));
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