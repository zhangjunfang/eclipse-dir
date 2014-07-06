/**
 *
 */
package com.xx;

/**
 * @author ocean date : 2014-4-18 上午11:24:15 email : zhangjunfang0505@163.com
 *         Copyright : newcapec zhengzhou
 */
public class WXX {

	public static void main(String[] args) {
		CertAuthBillService service=new CertAuthBillService();

		CertAuthBillServiceSoap  billServiceSoap=service.getCertAuthBillServiceSoap();
		System.err.println(billServiceSoap.getCurrentVer());
		System.err.println(billServiceSoap.testConnection());
		//System.err.println(billServiceSoap.verifyIdentity(strSigData, strSigValue, strUserCert, serrinfo, verifyIdentityResult));
	}

}
