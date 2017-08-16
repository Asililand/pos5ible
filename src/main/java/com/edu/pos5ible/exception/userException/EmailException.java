package com.edu.pos5ible.exception.userException;
/**
 * 
 * @author Pos5ible
 *
 */
public class EmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailException() {
		super();
	}

	public EmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmailException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailException(String message) {
		super(message);
	}

	public EmailException(Throwable cause) {
		super(cause);
	}
}
