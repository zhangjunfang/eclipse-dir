
package com.rop.security;

import java.util.List;

/**
 * <pre>
 * 功能说明：
 * </pre>
 */
public interface MainError {

    String getCode();

    String getMessage();

    String getSolution();

    List<SubError> getSubErrors();

    MainError addSubError(SubError subError);

}

