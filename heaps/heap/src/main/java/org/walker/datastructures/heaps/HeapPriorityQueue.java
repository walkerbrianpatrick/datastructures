package org.walker.datastructures.heaps;


public class HeapPriorityQueue {
	private Heap heap;
	
	public void insert(Node node) {
		heap.insert(node);
	}
	
	public Node remove() {
		return heap.remove();
	}
}
