package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.repository.Language;
import com.prijilevschi.service.DynamicModelService;
import com.prijilevschi.util.Keywords;
import com.prijilevschi.util.Validator;

public class Java implements Language {
	
	@Autowired
	DynamicModelService dynamicModelService;

	public String getFileFormat() {
		return ".java";
	}

	public void generateState(Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("State" + getFileFormat(), "UTF-8");
		
		writer.println("public interface State {");
		for(LinkDTO link : transitions){
			writer.println("\tpublic void " + link.getName() + " ();");
		}
		writer.println("}");
		
		writer.close();
	}
	
	public void generateConcreteState(NodeDTO state, Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(state.getName() + getFileFormat(), "UTF-8");
		
		String capitalizedName = state.getName().substring(0, 1) + state.getName().substring(1);
		writer.println("public class " + capitalizedName + " {");
		for(LinkDTO link : transitions){
			writer.println("\tpublic void " + link.getName() + "(){");
			if(link.getFrom().equals(state)){
				writer.println("\t\t");
			}
		}
		writer.println("");
		
		writer.println("}");
		writer.close();
	}

	@Override
	public void generateStateContext(Set<NodeDTO> states, Set<LinkDTO> transitions)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("StateContext" + getFileFormat(), "UTF-8");
		writer.println("public class StateContext{");
		
		writer.println("");
		
		for(NodeDTO state : states)
			writer.println("\tState " + state.getName());
		
		writer.println("");
		
		writer.println("\tState state;"); 
		
		writer.println("");
		
		//default constructor
		writer.println("\tpublic StateContext(){");
		for(NodeDTO state : states){
			writer.println("\t\t" + dynamicModelService.getLowerCasedName(state.getName()) + " = new " + state.getName() + "();");
		}
		writer.println("\t}");
		
		//getters for states
		writer.println("\tpublic State getState(){");
		writer.println("\t\treturn state;");
		writer.println("\t}");
		
		//methods as reactions between states
		for(LinkDTO transition : transitions){
			writer.println("\tpublic void " + transition.getName() + "(){");
			writer.println("\t\tstate." + transition.getName() + "();");
			writer.println("\t}\n");
		}
		
		writer.println("");
		
		writer.println("}"); //close class
		writer.close();
	}
	
	@Override
	public String validateLanguageRules(String name){
		return name;		
	}

}
