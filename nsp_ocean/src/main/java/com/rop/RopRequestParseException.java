
package com.rop;

/**
 * <pre>
 *   对请求数据进行解析时发生异常
 * </pre>
 */
public class RopRequestParseException extends RopException {
    @SuppressWarnings("unused")
	private String requestMessage;
	
	private static final long serialVersionUID = 77000905334895654L;

	public RopRequestParseException(String requestMessage) {
        this(requestMessage, "");
    }

    public RopRequestParseException(String requestMessage, String message) {
        this(requestMessage, message, null);
    }

    public RopRequestParseException(String requestMessage, String message, Throwable cause) {
        super(message, cause);
        this.requestMessage = requestMessage;
    }

    public RopRequestParseException(String requestMessage, Throwable cause) {
        this(requestMessage, null, cause);
    }
}

