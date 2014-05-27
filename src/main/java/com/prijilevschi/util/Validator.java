package com.prijilevschi.util;

import org.apache.log4j.Logger;

import com.prijilevschi.repository.Language;

/**
 * Singleton for state/transition validation. 
 * It verifies the name for rules which does not break common clauses.
 * @author Evgheni Prijilevschi
 *
 */
public class Validator {	
	private static final int MAX_SIZE = 1024;
	
	private static final Logger logger = Logger.getLogger(Validator.class);
	
	/**
	 * Variable for unnamed states indexing.
	 */
	private static int countStates = 0;
	/**
	 * Variable for unnamed transitions indexing.
	 */
	private static int countLinks = 0;
	
	private Language language;
	
	/**
	 * Validate state/transition name and put it in final form.
	 * @param Original String
	 * @return Modified String or new value if modification is not possible 
	 */
	public String validateRules(String name) {
		String temp = name.trim();
		if(name.length() > MAX_SIZE){
			logger.error("Length of String is too big!");
			return null;
		}
		//TODO: is one word
		//TODO: regexp validation - no html, js, code inside
		return temp;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
}
