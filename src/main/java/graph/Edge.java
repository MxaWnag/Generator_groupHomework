package graph;

public class Edge {

	private final Node	source;
	private final Node	target;
	public Node getSource() {
		return source;
	}

	public Node getTarget() {
		return target;
	}

	public Edge(Node source, Node target) {
		this.source = source;
		this.target = target;
		source.getOutgoingEdges().add(this);
		target.getIncomingEdges().add(this);
	}



	@Override
	public String toString() {
		return "Edge [" + source + ", " + target + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
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
		Edge other = (Edge) obj;
		if (source == null) {
			if (other.source != null) {
				return false;
			}
		} else if (!source.equals(other.source)) {
			return false;
		}
		if (target == null) {
			if (other.target != null) {
				return false;
			}
		} else if (!target.equals(other.target)) {
			return false;
		}
		return true;
	}

}
