package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_DICT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_DICT"
 */

public abstract class BaseBaseDict  implements Comparable, Serializable {

	public static String REF = "BaseDict";
	public static String PROP_D_DESC4 = "dDesc4";
	public static String PROP_D_DESC3 = "dDesc3";
	public static String PROP_D_DESC2 = "dDesc2";
	public static String PROP_D_DESC1 = "dDesc1";
	public static String PROP_D_CODE = "dCode";
	public static String PROP_SORT_NUM = "sortNum";
	public static String PROP_NOTES = "notes";
	public static String PROP_STATUS = "status";
	public static String PROP_ALLOW_EDIT = "allowEdit";
	public static String PROP_ID = "id";
	public static String PROP_C_CODE = "cCode";
	public static String PROP_D_DESC5 = "dDesc5";
	public static String PROP_VERSION = "version";


	// constructors
	public BaseBaseDict () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseDict (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String cCode;
	private java.lang.String dCode;
	private java.lang.String dDesc1;
	private java.lang.String dDesc2;
	private java.lang.String dDesc3;
	private java.lang.String dDesc4;
	private java.lang.String dDesc5;
	private java.lang.String status;
	private java.lang.String allowEdit;
	private java.lang.Integer sortNum;
	private java.lang.String notes;
	private java.lang.Integer version;



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
	 * Return the value associated with the column: C_CODE
	 */
	public java.lang.String getCCode () {
		return cCode;
	}

	/**
	 * Set the value related to the column: C_CODE
	 * @param cCode the C_CODE value
	 */
	public void setCCode (java.lang.String cCode) {
		this.cCode = cCode;
	}



	/**
	 * Return the value associated with the column: D_CODE
	 */
	public java.lang.String getDCode () {
		return dCode;
	}

	/**
	 * Set the value related to the column: D_CODE
	 * @param dCode the D_CODE value
	 */
	public void setDCode (java.lang.String dCode) {
		this.dCode = dCode;
	}



	/**
	 * Return the value associated with the column: D_DESC1
	 */
	public java.lang.String getDDesc1 () {
		return dDesc1;
	}

	/**
	 * Set the value related to the column: D_DESC1
	 * @param dDesc1 the D_DESC1 value
	 */
	public void setDDesc1 (java.lang.String dDesc1) {
		this.dDesc1 = dDesc1;
	}



	/**
	 * Return the value associated with the column: D_DESC2
	 */
	public java.lang.String getDDesc2 () {
		return dDesc2;
	}

	/**
	 * Set the value related to the column: D_DESC2
	 * @param dDesc2 the D_DESC2 value
	 */
	public void setDDesc2 (java.lang.String dDesc2) {
		this.dDesc2 = dDesc2;
	}



	/**
	 * Return the value associated with the column: D_DESC3
	 */
	public java.lang.String getDDesc3 () {
		return dDesc3;
	}

	/**
	 * Set the value related to the column: D_DESC3
	 * @param dDesc3 the D_DESC3 value
	 */
	public void setDDesc3 (java.lang.String dDesc3) {
		this.dDesc3 = dDesc3;
	}



	/**
	 * Return the value associated with the column: D_DESC4
	 */
	public java.lang.String getDDesc4 () {
		return dDesc4;
	}

	/**
	 * Set the value related to the column: D_DESC4
	 * @param dDesc4 the D_DESC4 value
	 */
	public void setDDesc4 (java.lang.String dDesc4) {
		this.dDesc4 = dDesc4;
	}



	/**
	 * Return the value associated with the column: D_DESC5
	 */
	public java.lang.String getDDesc5 () {
		return dDesc5;
	}

	/**
	 * Set the value related to the column: D_DESC5
	 * @param dDesc5 the D_DESC5 value
	 */
	public void setDDesc5 (java.lang.String dDesc5) {
		this.dDesc5 = dDesc5;
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
	 * Return the value associated with the column: ALLOW_EDIT
	 */
	public java.lang.String getAllowEdit () {
		return allowEdit;
	}

	/**
	 * Set the value related to the column: ALLOW_EDIT
	 * @param allowEdit the ALLOW_EDIT value
	 */
	public void setAllowEdit (java.lang.String allowEdit) {
		this.allowEdit = allowEdit;
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
	 * Return the value associated with the column: VERSION
	 */
	public java.lang.Integer getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: VERSION
	 * @param version the VERSION value
	 */
	public void setVersion (java.lang.Integer version) {
		this.version = version;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseDict)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseDict baseDict = (cn.com.newcapec.citycard.common.po.BaseDict) obj;
			if (null == this.getId() || null == baseDict.getId()) return false;
			else return (this.getId().equals(baseDict.getId()));
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