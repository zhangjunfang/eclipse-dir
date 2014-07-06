package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_CODE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_CODE"
 */

public abstract class BaseBaseCode  implements Comparable, Serializable {

	public static String REF = "BaseCode";
	public static String PROP_DIR = "dir";
	public static String PROP_ISSHOW = "isshow";
	public static String PROP_ACCCODE = "acccode";
	public static String PROP_ID = "id";
	public static String PROP_SORT_NUM = "sortNum";
	public static String PROP_ACCDSCRP = "accdscrp";
	public static String PROP_GROUP_ID = "groupId";


	// constructors
	public BaseBaseCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseCode (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String groupId;
	private java.lang.String acccode;
	private java.lang.String accdscrp;
	private java.lang.Integer isshow;
	private java.lang.Integer sortNum;
	private java.lang.Integer dir;



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
	 * Return the value associated with the column: GROUP_ID
	 */
	public java.lang.String getGroupId () {
		return groupId;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param groupId the GROUP_ID value
	 */
	public void setGroupId (java.lang.String groupId) {
		this.groupId = groupId;
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
	 * Return the value associated with the column: ACCDSCRP
	 */
	public java.lang.String getAccdscrp () {
		return accdscrp;
	}

	/**
	 * Set the value related to the column: ACCDSCRP
	 * @param accdscrp the ACCDSCRP value
	 */
	public void setAccdscrp (java.lang.String accdscrp) {
		this.accdscrp = accdscrp;
	}



	/**
	 * Return the value associated with the column: ISSHOW
	 */
	public java.lang.Integer getIsshow () {
		return isshow;
	}

	/**
	 * Set the value related to the column: ISSHOW
	 * @param isshow the ISSHOW value
	 */
	public void setIsshow (java.lang.Integer isshow) {
		this.isshow = isshow;
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
	 * Return the value associated with the column: DIR
	 */
	public java.lang.Integer getDir () {
		return dir;
	}

	/**
	 * Set the value related to the column: DIR
	 * @param dir the DIR value
	 */
	public void setDir (java.lang.Integer dir) {
		this.dir = dir;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseCode)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseCode baseCode = (cn.com.newcapec.citycard.common.po.BaseCode) obj;
			if (null == this.getId() || null == baseCode.getId()) return false;
			else return (this.getId().equals(baseCode.getId()));
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