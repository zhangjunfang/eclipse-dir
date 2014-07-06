package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_INDUSTRY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_INDUSTRY"
 */

public abstract class BaseBaseIndustry  implements Comparable, Serializable {

	public static String REF = "BaseIndustry";
	public static String PROP_JPDM = "jpdm";
	public static String PROP_ISSHOW = "isshow";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_INDUSTRY_P = "industryP";
	public static String PROP_INDUSTRYNAME = "industryname";
	public static String PROP_ACCCODE = "acccode";
	public static String PROP_RESERVED = "reserved";
	public static String PROP_INDUSTRYGRADE = "industrygrade";
	public static String PROP_ID = "id";


	// constructors
	public BaseBaseIndustry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseIndustry (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String industrycode;
	private java.lang.String industryname;
	private java.lang.String jpdm;
	private java.lang.String industrygrade;
	private java.lang.String industryP;
	private java.lang.String reserved;
	private java.lang.String acccode;
	private java.lang.String isshow;



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
	 * Return the value associated with the column: INDUSTRYCODE
	 */
	public java.lang.String getIndustrycode () {
		return industrycode;
	}

	/**
	 * Set the value related to the column: INDUSTRYCODE
	 * @param industrycode the INDUSTRYCODE value
	 */
	public void setIndustrycode (java.lang.String industrycode) {
		this.industrycode = industrycode;
	}



	/**
	 * Return the value associated with the column: INDUSTRYNAME
	 */
	public java.lang.String getIndustryname () {
		return industryname;
	}

	/**
	 * Set the value related to the column: INDUSTRYNAME
	 * @param industryname the INDUSTRYNAME value
	 */
	public void setIndustryname (java.lang.String industryname) {
		this.industryname = industryname;
	}



	/**
	 * Return the value associated with the column: JPDM
	 */
	public java.lang.String getJpdm () {
		return jpdm;
	}

	/**
	 * Set the value related to the column: JPDM
	 * @param jpdm the JPDM value
	 */
	public void setJpdm (java.lang.String jpdm) {
		this.jpdm = jpdm;
	}



	/**
	 * Return the value associated with the column: INDUSTRYGRADE
	 */
	public java.lang.String getIndustrygrade () {
		return industrygrade;
	}

	/**
	 * Set the value related to the column: INDUSTRYGRADE
	 * @param industrygrade the INDUSTRYGRADE value
	 */
	public void setIndustrygrade (java.lang.String industrygrade) {
		this.industrygrade = industrygrade;
	}



	/**
	 * Return the value associated with the column: INDUSTRY_P
	 */
	public java.lang.String getIndustryP () {
		return industryP;
	}

	/**
	 * Set the value related to the column: INDUSTRY_P
	 * @param industryP the INDUSTRY_P value
	 */
	public void setIndustryP (java.lang.String industryP) {
		this.industryP = industryP;
	}



	/**
	 * Return the value associated with the column: RESERVED
	 */
	public java.lang.String getReserved () {
		return reserved;
	}

	/**
	 * Set the value related to the column: RESERVED
	 * @param reserved the RESERVED value
	 */
	public void setReserved (java.lang.String reserved) {
		this.reserved = reserved;
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
	 * Return the value associated with the column: ISSHOW
	 */
	public java.lang.String getIsshow () {
		return isshow;
	}

	/**
	 * Set the value related to the column: ISSHOW
	 * @param isshow the ISSHOW value
	 */
	public void setIsshow (java.lang.String isshow) {
		this.isshow = isshow;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseIndustry)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseIndustry baseIndustry = (cn.com.newcapec.citycard.common.po.BaseIndustry) obj;
			if (null == this.getId() || null == baseIndustry.getId()) return false;
			else return (this.getId().equals(baseIndustry.getId()));
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