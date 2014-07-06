package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TERM_INFO_PARAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TERM_INFO_PARAM"
 */

public abstract class BaseTermInfoParam  implements Comparable, Serializable {

	public static String REF = "TermInfoParam";
	public static String PROP_DATATYPE = "datatype";
	public static String PROP_TYPECODE = "typecode";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_POSCODE = "poscode";


	// constructors
	public BaseTermInfoParam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTermInfoParam (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTermInfoParam (
		java.lang.String id,
		java.lang.String poscode,
		java.lang.Integer typecode,
		java.lang.String datatype,
		java.lang.String content) {

		this.setId(id);
		this.setPoscode(poscode);
		this.setTypecode(typecode);
		this.setDatatype(datatype);
		this.setContent(content);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String poscode;
	private java.lang.Integer typecode;
	private java.lang.String datatype;
	private java.lang.String content;



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
	 * Return the value associated with the column: POSCODE
	 */
	public java.lang.String getPoscode () {
		return poscode;
	}

	/**
	 * Set the value related to the column: POSCODE
	 * @param poscode the POSCODE value
	 */
	public void setPoscode (java.lang.String poscode) {
		this.poscode = poscode;
	}



	/**
	 * Return the value associated with the column: TYPECODE
	 */
	public java.lang.Integer getTypecode () {
		return typecode;
	}

	/**
	 * Set the value related to the column: TYPECODE
	 * @param typecode the TYPECODE value
	 */
	public void setTypecode (java.lang.Integer typecode) {
		this.typecode = typecode;
	}



	/**
	 * Return the value associated with the column: DATATYPE
	 */
	public java.lang.String getDatatype () {
		return datatype;
	}

	/**
	 * Set the value related to the column: DATATYPE
	 * @param datatype the DATATYPE value
	 */
	public void setDatatype (java.lang.String datatype) {
		this.datatype = datatype;
	}



	/**
	 * Return the value associated with the column: CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TermInfoParam)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TermInfoParam termInfoParam = (cn.com.newcapec.citycard.common.po.TermInfoParam) obj;
			if (null == this.getId() || null == termInfoParam.getId()) return false;
			else return (this.getId().equals(termInfoParam.getId()));
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