package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the CARD_PSAM_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CARD_PSAM_LOG"
 */

public abstract class BaseCardPsamLog  implements Comparable, Serializable {

	public static String REF = "CardPsamLog";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_STATE = "state";
	public static String PROP_SAMCARDNAME = "samcardname";
	public static String PROP_ID = "id";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_SAMCARDNO = "samcardno";


	// constructors
	public BaseCardPsamLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCardPsamLog (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCardPsamLog (
		java.lang.String id,
		java.lang.Integer samcardno,
		java.lang.String state,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setSamcardno(samcardno);
		this.setState(state);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer samcardno;
	private java.lang.String samcardname;
	private java.lang.String state;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.CardPsamLog)) return false;
		else {
			cn.com.newcapec.citycard.common.po.CardPsamLog cardPsamLog = (cn.com.newcapec.citycard.common.po.CardPsamLog) obj;
			if (null == this.getId() || null == cardPsamLog.getId()) return false;
			else return (this.getId().equals(cardPsamLog.getId()));
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