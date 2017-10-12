/**
 * 
 */
package com.target.fsm.states.impl;

import com.target.fsm.states.State;

/**
 * @author GVivek
 *
 */
public class Cancelled implements State {

	private static Cancelled cancelled = null;

	private State nextState = null;

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	private Cancelled() {
	}

	
	public static State getState() {
		if (cancelled == null) {
			cancelled = new Cancelled();
		}
		return cancelled;
	}

	public boolean statePossible(String input) {
		return false;
	}

}
