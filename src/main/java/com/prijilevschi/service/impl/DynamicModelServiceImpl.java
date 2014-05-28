package com.prijilevschi.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;
import com.prijilevschi.repository.Language;
import com.prijilevschi.service.DynamicModelService;
import com.prijilevschi.util.Validator;

@Service
public class DynamicModelServiceImpl implements DynamicModelService {
	@Autowired
	private BeanFactory beanFactory;
	
	private Language language;
	
	private Validator validator = new Validator();
	
	Set<NodeDTO> states = new HashSet<NodeDTO>();
	Set<LinkDTO> transitions = new HashSet<LinkDTO>();
	
	@Override
	public Set<NodeDTO> getNodes(List<Node> nodes) {
		NodeDTO state;
		String name;

		//Remove possible dublicates
		Set<Node> uniqueNodes = new HashSet<Node>(nodes);
		Map<String, Node> nodesMap = new HashMap<String, Node>();
		//if node with the same name have been added then change new state name
		
		for(Node node : uniqueNodes){
			
			//if(all right)
			
				
			
			if(!uniqueNodes.contains(node)){
				state = new NodeDTO();
				name = validator.validateRules(node.getName());
				
				state.setName(getCapitalizedName(name));
				state.setFinish(node.isFinish());
				states.add(state);
			}
		}
		return states;
	}
	

	@Override
	public Set<LinkDTO> getLinks(List<Link> links) {
		LinkDTO transition;
		String name;

		//Remove possible dublicates
		Set<Link> uniqueLinks = new HashSet<Link>(links);
		Map<String, Link> linksMap = new HashMap<String, Link>();
		//if link with the same name have been added then change new state name
		
		for(Link link : uniqueLinks){
			
			//if(all right)
			if(!uniqueLinks.contains(link)){
				transition = new LinkDTO();
				name = validator.validateRules(link.getName());
				
				transition.setName(getLowerCasedName(name));
				transition.setFrom(findStateByName(link.getFrom()));
				transition.setTo(findStateByName(link.getTo()));
				
				transitions.add(transition);
			}
		}
		return transitions;
	}
	
	@Override
	public String getCapitalizedName(String name) {
		String str;
		if(name.length() > 1){
			str = name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		else{
			str = name.toUpperCase();
		}
			
		return str;
	}

	@Override
	public String getLowerCasedName(String name) {
		String str;
		if(name.length() > 1){
			str = name.substring(0, 1).toLowerCase() + name.substring(1);
		}
		else{
			str = name.toLowerCase();
		}
			
		return str;
	}


	@Override
	public NodeDTO findStateByName(String name) {
		for(NodeDTO state : states)
			if(state.getName().equals(name))
				return state;
		return null;
	}
	
	@Override
	public void setLanguage(String language) {
		this.language = (Language) beanFactory.getBean(language);
		validator.setLanguage(this.language);
	}
	
	@Override
	public Language getLanguage(){
		return language;
	}

	/**
	 * Check if two states are placed at the same position
	 * @param nodes
	 */
	/*
	private void checkNames(Set<Node> nodes) {
		
		if(nodes.size() > 1){
			boolean unique;
			int j;
			for(int i = 1; i < nodes.size(); ++i){
				unique = true;
				j = i;
				while(j >= 0 && unique){
					Node current = nodes.get(i);
					Node temp = nodes.get(j);
					if(current.equals(temp))
						unique = false;
					--j;
				}
				if(unique){
					
				}
				
			}
		}
		
	}
	 */
}
