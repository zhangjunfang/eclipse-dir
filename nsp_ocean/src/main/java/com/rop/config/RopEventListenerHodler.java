
package com.rop.config;

import com.rop.event.RopEventListener;

/**
 * <pre>
 * 功能说明：
 * </pre>
 */
@SuppressWarnings("all")
public class RopEventListenerHodler {

    private RopEventListener ropEventListener;

    public RopEventListenerHodler(RopEventListener ropEventListener) {
        this.ropEventListener = ropEventListener;
    }

    public RopEventListener getRopEventListener() {
        return ropEventListener;
    }
}

