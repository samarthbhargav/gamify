/**
 * 
 */
package com.cod.gamify.common.except;

/**
 * @author Samarth Bhargav
 * 
 */
public class MongoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2383895310933666398L;

	/**
	 * 
	 */
	public MongoException() {
	}

	/**
	 * @param message
	 */
	public MongoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MongoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MongoException(String message, Throwable cause) {
		super(message, cause);
	}

}
