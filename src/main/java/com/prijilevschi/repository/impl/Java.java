package com.prijilevschi.repository.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
		Collections.
		for()
		writer.println("}");
		
		writer.close();
	}
	
	public void generateConcreteState(Node node) throws FileNotFoundException, UnsupportedEncodingException {
		int indent = 0;
		PrintWriter writer = new PrintWriter(node.getName() + getFileFormat(), "UTF-8");
			writer.println("");
		writer.close();
	}

}
