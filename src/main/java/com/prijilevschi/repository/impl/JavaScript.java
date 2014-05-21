package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.repository.Language;

public class JavaScript implements Language {

	public String getFileFormat() {
		return ".js";
	}

	@Override
	public void generateState(Set<LinkDTO> links) throws FileNotFoundException,
			UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateConcreteState(NodeDTO node, Set<LinkDTO> links)
			throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateStateContext(Set<NodeDTO> nodes, Set<LinkDTO> links)
			throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	

}
