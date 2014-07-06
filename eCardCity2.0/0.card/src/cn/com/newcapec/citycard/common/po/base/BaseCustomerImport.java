package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CUSTOMER_IMPORT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CUSTOMER_IMPORT"
 */

public abstract class BaseCustomerImport  implements Comparable, Serializable {

	public static String REF = "CustomerImport";
	public static String PROP_FLAG = "flag";
	public static String PROP_TELEPHONE = "telephone";
	public static String PROP_COUNTRY = "country";
	public static String PROP_IMPORTDATE = "importdate";
	public static String PROP_NAME = "name";
	public static String PROP_JPDM = "jpdm";
	public static String PROP_VER = "ver";
	public static String PROP_IDCARDNO = "idcardno";
	public static String PROP_EMAIL = "email";
	public static String PROP_NATION = "nation";
	public static String PROP_ADDRESS = "address";
	public static String PROP_CERTIFICATEID = "certificateid";
	public static String PROP_ID = "id";
	public static String PROP_SEX = "sex";


	// constructors
	public BaseCustomerImport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomerImport (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomerImport (
		java.lang.Integer id,
		java.util.Date importdate,
		java.lang.Integer sex,
		java.lang.String name,
		java.lang.String idcardno) {

		this.setId(id);
		this.setImportdate(importdate);
		this.setSex(sex);
		this.setName(name);
		this.setIdcardno(idcardno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date importdate;
	private java.lang.Integer sex;
	private java.lang.String name;
	private java.lang.String nation;
	private java.lang.Integer certificateid;
	private java.lang.String idcardno;
	private java.lang.String country;
	private java.lang.String jpdm;
	private java.lang.Integer ver;
	private java.lang.String address;
	private java.lang.String email;
	private java.lang.String telephone;
	private java.lang.String flag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: IMPORTDATE
	 */
	public java.util.Date getImportdate () {
		return importdate;
	}

	/**
	 * Set the value related to the column: IMPORTDATE
	 * @param importdate the IMPORTDATE value
	 */
	public void setImportdate (java.util.Date importdate) {
		this.importdate = importdate;
	}



	/**
	 * Return the value associated with the column: SEX
	 */
	public java.lang.Integer getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: SEX
	 * @param sex the SEX value
	 */
	public void setSex (java.lang.Integer sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: NATION
	 */
	public java.lang.String getNation () {
		return nation;
	}

	/**
	 * Set the value related to the column: NATION
	 * @param nation the NATION value
	 */
	public void setNation (java.lang.String nation) {
		this.nation = nation;
	}



	/**
	 * Return the value associated with the column: CERTIFICATEID
	 */
	public java.lang.Integer getCertificateid () {
		return certificateid;
	}

	/**
	 * Set the value related to the column: CERTIFICATEID
	 * @param certificateid the CERTIFICATEID value
	 */
	public void setCertificateid (java.lang.Integer certificateid) {
		this.certificateid = certificateid;
	}



	/**
	 * Return the value associated with the column: IDCARDNO
	 */
	public java.lang.String getIdcardno () {
		return idcardno;
	}

	/**
	 * Set the value related to the column: IDCARDNO
	 * @param idcardno the IDCARDNO value
	 */
	public void setIdcardno (java.lang.String idcardno) {
		this.idcardno = idcardno;
	}



	/**
	 * Return the value associated with the column: COUNTRY
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: COUNTRY
	 * @param country the COUNTRY value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
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
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param email the EMAIL value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: TELEPHONE
	 */
	public java.lang.String getTelephone () {
		return telephone;
	}

	/**
	 * Set the value related to the column: TELEPHONE
	 * @param telephone the TELEPHONE value
	 */
	public void setTelephone (java.lang.String telephone) {
		this.telephone = telephone;
	}



	/**
	 * Return the value associated with the column: FLAG
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: FLAG
	 * @param flag the FLAG value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CustomerImport)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CustomerImport customerImport = (cn.com.newcapec.citycard.common.po.CustomerImport) obj;
			if (null == this.getId() || null == customerImport.getId()) return false;
			else return (this.getId().equals(customerImport.getId()));
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