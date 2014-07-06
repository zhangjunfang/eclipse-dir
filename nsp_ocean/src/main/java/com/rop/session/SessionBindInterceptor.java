
package com.rop.session;

import com.rop.AbstractInterceptor;
import com.rop.RopRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 将{@link Session}绑定到{@link RopSessionHolder}中，默认注册。
 */
public class SessionBindInterceptor extends AbstractInterceptor {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void beforeService(RopRequestContext ropRequestContext) {
        if(ropRequestContext.getSession() != null){
            RopSessionHolder.put(ropRequestContext.getSession());
            if(logger.isDebugEnabled()){
                logger.debug("会话绑定到{}中",RopSessionHolder.class.getCanonicalName());
            }
        }
    }
}
