package com.prijilevschi.service;

import java.util.List;
import java.util.Set;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;
import com.prijilevschi.repository.Language;

/**
 * Service intended for passing and validating received information to the business model
 * @author Evgheni Prijilevschi
 *
 */
public interface DynamicModelService {
	/**
	 * Extract states of dynamic model with checking possible dublicates
	 * @param nodes Nodes from state diagram
	 */
	Set<NodeDTO> getNodes(List<Node> nodes);
	/**
	 * Extract transitions of dynamic model with checking possible dublicates
	 * @param links Transitions from state diagram
	 */
	Set<LinkDTO> getLinks(List<Link> links);
	
	/**
	 * Get name with capitalized first letter, usually used for class name 
	 * @param name State name from dynamic model
	 * @return String suitable for class name
	 */
	String getCapitalizedName(String name);
	/**
	 * Get name with lower-cased first letter, usually used for methods and variable names 
	 * @param name Transition's or state's name from dynamic model
	 * @return String suitable for methods and variable names
	 */
	String getLowerCasedName(String name);
	
	/**
	 * Find a state object from dynamic model by it's name
	 * @param name State name
	 * @return State data transfer object
	 */
	NodeDTO findStateByName(String name);
	
	/**
	 * Set appropriate programming language for code generation.
	 * Note that controller is connected with repository via dependency injection 
	 * @param language Programming language 
	 * @return 
	 */
	void setLanguage(String language);
	
	/**
	 * Get current programming language
	 * @return Polymorphic interface for generation purposes
	 */
	Language getLanguage();
}
