package com.prijilevschi.service.impl;

import java.util.HashSet;
import java.util.List;
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

@Service
public class DynamicModelServiceImpl implements DynamicModelService {
	@Autowired
	BeanFactory beanFactory;
	
	Language language;
	
	@Override
	public Set<NodeDTO> getNodes(List<Node> nodes) {
		Set<NodeDTO> states = new HashSet<NodeDTO>();
		NodeDTO state;		

		//Remove possible dublicates
		Set<Node> uniqueNodes = new HashSet<Node>(nodes);
			
		
		for(Node node : nodes){
			
			//if(all right)
			state = new NodeDTO();
			
			if(language.isValidName(node.getName())){
				
			}
			state.setName(getCapitalizedName(node.getName()));
			state.setFinish(node.isFinish());
			states.add(state);
			if(!states.contains(node)){
				//states.add(nodes.get(0));
			}
		}
		return null;
	}
	

	@Override
	public Set<LinkDTO> getLinks(List<Link> links) {
		// TODO Auto-generated method stub
		return null;
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
	public void setLanguage(String language) {
		this.language = (Language) beanFactory.getBean(language);
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
