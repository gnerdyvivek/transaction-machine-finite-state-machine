package com.target.fsm.states;

import com.target.fsm.FSM;
import com.target.fsm.exceptions.IllegalEventInputException;
import com.target.fsm.exceptions.IllegalStateInputException;

public interface StateTransition {

	public void switchState(FSM fsm, String input) throws IllegalStateInputException;
	
	public void makeTransition(FSM fsm, String input) throws IllegalEventInputException, IllegalStateInputException;
}
