package org.walker.datastructures.stacksandqueues;

import java.util.Arrays;

public class QueueLong {
	
	private long[] queue;
	private int maxElements;
	private int front;
	private int back;
	private int numElements;
	
	QueueLong(int maxElements){
		queue = new long[maxElements];
		this.maxElements = maxElements;
		front = 0;
		back = 0;
	}
	
	public void insert(long val) {
		queue[back] = val;
		back = back + 1 % maxElements;
		numElements++;
	}
	
	public long remove() {
		long result = queue[front];
		front = (front + 1) % maxElements;
		numElements--;
		return result;
	}
	public long peek() {
		return queue[front];
	}
	
	public boolean isFull() {
		return numElements == maxElements;
	}
	
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public String toString() {
		return "QueueLong [queue=" + Arrays.toString(queue) + ", maxElements=" + maxElements + ", front=" + front
				+ ", back=" + back + "]";
	}
	
	
}
