package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

	private final Set<Edge>			edges		= new HashSet<>();

	private final Map<String, Node>	nodesById	= new HashMap<>();

	public Set<Edge> getEdges() {
		return edges;
	}

	public Map<String, Node> getNodesById() {
		return this.nodesById;
	}

}
