
package com.rop;

/**
 * <pre>
 *    通过该适配器以统一的方式调用ROP方法
 * </pre>
 */
public interface ServiceMethodAdapter {
    /**
     * 调用服务方法
     *
     * @param ropRequestContext
     * @return
     */
    Object invokeServiceMethod(RopRequestContext ropRequestContext);

}

