package com.target.fsm.utility;

import com.target.fsm.events.Events;
import com.target.fsm.exceptions.FSMNotStartedException;
import com.target.fsm.exceptions.UnrecognizedEventStateException;

/**
 * 
 * @author GVivek
 *
 */
public class InputValidator {

	public static boolean validateInput(String input) throws UnrecognizedEventStateException {
		for(Events event : Events.values()) {
			if(event.getInputEvents().equals(input)) {
				return true;
			}
		}
		throw new UnrecognizedEventStateException();
	}
	
	public static boolean validateStartOfFSM(String input) throws FSMNotStartedException {
		if(input.toLowerCase().trim().equals(Events.StateS0.getInputEvents())) {
			return true;
		}
		throw new FSMNotStartedException();
	}
}
