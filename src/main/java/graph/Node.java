package graph;

import java.util.HashSet;
import java.util.Set;

public class Node {

	private final Set<Edge>	incomingEdges	= new HashSet<>();

	private final String	number;

	private final Set<Edge>	outgoingEdges	= new HashSet<>();

	public Node(String number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Node other = (Node) obj;
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		return true;
	}

	public Set<Edge> getIncomingEdges() {
		return this.incomingEdges;
	}

	public int getIndegree() {
		return this.incomingEdges.size();
	}

	public String getNumber() {
		return number;
	}

	public int getOutdegree() {
		return this.outgoingEdges.size();
	}

	public Set<Edge> getOutgoingEdges() {
		return this.outgoingEdges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return number;
	}

}
