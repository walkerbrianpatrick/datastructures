package org.walker.datastructures.heaps;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestHeap {
	Logger log = LoggerFactory.getLogger(TestHeap.class);

	@Test
	public void insert() {
		Heap heap = new Heap(10);
		heap.insert(new Node(90));

		assert (heap.size() == 1);
	}

	@Test
	public void insertTooMany() {
		Heap heap = new Heap(10);

		try {
			for (int i = 0; i < 11; i++) {
				heap.insert(new Node(90));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			assert true;
		}
	}

	@Test
	public void insertAndCheckTrickle() {
		Heap heap = new Heap(10);
		heap.insert(new Node(10));
		heap.insert(new Node(90));
		heap.insert(new Node(100));
		heap.insert(new Node(120));
		heap.insert(new Node(150));
		assert (checkAllChildrenLess(heap, 0));
	}

	@Test
	public void heapPriorityCheck() {
		Heap heap = new Heap(100);

		IntStream ints = new Random().ints(100L);
		ints.forEach(i -> heap.insert(new Node(i)));

		assert (checkAllChildrenLess(heap, 0));
	}

	@Test
	public void removalPreservesHeapPriority() {
		Heap heap = new Heap(100);

		IntStream ints = new Random().ints(100L);
		ints.forEach(i -> heap.insert(new Node(i)));

		for (int i = 0; i < 100; i++) {
			heap.remove();
			if(!checkAllChildrenLess(heap, 0)) {
				System.out.println(heap.toString());
				assert(false);
			} else {
				assert(true);
			}
		}
	}

	@Test
	public void changeLarger() {
		
		Heap heap = new Heap(10);
		heap.insert(new Node(10));
		heap.insert(new Node(90));
		heap.insert(new Node(100));
		heap.insert(new Node(120));
		heap.insert(new Node(150));
		
		heap.change(4, 199);
		Node changedNode = heap.remove();
		assert(changedNode.getKey() == 199);
		
	}
	
	@Test
	public void changeSmaller() {
		Heap heap = new Heap(10);
		heap.insert(new Node(10));
		heap.insert(new Node(90));
		heap.insert(new Node(100));
		heap.insert(new Node(120));
		heap.insert(new Node(150));
		
		heap.change(0, 9);
		Node changedNode = heap.remove();
		assert(changedNode.getKey() == 120);
		
	}
	
	
	private boolean checkAllChildrenLess(Heap heap, int position) {
		boolean result = true;
		// if we get to the end of the heap, return true because
		// anything is greater than nothing
		if (position > heap.size()) {
			return result;
		} // otherwise
		int nodeValue = heap.peek(position).getKey();
		int rightChildPosition = heap.getRightChildPosition(position);
		int leftChildPosition = heap.getLeftChildPosition(position);
		// greater than right child, and all children share property
		if (rightChildPosition < heap.size()) {
			result &= nodeValue > heap.peek(rightChildPosition).getKey();
			if (result!=true) {
				log.error("Node: "+Integer.toString(position)+
						" is less than right Node: "+ Integer.toString(rightChildPosition));
				log.error(Integer.toString(heap.peek(position).getKey())+ " " +
						Integer.toString(heap.peek(rightChildPosition).getKey()));
				
			}
			result &= checkAllChildrenLess(heap, rightChildPosition);
		}
		// greater than left child, and all children share property
		if (leftChildPosition < heap.size()) {
			result &= nodeValue > heap.peek(leftChildPosition).getKey();
			if (result!=true) {
				log.error("Node: "+Integer.toString(position)+
						" is less than left Node: "+ Integer.toString(leftChildPosition));
				log.error(Integer.toString(heap.peek(position).getKey())+ " " +
						Integer.toString(heap.peek(leftChildPosition).getKey()));
			}
			result &= checkAllChildrenLess(heap, leftChildPosition);
			
		}
		return result;
	}

	
}
