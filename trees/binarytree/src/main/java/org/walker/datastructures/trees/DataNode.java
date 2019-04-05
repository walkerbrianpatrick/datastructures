package org.walker.datastructures.trees;

public class DataNode <K extends Number,D> extends Node<K> {
	private D data;
	public DataNode(K key, D data) {
		super(key);
		this.data = data;
	}

	public DataNode(K key, D data, Node <K> leftChild, Node <K> rightChild) {
		super(key, leftChild, rightChild);
		this.data = data;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataNode<?, ?> other = (DataNode<?, ?>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DataNode [data=" + data + "]";
	}
}
