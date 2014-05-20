package com.prijilevschi.service;

import java.util.List;
import java.util.Set;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.model.Link;
import com.prijilevschi.model.Node;

public interface DynamicModelService {
	/**
	 * Extract states of dynamic model with checking possible dublicates
	 * @param nodes Nodes from state diagram
	 */
	Set<NodeDTO> getNodes(List<Node> nodes);
	/**
	 * Extract transitions of dynamic model with checking possible dublicates
	 * @param links Transitions from state diagram
	 */
	Set<LinkDTO> getLinks(List<Link> links);
}
