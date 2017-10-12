package com.target.fsm.states.impl;

import com.target.fsm.FSM;
import com.target.fsm.states.State;
import com.target.fsm.states.StateTransition;

/**
 * 
 * @author GVivek
 *
 */
public class MakeTransition implements StateTransition {

	public void switchState(FSM fsm, String input) {
		//do nothing
	}

	public void makeTransition(FSM fsm, String input) {
		State state = fsm.getCurrentState();
		System.out.println("Switching state to " + state.getNextState());
		fsm.setCurrentState(state.getNextState());
		fsm.setNextState(state.getNextState());
		if(!fsm.getInitiatedState().contains(fsm.getCurrentState())) {
			fsm.getInitiatedState().add(fsm.getCurrentState());
		}
	}

}
