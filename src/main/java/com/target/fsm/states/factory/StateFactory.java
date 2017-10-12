package com.target.fsm.states.factory;

import com.target.fsm.events.Events;
import com.target.fsm.states.State;
import com.target.fsm.states.impl.Cancelled;
import com.target.fsm.states.impl.Completed;
import com.target.fsm.states.impl.StateS0;
import com.target.fsm.states.impl.StateS1;
import com.target.fsm.states.impl.StateS2;
import com.target.fsm.states.impl.StateS3;
import com.target.fsm.states.impl.StateS4;

public class StateFactory {

	public static State getStateInstance(String input) {
		if (Events.CANCEL.getInputEvents().equals(input)) {
			return Cancelled.getState();
		} else if (Events.BUY.getInputEvents().equals(input)) {
			return Completed.getState();
		} else if (Events.StateS0.getInputEvents().equals(input)) {
			return StateS0.getState();
		} else if (Events.StateS1.getInputEvents().equals(input)) {
			return StateS1.getState();
		} else if (Events.StateS2.getInputEvents().equals(input)) {
			return StateS2.getState();
		} else if (Events.StateS3.getInputEvents().equals(input)) {
			return StateS3.getState();
		} else if (Events.StateS4.getInputEvents().equals(input)) {
			return StateS4.getState();
		}
		return null;
	}
}
