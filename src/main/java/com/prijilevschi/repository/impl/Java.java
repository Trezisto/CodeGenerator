package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.repository.Language;
import com.prijilevschi.service.DynamicModelService;

@Repository("Java")
public class Java implements Language {
	
	VelocityEngine engine;
	
	@Autowired
	DynamicModelService dynamicModelService;

	public String getFileFormat() {
		return ".java";
	}
	
	public Java(){
		engine = new VelocityEngine();
		engine.init();
	}
	
	public void generateState(Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException {
		List<String> names = new ArrayList<String>();
		
		for(LinkDTO transition : transitions)
			names.add(transition.getName());
		
		Template template = Velocity.getTemplate("./src/main/resources/templates/state/java.vm");
		VelocityContext context = new VelocityContext();
		context.put("transitions", names);
		
		PrintWriter writer = new PrintWriter("files/State" + getFileFormat(), "UTF-8");
		template.merge(context, writer);
		
		writer.close();
	}
	
	public void generateConcreteState(NodeDTO state, Set<LinkDTO> transitions) throws FileNotFoundException, UnsupportedEncodingException {
		List<String> names = new ArrayList<String>();
		
		for(LinkDTO transition : transitions)
			names.add(transition.getName());
		
		Template template = Velocity.getTemplate("./src/main/resources/templates/concrete_state/java.vm");
		VelocityContext context = new VelocityContext();
		context.put("transitions", names);
		
		PrintWriter writer = new PrintWriter("files/" + state.getName() + getFileFormat(), "UTF-8");
		template.merge(context, writer);
		
		writer.close();
	}

	@Override
	public void generateStateContext(Set<NodeDTO> states, Set<LinkDTO> transitions)
			throws FileNotFoundException, UnsupportedEncodingException {
		List<String> transitionNames = new ArrayList<String>();
		List<String> stateNames = new ArrayList<String>();
		
		for(LinkDTO transition : transitions)
			transitionNames.add(transition.getName());
		for(NodeDTO state : states)
			stateNames.add(state.getName().substring(0, 1).toLowerCase() + state.getName().substring(1));
		
		Template template = Velocity.getTemplate("./src/main/resources/templates/concrete_state/java.vm");
		VelocityContext context = new VelocityContext();
		context.put("transitions", transitionNames);
		context.put("states", stateNames);
		
		PrintWriter writer = new PrintWriter("files/Context" + getFileFormat(), "UTF-8");
		template.merge(context, writer);
		
		writer.close();
	}
	
	@Override
	public String filterLanguageRules(String name){
		return name;		
	}

}
