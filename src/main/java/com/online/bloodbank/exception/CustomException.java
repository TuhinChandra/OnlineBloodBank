package com.online.bloodbank.exception;

public class CustomException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -3606192608040360905L;

	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomException(final String message, final Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomException(final Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
