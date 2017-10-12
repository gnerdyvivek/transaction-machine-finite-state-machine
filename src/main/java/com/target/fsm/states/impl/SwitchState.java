package com.target.fsm.states.impl;

import com.target.fsm.FSM;
import com.target.fsm.exceptions.IllegalStateInputException;
import com.target.fsm.states.State;
import com.target.fsm.states.StateTransition;
import com.target.fsm.states.factory.StateFactory;

public class SwitchState implements StateTransition {

	public SwitchState() {
	}
	
	public void switchState(FSM fsm, String input) throws IllegalStateInputException {
		State state = StateFactory.getStateInstance(input);
		if(fsm.getInitiatedState().contains(state)) {
			System.out.println("Switching state to " + state);
			fsm.setCurrentState(state);
			fsm.setNextState(null);
		} else {
			throw new IllegalStateInputException();
		}
	}

	public void makeTransition(FSM fsm, String input) {
		//do nothing
	}

}
