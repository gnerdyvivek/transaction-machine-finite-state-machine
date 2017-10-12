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
public class StateS0 implements State {

	private static StateS0  stateS0 = null;
	
	private  State nextState = null;
	
	private StateS0() {
	}

	public static State getState() {
		if(stateS0 == null) {
			stateS0 = new StateS0();
		}
		return stateS0;
	}
	
	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	public  boolean statePossible(String input) throws IllegalEventInputException, IllegalStateInputException {
		
		if(Events.StateS0.getInputEvents().equals(input)) {
			setNextState(getState());
			return true;
		} else if (Events.EventR1.getInputEvents().equals(input)) {
			setNextState(StateS1.getState());
			return true;
		} else if (Events.EventR2.getInputEvents().equals(input)) {
			setNextState(StateS2.getState());
			return true;
		} else if (Events.CANCEL.getInputEvents().equals(input)) {
			setNextState(Cancelled.getState());
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
