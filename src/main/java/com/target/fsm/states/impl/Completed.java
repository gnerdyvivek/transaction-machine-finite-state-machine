package com.target.fsm.states.impl;

import com.target.fsm.states.State;

public class Completed implements State {

	private static Completed completed = null;

	private State nextState = null;

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	private Completed() {
	}

	public static State getState() {
		if (completed == null) {
			completed = new Completed();
		}
		return completed;
	}

	public boolean statePossible(String input) {
		return false;
	}

}
