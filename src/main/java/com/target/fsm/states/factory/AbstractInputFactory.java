package com.target.fsm.states.factory;

import com.target.fsm.states.StateTransition;
import com.target.fsm.states.impl.MakeTransition;
import com.target.fsm.states.impl.SwitchState;

public class AbstractInputFactory {

	public static StateTransition getStateTransitionMethod(String input) {
		if(input.startsWith("s")) {
			return new SwitchState();
		} else if (input.startsWith("r")||input.startsWith("b")||input.startsWith("c")) {
			return new MakeTransition();
		}
		return null;
		
	}
}
