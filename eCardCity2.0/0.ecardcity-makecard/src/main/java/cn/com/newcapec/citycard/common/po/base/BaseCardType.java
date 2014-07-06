package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CARD_TYPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CARD_TYPE"
 */

public abstract class BaseCardType  implements Comparable, Serializable {

	public static String REF = "CardType";
	public static String PROP_VER = "ver";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_GROUPID = "groupid";
	public static String PROP_ID = "id";
	public static String PROP_PARAMGROUPID = "paramgroupid";
	public static String PROP_CARDTYPENAME = "cardtypename";
	public static String PROP_SORTID = "sortid";


	// constructors
	public BaseCardType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCardType (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCardType (
		java.lang.String id,
		java.lang.String groupid,
		java.lang.String cardtypename,
		java.lang.Integer ver,
		java.lang.String paramgroupid) {

		this.setId(id);
		this.setGroupid(groupid);
		this.setCardtypename(cardtypename);
		this.setVer(ver);
		this.setParamgroupid(paramgroupid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String groupid;
	private java.lang.String cardtypename;
	private java.lang.Integer sortid;
	private java.lang.Integer ver;
	private java.lang.String paramgroupid;
	private java.lang.String description;



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
	 * Return the value associated with the column: GROUPID
	 */
	public java.lang.String getGroupid () {
		return groupid;
	}

	/**
	 * Set the value related to the column: GROUPID
	 * @param groupid the GROUPID value
	 */
	public void setGroupid (java.lang.String groupid) {
		this.groupid = groupid;
	}



	/**
	 * Return the value associated with the column: CARDTYPENAME
	 */
	public java.lang.String getCardtypename () {
		return cardtypename;
	}

	/**
	 * Set the value related to the column: CARDTYPENAME
	 * @param cardtypename the CARDTYPENAME value
	 */
	public void setCardtypename (java.lang.String cardtypename) {
		this.cardtypename = cardtypename;
	}



	/**
	 * Return the value associated with the column: SORTID
	 */
	public java.lang.Integer getSortid () {
		return sortid;
	}

	/**
	 * Set the value related to the column: SORTID
	 * @param sortid the SORTID value
	 */
	public void setSortid (java.lang.Integer sortid) {
		this.sortid = sortid;
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
	 * Return the value associated with the column: PARAMGROUPID
	 */
	public java.lang.String getParamgroupid () {
		return paramgroupid;
	}

	/**
	 * Set the value related to the column: PARAMGROUPID
	 * @param paramgroupid the PARAMGROUPID value
	 */
	public void setParamgroupid (java.lang.String paramgroupid) {
		this.paramgroupid = paramgroupid;
	}



	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CardType)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CardType cardType = (cn.com.newcapec.citycard.common.po.CardType) obj;
			if (null == this.getId() || null == cardType.getId()) return false;
			else return (this.getId().equals(cardType.getId()));
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