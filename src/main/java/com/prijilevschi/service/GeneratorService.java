package com.prijilevschi.service;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.repository.Language;

import java.util.Set;

public interface GeneratorService {
	void init(Language language);
	void generateCode(Set<NodeDTO> nodes, Set<LinkDTO> links);
}
