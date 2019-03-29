package org.walker.datastructures.trees;

public class CharNode {
	private char symbol;
	private CharNode leftChild;
	private CharNode rightChild;
	
	public CharNode(char symbol) {
		super();
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public CharNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(CharNode leftChild) {
		this.leftChild = leftChild;
	}

	public CharNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(CharNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
		result = prime * result + ((rightChild == null) ? 0 : rightChild.hashCode());
		result = prime * result + symbol;
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
		CharNode other = (CharNode) obj;
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
		if (symbol != other.symbol)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CharNode [symbol=" + symbol + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
}

