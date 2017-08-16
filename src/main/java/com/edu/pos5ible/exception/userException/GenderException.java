package com.edu.pos5ible.exception.userException;

public class GenderException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenderException() {
		super();
	}

	public GenderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GenderException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenderException(String message) {
		super(message);
	}

	public GenderException(Throwable cause) {
		super(cause);
	}
	
	

}
