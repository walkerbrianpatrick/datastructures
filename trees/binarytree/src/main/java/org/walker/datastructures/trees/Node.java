package org.walker.datastructures.trees;

public class Node <K extends Number> {
	private K key;
	private Node <K> leftChild;
	private Node <K> rightChild;
	
	public Node(K key) {
		super();
		this.key = key;
	}
	
	public Node(K key, Node <K> leftChild, Node <K> rightChild) {
		super();
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public Node <K> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node <K> leftChild) {
		this.leftChild = leftChild;
	}

	public Node <K> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node <K> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
		result = prime * result + ((rightChild == null) ? 0 : rightChild.hashCode());
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
		Node<?> other = (Node<?>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (!leftChild.equals(other.leftChild))
			return false;
		if (rightChild == null) {
			if (other.rightChild != null)
				return false;
		} else if (!rightChild.equals(other.rightChild))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}

}
