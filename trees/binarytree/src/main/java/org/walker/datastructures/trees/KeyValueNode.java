package org.walker.datastructures.trees;

public class KeyValueNode {
	private int key;
	private double data;
	private KeyValueNode leftChild;
	private KeyValueNode rightChild;
	
	public KeyValueNode(int key, double data) {
		super();
		this.key = key;
		this.data = data;
	}
	
	public KeyValueNode(int key, double data, KeyValueNode leftChild, KeyValueNode rightChild) {
		super();
		this.key = key;
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public void graft(KeyValueNode branch) {
		this.key = branch.getKey();
		this.data = branch.getData();
		this.leftChild = branch.getLeftChild();
		this.rightChild = branch.getRightChild();
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public KeyValueNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(KeyValueNode leftChild) {
		this.leftChild = leftChild;
	}

	public KeyValueNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(KeyValueNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(data);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + key;
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
		KeyValueNode other = (KeyValueNode) obj;
		if (Double.doubleToLongBits(data) != Double.doubleToLongBits(other.data))
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
