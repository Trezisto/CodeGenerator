package com.prijilevschi.service;

import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;
import com.prijilevschi.repository.Language;

import java.util.List;

public interface GeneratorService {
	void init(Language language);
	void generateCode(List<Node> nodes, List<Link> links);
}
