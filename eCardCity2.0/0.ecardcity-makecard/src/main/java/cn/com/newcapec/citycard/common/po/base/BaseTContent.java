package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_CONTENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_CONTENT"
 */

public abstract class BaseTContent  implements Comparable, Serializable {

	public static String REF = "TContent";
	public static String PROP_CHANNEL_ID = "channelId";
	public static String PROP_SOURCE = "source";
	public static String PROP_HIT = "hit";
	public static String PROP_STATE = "state";
	public static String PROP_UPDATEUSER = "updateuser";
	public static String PROP_ID = "id";
	public static String PROP_CTITLE = "ctitle";
	public static String PROP_UPDATETIME = "updatetime";
	public static String PROP_CCONTENT = "ccontent";


	// constructors
	public BaseTContent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTContent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTContent (
		java.lang.Integer id,
		java.lang.String ctitle,
		java.lang.String state,
		java.lang.Integer channelId,
		java.lang.String updateuser,
		java.util.Date updatetime) {

		this.setId(id);
		this.setCtitle(ctitle);
		this.setState(state);
		this.setChannelId(channelId);
		this.setUpdateuser(updateuser);
		this.setUpdatetime(updatetime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ctitle;
	private java.lang.String ccontent;
	private java.lang.String source;
	private java.lang.Integer hit;
	private java.lang.String state;
	private java.lang.Integer channelId;
	private java.lang.String updateuser;
	private java.util.Date updatetime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: C_TITLE
	 */
	public java.lang.String getCtitle () {
		return ctitle;
	}

	/**
	 * Set the value related to the column: C_TITLE
	 * @param ctitle the C_TITLE value
	 */
	public void setCtitle (java.lang.String ctitle) {
		this.ctitle = ctitle;
	}



	/**
	 * Return the value associated with the column: C_CONTENT
	 */
	public java.lang.String getCcontent () {
		return ccontent;
	}

	/**
	 * Set the value related to the column: C_CONTENT
	 * @param ccontent the C_CONTENT value
	 */
	public void setCcontent (java.lang.String ccontent) {
		this.ccontent = ccontent;
	}



	/**
	 * Return the value associated with the column: SOURCE
	 */
	public java.lang.String getSource () {
		return source;
	}

	/**
	 * Set the value related to the column: SOURCE
	 * @param source the SOURCE value
	 */
	public void setSource (java.lang.String source) {
		this.source = source;
	}



	/**
	 * Return the value associated with the column: HIT
	 */
	public java.lang.Integer getHit () {
		return hit;
	}

	/**
	 * Set the value related to the column: HIT
	 * @param hit the HIT value
	 */
	public void setHit (java.lang.Integer hit) {
		this.hit = hit;
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
	 * Return the value associated with the column: CHANNEL_ID
	 */
	public java.lang.Integer getChannelId () {
		return channelId;
	}

	/**
	 * Set the value related to the column: CHANNEL_ID
	 * @param channelId the CHANNEL_ID value
	 */
	public void setChannelId (java.lang.Integer channelId) {
		this.channelId = channelId;
	}



	/**
	 * Return the value associated with the column: UPDATEUSER
	 */
	public java.lang.String getUpdateuser () {
		return updateuser;
	}

	/**
	 * Set the value related to the column: UPDATEUSER
	 * @param updateuser the UPDATEUSER value
	 */
	public void setUpdateuser (java.lang.String updateuser) {
		this.updateuser = updateuser;
	}



	/**
	 * Return the value associated with the column: UPDATETIME
	 */
	public java.util.Date getUpdatetime () {
		return updatetime;
	}

	/**
	 * Set the value related to the column: UPDATETIME
	 * @param updatetime the UPDATETIME value
	 */
	public void setUpdatetime (java.util.Date updatetime) {
		this.updatetime = updatetime;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TContent)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TContent tContent = (cn.com.newcapec.citycard.common.po.TContent) obj;
			if (null == this.getId() || null == tContent.getId()) return false;
			else return (this.getId().equals(tContent.getId()));
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