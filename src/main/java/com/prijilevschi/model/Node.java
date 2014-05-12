package com.prijilevschi.model;

/**
 * State of FSM
 * @author eprijilevschi
 *
 */
public class Node {
	private String name;
	private boolean finish;

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
