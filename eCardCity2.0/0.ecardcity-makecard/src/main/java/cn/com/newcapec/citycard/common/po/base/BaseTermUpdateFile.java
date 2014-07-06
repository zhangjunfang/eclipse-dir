package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TERM_UPDATE_FILE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TERM_UPDATE_FILE"
 */

public abstract class BaseTermUpdateFile  implements Comparable, Serializable {

	public static String REF = "TermUpdateFile";
	public static String PROP_EDIT_DATE = "editDate";
	public static String PROP_SYSTYPE = "systype";
	public static String PROP_FILEURL = "fileurl";
	public static String PROP_ID = "id";
	public static String PROP_FILEVER = "filever";
	public static String PROP_EDIT_PERSON = "editPerson";
	public static String PROP_FILENAME = "filename";


	// constructors
	public BaseTermUpdateFile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTermUpdateFile (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTermUpdateFile (
		java.lang.String id,
		java.lang.String filename,
		java.lang.String fileurl,
		java.lang.String filever,
		java.lang.String systype,
		java.lang.String editPerson,
		java.util.Date editDate) {

		this.setId(id);
		this.setFilename(filename);
		this.setFileurl(fileurl);
		this.setFilever(filever);
		this.setSystype(systype);
		this.setEditPerson(editPerson);
		this.setEditDate(editDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String filename;
	private java.lang.String fileurl;
	private java.lang.String filever;
	private java.lang.String systype;
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
	 * Return the value associated with the column: FILENAME
	 */
	public java.lang.String getFilename () {
		return filename;
	}

	/**
	 * Set the value related to the column: FILENAME
	 * @param filename the FILENAME value
	 */
	public void setFilename (java.lang.String filename) {
		this.filename = filename;
	}



	/**
	 * Return the value associated with the column: FILEURL
	 */
	public java.lang.String getFileurl () {
		return fileurl;
	}

	/**
	 * Set the value related to the column: FILEURL
	 * @param fileurl the FILEURL value
	 */
	public void setFileurl (java.lang.String fileurl) {
		this.fileurl = fileurl;
	}



	/**
	 * Return the value associated with the column: FILEVER
	 */
	public java.lang.String getFilever () {
		return filever;
	}

	/**
	 * Set the value related to the column: FILEVER
	 * @param filever the FILEVER value
	 */
	public void setFilever (java.lang.String filever) {
		this.filever = filever;
	}



	/**
	 * Return the value associated with the column: SYSTYPE
	 */
	public java.lang.String getSystype () {
		return systype;
	}

	/**
	 * Set the value related to the column: SYSTYPE
	 * @param systype the SYSTYPE value
	 */
	public void setSystype (java.lang.String systype) {
		this.systype = systype;
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
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TermUpdateFile)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TermUpdateFile termUpdateFile = (cn.com.newcapec.citycard.common.po.TermUpdateFile) obj;
			if (null == this.getId() || null == termUpdateFile.getId()) return false;
			else return (this.getId().equals(termUpdateFile.getId()));
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