package com.target.fsm.states.impl;

import com.target.fsm.events.Events;
import com.target.fsm.exceptions.IllegalEventInputException;
import com.target.fsm.exceptions.IllegalStateInputException;
import com.target.fsm.states.State;

public class StateS3 implements State {

	private static StateS3 stateS3 = null;

	private State nextState = null;

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	private StateS3() {
	}

	public static State getState() {
		if (stateS3 == null) {
			stateS3 = new StateS3();
		}
		return stateS3;
	}

	public boolean statePossible(String input) throws IllegalEventInputException, IllegalStateInputException {
		if(Events.StateS3.getInputEvents().equals(input)) {
			setNextState(getState());
			return true;
		} else if (Events.CANCEL.getInputEvents().equals(input)) {
			setNextState(Cancelled.getState());
			return true;
		} else if (Events.EventR1.getInputEvents().equals(input)) {
			setNextState(StateS4.getState());
			return true;
		} else if (input.startsWith("r")) {
			throw new IllegalEventInputException();
		} else if (input.startsWith("s")) {
			throw new IllegalStateInputException();
		} else if (input.startsWith("b")) {
			throw new IllegalEventInputException();
		}
		return false;
	}

}
