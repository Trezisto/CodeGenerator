package com.prijilevschi.dto;

public class LinkDTO {
	/**
	 *  Non-capitalized validated transition name;
	 */
	private String name;
	/**
	 *  State where transition begins;
	 */
	private NodeDTO from;
	/**
	 *  State where transition ends;
	 */
	private NodeDTO to;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NodeDTO getFrom() {
		return from;
	}
	public void setFrom(NodeDTO from) {
		this.from = from;
	}
	public NodeDTO getTo() {
		return to;
	}
	public void setTo(NodeDTO to) {
		this.to = to;
	}
}
