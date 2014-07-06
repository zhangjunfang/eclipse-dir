package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_PICTURE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_PICTURE"
 */

public abstract class BaseTPicture  implements Comparable, Serializable {

	public static String REF = "TPicture";
	public static String PROP_RECOMMEND = "recommend";
	public static String PROP_PICURL = "picurl";
	public static String PROP_CATEGORY = "category";
	public static String PROP_GUID = "guid";
	public static String PROP_INDEXPAGE = "indexpage";
	public static String PROP_UPDATEUSER = "updateuser";
	public static String PROP_ID = "id";
	public static String PROP_UPDATETIME = "updatetime";


	// constructors
	public BaseTPicture () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTPicture (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTPicture (
		java.lang.Integer id,
		java.lang.String guid,
		java.lang.String category,
		java.lang.String picurl,
		java.lang.String updateuser,
		java.util.Date updatetime) {

		this.setId(id);
		this.setGuid(guid);
		this.setCategory(category);
		this.setPicurl(picurl);
		this.setUpdateuser(updateuser);
		this.setUpdatetime(updatetime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String guid;
	private java.lang.String category;
	private java.lang.String picurl;
	private java.lang.String recommend;
	private java.lang.String indexpage;
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
	 * Return the value associated with the column: GUID
	 */
	public java.lang.String getGuid () {
		return guid;
	}

	/**
	 * Set the value related to the column: GUID
	 * @param guid the GUID value
	 */
	public void setGuid (java.lang.String guid) {
		this.guid = guid;
	}



	/**
	 * Return the value associated with the column: CATEGORY
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY
	 * @param category the CATEGORY value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: PICURL
	 */
	public java.lang.String getPicurl () {
		return picurl;
	}

	/**
	 * Set the value related to the column: PICURL
	 * @param picurl the PICURL value
	 */
	public void setPicurl (java.lang.String picurl) {
		this.picurl = picurl;
	}



	/**
	 * Return the value associated with the column: RECOMMEND
	 */
	public java.lang.String getRecommend () {
		return recommend;
	}

	/**
	 * Set the value related to the column: RECOMMEND
	 * @param recommend the RECOMMEND value
	 */
	public void setRecommend (java.lang.String recommend) {
		this.recommend = recommend;
	}



	/**
	 * Return the value associated with the column: INDEXPAGE
	 */
	public java.lang.String getIndexpage () {
		return indexpage;
	}

	/**
	 * Set the value related to the column: INDEXPAGE
	 * @param indexpage the INDEXPAGE value
	 */
	public void setIndexpage (java.lang.String indexpage) {
		this.indexpage = indexpage;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TPicture)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TPicture tPicture = (cn.com.newcapec.citycard.common.po.TPicture) obj;
			if (null == this.getId() || null == tPicture.getId()) return false;
			else return (this.getId().equals(tPicture.getId()));
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