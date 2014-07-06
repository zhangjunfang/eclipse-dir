package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CONSUME_OPCOUNT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CONSUME_OPCOUNT"
 */

public abstract class BaseConsumeOpcount  implements Comparable, Serializable {

	public static String REF = "ConsumeOpcount";
	public static String PROP_WALLETTYPE = "wallettype";
	public static String PROP_ID = "id";
	public static String PROP_ASN = "asn";
	public static String PROP_OPCOUNT = "opcount";


	// constructors
	public BaseConsumeOpcount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseConsumeOpcount (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseConsumeOpcount (
		java.lang.String id,
		java.lang.Integer asn,
		java.lang.Integer opcount,
		java.lang.String wallettype) {

		this.setId(id);
		this.setAsn(asn);
		this.setOpcount(opcount);
		this.setWallettype(wallettype);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer asn;
	private java.lang.Integer opcount;
	private java.lang.String wallettype;



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
	 * Return the value associated with the column: ASN
	 */
	public java.lang.Integer getAsn () {
		return asn;
	}

	/**
	 * Set the value related to the column: ASN
	 * @param asn the ASN value
	 */
	public void setAsn (java.lang.Integer asn) {
		this.asn = asn;
	}



	/**
	 * Return the value associated with the column: OPCOUNT
	 */
	public java.lang.Integer getOpcount () {
		return opcount;
	}

	/**
	 * Set the value related to the column: OPCOUNT
	 * @param opcount the OPCOUNT value
	 */
	public void setOpcount (java.lang.Integer opcount) {
		this.opcount = opcount;
	}



	/**
	 * Return the value associated with the column: WALLETTYPE
	 */
	public java.lang.String getWallettype () {
		return wallettype;
	}

	/**
	 * Set the value related to the column: WALLETTYPE
	 * @param wallettype the WALLETTYPE value
	 */
	public void setWallettype (java.lang.String wallettype) {
		this.wallettype = wallettype;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.ConsumeOpcount)) return false;
		else {
			cn.com.newcapec.citycard.common.po.ConsumeOpcount consumeOpcount = (cn.com.newcapec.citycard.common.po.ConsumeOpcount) obj;
			if (null == this.getId() || null == consumeOpcount.getId()) return false;
			else return (this.getId().equals(consumeOpcount.getId()));
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