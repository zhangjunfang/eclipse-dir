package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_LOG"
 */

public abstract class BaseTLog  implements Comparable, Serializable {

	public static String REF = "TLog";
	public static String PROP_IP = "ip";
	public static String PROP_ACTION = "action";
	public static String PROP_DEL_FLAG = "delFlag";
	public static String PROP_LOG_CONTENT = "logContent";
	public static String PROP_OPERATOR = "operator";
	public static String PROP_ID = "id";
	public static String PROP_MODULE = "module";
	public static String PROP_LOG_DATE = "logDate";


	// constructors
	public BaseTLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTLog (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTLog (
		java.lang.Integer id,
		java.lang.String operator,
		java.lang.String module,
		java.lang.String action,
		java.lang.String logContent,
		java.util.Date logDate) {

		this.setId(id);
		this.setOperator(operator);
		this.setModule(module);
		this.setAction(action);
		this.setLogContent(logContent);
		this.setLogDate(logDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String operator;
	private java.lang.String module;
	private java.lang.String action;
	private java.lang.String logContent;
	private java.util.Date logDate;
	private java.lang.String ip;
	private java.lang.String delFlag;



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
	 * Return the value associated with the column: OPERATOR
	 */
	public java.lang.String getOperator () {
		return operator;
	}

	/**
	 * Set the value related to the column: OPERATOR
	 * @param operator the OPERATOR value
	 */
	public void setOperator (java.lang.String operator) {
		this.operator = operator;
	}



	/**
	 * Return the value associated with the column: MODULE
	 */
	public java.lang.String getModule () {
		return module;
	}

	/**
	 * Set the value related to the column: MODULE
	 * @param module the MODULE value
	 */
	public void setModule (java.lang.String module) {
		this.module = module;
	}



	/**
	 * Return the value associated with the column: ACTION
	 */
	public java.lang.String getAction () {
		return action;
	}

	/**
	 * Set the value related to the column: ACTION
	 * @param action the ACTION value
	 */
	public void setAction (java.lang.String action) {
		this.action = action;
	}



	/**
	 * Return the value associated with the column: LOG_CONTENT
	 */
	public java.lang.String getLogContent () {
		return logContent;
	}

	/**
	 * Set the value related to the column: LOG_CONTENT
	 * @param logContent the LOG_CONTENT value
	 */
	public void setLogContent (java.lang.String logContent) {
		this.logContent = logContent;
	}



	/**
	 * Return the value associated with the column: LOG_DATE
	 */
	public java.util.Date getLogDate () {
		return logDate;
	}

	/**
	 * Set the value related to the column: LOG_DATE
	 * @param logDate the LOG_DATE value
	 */
	public void setLogDate (java.util.Date logDate) {
		this.logDate = logDate;
	}



	/**
	 * Return the value associated with the column: IP
	 */
	public java.lang.String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: IP
	 * @param ip the IP value
	 */
	public void setIp (java.lang.String ip) {
		this.ip = ip;
	}



	/**
	 * Return the value associated with the column: DEL_FLAG
	 */
	public java.lang.String getDelFlag () {
		return delFlag;
	}

	/**
	 * Set the value related to the column: DEL_FLAG
	 * @param delFlag the DEL_FLAG value
	 */
	public void setDelFlag (java.lang.String delFlag) {
		this.delFlag = delFlag;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TLog)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TLog tLog = (cn.com.newcapec.citycard.common.po.TLog) obj;
			if (null == this.getId() || null == tLog.getId()) return false;
			else return (this.getId().equals(tLog.getId()));
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