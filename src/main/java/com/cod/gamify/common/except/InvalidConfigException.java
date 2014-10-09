/**
 * 
 */
package com.cod.gamify.common.except;

/**
 * @author Samarth Bhargav
 * 
 */
public class InvalidConfigException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6082685935824557022L;

	/**
	 * 
	 */
	public InvalidConfigException() {
	}

	/**
	 * @param message
	 */
	public InvalidConfigException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidConfigException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidConfigException(String message, Throwable cause) {
		super(message, cause);
	}

}
