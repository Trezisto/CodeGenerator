package com.prijilevschi.repository;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;

public interface Language {
	public String getFileFormat();
	
	public void generateState(Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException;
	public void generateConcreteState(NodeDTO state, Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException;
	public void generateStateContext(Set<NodeDTO> states, Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException;
	
	/**
	 * Check the following statements:
	 * - State or transition name is not empty.
	 * - Name is not equal to the special language keyword.
	 * - Name doesn't begin with number and it doesn't contain there special characters.
	 * (i.e. it doesn't violate any programming language rule)
	 *  //There are not two states with the same name. (NOT HERE)
	 * 
	 * @param name State or transition name which has been already trimmed and lower-cased
	 * @return 
	 */
	public boolean isValidName(String name); 
}
