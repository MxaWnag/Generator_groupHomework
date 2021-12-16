package org.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import graph.Node;

/**
 * A path from node ni to nj is simple if
 * no node appears more than once,
 * except possibly the first and last nodes.
 * <ul>
 * <li>No internal loops
 * <li>Includes all other subpaths
 * <li>A loop is a simple path
 * </ul>
 *
 *
 */
public class SimplePath {

	private final List<Node>	nodeList;
	private Boolean				isValid;
	private boolean				isTerminated;
	public final int			length;

	public SimplePath(Node startNode) {
		nodeList = new ArrayList<>();
		nodeList.add(startNode);
		length = 0;
	}

	public SimplePath(SimplePath rootPath, Node tailNode) {
		if (!rootPath.isValid()) {
			throw new IllegalArgumentException("Simple paths can be extended only from valid simple paths");
		}
		nodeList = new ArrayList<>();
		nodeList.addAll(rootPath.nodeList);
		nodeList.add(tailNode);
		length = nodeList.size() - 1;
	}

	public int getLength() {
		return length;
	}

	public Node getLastNode() {
		return nodeList.get(nodeList.size() - 1);
	}

	public boolean isValid() {
		if (isValid == null) {
			isValid = true;
			Node lastNode = getLastNode();
			for (int i = 1; i < nodeList.size() - 1; i++) {
				Node node = nodeList.get(i);
				if (node.equals(lastNode)) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;
	}

	public boolean isIncludedIn(SimplePath otherPath) {
		List<Node> otherNodes = otherPath.nodeList;
		Iterator<Node> iterator = otherNodes.iterator();
		Node fistNode = getFistNode();
		while (iterator.hasNext()) {
			Node currentNode = iterator.next();
			if (currentNode.equals(fistNode)) {
				if (length == 0) {
					return true;
				}
				return checkSequence(iterator);
			}
		}
		return false;
	}

	private boolean checkSequence(Iterator<Node> iterator) {
		int index = 1;
		while (iterator.hasNext()) {
			Node node = iterator.next();
			if (!node.equals(nodeList.get(index))) {
				// we can safely return false because each node is contained at most once,
				// so there won't be any subsequence that starts later
				return false;
			}
			index++;
			if (index > getLength()) {
				return true;
			}

		}
		return false;
	}

	public Node getFistNode() {
		return nodeList.get(0);
	}

	public boolean isTerminated() {
		return this.isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

	@Override
	public String toString() {
		String nodeListString = nodeList.toString();
		if (isTerminated) {
			nodeListString += "!";
		} else if (nodeList.size() > 1) {
			if (getFistNode().equals(getLastNode())) {
				nodeListString += "*";
			}
		}
		return nodeListString;
	}

}
