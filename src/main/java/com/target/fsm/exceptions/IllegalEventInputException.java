package com.target.fsm.exceptions;

public class IllegalEventInputException extends Exception {

	/**
	 * @author GVivek
	 */
	private static final long serialVersionUID = 1L;

	public IllegalEventInputException() {
	}

	public IllegalEventInputException(String message) {
		super(message);
	}

	public IllegalEventInputException(Throwable cause) {
		super(cause);
	}

	public IllegalEventInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalEventInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
