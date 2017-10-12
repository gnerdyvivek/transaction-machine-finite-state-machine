/**
 * 
 */
package com.target.fsm.events;

/**
 * @author GVivek
 *
 */
public enum Events {

	StateS0("s0"),
	StateS1("s1"),
	StateS2("s2"),
	StateS3("s3"),
	StateS4("s4"),
	EventR1("r1"),
	EventR2("r2"),
	CANCEL("cancel"),
	BUY("buy");
	
	
	private String inputEvents;
	
	Events(String event) {
		this.inputEvents = event;
	}
	
	public String getInputEvents() {
		return inputEvents;
	}
	
}
