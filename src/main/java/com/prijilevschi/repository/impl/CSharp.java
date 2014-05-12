package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;
import com.prijilevschi.repository.Language;

public class CSharp implements Language {

	public String getFileFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateState(List<Link> lists) throws FileNotFoundException,
			UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateConcreteState(Node node, List<Link> links)
			throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateStateContext(Set<Node> nodes, Set<Link> links)
			throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

}
