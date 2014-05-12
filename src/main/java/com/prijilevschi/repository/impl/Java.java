package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;
import com.prijilevschi.repository.Language;

@Repository
public class Java implements Language {

	public String getFileFormat() {
		return ".java";
	}

	public void generateState(List<Link> lists) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("State" + getFileFormat(), "UTF-8");
		
		writer.println("public interface State {");
		Set<Link> linkSet = new HashSet<Link>(lists);
		for(Link link : linkSet){
			writer.println("\tpublic void " + link.getName() + " ();");
		}
		writer.println("}");
		
		writer.close();
	}
	
	public void generateConcreteState(Node node, List<Link> links) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(node.getName() + getFileFormat(), "UTF-8");
		
		
		writer.println("public class " + node.getName() + " {");
		for(Link link : links){
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
	public void generateStateContext(Set<Node> nodes, Set<Link> links)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("StateContext" + getFileFormat(), "UTF-8");
		writer.println("public class StateContext{");
		
		writer.println("");
		
		for(Node node : nodes)
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
