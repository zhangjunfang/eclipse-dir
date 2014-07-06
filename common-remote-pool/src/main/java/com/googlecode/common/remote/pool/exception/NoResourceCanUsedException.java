package com.googlecode.common.remote.pool.exception;

@SuppressWarnings("serial")
public class NoResourceCanUsedException extends
		UncheckedCommonRemotePoolException {

	public NoResourceCanUsedException(String string) {
	}

	public NoResourceCanUsedException() {
		super();
	}

	public NoResourceCanUsedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoResourceCanUsedException(Throwable cause) {
		super(cause);
	}

}
