package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CUSTOMER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CUSTOMER"
 */

public abstract class BaseCustomer  implements Comparable, Serializable {

	public static String REF = "Customer";
	public static String PROP_TELEPHONE = "telephone";
	public static String PROP_COUNTRY = "country";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_NAME = "name";
	public static String PROP_POSTCODE = "postcode";
	public static String PROP_STATUS = "status";
	public static String PROP_JPDM = "jpdm";
	public static String PROP_VER = "ver";
	public static String PROP_BIRTHDAY = "birthday";
	public static String PROP_IDCARDNO = "idcardno";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_EMAIL = "email";
	public static String PROP_RREMARK = "rremark";
	public static String PROP_NATION = "nation";
	public static String PROP_ADDRESS = "address";
	public static String PROP_CERTIFICATEID = "certificateid";
	public static String PROP_ID = "id";
	public static String PROP_SEX = "sex";


	// constructors
	public BaseCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomer (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomer (
		java.lang.String id,
		java.lang.String status,
		java.lang.String sex,
		java.lang.String name,
		java.lang.String nation,
		java.lang.String certificateid,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setStatus(status);
		this.setSex(sex);
		this.setName(name);
		this.setNation(nation);
		this.setCertificateid(certificateid);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String status;
	private java.lang.String sex;
	private java.lang.String name;
	private java.lang.String nation;
	private java.lang.String certificateid;
	private java.lang.String idcardno;
	private java.lang.String country;
	private java.lang.String jpdm;
	private java.lang.Integer ver;
	private java.lang.String address;
	private java.lang.String email;
	private java.lang.String telephone;
	private java.lang.String postcode;
	private java.util.Date birthday;
	private java.lang.String rremark;
	private java.lang.String editPerson;
	private java.util.Date editDate;



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
	 * Return the value associated with the column: SEX
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: SEX
	 * @param sex the SEX value
	 */
	public void setSex (java.lang.String sex) {
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
	public java.lang.String getCertificateid () {
		return certificateid;
	}

	/**
	 * Set the value related to the column: CERTIFICATEID
	 * @param certificateid the CERTIFICATEID value
	 */
	public void setCertificateid (java.lang.String certificateid) {
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
	 * Return the value associated with the column: POSTCODE
	 */
	public java.lang.String getPostcode () {
		return postcode;
	}

	/**
	 * Set the value related to the column: POSTCODE
	 * @param postcode the POSTCODE value
	 */
	public void setPostcode (java.lang.String postcode) {
		this.postcode = postcode;
	}



	/**
	 * Return the value associated with the column: BIRTHDAY
	 */
	public java.util.Date getBirthday () {
		return birthday;
	}

	/**
	 * Set the value related to the column: BIRTHDAY
	 * @param birthday the BIRTHDAY value
	 */
	public void setBirthday (java.util.Date birthday) {
		this.birthday = birthday;
	}



	/**
	 * Return the value associated with the column: RREMARK
	 */
	public java.lang.String getRremark () {
		return rremark;
	}

	/**
	 * Set the value related to the column: RREMARK
	 * @param rremark the RREMARK value
	 */
	public void setRremark (java.lang.String rremark) {
		this.rremark = rremark;
	}



	/**
	 * Return the value associated with the column: EDIT_PERSON
	 */
	public java.lang.String getEditPerson () {
		return editPerson;
	}

	/**
	 * Set the value related to the column: EDIT_PERSON
	 * @param editPerson the EDIT_PERSON value
	 */
	public void setEditPerson (java.lang.String editPerson) {
		this.editPerson = editPerson;
	}



	/**
	 * Return the value associated with the column: EDIT_DATE
	 */
	public java.util.Date getEditDate () {
		return editDate;
	}

	/**
	 * Set the value related to the column: EDIT_DATE
	 * @param editDate the EDIT_DATE value
	 */
	public void setEditDate (java.util.Date editDate) {
		this.editDate = editDate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.Customer)) return false;
		else {
			cn.com.newcapec.citycard.common.po.Customer customer = (cn.com.newcapec.citycard.common.po.Customer) obj;
			if (null == this.getId() || null == customer.getId()) return false;
			else return (this.getId().equals(customer.getId()));
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