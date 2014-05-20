package com.prijilevschi.dto;

import com.prijilevschi.model.Node;

public class LinkDTO {
	private String name;
	private Node from;
	private Node to;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
}
