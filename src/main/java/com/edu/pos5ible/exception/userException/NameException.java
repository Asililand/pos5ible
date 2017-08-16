/**
 * 
 */
package com.edu.pos5ible.exception.userException;

/**
 * @author Pos5ible
 *
 */
public class NameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NameException() {}
	
	public NameException(String message) {
		super(message);
	}
	
	public NameException(Throwable cause) {
		super(cause);
	}

	public NameException(String message,Throwable cause) {
		super(message, cause);
	}
	
	public NameException(String message, Throwable cause, boolean enablesuperssion, boolean writableStackTrace) {
		super(message, cause, enablesuperssion, writableStackTrace);
	}
}
