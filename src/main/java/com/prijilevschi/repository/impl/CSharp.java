package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.repository.Language;

public class CSharp implements Language {

	public String getFileFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateState(Set<LinkDTO> transitions) throws FileNotFoundException,
			UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateConcreteState(NodeDTO state, Set<LinkDTO> transitions)
			throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateStateContext(Set<NodeDTO> states, Set<LinkDTO> transitions)
			throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String validateLanguageRules(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
