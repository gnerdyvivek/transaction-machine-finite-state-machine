package com.target.fsm;

import java.util.ArrayList;
import java.util.List;

import com.target.fsm.exceptions.IllegalEventInputException;
import com.target.fsm.exceptions.IllegalStateInputException;
import com.target.fsm.states.State;
import com.target.fsm.states.StateTransition;
import com.target.fsm.states.factory.AbstractInputFactory;
import com.target.fsm.states.impl.Cancelled;
import com.target.fsm.states.impl.Completed;
import com.target.fsm.states.impl.MakeTransition;
import com.target.fsm.states.impl.SwitchState;

/**
 * 
 * @author GVivek
 *
 */
public class FSM {

	private State currentState;
	
	private State nextState;

	private static boolean fsmStarted = false;

	private List<State> initiatedState = new ArrayList<State>(7);

	public List<State> getInitiatedState() {
		return initiatedState;
	}

	public void setInitiatedState(List<State> initiatedState) {
		this.initiatedState = initiatedState;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	public static boolean isFsmStarted() {
		return fsmStarted;
	}

	public static void setFsmStarted(boolean fsmStarted) {
		FSM.fsmStarted = fsmStarted;
	}

	public boolean validateFSMStart() {
		return fsmStarted;
	}

	/**
	 * check whether we need reached terminal state or not.
	 * 
	 * @return
	 */
	public boolean checkTerminal() {

		if (this.getNextState() instanceof Cancelled) {
			System.out.println("User Has cancelled the transaction");
			return true;
		} else if (this.getNextState() instanceof Completed) {
			System.out.println("Congratulation FSM transaction Completed Succesfully");
			return true;
		}
		return false;
	}

	/**
	 * make transition to other state or abort with failure
	 * @param fsmInput
	 * @throws IllegalEventInputException
	 * @throws IllegalStateInputException
	 */
	public void makeTransition(String fsmInput) throws IllegalEventInputException, IllegalStateInputException {

		StateTransition transition = AbstractInputFactory.getStateTransitionMethod(fsmInput);
		if (transition instanceof SwitchState) {
			transition.switchState(this, fsmInput);
		} else if (transition instanceof MakeTransition) {
			if (this.getCurrentState().statePossible(fsmInput)) {
				transition.makeTransition(this, fsmInput);
			}

		}

	}
}
