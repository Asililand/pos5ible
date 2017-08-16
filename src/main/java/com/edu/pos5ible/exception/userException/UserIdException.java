package com.edu.pos5ible.exception.userException;

public class UserIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserIdException() {
		super();
	}

	public UserIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserIdException(String message) {
		super(message);
	}

	public UserIdException(Throwable cause) {
		super(cause);
	}
	

}
