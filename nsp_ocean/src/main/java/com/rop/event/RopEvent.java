
package com.rop.event;

import com.rop.RopContext;

import java.util.EventObject;

/**
 * <pre>
 * 功能说明：
 * </pre>
 */
@SuppressWarnings("all")
public abstract class RopEvent extends EventObject {

    private RopContext ropContext;

    public RopEvent(Object source, RopContext ropContext) {
        super(source);
        this.ropContext = ropContext;
    }

    public RopContext getRopContext() {
        return ropContext;
    }
}

