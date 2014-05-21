package com.prijilevschi.service.impl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.repository.Language;
import com.prijilevschi.service.GeneratorService;

@Service
public class GeneratorServiceImpl implements GeneratorService{
	private Language language;
	
	public void init(Language language){
		this.language = language;
	}
	
	public void generateCode(Set<NodeDTO> nodes, Set<LinkDTO> links) {
		try {
			language.generateState(links);
			for(NodeDTO node : nodes){
				language.generateConcreteState(node, links);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
