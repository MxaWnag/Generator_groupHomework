package org.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class GraphVerfier {

	private Node									entryNode;

	private Node									exitNode;

	private final Graph								graph;

	private int										maxPathLength;

	private final List<SimplePath>					primePaths			= new ArrayList<>();

	private final Map<Integer, List<SimplePath>>	simplePathsByLength	= new HashMap<>();

	public GraphVerfier(Graph graph) {
		this.graph = graph;
		for (Node node : graph.getNodesById().values()) {
			if (node.getIndegree() == 0) {
				if (entryNode != null) {
					throw new IllegalArgumentException("Graph has multiple entry points");
				}
				entryNode = node;
			} else if (node.getOutdegree() == 0) {
				if (exitNode != null) {
					throw new IllegalArgumentException("Graph has multiple exit points");
				}
				exitNode = node;
			}
		}
	}

	private void addSimplePath(SimplePath simplePath) {
		List<SimplePath> pathsWithSameLenght = simplePathsByLength.computeIfAbsent(simplePath.getLength(), ArrayList::new);
		pathsWithSameLenght.add(simplePath);
	}

	public void buildPrimePaths() {
		for (int pathLenght = 0; pathLenght < maxPathLength; pathLenght++) {
			List<SimplePath> simplePaths = simplePathsByLength.get(pathLenght);
			for (SimplePath simplePath : simplePaths) {
				if (!isIncludedInOtherPath(simplePath)) {
					primePaths.add(simplePath);
				}
			}
		}
	}

	public void buildSimplePaths() {
		//@formatter:off
		List<SimplePath> initialPaths = graph.getNodesById()
										.values()
										.stream()
										.map(node -> new SimplePath(node))
										.collect(Collectors.toList());
		//@formatter:on
		simplePathsByLength.put(0, initialPaths);
		maxPathLength = graph.getNodesById().size() + 1;
		buildSimplePaths(1);

	}

	private void buildSimplePaths(int length) {
		maxPathLength = length;
		List<SimplePath> precedingPaths = simplePathsByLength.get(length - 1);
		boolean newPathAdded = false;
		for (SimplePath rootPath : precedingPaths) {
			Node lastNode = rootPath.getLastNode();
			Node firstNode = rootPath.getFistNode();
			if (length > 1 && firstNode.equals(lastNode)) {
				continue; // avoid cycles
			}
			if (lastNode.equals(exitNode)) {
				rootPath.setTerminated(true);
				continue;
			}
			boolean isRootPathTerminated = true;
			for (Edge edge : lastNode.getOutgoingEdges()) {
				SimplePath forkingPath = new SimplePath(rootPath, edge.getTarget());
				if (forkingPath.isValid()) {
					addSimplePath(forkingPath);
					newPathAdded = true;
					isRootPathTerminated = false;
				}
			}
			rootPath.setTerminated(isRootPathTerminated);
		}
		if (newPathAdded) {
			buildSimplePaths(length + 1);
		}
	}

	public Node getEntryNode() {
		return this.entryNode;
	}

	public Node getExitNode() {
		return this.exitNode;
	}

	public Graph getGraph() {
		return this.graph;
	}

	public int getMaxPathLength() {
		return this.maxPathLength;
	}

	public List<SimplePath> getPrimePaths() {
		return this.primePaths;
	}

	public Map<Integer, List<SimplePath>> getSimplePathsByLength() {
		return this.simplePathsByLength;
	}

	private boolean isIncludedInOtherPath(SimplePath simplePath) {
		for (int pathLenght = simplePath.getLength() + 1; pathLenght < maxPathLength; pathLenght++) {
			List<SimplePath> simplePaths = simplePathsByLength.get(pathLenght);
			for (SimplePath largerPath : simplePaths) {
				if (simplePath.isIncludedIn(largerPath)) {
					return true;
				}
			}
		}
		return false;
	}

	public void printSimplePaths() {
		int totalNumberOfPaths = 0;
		for (int pathLenght = 0; pathLenght < maxPathLength; pathLenght++) {
			List<SimplePath> simplePaths = simplePathsByLength.get(pathLenght);
			int numberOfPaths = simplePaths.size();
			totalNumberOfPaths += numberOfPaths;
			System.out.println("Length " + pathLenght + " (" + numberOfPaths + " paths):");
			for (SimplePath simplePath : simplePaths) {
				System.out.println(simplePath);
			}
			System.out.println();
		}
		System.out.println("\nTotal Number of Simple Paths = " + totalNumberOfPaths);
	}

	public void setEntryNode(Node entryNode) {
		this.entryNode = entryNode;
	}

	public void setExitNode(Node exitNode) {
		this.exitNode = exitNode;
	}

	public void setMaxPathLength(int maxPathLength) {
		this.maxPathLength = maxPathLength;
	}

}
