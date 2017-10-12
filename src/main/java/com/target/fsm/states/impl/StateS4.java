package com.target.fsm.states.impl;

import com.target.fsm.events.Events;
import com.target.fsm.exceptions.IllegalEventInputException;
import com.target.fsm.exceptions.IllegalStateInputException;
import com.target.fsm.states.State;

public class StateS4 implements State {

	private static StateS4 stateS4 = null;

	private State nextState = null;

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	private StateS4() {
	}

	public static State getState() {
		if (stateS4 == null) {
			stateS4 = new StateS4();
		}
		return stateS4;
	}

	public boolean statePossible(String input) throws IllegalEventInputException, IllegalStateInputException {
		if(Events.StateS4.getInputEvents().equals(input)) {
			setNextState(getState());
			return true;
		} else if (Events.CANCEL.getInputEvents().equals(input)) {
			setNextState(Cancelled.getState());
			return true;
		} else if (Events.BUY.getInputEvents().equals(input)) {
			setNextState(Completed.getState());
			return true;
		} else if (input.startsWith("r")) {
			throw new IllegalEventInputException();
		} else if (input.startsWith("s")) {
			throw new IllegalStateInputException();
		}
		return false;
	}

}
