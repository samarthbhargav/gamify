/**
 * 
 */
package com.cod.gamify.common.except;

/**
 * @author Samarth Bhargav
 * 
 */
public class IncompleteEntityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4922625116618629705L;

	/**
	 * 
	 */
	public IncompleteEntityException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IncompleteEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public IncompleteEntityException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IncompleteEntityException(Throwable cause) {
		super(cause);
	}

}
