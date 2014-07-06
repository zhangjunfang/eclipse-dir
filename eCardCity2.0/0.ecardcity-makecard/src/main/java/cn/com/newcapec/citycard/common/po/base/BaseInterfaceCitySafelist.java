package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the INTERFACE_CITY_SAFELIST table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="INTERFACE_CITY_SAFELIST"
 */

public abstract class BaseInterfaceCitySafelist  implements Comparable, Serializable {

	public static String REF = "InterfaceCitySafelist";
	public static String PROP_CITYNAME = "cityname";
	public static String PROP_CITYCODE = "citycode";
	public static String PROP_ID = "id";
	public static String PROP_FILENAME = "filename";


	// constructors
	public BaseInterfaceCitySafelist () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInterfaceCitySafelist (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String filename;
	private java.lang.String citycode;
	private java.lang.String cityname;



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
	 * Return the value associated with the column: FILENAME
	 */
	public java.lang.String getFilename () {
		return filename;
	}

	/**
	 * Set the value related to the column: FILENAME
	 * @param filename the FILENAME value
	 */
	public void setFilename (java.lang.String filename) {
		this.filename = filename;
	}



	/**
	 * Return the value associated with the column: CITYCODE
	 */
	public java.lang.String getCitycode () {
		return citycode;
	}

	/**
	 * Set the value related to the column: CITYCODE
	 * @param citycode the CITYCODE value
	 */
	public void setCitycode (java.lang.String citycode) {
		this.citycode = citycode;
	}



	/**
	 * Return the value associated with the column: CITYNAME
	 */
	public java.lang.String getCityname () {
		return cityname;
	}

	/**
	 * Set the value related to the column: CITYNAME
	 * @param cityname the CITYNAME value
	 */
	public void setCityname (java.lang.String cityname) {
		this.cityname = cityname;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.InterfaceCitySafelist)) return false;
		else {
			cn.com.newcapec.citycard.common.po.InterfaceCitySafelist interfaceCitySafelist = (cn.com.newcapec.citycard.common.po.InterfaceCitySafelist) obj;
			if (null == this.getId() || null == interfaceCitySafelist.getId()) return false;
			else return (this.getId().equals(interfaceCitySafelist.getId()));
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