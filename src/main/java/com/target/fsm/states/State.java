package com.target.fsm.states;

import com.target.fsm.exceptions.IllegalEventInputException;
import com.target.fsm.exceptions.IllegalStateInputException;

/**
 * 
 * @author GVivek
 * represents the different state in A FSM
 */

public interface State {
	/**
	 * check whether current given input is possible or not on current FSM state
	 * @param input
	 * @return
	 * @throws IllegalEventInputException,IllegalStateInput 
	 */
	public boolean statePossible(String input) throws IllegalEventInputException,IllegalStateInputException;
	
	public void setNextState(State state);
	
	public State getNextState();
	
}
