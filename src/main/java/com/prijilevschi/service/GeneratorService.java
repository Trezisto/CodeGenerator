package com.prijilevschi.service;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.repository.Language;

import java.util.Set;

/**
 * Service layer responsible for code generation
 * @author Evgheni Prijilevschi
 *
 */
public interface GeneratorService {
	/**
	 * General method where generation launches. 
	 * It generates State Context, State Interface and Concrete States.
	 * @param states Valid states prepared for generation step.
	 * @param transitions Valid states ready for code generation.
	 */
	void generateCode(Set<NodeDTO> states, Set<LinkDTO> transitions);
	
	Language getLanguage();
	void setLanguage(Language language);
}
