package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the TERM_INFO_STATUS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TERM_INFO_STATUS"
 */

public abstract class BaseTermInfoStatus  implements Comparable, Serializable {

	public static String REF = "TermInfoStatus";
	public static String PROP_UPLOAD_DATE = "uploadDate";
	public static String PROP_COMM_FAILURE = "commFailure";
	public static String PROP_CONN_FAILURE = "connFailure";
	public static String PROP_DISCONN_FAILURE = "disconnFailure";
	public static String PROP_FLASH_FAILURE = "flashFailure";
	public static String PROP_COMM_SUCCESS = "commSuccess";
	public static String PROP_TRANSMITOROK = "transmitorok";
	public static String PROP_FRAM_SUCCESS = "framSuccess";
	public static String PROP_FRAM_FAILURE = "framFailure";
	public static String PROP_RECREMAININGCOUNT = "recremainingcount";
	public static String PROP_POINTFIVESIX_FAILURE = "pointfivesixFailure";
	public static String PROP_RECEIVE_FAILURE = "receiveFailure";
	public static String PROP_PARAMVER = "paramver";
	public static String PROP_GRANTLISTVER = "grantlistver";
	public static String PROP_TROUBLEFREETIME = "troublefreetime";
	public static String PROP_COMMSUCCESSRATIO = "commsuccessratio";
	public static String PROP_SIGNINDATE = "signindate";
	public static String PROP_SIGNOFFDATE = "signoffdate";
	public static String PROP_PARTNER_NO = "partnerNo";
	public static String PROP_PSAMCARDOK = "psamcardok";
	public static String PROP_TRADE_TYPE = "tradeType";
	public static String PROP_BLACKLISTVER = "blacklistver";
	public static String PROP_ID = "id";
	public static String PROP_POSCODE = "poscode";
	public static String PROP_APPLICATIONVER = "applicationver";
	public static String PROP_KEYBOARDOK = "keyboardok";
	public static String PROP_POINTFIVESIX_SUCCESS = "pointfivesixSuccess";
	public static String PROP_MAC_ADDRESS = "macAddress";
	public static String PROP_APPID = "appid";
	public static String PROP_CONN_SUCCESS = "connSuccess";
	public static String PROP_NETWORK_SIGNAL = "networkSignal";
	public static String PROP_PSAM_FAILURE = "psamFailure";
	public static String PROP_SIGNDATE = "signdate";
	public static String PROP_SIGNINSTATUS = "signinstatus";
	public static String PROP_UPLOAD_TIME = "uploadTime";
	public static String PROP_DISCONN_SUCCESS = "disconnSuccess";
	public static String PROP_TRANSBATNO = "transbatno";
	public static String PROP_RECEIVE_SUCCESS = "receiveSuccess";
	public static String PROP_FLASH_SUCCESS = "flashSuccess";
	public static String PROP_NO_COLLECT_UNIONPAY = "noCollectUnionpay";
	public static String PROP_NO_COLLECT_INDUSTRY = "noCollectIndustry";
	public static String PROP_NO_COLLECT_UNIONPAY_RTN = "noCollectUnionpayRtn";
	public static String PROP_PRINTEROK = "printerok";
	public static String PROP_ANSWERBACK_CODE = "answerbackCode";
	public static String PROP_SEND_SUCCESS = "sendSuccess";
	public static String PROP_SEND_FAILURE = "sendFailure";
	public static String PROP_PSAM_SUCCESS = "psamSuccess";
	public static String PROP_SYSTEM_TRACE_NUMBER = "systemTraceNumber";
	public static String PROP_TERMID = "termid";
	public static String PROP_ONLINETIME = "onlinetime";


	// constructors
	public BaseTermInfoStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTermInfoStatus (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTermInfoStatus (
		java.lang.String id,
		java.lang.String termid,
		java.lang.String poscode,
		java.lang.Integer transbatno,
		java.lang.String applicationver,
		java.lang.Integer blacklistver,
		java.lang.Integer grantlistver,
		java.lang.Integer signinstatus,
		java.util.Date signdate) {

		this.setId(id);
		this.setTermid(termid);
		this.setPoscode(poscode);
		this.setTransbatno(transbatno);
		this.setApplicationver(applicationver);
		this.setBlacklistver(blacklistver);
		this.setGrantlistver(grantlistver);
		this.setSigninstatus(signinstatus);
		this.setSigndate(signdate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String termid;
	private java.lang.String poscode;
	private java.lang.Integer transbatno;
	private java.util.Date signindate;
	private java.util.Date signoffdate;
	private java.lang.Integer paramver;
	private java.lang.String applicationver;
	private java.lang.Integer blacklistver;
	private java.lang.Integer grantlistver;
	private java.lang.Integer signinstatus;
	private java.util.Date signdate;
	private java.lang.String appid;
	private java.lang.Integer printerok;
	private java.lang.Integer transmitorok;
	private java.lang.Integer keyboardok;
	private java.lang.Integer psamcardok;
	private java.lang.Integer commsuccessratio;
	private java.lang.Integer troublefreetime;
	private java.lang.Integer onlinetime;
	private java.lang.Integer recremainingcount;
	private java.lang.Integer tradeType;
	private java.lang.Integer systemTraceNumber;
	private java.util.Date uploadTime;
	private java.util.Date uploadDate;
	private java.lang.Integer partnerNo;
	private java.lang.Integer answerbackCode;
	private java.lang.Integer networkSignal;
	private java.lang.Integer commSuccess;
	private java.lang.Integer commFailure;
	private java.lang.Integer connSuccess;
	private java.lang.Integer connFailure;
	private java.lang.Integer sendSuccess;
	private java.lang.Integer sendFailure;
	private java.lang.Integer receiveSuccess;
	private java.lang.Integer receiveFailure;
	private java.lang.Integer disconnSuccess;
	private java.lang.Integer disconnFailure;
	private java.lang.Integer pointfivesixSuccess;
	private java.lang.Integer pointfivesixFailure;
	private java.lang.Integer psamSuccess;
	private java.lang.Integer psamFailure;
	private java.lang.Integer framSuccess;
	private java.lang.Integer framFailure;
	private java.lang.Integer flashSuccess;
	private java.lang.Integer flashFailure;
	private java.lang.Integer noCollectIndustry;
	private java.lang.Integer noCollectUnionpay;
	private java.lang.Integer noCollectUnionpayRtn;
	private java.lang.Integer macAddress;



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
	 * Return the value associated with the column: POSCODE
	 */
	public java.lang.String getPoscode () {
		return poscode;
	}

	/**
	 * Set the value related to the column: POSCODE
	 * @param poscode the POSCODE value
	 */
	public void setPoscode (java.lang.String poscode) {
		this.poscode = poscode;
	}



	/**
	 * Return the value associated with the column: TRANSBATNO
	 */
	public java.lang.Integer getTransbatno () {
		return transbatno;
	}

	/**
	 * Set the value related to the column: TRANSBATNO
	 * @param transbatno the TRANSBATNO value
	 */
	public void setTransbatno (java.lang.Integer transbatno) {
		this.transbatno = transbatno;
	}



	/**
	 * Return the value associated with the column: SIGNINDATE
	 */
	public java.util.Date getSignindate () {
		return signindate;
	}

	/**
	 * Set the value related to the column: SIGNINDATE
	 * @param signindate the SIGNINDATE value
	 */
	public void setSignindate (java.util.Date signindate) {
		this.signindate = signindate;
	}



	/**
	 * Return the value associated with the column: SIGNOFFDATE
	 */
	public java.util.Date getSignoffdate () {
		return signoffdate;
	}

	/**
	 * Set the value related to the column: SIGNOFFDATE
	 * @param signoffdate the SIGNOFFDATE value
	 */
	public void setSignoffdate (java.util.Date signoffdate) {
		this.signoffdate = signoffdate;
	}



	/**
	 * Return the value associated with the column: PARAMVER
	 */
	public java.lang.Integer getParamver () {
		return paramver;
	}

	/**
	 * Set the value related to the column: PARAMVER
	 * @param paramver the PARAMVER value
	 */
	public void setParamver (java.lang.Integer paramver) {
		this.paramver = paramver;
	}



	/**
	 * Return the value associated with the column: APPLICATIONVER
	 */
	public java.lang.String getApplicationver () {
		return applicationver;
	}

	/**
	 * Set the value related to the column: APPLICATIONVER
	 * @param applicationver the APPLICATIONVER value
	 */
	public void setApplicationver (java.lang.String applicationver) {
		this.applicationver = applicationver;
	}



	/**
	 * Return the value associated with the column: BLACKLISTVER
	 */
	public java.lang.Integer getBlacklistver () {
		return blacklistver;
	}

	/**
	 * Set the value related to the column: BLACKLISTVER
	 * @param blacklistver the BLACKLISTVER value
	 */
	public void setBlacklistver (java.lang.Integer blacklistver) {
		this.blacklistver = blacklistver;
	}



	/**
	 * Return the value associated with the column: GRANTLISTVER
	 */
	public java.lang.Integer getGrantlistver () {
		return grantlistver;
	}

	/**
	 * Set the value related to the column: GRANTLISTVER
	 * @param grantlistver the GRANTLISTVER value
	 */
	public void setGrantlistver (java.lang.Integer grantlistver) {
		this.grantlistver = grantlistver;
	}



	/**
	 * Return the value associated with the column: SIGNINSTATUS
	 */
	public java.lang.Integer getSigninstatus () {
		return signinstatus;
	}

	/**
	 * Set the value related to the column: SIGNINSTATUS
	 * @param signinstatus the SIGNINSTATUS value
	 */
	public void setSigninstatus (java.lang.Integer signinstatus) {
		this.signinstatus = signinstatus;
	}



	/**
	 * Return the value associated with the column: SIGNDATE
	 */
	public java.util.Date getSigndate () {
		return signdate;
	}

	/**
	 * Set the value related to the column: SIGNDATE
	 * @param signdate the SIGNDATE value
	 */
	public void setSigndate (java.util.Date signdate) {
		this.signdate = signdate;
	}



	/**
	 * Return the value associated with the column: APPID
	 */
	public java.lang.String getAppid () {
		return appid;
	}

	/**
	 * Set the value related to the column: APPID
	 * @param appid the APPID value
	 */
	public void setAppid (java.lang.String appid) {
		this.appid = appid;
	}



	/**
	 * Return the value associated with the column: PRINTEROK
	 */
	public java.lang.Integer getPrinterok () {
		return printerok;
	}

	/**
	 * Set the value related to the column: PRINTEROK
	 * @param printerok the PRINTEROK value
	 */
	public void setPrinterok (java.lang.Integer printerok) {
		this.printerok = printerok;
	}



	/**
	 * Return the value associated with the column: TRANSMITOROK
	 */
	public java.lang.Integer getTransmitorok () {
		return transmitorok;
	}

	/**
	 * Set the value related to the column: TRANSMITOROK
	 * @param transmitorok the TRANSMITOROK value
	 */
	public void setTransmitorok (java.lang.Integer transmitorok) {
		this.transmitorok = transmitorok;
	}



	/**
	 * Return the value associated with the column: KEYBOARDOK
	 */
	public java.lang.Integer getKeyboardok () {
		return keyboardok;
	}

	/**
	 * Set the value related to the column: KEYBOARDOK
	 * @param keyboardok the KEYBOARDOK value
	 */
	public void setKeyboardok (java.lang.Integer keyboardok) {
		this.keyboardok = keyboardok;
	}



	/**
	 * Return the value associated with the column: PSAMCARDOK
	 */
	public java.lang.Integer getPsamcardok () {
		return psamcardok;
	}

	/**
	 * Set the value related to the column: PSAMCARDOK
	 * @param psamcardok the PSAMCARDOK value
	 */
	public void setPsamcardok (java.lang.Integer psamcardok) {
		this.psamcardok = psamcardok;
	}



	/**
	 * Return the value associated with the column: COMMSUCCESSRATIO
	 */
	public java.lang.Integer getCommsuccessratio () {
		return commsuccessratio;
	}

	/**
	 * Set the value related to the column: COMMSUCCESSRATIO
	 * @param commsuccessratio the COMMSUCCESSRATIO value
	 */
	public void setCommsuccessratio (java.lang.Integer commsuccessratio) {
		this.commsuccessratio = commsuccessratio;
	}



	/**
	 * Return the value associated with the column: TROUBLEFREETIME
	 */
	public java.lang.Integer getTroublefreetime () {
		return troublefreetime;
	}

	/**
	 * Set the value related to the column: TROUBLEFREETIME
	 * @param troublefreetime the TROUBLEFREETIME value
	 */
	public void setTroublefreetime (java.lang.Integer troublefreetime) {
		this.troublefreetime = troublefreetime;
	}



	/**
	 * Return the value associated with the column: ONLINETIME
	 */
	public java.lang.Integer getOnlinetime () {
		return onlinetime;
	}

	/**
	 * Set the value related to the column: ONLINETIME
	 * @param onlinetime the ONLINETIME value
	 */
	public void setOnlinetime (java.lang.Integer onlinetime) {
		this.onlinetime = onlinetime;
	}



	/**
	 * Return the value associated with the column: RECREMAININGCOUNT
	 */
	public java.lang.Integer getRecremainingcount () {
		return recremainingcount;
	}

	/**
	 * Set the value related to the column: RECREMAININGCOUNT
	 * @param recremainingcount the RECREMAININGCOUNT value
	 */
	public void setRecremainingcount (java.lang.Integer recremainingcount) {
		this.recremainingcount = recremainingcount;
	}



	/**
	 * Return the value associated with the column: TRADE_TYPE
	 */
	public java.lang.Integer getTradeType () {
		return tradeType;
	}

	/**
	 * Set the value related to the column: TRADE_TYPE
	 * @param tradeType the TRADE_TYPE value
	 */
	public void setTradeType (java.lang.Integer tradeType) {
		this.tradeType = tradeType;
	}



	/**
	 * Return the value associated with the column: SYSTEM_TRACE_NUMBER
	 */
	public java.lang.Integer getSystemTraceNumber () {
		return systemTraceNumber;
	}

	/**
	 * Set the value related to the column: SYSTEM_TRACE_NUMBER
	 * @param systemTraceNumber the SYSTEM_TRACE_NUMBER value
	 */
	public void setSystemTraceNumber (java.lang.Integer systemTraceNumber) {
		this.systemTraceNumber = systemTraceNumber;
	}



	/**
	 * Return the value associated with the column: UPLOAD_TIME
	 */
	public java.util.Date getUploadTime () {
		return uploadTime;
	}

	/**
	 * Set the value related to the column: UPLOAD_TIME
	 * @param uploadTime the UPLOAD_TIME value
	 */
	public void setUploadTime (java.util.Date uploadTime) {
		this.uploadTime = uploadTime;
	}



	/**
	 * Return the value associated with the column: UPLOAD_DATE
	 */
	public java.util.Date getUploadDate () {
		return uploadDate;
	}

	/**
	 * Set the value related to the column: UPLOAD_DATE
	 * @param uploadDate the UPLOAD_DATE value
	 */
	public void setUploadDate (java.util.Date uploadDate) {
		this.uploadDate = uploadDate;
	}



	/**
	 * Return the value associated with the column: PARTNER_NO
	 */
	public java.lang.Integer getPartnerNo () {
		return partnerNo;
	}

	/**
	 * Set the value related to the column: PARTNER_NO
	 * @param partnerNo the PARTNER_NO value
	 */
	public void setPartnerNo (java.lang.Integer partnerNo) {
		this.partnerNo = partnerNo;
	}



	/**
	 * Return the value associated with the column: ANSWERBACK_CODE
	 */
	public java.lang.Integer getAnswerbackCode () {
		return answerbackCode;
	}

	/**
	 * Set the value related to the column: ANSWERBACK_CODE
	 * @param answerbackCode the ANSWERBACK_CODE value
	 */
	public void setAnswerbackCode (java.lang.Integer answerbackCode) {
		this.answerbackCode = answerbackCode;
	}



	/**
	 * Return the value associated with the column: NETWORK_SIGNAL
	 */
	public java.lang.Integer getNetworkSignal () {
		return networkSignal;
	}

	/**
	 * Set the value related to the column: NETWORK_SIGNAL
	 * @param networkSignal the NETWORK_SIGNAL value
	 */
	public void setNetworkSignal (java.lang.Integer networkSignal) {
		this.networkSignal = networkSignal;
	}



	/**
	 * Return the value associated with the column: COMM_SUCCESS
	 */
	public java.lang.Integer getCommSuccess () {
		return commSuccess;
	}

	/**
	 * Set the value related to the column: COMM_SUCCESS
	 * @param commSuccess the COMM_SUCCESS value
	 */
	public void setCommSuccess (java.lang.Integer commSuccess) {
		this.commSuccess = commSuccess;
	}



	/**
	 * Return the value associated with the column: COMM_FAILURE
	 */
	public java.lang.Integer getCommFailure () {
		return commFailure;
	}

	/**
	 * Set the value related to the column: COMM_FAILURE
	 * @param commFailure the COMM_FAILURE value
	 */
	public void setCommFailure (java.lang.Integer commFailure) {
		this.commFailure = commFailure;
	}



	/**
	 * Return the value associated with the column: CONN_SUCCESS
	 */
	public java.lang.Integer getConnSuccess () {
		return connSuccess;
	}

	/**
	 * Set the value related to the column: CONN_SUCCESS
	 * @param connSuccess the CONN_SUCCESS value
	 */
	public void setConnSuccess (java.lang.Integer connSuccess) {
		this.connSuccess = connSuccess;
	}



	/**
	 * Return the value associated with the column: CONN_FAILURE
	 */
	public java.lang.Integer getConnFailure () {
		return connFailure;
	}

	/**
	 * Set the value related to the column: CONN_FAILURE
	 * @param connFailure the CONN_FAILURE value
	 */
	public void setConnFailure (java.lang.Integer connFailure) {
		this.connFailure = connFailure;
	}



	/**
	 * Return the value associated with the column: SEND_SUCCESS
	 */
	public java.lang.Integer getSendSuccess () {
		return sendSuccess;
	}

	/**
	 * Set the value related to the column: SEND_SUCCESS
	 * @param sendSuccess the SEND_SUCCESS value
	 */
	public void setSendSuccess (java.lang.Integer sendSuccess) {
		this.sendSuccess = sendSuccess;
	}



	/**
	 * Return the value associated with the column: SEND_FAILURE
	 */
	public java.lang.Integer getSendFailure () {
		return sendFailure;
	}

	/**
	 * Set the value related to the column: SEND_FAILURE
	 * @param sendFailure the SEND_FAILURE value
	 */
	public void setSendFailure (java.lang.Integer sendFailure) {
		this.sendFailure = sendFailure;
	}



	/**
	 * Return the value associated with the column: RECEIVE_SUCCESS
	 */
	public java.lang.Integer getReceiveSuccess () {
		return receiveSuccess;
	}

	/**
	 * Set the value related to the column: RECEIVE_SUCCESS
	 * @param receiveSuccess the RECEIVE_SUCCESS value
	 */
	public void setReceiveSuccess (java.lang.Integer receiveSuccess) {
		this.receiveSuccess = receiveSuccess;
	}



	/**
	 * Return the value associated with the column: RECEIVE_FAILURE
	 */
	public java.lang.Integer getReceiveFailure () {
		return receiveFailure;
	}

	/**
	 * Set the value related to the column: RECEIVE_FAILURE
	 * @param receiveFailure the RECEIVE_FAILURE value
	 */
	public void setReceiveFailure (java.lang.Integer receiveFailure) {
		this.receiveFailure = receiveFailure;
	}



	/**
	 * Return the value associated with the column: DISCONN_SUCCESS
	 */
	public java.lang.Integer getDisconnSuccess () {
		return disconnSuccess;
	}

	/**
	 * Set the value related to the column: DISCONN_SUCCESS
	 * @param disconnSuccess the DISCONN_SUCCESS value
	 */
	public void setDisconnSuccess (java.lang.Integer disconnSuccess) {
		this.disconnSuccess = disconnSuccess;
	}



	/**
	 * Return the value associated with the column: DISCONN_FAILURE
	 */
	public java.lang.Integer getDisconnFailure () {
		return disconnFailure;
	}

	/**
	 * Set the value related to the column: DISCONN_FAILURE
	 * @param disconnFailure the DISCONN_FAILURE value
	 */
	public void setDisconnFailure (java.lang.Integer disconnFailure) {
		this.disconnFailure = disconnFailure;
	}



	/**
	 * Return the value associated with the column: POINTFIVESIX_SUCCESS
	 */
	public java.lang.Integer getPointfivesixSuccess () {
		return pointfivesixSuccess;
	}

	/**
	 * Set the value related to the column: POINTFIVESIX_SUCCESS
	 * @param pointfivesixSuccess the POINTFIVESIX_SUCCESS value
	 */
	public void setPointfivesixSuccess (java.lang.Integer pointfivesixSuccess) {
		this.pointfivesixSuccess = pointfivesixSuccess;
	}



	/**
	 * Return the value associated with the column: POINTFIVESIX_FAILURE
	 */
	public java.lang.Integer getPointfivesixFailure () {
		return pointfivesixFailure;
	}

	/**
	 * Set the value related to the column: POINTFIVESIX_FAILURE
	 * @param pointfivesixFailure the POINTFIVESIX_FAILURE value
	 */
	public void setPointfivesixFailure (java.lang.Integer pointfivesixFailure) {
		this.pointfivesixFailure = pointfivesixFailure;
	}



	/**
	 * Return the value associated with the column: PSAM_SUCCESS
	 */
	public java.lang.Integer getPsamSuccess () {
		return psamSuccess;
	}

	/**
	 * Set the value related to the column: PSAM_SUCCESS
	 * @param psamSuccess the PSAM_SUCCESS value
	 */
	public void setPsamSuccess (java.lang.Integer psamSuccess) {
		this.psamSuccess = psamSuccess;
	}



	/**
	 * Return the value associated with the column: PSAM_FAILURE
	 */
	public java.lang.Integer getPsamFailure () {
		return psamFailure;
	}

	/**
	 * Set the value related to the column: PSAM_FAILURE
	 * @param psamFailure the PSAM_FAILURE value
	 */
	public void setPsamFailure (java.lang.Integer psamFailure) {
		this.psamFailure = psamFailure;
	}



	/**
	 * Return the value associated with the column: FRAM_SUCCESS
	 */
	public java.lang.Integer getFramSuccess () {
		return framSuccess;
	}

	/**
	 * Set the value related to the column: FRAM_SUCCESS
	 * @param framSuccess the FRAM_SUCCESS value
	 */
	public void setFramSuccess (java.lang.Integer framSuccess) {
		this.framSuccess = framSuccess;
	}



	/**
	 * Return the value associated with the column: FRAM_FAILURE
	 */
	public java.lang.Integer getFramFailure () {
		return framFailure;
	}

	/**
	 * Set the value related to the column: FRAM_FAILURE
	 * @param framFailure the FRAM_FAILURE value
	 */
	public void setFramFailure (java.lang.Integer framFailure) {
		this.framFailure = framFailure;
	}



	/**
	 * Return the value associated with the column: FLASH_SUCCESS
	 */
	public java.lang.Integer getFlashSuccess () {
		return flashSuccess;
	}

	/**
	 * Set the value related to the column: FLASH_SUCCESS
	 * @param flashSuccess the FLASH_SUCCESS value
	 */
	public void setFlashSuccess (java.lang.Integer flashSuccess) {
		this.flashSuccess = flashSuccess;
	}



	/**
	 * Return the value associated with the column: FLASH_FAILURE
	 */
	public java.lang.Integer getFlashFailure () {
		return flashFailure;
	}

	/**
	 * Set the value related to the column: FLASH_FAILURE
	 * @param flashFailure the FLASH_FAILURE value
	 */
	public void setFlashFailure (java.lang.Integer flashFailure) {
		this.flashFailure = flashFailure;
	}



	/**
	 * Return the value associated with the column: NO_COLLECT_INDUSTRY
	 */
	public java.lang.Integer getNoCollectIndustry () {
		return noCollectIndustry;
	}

	/**
	 * Set the value related to the column: NO_COLLECT_INDUSTRY
	 * @param noCollectIndustry the NO_COLLECT_INDUSTRY value
	 */
	public void setNoCollectIndustry (java.lang.Integer noCollectIndustry) {
		this.noCollectIndustry = noCollectIndustry;
	}



	/**
	 * Return the value associated with the column: NO_COLLECT_UNIONPAY
	 */
	public java.lang.Integer getNoCollectUnionpay () {
		return noCollectUnionpay;
	}

	/**
	 * Set the value related to the column: NO_COLLECT_UNIONPAY
	 * @param noCollectUnionpay the NO_COLLECT_UNIONPAY value
	 */
	public void setNoCollectUnionpay (java.lang.Integer noCollectUnionpay) {
		this.noCollectUnionpay = noCollectUnionpay;
	}



	/**
	 * Return the value associated with the column: NO_COLLECT_UNIONPAY_RTN
	 */
	public java.lang.Integer getNoCollectUnionpayRtn () {
		return noCollectUnionpayRtn;
	}

	/**
	 * Set the value related to the column: NO_COLLECT_UNIONPAY_RTN
	 * @param noCollectUnionpayRtn the NO_COLLECT_UNIONPAY_RTN value
	 */
	public void setNoCollectUnionpayRtn (java.lang.Integer noCollectUnionpayRtn) {
		this.noCollectUnionpayRtn = noCollectUnionpayRtn;
	}



	/**
	 * Return the value associated with the column: MAC_ADDRESS
	 */
	public java.lang.Integer getMacAddress () {
		return macAddress;
	}

	/**
	 * Set the value related to the column: MAC_ADDRESS
	 * @param macAddress the MAC_ADDRESS value
	 */
	public void setMacAddress (java.lang.Integer macAddress) {
		this.macAddress = macAddress;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.TermInfoStatus)) return false;
		else {
			cn.com.newcapec.citycard.common.po.TermInfoStatus termInfoStatus = (cn.com.newcapec.citycard.common.po.TermInfoStatus) obj;
			if (null == this.getId() || null == termInfoStatus.getId()) return false;
			else return (this.getId().equals(termInfoStatus.getId()));
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