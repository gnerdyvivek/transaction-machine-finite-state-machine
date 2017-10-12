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
public class StateS2 implements State {

	private static StateS2 stateS2 = null;

	private State nextState = null;

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	private StateS2() {
	}

	public static State getState() {
		if (stateS2 == null) {
			stateS2 = new StateS2();
		}
		return stateS2;
	}

	public boolean statePossible(String input) throws IllegalEventInputException, IllegalStateInputException {
		if(Events.StateS2.getInputEvents().equals(input)) {
			setNextState(getState());
			return true;
		} else if (Events.CANCEL.getInputEvents().equals(input)) {
			setNextState(Cancelled.getState());
			return true;
		} else if (Events.EventR1.getInputEvents().equals(input)) {
			setNextState(StateS3.getState());
			return true;
		} else if (Events.EventR2.getInputEvents().equals(input)) {
			setNextState(StateS4.getState());
			return true;
		} else if (input.startsWith("r")) {
			throw new IllegalEventInputException();
		} else if (input.startsWith("s")) {
			throw new IllegalStateInputException();
		}
		return false;
	}

}
