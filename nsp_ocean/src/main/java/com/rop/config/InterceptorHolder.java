
package com.rop.config;

import com.rop.Interceptor;

/**
 * <pre>
 * 功能说明：
 * </pre>
 */
public class InterceptorHolder {

    private Interceptor interceptor;

    public InterceptorHolder(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }
}

