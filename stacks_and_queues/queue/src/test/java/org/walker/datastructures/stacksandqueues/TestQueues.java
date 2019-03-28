package org.walker.datastructures.stacksandqueues;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestQueues {
	Logger log = LoggerFactory.getLogger(TestQueues.class);
	
	@Test
	public void testFillQueue() {
		QueueLong queue = new QueueLong(5);
		long val = 0;
		while(!queue.isFull()) {
			queue.insert(val++);
		}
		assert true;
	}
	
	@Test
	public void testInsertAndRemove() {
		QueueLong queue = new QueueLong(5);
		long val = 0;
		// add values until the queue is full
		while(!queue.isFull()) {
			queue.insert(val++);
		}
		val = 0;
		// remove values and compare them to the original values
		while(!queue.isEmpty()) {
			assert(val == queue.remove());
			val++;
		}
	}
	
	@Test
	public void testInsertRightDequeue() {
		DequeueLong queue = new DequeueLong(5);
		long val = 0;
		while(!queue.isFull()) {
			queue.insertRight(val++);
		}
		assert true;
	}
	
	@Test
	public void testInsertLeftDequeue() {
		DequeueLong queue = new DequeueLong(5);
		long val = 0;
		while(!queue.isFull()) {
			queue.insertLeft(val++);
		}
		assert true;
	}
	
	@Test
	public void testInsertLeftAndRemove() {
		DequeueLong queue = new DequeueLong(5);
		long val = 0;
		// add values until the queue is full
		while(!queue.isFull()) {
			queue.insertLeft(val++);
		}
		val = 0;
		// remove values and compare them to the original values
		while(!queue.isEmpty()) {
			assert(val == queue.removeRight());
			val++;
		}
	}
	
	@Test
	public void testInsertRightAndRemoveLeft() {
		DequeueLong queue = new DequeueLong(5);
		long val = 0;
		// add values until the queue is full
		while(!queue.isFull()) {
			queue.insertRight(val++);
		}
		val = 0;
		// remove values and compare them to the original values
		while(!queue.isEmpty()) {
			assert(val == queue.removeLeft());
			val++;
		}
	}
	
	@Test
	public void testPriorityQueue() {
		PriorityQueue pqueue = new PriorityQueue(5);
		pqueue.push(3);
		pqueue.push(4);
		pqueue.push(5);
		pqueue.push(1);
		pqueue.push(2);
		log.info(pqueue.toString());
		long val = 5L;
		// check that popping from the queue returns values in sorted order
		while(!pqueue.isEmpty()) {
			assert(val--==pqueue.pop());
		}
	}
	
	@Test
	public void testFillPriorityQueue() {
		PriorityQueue pqueue = new PriorityQueue(5);
		long val = 5L;
		while(!pqueue.isFull()) {
			pqueue.push(val--);
		}
		// if we didn't throw an exception the conditions worked
		assert(true);
	}	
	
}
