package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CUSTOMER_PHOTO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CUSTOMER_PHOTO"
 */

public abstract class BaseCustomerPhoto  implements Comparable, Serializable {

	public static String REF = "CustomerPhoto";
	public static String PROP_VER = "ver";
	public static String PROP_PHOTOID = "photoid";
	public static String PROP_ID = "id";
	public static String PROP_PHOTO = "photo";
	public static String PROP_CUSTOMERID = "customerid";


	// constructors
	public BaseCustomerPhoto () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomerPhoto (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomerPhoto (
		java.lang.String id,
		java.lang.String customerid,
		java.lang.String photoid,
		byte[] photo) {

		this.setId(id);
		this.setCustomerid(customerid);
		this.setPhotoid(photoid);
		this.setPhoto(photo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String customerid;
	private java.lang.String photoid;
	private byte[] photo;
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
	 * Return the value associated with the column: CUSTOMERID
	 */
	public java.lang.String getCustomerid () {
		return customerid;
	}

	/**
	 * Set the value related to the column: CUSTOMERID
	 * @param customerid the CUSTOMERID value
	 */
	public void setCustomerid (java.lang.String customerid) {
		this.customerid = customerid;
	}



	/**
	 * Return the value associated with the column: PHOTOID
	 */
	public java.lang.String getPhotoid () {
		return photoid;
	}

	/**
	 * Set the value related to the column: PHOTOID
	 * @param photoid the PHOTOID value
	 */
	public void setPhotoid (java.lang.String photoid) {
		this.photoid = photoid;
	}



	/**
	 * Return the value associated with the column: PHOTO
	 */
	public byte[] getPhoto () {
		return photo;
	}

	/**
	 * Set the value related to the column: PHOTO
	 * @param photo the PHOTO value
	 */
	public void setPhoto (byte[] photo) {
		this.photo = photo;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CustomerPhoto)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CustomerPhoto customerPhoto = (cn.com.newcapec.citycard.common.po.CustomerPhoto) obj;
			if (null == this.getId() || null == customerPhoto.getId()) return false;
			else return (this.getId().equals(customerPhoto.getId()));
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