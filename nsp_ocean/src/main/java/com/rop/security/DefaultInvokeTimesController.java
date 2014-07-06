
package com.rop.security;

import com.rop.session.Session;

/**
 * <pre>
 *    默认的实现
 * </pre>
 */
public class DefaultInvokeTimesController implements InvokeTimesController {

    @Override
    public void caculateInvokeTimes(String appKey, Session session) {
    }

    @Override
    public boolean isUserInvokeLimitExceed(String appKey, Session session) {
        return false;
    }

    @Override
    public boolean isSessionInvokeLimitExceed(String appKey, String sessionId) {
        return false;
    }

    @Override
    public boolean isAppInvokeLimitExceed(String appKey) {
        return false;
    }

    @Override
    public boolean isAppInvokeFrequencyExceed(String appKey) {
        return false;
    }
}

