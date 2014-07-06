package cn.com.newcapec.citycard.system.domain;

import java.util.Date;

import cn.com.newcapec.citycard.common.po.TLog;


/**
 * This is an object that contains data related to the LOG_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="LOG_INFO"
 */

public class TLogSearch extends TLog{
	private static final long serialVersionUID = -218015377905896832L;
	private Date startDate=null;
	private Date endDate=null;
	
	public TLogSearch () {
		super();
	}
	public TLogSearch (TLog logInfo) {
		super(logInfo.getId());
	}

	
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}