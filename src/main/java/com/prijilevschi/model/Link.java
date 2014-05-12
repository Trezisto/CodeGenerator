package com.prijilevschi.model;

/**
 * Transition between states of FSM
 * @author eprijilevschi
 *
 */
public class Link {
	private String name;
	private Node from;
	private Node to;
	
	public Node getFrom() {
		return from;
	}

	public void setFrom(Node from) {
		this.from = from;
	}

	public Node getTo() {
		return to;
	}

	public void setTo(Node to) {
		this.to = to;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
