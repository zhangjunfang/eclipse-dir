/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.biz.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.foundation.ecardcity.makecard.biz.ECardPreService;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.ECardPreServiceResultForm;
import cn.newcapec.framework.core.rest.Msg;
import cn.newcapec.framework.core.utils.dataUtils.DateUtil;

/**
 * 密钥前置服务公共业务接口实现类
 * 
 * @author wulimo
 * 
 */
@Service("eCardPreService")
@Transactional
@SuppressWarnings("all")
public class ECardPreServiceImpl implements ECardPreService {
	private static final Logger log = Logger
			.getLogger(ECardPreServiceImpl.class);
	/**
	 * 密钥前置服务URL
	 */
	// private static final String ECardPreSERVICE_URL =
	// "http://192.168.60.203/ECardPreServiceCity/ECardPreService_Out.asmx";
	private static final String ECardPreSERVICE_URL = "http://192.168.60.196/eCardBusWebService/Newcapec.Bus.PlatFormWS.asmx";
	/**
	 * 密钥前置服务NAMESPACE
	 */
	// private static final String ECardPreSERVICE_NAMESPACE =
	// "http://NewCap.com/CapWebServicePsam/";
	private static final String ECardPreSERVICE_NAMESPACE = "http://NewCap.com/NewCapecWebService/";

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.ECardPreService#
	 * getECardPreServiceCity(net.sf.json.JSONObject)
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Msg getECardPreServiceCity(JSONObject param) {
		Msg msg = new Msg();
		msg.setMsg(CardTipConstant.TIP_WEBSERVICE_REQ_FAIL);
		if (param.containsKey("method")) {
			String method = param.getString("method");
			ECardPreServiceResultForm result = null;

			String reqOpDT = DateUtil.toDateTimeString(DateUtil.getCurrDay(),
					DateUtil.DATETIME_FORMAT);

			// 测试连接 result=boolean
			if (method.equals("TestConnection")) {
				result = reqECardPreService(method, new Object[] {},
						new Object[] {});
			}

			// 显示本密钥前置服务的版本信息以及配套一卡通软件信息
			if (method.equals("GetCurrentVer")) {
				result = reqECardPreService(method, new Object[] {},
						new Object[] {});

			}

			// 获取MAC2码,(返回值参见接口统一返回值代码定义列表)
			if (method.equals("PBOC_CheckMAC")) {
				// 查询code
				String pSelfAuthCode = "73813699778405318494987367366626";
				String pAuthID = "1";
				String pAuthCode = "73813699778405318494987367366626";
				// 60539133580684947446114868952953
				String ASN = param.getString("ASN");
				String Rand = param.getString("Rand");
				String NoteCase = param.getString("NoteCase");
				String OddFare = param.getString("OddFare");
				String OpCount = param.getString("OpCount");
				String OpFare = param.getString("OpFare");
				String PosCode = param.getString("PosCode");
				// 生成充值的19位时间
				String OpDT = DateUtil.toDateTimeString(DateUtil.getCurrDay(),
						DateUtil.DATETIME_FORMAT);
				OpDT = OpDT.replaceAll("-", "");
				OpDT = OpDT.replaceAll(" ", "");
				OpDT = OpDT.replaceAll(":", "");
				String bytes = param.getString("bytes");
				// method:"PBOC_CheckMAC",pAuthID:4,ASN:asn,Rand:a3,NoteCase:0,OddFare:a1,OpCount:a2,OpFare:opFare,PosCode:a0,bytes:mac1

				result = reqECardPreService(method, new Object[] {
						"pSelfAuthCode", "pAuthID", "pAuthCode", "ASN", "Rand",
						"NoteCase", "OddFare", "OpCount", "OpFare", "PosCode",
						"OpDT", "bytes", "ErrMsg" }, new Object[] {
						pSelfAuthCode, pAuthID, pAuthCode, ASN, Rand, NoteCase,
						OddFare, OpCount, OpFare, PosCode, OpDT, bytes,
						"ErrMsg" });
			}
			// 加款操作MAC验证
			if (method.equals("CheckMac")) {
				// 查询code
				String pSelfAuthCode = "73813699778405318494987367366626";
				String pAuthID = "1";
				String pAuthCode = "73813699778405318494987367366626";
				String ASN = param.getString("ASN");
				String Rand = param.getString("Rand");
				String NoteCase = param.getString("NoteCase");
				String OddFare = param.getString("OddFare");// 加款钱余额
				String OpCount = param.getString("OpCount");
				String OpFare = param.getString("OpFare");
				String PosCode = param.getString("PosCode");
				// 生成充值的19位时间
				String OpDT = reqOpDT;
				OpDT = OpDT.replaceAll("-", "");
				OpDT = OpDT.replaceAll(" ", "");
				OpDT = OpDT.replaceAll(":", "");
				String mac1 = param.getString("mac1");
				// method:"PBOC_CheckMAC",pAuthID:4,ASN:asn,Rand:a3,NoteCase:0,OddFare:a1,OpCount:a2,OpFare:opFare,PosCode:a0,bytes:mac1
				result = reqECardPreService(method, new Object[] { "ASN",
						"Rand", "NoteCase", "OpCount", "OddFare", "OpFare",
						"PosCode", "OpDT", "MAC", "out_msg" }, new Object[] {
						ASN, Rand, NoteCase, OpCount, OddFare, OpFare, PosCode,
						OpDT, mac1, "0" });

			}

			// 验证TAC码,(返回值参见接口统一返回值代码定义列表)
			if (method.equals("PBOC_CheckTAC_Verify")) {
				result = reqECardPreService(method, new Object[] {
						"pSelfAuthCode", "pAuthID", "pAuthCode", "ASN",
						"MakeCardID", "NoteCase", "OddFare", "OpCount",
						"OpFare", "PosCode", "OpDT", "orgTacCode", "tacType",
						"ErrMsg" }, new Object[] {});
			}
			// 获取应用密钥,(返回值参见接口统一返回值代码定义列表)
			if (method.equals("PBOC_GetKeyForApp")) {
				result = reqECardPreService(method, new Object[] {
						"pSelfAuthCode", "pAuthID", "pAuthCode", "sectorInfo",
						"cardsnr", "cardMac", "encKey", "ErrMsg" },
						new Object[] {});
			}

			// 根据认证ID获取认证码,(返回值参见接口统一返回值代码定义列表)
			if (method.equals("GetAuthCodeByAuthID")) {

				result = reqECardPreService(method, new Object[] {
						"pSelfAuthCode", "pAuthID", "pOutAuthCode",
						"pNewAuthCode", "ErrMsg" }, new Object[] {});
			}

			// 密钥前置服务系统PSAM卡状态管理,操作类型OpType = 1挂失,2解挂,3注销,(返回值参见接口统一返回值代码定义列表)
			if (method.equals("PsamCardStatusMng")) {
				result = reqECardPreService(method, new Object[] {
						"pSelfAuthCode", "pAuthID", "pAuthCode", "OpType",
						"PosCode", "Reason", "ErrMsg" }, new Object[] {});
			}

			// 密钥前置服务系统PSAM卡注册,(返回值参见接口统一返回值代码定义列表)
			if (method.equals("PsamCardRegister")) {
				result = reqECardPreService(method, new Object[] {
						"pSelfAuthCode", "pAuthID", "pAuthCode", "PsamCode",
						"PrintCode", "sCardSnr", "PosCode", "beginDt", "endDt",
						"ErrMsg" }, new Object[] {});
			}

			// 返回结果

			if (null != result && result.getStatusCode() == 200) {
				log.info("---method:" + result.getMethod());
				log.info("---param:" + result.getParamXml());
				log.info("---result:" + result.getSoapResponseData());
				result.setOpdate(reqOpDT);
				msg.setMsg(CardTipConstant.TIP_IS_OK);
				msg.setData(result);
			} else {
				msg.setMsg(CardTipConstant.TIP_WEBSERVICE_REQ_FAIL
						+ "[statusCode:" + result.getStatusCode() + "]");
			}
		}
		return msg;
	}

	/**
	 * 城市密钥前置服务请求
	 * 
	 * @param method
	 *            服务方法
	 * @param key
	 *            参数名称
	 * @param value
	 *            参数键值
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	private ECardPreServiceResultForm reqECardPreService(String method,
			Object[] key, Object[] value) {
		ECardPreServiceResultForm result = new ECardPreServiceResultForm();
		try {
			PostMethod postMethod = new PostMethod(ECardPreSERVICE_URL);
			String paramXml = getParamXml(key, value);
			// 请求报文
			String soapReqData = getSoapReqDataByPost(method, paramXml);
			// 报文头、长度设置
			byte[] b = soapReqData.getBytes("utf-8");
			InputStream is = new ByteArrayInputStream(b, 0, b.length);
			RequestEntity requestEntity = new InputStreamRequestEntity(is,
					b.length, "text/xml; charset=utf-8");
			postMethod.setRequestEntity(requestEntity);
			HttpClient httpClient = new HttpClient();
			httpClient.setConnectionTimeout(10000);// 连接超时30秒
			httpClient.setTimeout(10000);// 超时30秒
			// 报文Http请求状态码
			int statusCode = httpClient.executeMethod(postMethod);
			// 返回的报文
			String soapResponseData = postMethod.getResponseBodyAsString();
			result.setMethod(method);
			result.setParamXml(paramXml);
			result.setStatusCode(statusCode);
			result.setSoapReqData(soapReqData);
			result.setSoapResponseData(soapResponseData);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 封装请求报文的参数xml
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	private String getParamXml(Object[] key, Object[] value) {
		String str = "";
		if (key.length > 0 && key.length == value.length) {
			for (int i = 0; i < key.length; i++) {
				str += "<" + key[i] + ">" + value[i] + "</" + key[i] + ">";
			}
		}
		return str;
	}

	/**
	 * 生成soap请求数据
	 * 
	 * @param method
	 * @param keyValue
	 * @return
	 */
	private String getSoapReqDataByPost(String method, String paramXMl) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		sb.append(" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
		sb.append(" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("<soap:Body>");
		sb.append("<" + method + " xmlns=\"" + ECardPreSERVICE_NAMESPACE
				+ "\">");
		sb.append(paramXMl);
		sb.append("</" + method + ">");
		sb.append("</soap:Body>");
		sb.append("</soap:Envelope>");
		return sb.toString();
	}
}
