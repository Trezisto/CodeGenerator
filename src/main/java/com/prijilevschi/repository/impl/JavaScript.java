package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;
import com.prijilevschi.repository.Language;

@Repository
public class JavaScript implements Language {

	public String getFileFormat() {
		return ".js";
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
