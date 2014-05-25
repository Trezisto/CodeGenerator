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
	
	@Override
	public void generateCode(Set<NodeDTO> states, Set<LinkDTO> transitions) {
		try {
			language.generateState(transitions);
			for(NodeDTO state : states){
				language.generateConcreteState(state, transitions);
			}
			language.generateStateContext(states, transitions);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
