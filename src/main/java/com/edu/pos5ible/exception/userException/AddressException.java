package com.edu.pos5ible.exception.userException;

public class AddressException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressException() {
		super();
	}

	public AddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddressException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressException(String message) {
		super(message);
	}

	public AddressException(Throwable cause) {
		super(cause);
	}
	
	

}
