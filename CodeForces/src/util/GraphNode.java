package util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphNode {
	
	public int x;
	public int y;
	public int level;
	public Set<GraphNode> connectedNodes;
	
	public GraphNode(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.connectedNodes = new HashSet<>();
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		return x == other.x && y == other.y;
	}


	@Override
	public String toString() {
		return "{\""+this.hashCode()+"\": {"
				+ "\n\t\"x\":" + x + ", "
				+ "\n\t\"y\":" + y + ", "
				+ "\n\t\"l\":" + level + ", "
				+ "\n\t\"connectedNodes\":" + connectedNodes
				+ "\n}}";
	}
}
