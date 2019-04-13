package org.walker.datastructures.algorithms;

/**
 * sorts in ascending order, in place on the array that is passed to it
 * @author walker
 *
 */
public class FasterHeapSort {

	private int [] heapArray;
	private int numNodes;
	
	
	public FasterHeapSort(int [] unsorted) {
		this.heapArray = unsorted;
		this.numNodes = unsorted.length;
	}

	public void sort() {
		for(int i= numNodes/2 -1; i>=0;i--) {
			trickleDown(i, heapArray[i]);
		}
	}
	
	public int [] getSortedArray() {

		for(int i =heapArray.length-1; i>-1;i-- ) {
			heapArray[i] = remove();
		}
		
		return heapArray;
	}

	public int remove() {
		int result = heapArray[0];
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
	private void trickleDown(int position, int val) {
		// check to see if there is no left child
		if (getLeftChildPosition(position) >= size()) {
			heapArray[position] = val;
			return;
		}

		int leftChild = heapArray[getLeftChildPosition(position)];
		// right child exists
		if (getRightChildPosition(position) < size()) {
			int rightChild = heapArray[getRightChildPosition(position)];
			// if the right child is larger
			if (rightChild > leftChild) {
				// is child bigger than current node?
				if (rightChild > val) {
					// swap to right child place, then recurse to right child
					heapArray[position] = rightChild;
					trickleDown(getRightChildPosition(position), val);
					return;
				} // if the left child is larger, or equal
			}
		} // otherwise, check if left child is larger
		if (leftChild > val) {
			// swap to left child place, then recurse to left child
			heapArray[position] = leftChild;
			trickleDown(getLeftChildPosition(position), val);
			return;
		}

		heapArray[position] = val;
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

	public int peek(int position) {
		return (heapArray[position]);
	}

	public int size() {
		return this.numNodes;
	}
}
