package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.repository.Language;

public class Java implements Language {

	public String getFileFormat() {
		return ".java";
	}

	public void generateState(Set<LinkDTO> links) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("State" + getFileFormat(), "UTF-8");
		
		writer.println("public interface State {");
		for(LinkDTO link : links){
			writer.println("\tpublic void " + link.getName() + " ();");
		}
		writer.println("}");
		
		writer.close();
	}
	
	public void generateConcreteState(NodeDTO node, Set<LinkDTO> links) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(node.getName() + getFileFormat(), "UTF-8");
		
		
		writer.println("public class " + node.getName() + " {");
		for(LinkDTO link : links){
			writer.println("\tpublic void " + link.getName() + "(){");
			if(link.getFrom().equals(node)){
				writer.println("\t\t");
			}
		}
		writer.println("");
		
		writer.println("}");
		writer.close();
	}

	@Override
	public void generateStateContext(Set<NodeDTO> nodes, Set<LinkDTO> links)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("StateContext" + getFileFormat(), "UTF-8");
		writer.println("public class StateContext{");
		
		writer.println("");
		
		for(NodeDTO node : nodes)
			writer.println("\tState " + node.getName());
		
		writer.println("");
		
		writer.println("\tState state;");
		
		writer.println("\tpublic StateContext(){");
		//TODO:
		writer.println("\t}");
		
		writer.println("}");
		writer.close();
	}

}
