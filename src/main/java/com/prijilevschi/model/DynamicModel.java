package com.prijilevschi.model;

import java.util.List;

public class DynamicModel {
	String language;
	List<Node> states;
	List<Link> links;
	
	public DynamicModel(String language, List<Node> states, List<Link> links) {
		this.language = language;
		this.states = states;
		this.links = links;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Node> getStates() {
		return states;
	}

	public void setStates(List<Node> states) {
		this.states = states;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
