
package com.rop.response;

import com.rop.security.MainError;
import com.rop.security.MainErrorType;
import com.rop.security.MainErrors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Locale;

/**
 * <pre>
 *   当服务平台资源耗尽（超过最大线程数且列队排满后）
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
public class RejectedServiceResponse extends ErrorResponse  {

    public RejectedServiceResponse() {
    }

    public RejectedServiceResponse(Locale locale) {
        MainError mainError = MainErrors.getError(MainErrorType.FORBIDDEN_REQUEST, locale);
        setMainError(mainError);
    }
}

