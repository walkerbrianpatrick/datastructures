package org.walker.datastructures.heaps;

import java.util.Arrays;

public class Heap {

	// TODO: implement array type nodes as the leftchild and rightchild
	// objects are not needed
	private Node [] heapArray;
	private int numNodes;

	public Heap(int size) {
		this.heapArray = new Node[size];
		this.numNodes = 0;
	}

	public void insert(Node node) {
		// insert the node in the highest position in the tree
		// then trickle up the nodes until it is greater than its children,
		// but less than its parent, or it is the root node
		trickleUp(numNodes, node);
		// heapArray[position] = node;
		// increment the node count
		numNodes++;
	}

	/**
	 * Check if the current node is larger than its parent if so, switch them
	 * 
	 * @param position
	 */
	private void trickleUp(int position, Node startingNode) {
		// handle the root condition
		if (position == 0) {
			heapArray[0] = startingNode;
			return;
		}
		int parentPosition = getParentPosition(position);

		Node parent = heapArray[parentPosition];

		if (startingNode.getKey() > parent.getKey()) {
			heapArray[position] = parent;
			trickleUp(parentPosition, startingNode);
		} else {
			heapArray[position] = startingNode;
		}
	}

	public Node remove() {
		Node result = heapArray[0];
		// take the last node from the heap
		heapArray[0] = heapArray[numNodes - 1];
		numNodes--;
		// trickle it down the tree until it is less than its parent
		// and greater than its children
		trickleDown(0, heapArray[0]);
		return result;
	}

	/**
	 * check the current node, see if it is smaller than one of its children if so,
	 * switch them
	 * 
	 * @param position
	 */
	private void trickleDown(int position, Node startingNode) {
		// check to see if there is no left child
		if (getLeftChildPosition(position) >= size()) {
			heapArray[position] = startingNode;
			return;
		}

		Node leftChild = heapArray[getLeftChildPosition(position)];
		// right child exists
		if (getRightChildPosition(position) < size()) {
			Node rightChild = heapArray[getRightChildPosition(position)];
			// if the right child is larger
			if (rightChild.getKey() > leftChild.getKey()) {
				// is child bigger than current node?
				if (rightChild.getKey() > startingNode.getKey()) {
					// swap to right child place, then recurse to right child
					heapArray[position] = rightChild;
					trickleDown(getRightChildPosition(position), startingNode);
					return;
				} // if the left child is larger, or equal
			}
		} // otherwise, check if left child is larger
		if (leftChild.getKey() > startingNode.getKey()) {
			// swap to left child place, then recurse to left child
			heapArray[position] = leftChild;
			trickleDown(getLeftChildPosition(position), startingNode);
			return;
		}

		heapArray[position] = startingNode;
	}

	public int getLeftChildPosition(int position) {
		return 2 * position + 1;
	}

	public int getRightChildPosition(int position) {
		return 2 * position + 2;
	}

	public int getParentPosition(int position) {
		return (position - 1) / 2;
	}

	public Node peek(int position) {
		return (heapArray[position]);
	}

	public void change(int position, int newKey) {
		int oldKey = heapArray[position].getKey();
		heapArray[position].setKey(newKey);
		if (oldKey < newKey) {
			trickleUp(position, heapArray[position]);
		} else {
			trickleDown(position, heapArray[position]);
		}
	}

	public int size() {
		return this.numNodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(heapArray);
		result = prime * result + numNodes;
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
		Heap other = (Heap) obj;
		if (!Arrays.equals(heapArray, other.heapArray))
			return false;
		if (numNodes != other.numNodes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Heap [heapArray=" + Arrays.toString(heapArray) + ", numNodes=" + numNodes + "]";
	}
}
