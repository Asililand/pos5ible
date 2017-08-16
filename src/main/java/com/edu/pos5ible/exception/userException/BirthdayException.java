package com.edu.pos5ible.exception.userException;

public class BirthdayException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BirthdayException() {
		super();
	}

	public BirthdayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BirthdayException(String message, Throwable cause) {
		super(message, cause);
	}

	public BirthdayException(String message) {
		super(message);
	}

	public BirthdayException(Throwable cause) {
		super(cause);
	}
	

}
