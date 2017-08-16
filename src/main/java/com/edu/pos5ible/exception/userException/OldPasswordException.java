package com.edu.pos5ible.exception.userException;

public class OldPasswordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OldPasswordException() {
		super();
	}

	public OldPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OldPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public OldPasswordException(String message) {
		super(message);
	}

	public OldPasswordException(Throwable cause) {
		super(cause);
	}
	

}
