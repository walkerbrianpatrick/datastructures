package org.walker.datastructures;

import java.util.Arrays;

public class Vertex {
	private char label;
	private boolean visited;
	
	public Vertex(char label) {
		this.label = label;
		this.visited = false;
	}

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + label;
		result = prime * result + (visited ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (label != other.label)
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [label=" + label + ", visited=" + visited + "]";
	}
}
