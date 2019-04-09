package org.walker.datastructures.heaps;

import java.util.Arrays;


import org.walker.datastructures.trees.Node;

public class Heap <T>{
	
	// TODO: implement array type nodes as the leftchild and rightchild 
	//       objects are not needed
	private Node<T> heapArray[];
	private int numNodes;
	
	@SuppressWarnings("unchecked")
	Heap (int size){
		this.heapArray = (Node<T>[]) new Node<?> [size];
		this.numNodes = 0;
	}
	
	public void insert(Node<T> node) {
		// insert the node in the highest position in the tree
		heapArray[numNodes] = node;
		// now trickle up the nodes until it is greater than its children, 
		// but less than its parent, or it is the root node	
		trickleUp(numNodes);
		
		//increment the node count
		numNodes++;
	}
	
	// TODO: this method is inefficient due to the number of copies
	// it should be replaced with a method that holds the new node
	// in memory until the final position is identified
	private void trickleUp(int position) {
		// handle the root condition
		if(position == 0) {
			return;
		}
		int parentPosition = getParentPosition(position);
		Node<T> node = heapArray[position];
		Node<T> parent = heapArray[parentPosition];
		
		if(node.getKey() > parent.getKey()) {
			heapArray[parentPosition] = node;
			heapArray[position] = parent;
			trickleUp(parentPosition);
		}
	}

	public Node<T> remove(){
		Node<T> result = heapArray[0];
		// take the last node from the heap
		heapArray[0] = heapArray[numNodes-1];
		numNodes--;
		// trickle it down the tree until it is less than its parent
		// and greater than its children
		
		// recursive function
		// if one of this node's children is larger than this node,
		// check which of the node's children is
		// the largest, swap it with the current node
		// This must cease if the children are outside of the range of the heap
		// if they are deleted, or if the node is in the correct position
		// there is an edge case when the last node is the single child of 
		//  a parent node that might need explicit handling
		
		return result;
	}
	
	
	private int getLeftChildPosition(int position){
		return 2*position +1;
	}
	
	private int getRightChildPosition(int position){
		return 2*position + 2;
	}
	
	private int getParentPosition(int position){
		return (position-1)/2;
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
