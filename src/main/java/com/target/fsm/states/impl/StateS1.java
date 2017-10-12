package com.target.fsm.states.impl;

import com.target.fsm.events.Events;
import com.target.fsm.exceptions.IllegalEventInputException;
import com.target.fsm.exceptions.IllegalStateInputException;
import com.target.fsm.states.State;

/**
 * 
 * @author GVivek
 *
 */
public class StateS1 implements State {

	private static  StateS1  stateS1 = null;
	
	private  State nextState = null;
	
	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	private StateS1() {
	}

	public static State getState() {
		if(stateS1 == null) {
			stateS1 = new StateS1();
		}
		return stateS1;
	}
	
	public boolean statePossible(String input) throws IllegalEventInputException, IllegalStateInputException {
		if(Events.StateS1.getInputEvents().equals(input)) {
			setNextState(getState());
			return true;
		} else if (Events.CANCEL.getInputEvents().equals(input)) {
			setNextState(Cancelled.getState());
			return true;
		} else if (Events.EventR1.getInputEvents().equals(input)) {
			setNextState(StateS2.getState());
			return true;
		} else if (Events.EventR2.getInputEvents().equals(input)) {
			setNextState(StateS3.getState());
			return true;
		} else if (input.startsWith("r")) {
			throw new IllegalEventInputException();
		} else if (input.startsWith("s")) {
			throw new IllegalStateInputException();
		}
		return false;
	}

}
