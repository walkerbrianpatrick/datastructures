package org.walker.datastructures.algorithms;

import org.walker.datastructures.heaps.Heap;
import org.walker.datastructures.heaps.Node;

// The Naive heap sort approach is to insert all the elements of an
// array into a heap, then remove them one by one
// This has computational complexity O(Nlog(N))
public class NaiveHeapSort {
	Heap heap;
	NaiveHeapSort() {
	}
	
	public int [] sort(int [] unsorted) {
		int [] sorted = new int [unsorted.length];
		heap = new Heap(unsorted.length);
		for(int ele : unsorted) {
			heap.insert(new Node(ele));
		}
		for(int i = 0; i<unsorted.length; i++) {
			sorted[i] = heap.remove().getKey();
		}
		return sorted;
	}
}
