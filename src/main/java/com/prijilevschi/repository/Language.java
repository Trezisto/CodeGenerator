package com.prijilevschi.repository;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;

public interface Language {
	public String getFileFormat();
	
	public void generateState(List<Link> lists) throws FileNotFoundException, UnsupportedEncodingException;
	public void generateConcreteState(Node node) throws FileNotFoundException, UnsupportedEncodingException;
}
