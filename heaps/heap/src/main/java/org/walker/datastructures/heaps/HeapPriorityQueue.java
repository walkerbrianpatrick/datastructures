package org.walker.datastructures.heaps;

import org.walker.datastructures.trees.Node;

public class HeapPriorityQueue <T>{
	private Heap<T> heap;
	
	public void insert(Node<T> node) {
		heap.insert(node);
	}
	
	public Node<T> remove() {
		return heap.remove();
	}
}
