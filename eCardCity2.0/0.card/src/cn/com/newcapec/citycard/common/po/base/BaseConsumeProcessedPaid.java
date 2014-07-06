package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CONSUME_PROCESSED_PAID table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CONSUME_PROCESSED_PAID"
 */

public abstract class BaseConsumeProcessedPaid  implements Comparable, Serializable {

	public static String REF = "ConsumeProcessedPaid";
	public static String PROP_BILLNO = "billno";
	public static String PROP_COLLECTPOINT = "collectpoint";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_ADJUSTFLAG = "adjustflag";
	public static String PROP_COUSUME_PROCESSED_ID = "cousumeProcessedId";
	public static String PROP_ID = "id";
	public static String PROP_STATDATE = "statdate";


	// constructors
	public BaseConsumeProcessedPaid () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseConsumeProcessedPaid (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseConsumeProcessedPaid (
		java.lang.String id,
		java.lang.String cousumeProcessedId,
		java.lang.String industrycode,
		java.lang.String adjustflag,
		java.lang.String billno) {

		this.setId(id);
		this.setCousumeProcessedId(cousumeProcessedId);
		this.setIndustrycode(industrycode);
		this.setAdjustflag(adjustflag);
		this.setBillno(billno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String cousumeProcessedId;
	private java.util.Date statdate;
	private java.lang.String industrycode;
	private java.lang.String adjustflag;
	private java.lang.String collectpoint;
	private java.lang.String billno;



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
	 * Return the value associated with the column: COUSUME_PROCESSED_ID
	 */
	public java.lang.String getCousumeProcessedId () {
		return cousumeProcessedId;
	}

	/**
	 * Set the value related to the column: COUSUME_PROCESSED_ID
	 * @param cousumeProcessedId the COUSUME_PROCESSED_ID value
	 */
	public void setCousumeProcessedId (java.lang.String cousumeProcessedId) {
		this.cousumeProcessedId = cousumeProcessedId;
	}



	/**
	 * Return the value associated with the column: STATDATE
	 */
	public java.util.Date getStatdate () {
		return statdate;
	}

	/**
	 * Set the value related to the column: STATDATE
	 * @param statdate the STATDATE value
	 */
	public void setStatdate (java.util.Date statdate) {
		this.statdate = statdate;
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
	 * Return the value associated with the column: ADJUSTFLAG
	 */
	public java.lang.String getAdjustflag () {
		return adjustflag;
	}

	/**
	 * Set the value related to the column: ADJUSTFLAG
	 * @param adjustflag the ADJUSTFLAG value
	 */
	public void setAdjustflag (java.lang.String adjustflag) {
		this.adjustflag = adjustflag;
	}



	/**
	 * Return the value associated with the column: COLLECTPOINT
	 */
	public java.lang.String getCollectpoint () {
		return collectpoint;
	}

	/**
	 * Set the value related to the column: COLLECTPOINT
	 * @param collectpoint the COLLECTPOINT value
	 */
	public void setCollectpoint (java.lang.String collectpoint) {
		this.collectpoint = collectpoint;
	}



	/**
	 * Return the value associated with the column: BILLNO
	 */
	public java.lang.String getBillno () {
		return billno;
	}

	/**
	 * Set the value related to the column: BILLNO
	 * @param billno the BILLNO value
	 */
	public void setBillno (java.lang.String billno) {
		this.billno = billno;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.ConsumeProcessedPaid)) return false;
		else {
			cn.com.newcapec.citycard.common.po.ConsumeProcessedPaid consumeProcessedPaid = (cn.com.newcapec.citycard.common.po.ConsumeProcessedPaid) obj;
			if (null == this.getId() || null == consumeProcessedPaid.getId()) return false;
			else return (this.getId().equals(consumeProcessedPaid.getId()));
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