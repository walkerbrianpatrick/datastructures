package org.walker.datastructures.heaps;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.walker.datastructures.trees.Node;

public class TestHeap {
	Logger log = LoggerFactory.getLogger(TestHeap.class);
	
	@Test
	public void insert() {
		Heap<Double> heap = new Heap<Double>(10);
		heap.insert(new Node<Double>(90, 1.0));

		assert (heap.size() == 1);
	}

	@Test
	public void insertTooMany() {
		Heap<Double> heap = new Heap<Double>(10);

		try {
			for (int i = 0; i < 11; i++) {
				heap.insert(new Node<Double>(90, 1.0));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			assert true;
		}
	}
	
	@Test
	public void insertAndCheckTrickle() {
		Heap<Double> heap = new Heap<Double>(10);
		heap.insert(new Node<Double>(10, 1.0));
		heap.insert(new Node<Double>(90, 1.0));
		log.info(heap.toString());
	}

	
	
}
