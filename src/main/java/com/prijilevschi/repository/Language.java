package com.prijilevschi.repository;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;

public interface Language {
	public String getFileFormat();
	
	public void generateState(Set<LinkDTO> links) throws FileNotFoundException, UnsupportedEncodingException;
	public void generateConcreteState(NodeDTO node, Set<LinkDTO> links) throws FileNotFoundException, UnsupportedEncodingException;
	public void generateStateContext(Set<NodeDTO> nodes, Set<LinkDTO> links) throws FileNotFoundException, UnsupportedEncodingException;
}
