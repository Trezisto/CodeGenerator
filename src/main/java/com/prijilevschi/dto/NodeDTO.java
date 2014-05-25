package com.prijilevschi.dto;

public class NodeDTO {
	/**
	 * Capitalized validated state name;
	 */
	private String name;
	/**
	 * Is State finite or not;
	 */
	private boolean finish;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
}
