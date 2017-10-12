package com.target.fsm.exceptions;

public class IllegalStateInputException extends Exception {

	/**
	 * @author GVivek
	 */
	private static final long serialVersionUID = 1L;

	public IllegalStateInputException() {
	}

	public IllegalStateInputException(String arg0) {
		super(arg0);
	}

	public IllegalStateInputException(Throwable arg0) {
		super(arg0);
	}

	public IllegalStateInputException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IllegalStateInputException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
