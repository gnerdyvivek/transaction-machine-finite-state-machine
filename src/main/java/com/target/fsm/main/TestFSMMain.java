package com.target.fsm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.target.fsm.FSM;
import com.target.fsm.exceptions.FSMNotStartedException;
import com.target.fsm.exceptions.IllegalEventInputException;
import com.target.fsm.exceptions.IllegalStateInputException;
import com.target.fsm.exceptions.UnrecognizedEventStateException;
import com.target.fsm.states.factory.StateFactory;
import com.target.fsm.utility.InputValidator;

/**
 * 
 * @author GVivek
 *
 */
public class TestFSMMain {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FSM fsm = new FSM();
		try {
			// first check FSM is started or not
			if (!fsm.isFsmStarted()) {
				String input = br.readLine().toLowerCase().trim();
				if (InputValidator.validateInput(input)) {
					if (InputValidator.validateStartOfFSM(input)) {
						fsm.setFsmStarted(true);
						System.out.println("Starting the Target Finite State Machine");
						fsm.setCurrentState(StateFactory.getStateInstance(input));
						fsm.getInitiatedState().add(fsm.getCurrentState());
					}
				}
			}

			// go over fsm if fsm is already started
			while (true) {
				String fsmInput = br.readLine().toLowerCase().trim();
				if (InputValidator.validateInput(fsmInput)) {
					fsm.makeTransition(fsmInput);
				}
				
				if(fsm.checkTerminal()) {
					break;
				}
			}
			
		} catch (IOException e) {
			System.out.println("I/O Exception Occured. Shutting down FSM");
		} catch (UnrecognizedEventStateException e) {
			System.out.println("Entered State or Input Can not be recognized. Aborting FSM");
		} catch (FSMNotStartedException e) {
			System.out.println("FSM has not started yet , plz start the FSM first.");
		} catch (IllegalEventInputException e) {
			System.out.println("Illegal input for state transition. Shutting down FSM.");
		} catch (IllegalStateInputException e) {
			System.out.println("Illegal state for state switch. Shutting down FSM.");
		} finally {
			br.close();
		}

	}
}
