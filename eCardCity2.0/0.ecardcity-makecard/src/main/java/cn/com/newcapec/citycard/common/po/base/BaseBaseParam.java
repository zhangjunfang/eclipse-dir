package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_PARAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_PARAM"
 */

public abstract class BaseBaseParam  implements Comparable, Serializable {

	public static String REF = "BaseParam";
	public static String PROP_P_CODE = "pCode";
	public static String PROP_P_DESC = "pDesc";
	public static String PROP_P_VALUE_TYPE = "pValueType";
	public static String PROP_TITLE_NAME = "titleName";
	public static String PROP_CARDTYPE = "cardtype";
	public static String PROP_P_GROUP = "pGroup";
	public static String PROP_P_VALUE = "pValue";
	public static String PROP_SORT_NUM = "sortNum";
	public static String PROP_P_NAME = "pName";
	public static String PROP_NOTES = "notes";
	public static String PROP_VER = "ver";
	public static String PROP_ALLOW_EDIT = "allowEdit";
	public static String PROP_ALLOW_VISIBLE = "allowVisible";
	public static String PROP_ID = "id";


	// constructors
	public BaseBaseParam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseParam (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String cardtype;
	private java.lang.String pGroup;
	private java.lang.String pName;
	private java.lang.String pValue;
	private java.lang.String pValueType;
	private java.lang.String pCode;
	private java.lang.String titleName;
	private java.lang.String pDesc;
	private java.lang.String allowEdit;
	private java.lang.String allowVisible;
	private java.lang.Integer sortNum;
	private java.lang.String notes;
	private java.lang.Integer ver;



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
	 * Return the value associated with the column: CARDTYPE
	 */
	public java.lang.String getCardtype () {
		return cardtype;
	}

	/**
	 * Set the value related to the column: CARDTYPE
	 * @param cardtype the CARDTYPE value
	 */
	public void setCardtype (java.lang.String cardtype) {
		this.cardtype = cardtype;
	}



	/**
	 * Return the value associated with the column: P_GROUP
	 */
	public java.lang.String getPGroup () {
		return pGroup;
	}

	/**
	 * Set the value related to the column: P_GROUP
	 * @param pGroup the P_GROUP value
	 */
	public void setPGroup (java.lang.String pGroup) {
		this.pGroup = pGroup;
	}



	/**
	 * Return the value associated with the column: P_NAME
	 */
	public java.lang.String getPName () {
		return pName;
	}

	/**
	 * Set the value related to the column: P_NAME
	 * @param pName the P_NAME value
	 */
	public void setPName (java.lang.String pName) {
		this.pName = pName;
	}



	/**
	 * Return the value associated with the column: P_VALUE
	 */
	public java.lang.String getPValue () {
		return pValue;
	}

	/**
	 * Set the value related to the column: P_VALUE
	 * @param pValue the P_VALUE value
	 */
	public void setPValue (java.lang.String pValue) {
		this.pValue = pValue;
	}



	/**
	 * Return the value associated with the column: P_VALUE_TYPE
	 */
	public java.lang.String getPValueType () {
		return pValueType;
	}

	/**
	 * Set the value related to the column: P_VALUE_TYPE
	 * @param pValueType the P_VALUE_TYPE value
	 */
	public void setPValueType (java.lang.String pValueType) {
		this.pValueType = pValueType;
	}



	/**
	 * Return the value associated with the column: P_CODE
	 */
	public java.lang.String getPCode () {
		return pCode;
	}

	/**
	 * Set the value related to the column: P_CODE
	 * @param pCode the P_CODE value
	 */
	public void setPCode (java.lang.String pCode) {
		this.pCode = pCode;
	}



	/**
	 * Return the value associated with the column: TITLE_NAME
	 */
	public java.lang.String getTitleName () {
		return titleName;
	}

	/**
	 * Set the value related to the column: TITLE_NAME
	 * @param titleName the TITLE_NAME value
	 */
	public void setTitleName (java.lang.String titleName) {
		this.titleName = titleName;
	}



	/**
	 * Return the value associated with the column: P_DESC
	 */
	public java.lang.String getPDesc () {
		return pDesc;
	}

	/**
	 * Set the value related to the column: P_DESC
	 * @param pDesc the P_DESC value
	 */
	public void setPDesc (java.lang.String pDesc) {
		this.pDesc = pDesc;
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
	 * Return the value associated with the column: ALLOW_VISIBLE
	 */
	public java.lang.String getAllowVisible () {
		return allowVisible;
	}

	/**
	 * Set the value related to the column: ALLOW_VISIBLE
	 * @param allowVisible the ALLOW_VISIBLE value
	 */
	public void setAllowVisible (java.lang.String allowVisible) {
		this.allowVisible = allowVisible;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseParam)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseParam baseParam = (cn.com.newcapec.citycard.common.po.BaseParam) obj;
			if (null == this.getId() || null == baseParam.getId()) return false;
			else return (this.getId().equals(baseParam.getId()));
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