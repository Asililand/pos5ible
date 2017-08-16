package com.edu.pos5ible.exception.contentException;

public class ContentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContentException() {
		super();
	}

	public ContentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ContentException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContentException(String message) {
		super(message);
	}

	public ContentException(Throwable cause) {
		super(cause);
	}
	
	

}
