package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CARD_PSAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CARD_PSAM"
 */

public abstract class BaseCardPsam  implements Comparable, Serializable {

	public static String REF = "CardPsam";
	public static String PROP_LASTUPDATE = "lastupdate";
	public static String PROP_STARTDATE = "startdate";
	public static String PROP_ENDDATE = "enddate";
	public static String PROP_SAMCARDSNR = "samcardsnr";
	public static String PROP_ADDTYPE = "addtype";
	public static String PROP_LOSSDATE = "lossdate";
	public static String PROP_LOSSRECNO = "lossrecno";
	public static String PROP_PRINTCODE = "printcode";
	public static String PROP_SAMCARDNO = "samcardno";
	public static String PROP_CREATEDATE = "createdate";
	public static String PROP_SAMCARDTYPE = "samcardtype";
	public static String PROP_VER = "ver";
	public static String PROP_STATE = "state";
	public static String PROP_SAMCARDNAME = "samcardname";
	public static String PROP_ID = "id";
	public static String PROP_SAMCARDSN = "samcardsn";


	// constructors
	public BaseCardPsam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCardPsam (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCardPsam (
		java.lang.String id,
		java.lang.Integer samcardno,
		java.lang.Integer samcardsn,
		java.lang.String samcardsnr,
		java.lang.String state,
		java.util.Date startdate,
		java.util.Date enddate,
		java.util.Date lastupdate,
		java.util.Date createdate,
		java.lang.Integer ver,
		java.lang.String addtype,
		java.lang.String samcardtype,
		java.lang.String printcode) {

		this.setId(id);
		this.setSamcardno(samcardno);
		this.setSamcardsn(samcardsn);
		this.setSamcardsnr(samcardsnr);
		this.setState(state);
		this.setStartdate(startdate);
		this.setEnddate(enddate);
		this.setLastupdate(lastupdate);
		this.setCreatedate(createdate);
		this.setVer(ver);
		this.setAddtype(addtype);
		this.setSamcardtype(samcardtype);
		this.setPrintcode(printcode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer samcardno;
	private java.lang.String samcardname;
	private java.lang.Integer samcardsn;
	private java.lang.String samcardsnr;
	private java.lang.String state;
	private java.util.Date startdate;
	private java.util.Date enddate;
	private java.util.Date lossdate;
	private java.lang.Integer lossrecno;
	private java.util.Date lastupdate;
	private java.util.Date createdate;
	private java.lang.Integer ver;
	private java.lang.String addtype;
	private java.lang.String samcardtype;
	private java.lang.String printcode;



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
	 * Return the value associated with the column: SAMCARDNO
	 */
	public java.lang.Integer getSamcardno () {
		return samcardno;
	}

	/**
	 * Set the value related to the column: SAMCARDNO
	 * @param samcardno the SAMCARDNO value
	 */
	public void setSamcardno (java.lang.Integer samcardno) {
		this.samcardno = samcardno;
	}



	/**
	 * Return the value associated with the column: SAMCARDNAME
	 */
	public java.lang.String getSamcardname () {
		return samcardname;
	}

	/**
	 * Set the value related to the column: SAMCARDNAME
	 * @param samcardname the SAMCARDNAME value
	 */
	public void setSamcardname (java.lang.String samcardname) {
		this.samcardname = samcardname;
	}



	/**
	 * Return the value associated with the column: SAMCARDSN
	 */
	public java.lang.Integer getSamcardsn () {
		return samcardsn;
	}

	/**
	 * Set the value related to the column: SAMCARDSN
	 * @param samcardsn the SAMCARDSN value
	 */
	public void setSamcardsn (java.lang.Integer samcardsn) {
		this.samcardsn = samcardsn;
	}



	/**
	 * Return the value associated with the column: SAMCARDSNR
	 */
	public java.lang.String getSamcardsnr () {
		return samcardsnr;
	}

	/**
	 * Set the value related to the column: SAMCARDSNR
	 * @param samcardsnr the SAMCARDSNR value
	 */
	public void setSamcardsnr (java.lang.String samcardsnr) {
		this.samcardsnr = samcardsnr;
	}



	/**
	 * Return the value associated with the column: STATE
	 */
	public java.lang.String getState () {
		return state;
	}

	/**
	 * Set the value related to the column: STATE
	 * @param state the STATE value
	 */
	public void setState (java.lang.String state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: STARTDATE
	 */
	public java.util.Date getStartdate () {
		return startdate;
	}

	/**
	 * Set the value related to the column: STARTDATE
	 * @param startdate the STARTDATE value
	 */
	public void setStartdate (java.util.Date startdate) {
		this.startdate = startdate;
	}



	/**
	 * Return the value associated with the column: ENDDATE
	 */
	public java.util.Date getEnddate () {
		return enddate;
	}

	/**
	 * Set the value related to the column: ENDDATE
	 * @param enddate the ENDDATE value
	 */
	public void setEnddate (java.util.Date enddate) {
		this.enddate = enddate;
	}



	/**
	 * Return the value associated with the column: LOSSDATE
	 */
	public java.util.Date getLossdate () {
		return lossdate;
	}

	/**
	 * Set the value related to the column: LOSSDATE
	 * @param lossdate the LOSSDATE value
	 */
	public void setLossdate (java.util.Date lossdate) {
		this.lossdate = lossdate;
	}



	/**
	 * Return the value associated with the column: LOSSRECNO
	 */
	public java.lang.Integer getLossrecno () {
		return lossrecno;
	}

	/**
	 * Set the value related to the column: LOSSRECNO
	 * @param lossrecno the LOSSRECNO value
	 */
	public void setLossrecno (java.lang.Integer lossrecno) {
		this.lossrecno = lossrecno;
	}



	/**
	 * Return the value associated with the column: LASTUPDATE
	 */
	public java.util.Date getLastupdate () {
		return lastupdate;
	}

	/**
	 * Set the value related to the column: LASTUPDATE
	 * @param lastupdate the LASTUPDATE value
	 */
	public void setLastupdate (java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}



	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
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
	 * Return the value associated with the column: ADDTYPE
	 */
	public java.lang.String getAddtype () {
		return addtype;
	}

	/**
	 * Set the value related to the column: ADDTYPE
	 * @param addtype the ADDTYPE value
	 */
	public void setAddtype (java.lang.String addtype) {
		this.addtype = addtype;
	}



	/**
	 * Return the value associated with the column: SAMCARDTYPE
	 */
	public java.lang.String getSamcardtype () {
		return samcardtype;
	}

	/**
	 * Set the value related to the column: SAMCARDTYPE
	 * @param samcardtype the SAMCARDTYPE value
	 */
	public void setSamcardtype (java.lang.String samcardtype) {
		this.samcardtype = samcardtype;
	}



	/**
	 * Return the value associated with the column: PRINTCODE
	 */
	public java.lang.String getPrintcode () {
		return printcode;
	}

	/**
	 * Set the value related to the column: PRINTCODE
	 * @param printcode the PRINTCODE value
	 */
	public void setPrintcode (java.lang.String printcode) {
		this.printcode = printcode;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CardPsam)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CardPsam cardPsam = (cn.com.newcapec.citycard.common.po.CardPsam) obj;
			if (null == this.getId() || null == cardPsam.getId()) return false;
			else return (this.getId().equals(cardPsam.getId()));
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