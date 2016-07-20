package org.kornogcomputing.bossanova.exception;

/**
 * 
 * @author herve
 *
 */
public class NoComponentNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4745321181934161353L;

	/**
	 * 
	 */
	public NoComponentNameException() {
		super();
	}

	/**
	 * @param message the message to display
	 */
	public NoComponentNameException(String message) {
		super(message);		
	}

}
