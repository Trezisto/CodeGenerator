package com.prijilevschi.service.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;
import com.prijilevschi.repository.Language;
import com.prijilevschi.service.GeneratorService;

@Service
public class GeneratorServiceImpl implements GeneratorService{
	@Autowired
	Language language;
	
	public void init(Language language){
		this.language = language;
	}
	
	public void generateCode(List<Node> nodes, List<Link> links) {
		try {
			language.generateState(links);
			for(Node node : nodes){
				language.generateConcreteState(node);
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
