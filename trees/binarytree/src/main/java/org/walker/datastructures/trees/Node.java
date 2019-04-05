package org.walker.datastructures.trees;

public class Node <T> {
	private long key;
	private T data;
	private Node <T> leftChild;
	private Node <T> rightChild;
	
	public Node(long key, T data) {
		super();
		this.key = key;
		this.data = data;
	}
	
	public Node(long key,T data, Node <T> leftChild, Node <T> rightChild) {
		super();
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.data = data;
	}
	
	public void graft(Node <T> node) {
		this.key = node.getKey();
		this.data = node.getData();
		this.leftChild = node.getLeftChild();
		this.rightChild = node.getRightChild();
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public Node <T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node <T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node <T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node <T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + (int) (key ^ (key >>> 32));
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (key != other.key)
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
		return "Node [key=" + key + ", data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}


}
