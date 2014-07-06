
package com.rop.event;

import com.rop.RopContext;

/**
 * <pre>
 * 功能说明：
 * </pre>
 */
@SuppressWarnings("all")
public class PreCloseRopEvent extends RopEvent {
    public PreCloseRopEvent(Object source, RopContext ropContext) {
        super(source, ropContext);
    }
}

