package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the INTERFACE_DATA_EXCHANGE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="INTERFACE_DATA_EXCHANGE"
 */

public abstract class BaseInterfaceDataExchange  implements Comparable, Serializable {

	public static String REF = "InterfaceDataExchange";
	public static String PROP_VER = "ver";
	public static String PROP_TABLENAME = "tablename";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_ID = "id";


	// constructors
	public BaseInterfaceDataExchange () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInterfaceDataExchange (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseInterfaceDataExchange (
		java.lang.String id,
		java.lang.String tablename,
		java.lang.Integer ver,
		java.lang.String industrycode) {

		this.setId(id);
		this.setTablename(tablename);
		this.setVer(ver);
		this.setIndustrycode(industrycode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String tablename;
	private java.lang.Integer ver;
	private java.lang.String industrycode;



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
	 * Return the value associated with the column: TABLENAME
	 */
	public java.lang.String getTablename () {
		return tablename;
	}

	/**
	 * Set the value related to the column: TABLENAME
	 * @param tablename the TABLENAME value
	 */
	public void setTablename (java.lang.String tablename) {
		this.tablename = tablename;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.InterfaceDataExchange)) return false;
		else {
			cn.com.newcapec.citycard.common.po.InterfaceDataExchange interfaceDataExchange = (cn.com.newcapec.citycard.common.po.InterfaceDataExchange) obj;
			if (null == this.getId() || null == interfaceDataExchange.getId()) return false;
			else return (this.getId().equals(interfaceDataExchange.getId()));
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