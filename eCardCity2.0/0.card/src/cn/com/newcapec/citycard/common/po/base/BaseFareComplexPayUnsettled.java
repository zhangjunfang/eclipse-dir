package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the FARE_COMPLEX_PAY_UNSETTLED table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FARE_COMPLEX_PAY_UNSETTLED"
 */

public abstract class BaseFareComplexPayUnsettled  implements Comparable, Serializable {

	public static String REF = "FareComplexPayUnsettled";
	public static String PROP_PAYTP = "paytp";
	public static String PROP_BILLNO = "billno";
	public static String PROP_PAYSUCCESSDATE = "paysuccessdate";
	public static String PROP_UPLOADPRICEDT = "uploadpricedt";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_RESULTPAYDT = "resultpaydt";
	public static String PROP_APPLYDT = "applydt";
	public static String PROP_PAYRESULT = "payresult";
	public static String PROP_PAYOBJ = "payobj";
	public static String PROP_MEASURE = "measure";
	public static String PROP_MUSTPAYPRICE = "mustpayprice";
	public static String PROP_MERCHANTCODE = "merchantcode";
	public static String PROP_TRADENO = "tradeno";
	public static String PROP_LASTPAYLEAVE = "lastpayleave";
	public static String PROP_REALITYPAY = "realitypay";
	public static String PROP_ID = "id";
	public static String PROP_TAC = "tac";
	public static String PROP_LASTPAY = "lastpay";
	public static String PROP_RECORDSTATUS = "recordstatus";
	public static String PROP_TERMID = "termid";
	public static String PROP_UNITPRICE = "unitprice";


	// constructors
	public BaseFareComplexPayUnsettled () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFareComplexPayUnsettled (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFareComplexPayUnsettled (
		java.lang.String id,
		java.lang.String billno,
		java.lang.String measure,
		java.lang.String unitprice,
		java.lang.String mustpayprice,
		java.lang.String paytp,
		java.lang.String payresult,
		java.lang.String tradeno,
		java.lang.String termid,
		java.lang.String tac,
		java.math.BigDecimal recordstatus,
		java.lang.String realitypay) {

		this.setId(id);
		this.setBillno(billno);
		this.setMeasure(measure);
		this.setUnitprice(unitprice);
		this.setMustpayprice(mustpayprice);
		this.setPaytp(paytp);
		this.setPayresult(payresult);
		this.setTradeno(tradeno);
		this.setTermid(termid);
		this.setTac(tac);
		this.setRecordstatus(recordstatus);
		this.setRealitypay(realitypay);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String billno;
	private java.lang.String measure;
	private java.lang.String unitprice;
	private java.lang.String lastpay;
	private java.lang.String lastpayleave;
	private java.lang.String mustpayprice;
	private java.lang.String paytp;
	private java.lang.String payresult;
	private java.util.Date applydt;
	private java.util.Date resultpaydt;
	private java.lang.String industrycode;
	private java.lang.String merchantcode;
	private java.lang.String tradeno;
	private java.lang.String termid;
	private java.lang.String tac;
	private java.math.BigDecimal recordstatus;
	private java.lang.String payobj;
	private java.util.Date paysuccessdate;
	private java.lang.String realitypay;
	private java.util.Date uploadpricedt;



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



	/**
	 * Return the value associated with the column: MEASURE
	 */
	public java.lang.String getMeasure () {
		return measure;
	}

	/**
	 * Set the value related to the column: MEASURE
	 * @param measure the MEASURE value
	 */
	public void setMeasure (java.lang.String measure) {
		this.measure = measure;
	}



	/**
	 * Return the value associated with the column: UNITPRICE
	 */
	public java.lang.String getUnitprice () {
		return unitprice;
	}

	/**
	 * Set the value related to the column: UNITPRICE
	 * @param unitprice the UNITPRICE value
	 */
	public void setUnitprice (java.lang.String unitprice) {
		this.unitprice = unitprice;
	}



	/**
	 * Return the value associated with the column: LASTPAY
	 */
	public java.lang.String getLastpay () {
		return lastpay;
	}

	/**
	 * Set the value related to the column: LASTPAY
	 * @param lastpay the LASTPAY value
	 */
	public void setLastpay (java.lang.String lastpay) {
		this.lastpay = lastpay;
	}



	/**
	 * Return the value associated with the column: LASTPAYLEAVE
	 */
	public java.lang.String getLastpayleave () {
		return lastpayleave;
	}

	/**
	 * Set the value related to the column: LASTPAYLEAVE
	 * @param lastpayleave the LASTPAYLEAVE value
	 */
	public void setLastpayleave (java.lang.String lastpayleave) {
		this.lastpayleave = lastpayleave;
	}



	/**
	 * Return the value associated with the column: MUSTPAYPRICE
	 */
	public java.lang.String getMustpayprice () {
		return mustpayprice;
	}

	/**
	 * Set the value related to the column: MUSTPAYPRICE
	 * @param mustpayprice the MUSTPAYPRICE value
	 */
	public void setMustpayprice (java.lang.String mustpayprice) {
		this.mustpayprice = mustpayprice;
	}



	/**
	 * Return the value associated with the column: PAYTP
	 */
	public java.lang.String getPaytp () {
		return paytp;
	}

	/**
	 * Set the value related to the column: PAYTP
	 * @param paytp the PAYTP value
	 */
	public void setPaytp (java.lang.String paytp) {
		this.paytp = paytp;
	}



	/**
	 * Return the value associated with the column: PAYRESULT
	 */
	public java.lang.String getPayresult () {
		return payresult;
	}

	/**
	 * Set the value related to the column: PAYRESULT
	 * @param payresult the PAYRESULT value
	 */
	public void setPayresult (java.lang.String payresult) {
		this.payresult = payresult;
	}



	/**
	 * Return the value associated with the column: APPLYDT
	 */
	public java.util.Date getApplydt () {
		return applydt;
	}

	/**
	 * Set the value related to the column: APPLYDT
	 * @param applydt the APPLYDT value
	 */
	public void setApplydt (java.util.Date applydt) {
		this.applydt = applydt;
	}



	/**
	 * Return the value associated with the column: RESULTPAYDT
	 */
	public java.util.Date getResultpaydt () {
		return resultpaydt;
	}

	/**
	 * Set the value related to the column: RESULTPAYDT
	 * @param resultpaydt the RESULTPAYDT value
	 */
	public void setResultpaydt (java.util.Date resultpaydt) {
		this.resultpaydt = resultpaydt;
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
	 * Return the value associated with the column: MERCHANTCODE
	 */
	public java.lang.String getMerchantcode () {
		return merchantcode;
	}

	/**
	 * Set the value related to the column: MERCHANTCODE
	 * @param merchantcode the MERCHANTCODE value
	 */
	public void setMerchantcode (java.lang.String merchantcode) {
		this.merchantcode = merchantcode;
	}



	/**
	 * Return the value associated with the column: TRADENO
	 */
	public java.lang.String getTradeno () {
		return tradeno;
	}

	/**
	 * Set the value related to the column: TRADENO
	 * @param tradeno the TRADENO value
	 */
	public void setTradeno (java.lang.String tradeno) {
		this.tradeno = tradeno;
	}



	/**
	 * Return the value associated with the column: TERMID
	 */
	public java.lang.String getTermid () {
		return termid;
	}

	/**
	 * Set the value related to the column: TERMID
	 * @param termid the TERMID value
	 */
	public void setTermid (java.lang.String termid) {
		this.termid = termid;
	}



	/**
	 * Return the value associated with the column: TAC
	 */
	public java.lang.String getTac () {
		return tac;
	}

	/**
	 * Set the value related to the column: TAC
	 * @param tac the TAC value
	 */
	public void setTac (java.lang.String tac) {
		this.tac = tac;
	}



	/**
	 * Return the value associated with the column: RECORDSTATUS
	 */
	public java.math.BigDecimal getRecordstatus () {
		return recordstatus;
	}

	/**
	 * Set the value related to the column: RECORDSTATUS
	 * @param recordstatus the RECORDSTATUS value
	 */
	public void setRecordstatus (java.math.BigDecimal recordstatus) {
		this.recordstatus = recordstatus;
	}



	/**
	 * Return the value associated with the column: PAYOBJ
	 */
	public java.lang.String getPayobj () {
		return payobj;
	}

	/**
	 * Set the value related to the column: PAYOBJ
	 * @param payobj the PAYOBJ value
	 */
	public void setPayobj (java.lang.String payobj) {
		this.payobj = payobj;
	}



	/**
	 * Return the value associated with the column: PAYSUCCESSDATE
	 */
	public java.util.Date getPaysuccessdate () {
		return paysuccessdate;
	}

	/**
	 * Set the value related to the column: PAYSUCCESSDATE
	 * @param paysuccessdate the PAYSUCCESSDATE value
	 */
	public void setPaysuccessdate (java.util.Date paysuccessdate) {
		this.paysuccessdate = paysuccessdate;
	}



	/**
	 * Return the value associated with the column: REALITYPAY
	 */
	public java.lang.String getRealitypay () {
		return realitypay;
	}

	/**
	 * Set the value related to the column: REALITYPAY
	 * @param realitypay the REALITYPAY value
	 */
	public void setRealitypay (java.lang.String realitypay) {
		this.realitypay = realitypay;
	}



	/**
	 * Return the value associated with the column: UPLOADPRICEDT
	 */
	public java.util.Date getUploadpricedt () {
		return uploadpricedt;
	}

	/**
	 * Set the value related to the column: UPLOADPRICEDT
	 * @param uploadpricedt the UPLOADPRICEDT value
	 */
	public void setUploadpricedt (java.util.Date uploadpricedt) {
		this.uploadpricedt = uploadpricedt;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.FareComplexPayUnsettled)) return false;
		else {
			cn.com.newcapec.citycard.common.po.FareComplexPayUnsettled fareComplexPayUnsettled = (cn.com.newcapec.citycard.common.po.FareComplexPayUnsettled) obj;
			if (null == this.getId() || null == fareComplexPayUnsettled.getId()) return false;
			else return (this.getId().equals(fareComplexPayUnsettled.getId()));
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