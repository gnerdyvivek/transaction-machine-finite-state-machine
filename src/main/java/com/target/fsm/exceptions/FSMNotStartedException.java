package com.target.fsm.exceptions;

/**
 * 
 * @author GVivek
 *
 */
public class FSMNotStartedException extends Exception {

	private static final long serialVersionUID = 1L;

	public FSMNotStartedException() {
	}

	public FSMNotStartedException(String arg0) {
		super(arg0);
	}

	public FSMNotStartedException(Throwable arg0) {
		super(arg0);
	}

	public FSMNotStartedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FSMNotStartedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
