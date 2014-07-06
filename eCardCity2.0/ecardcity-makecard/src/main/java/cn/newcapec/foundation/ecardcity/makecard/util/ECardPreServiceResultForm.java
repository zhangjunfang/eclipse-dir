package cn.newcapec.foundation.ecardcity.makecard.util;

/**
 * 调用密钥前置服务返回值信息
 * 
 * @author wulimo
 * 
 */
public class ECardPreServiceResultForm {
	private String method;// 服务方法名
	private String paramXml;// 封装请求参数
	private String soapReqData;// 请求报文
	private String soapResponseData;// 返回报文
	private int statusCode;// 返回状态码
	private String resultStr;// 返回结果
	private String opdate;// 操作时间

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOpdate() {
		return opdate;
	}

	public void setOpdate(String opdate) {
		this.opdate = opdate;
	}

	public String getParamXml() {
		return paramXml;
	}

	public void setParamXml(String paramXml) {
		this.paramXml = paramXml;
	}

	public String getSoapReqData() {
		return soapReqData;
	}

	public void setSoapReqData(String soapReqData) {
		this.soapReqData = soapReqData;
	}

	public String getSoapResponseData() {
		return soapResponseData;
	}

	public void setSoapResponseData(String soapResponseData) {
		this.soapResponseData = soapResponseData;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

}
