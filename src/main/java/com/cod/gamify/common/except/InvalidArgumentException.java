/**
 * 
 */
package com.cod.gamify.common.except;

/**
 * @author Samarth Bhargav
 * 
 */
public class InvalidArgumentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3613104467928515961L;

	/**
	 * 
	 */
	public InvalidArgumentException() {
	}

	/**
	 * @param message
	 */
	public InvalidArgumentException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidArgumentException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidArgumentException(String message, Throwable cause) {
		super(message, cause);
	}
}
