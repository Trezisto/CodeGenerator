package com.prijilevschi.repository;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.util.Filter;

public interface Language {
	public String getFileFormat();
	
	public void generateState(Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException;
	public void generateConcreteState(NodeDTO state, Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException;
	public void generateStateContext(Set<NodeDTO> states, Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException;
	
	/**
	 * Check the following statements:<br/>
	 * - Name is not equal to the special language keyword.<br/>
	 * - Name doesn't begin with number and it doesn't contain there special characters.<br/>
	 * (i.e. it doesn't violate any programming language rule)<br/>
	 * 
	 * @param name State or transition name which has been already checked
	 * @return Modified String
	 */
	public String filterLanguageRules(String name);
}
