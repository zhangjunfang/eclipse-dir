package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_DICT_CATEGORY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_DICT_CATEGORY"
 */

public abstract class BaseBaseDictCategory  implements Comparable, Serializable {

	public static String REF = "BaseDictCategory";
	public static String PROP_NOTES = "notes";
	public static String PROP_ALLOW_EDIT = "allowEdit";
	public static String PROP_C_NAME = "cName";
	public static String PROP_C_TYPE = "cType";
	public static String PROP_ALLOW_MEMORY = "allowMemory";
	public static String PROP_ID = "id";
	public static String PROP_SORT_NUM = "sortNum";
	public static String PROP_VERSION = "version";
	public static String PROP_C_CODE = "cCode";


	// constructors
	public BaseBaseDictCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseDictCategory (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String cCode;
	private java.lang.String cName;
	private java.lang.String cType;
	private java.lang.String allowEdit;
	private java.lang.String allowMemory;
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
	 * Return the value associated with the column: C_NAME
	 */
	public java.lang.String getCName () {
		return cName;
	}

	/**
	 * Set the value related to the column: C_NAME
	 * @param cName the C_NAME value
	 */
	public void setCName (java.lang.String cName) {
		this.cName = cName;
	}



	/**
	 * Return the value associated with the column: C_TYPE
	 */
	public java.lang.String getCType () {
		return cType;
	}

	/**
	 * Set the value related to the column: C_TYPE
	 * @param cType the C_TYPE value
	 */
	public void setCType (java.lang.String cType) {
		this.cType = cType;
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
	 * Return the value associated with the column: ALLOW_MEMORY
	 */
	public java.lang.String getAllowMemory () {
		return allowMemory;
	}

	/**
	 * Set the value related to the column: ALLOW_MEMORY
	 * @param allowMemory the ALLOW_MEMORY value
	 */
	public void setAllowMemory (java.lang.String allowMemory) {
		this.allowMemory = allowMemory;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseDictCategory)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseDictCategory baseDictCategory = (cn.com.newcapec.citycard.common.po.BaseDictCategory) obj;
			if (null == this.getId() || null == baseDictCategory.getId()) return false;
			else return (this.getId().equals(baseDictCategory.getId()));
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