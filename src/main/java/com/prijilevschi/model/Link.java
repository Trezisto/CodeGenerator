package com.prijilevschi.model;

/**
 * Transition between states of FSM
 * @author Evgheni Prijilevschi
 *
 */
public class Link {
	
	private String name;
	private String from;
	private String to;
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
