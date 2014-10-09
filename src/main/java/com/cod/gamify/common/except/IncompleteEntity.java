/**
 * 
 */
package com.cod.gamify.common.except;

/**
 * @author Samarth Bhargav
 * 
 */
public class IncompleteEntity extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4922625116618629705L;

	/**
	 * 
	 */
	public IncompleteEntity() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IncompleteEntity(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public IncompleteEntity(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IncompleteEntity(Throwable cause) {
		super(cause);
	}

}
