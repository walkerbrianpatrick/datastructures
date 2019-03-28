package org.walker.datastructures.stacksandqueues;

import java.util.Arrays;

public class DequeueLong {
	private long[] queue;
	private int maxElements;
	private int left;
	private int right;
	private int numElements;
	
	DequeueLong(int maxElements){
		queue = new long[maxElements];
		this.maxElements = maxElements;
		left = 0;
		right = 0;
	}
	
	public void insertRight(long val) {
		queue[right] = val;
		right = right + 1 % maxElements;
		numElements++;
	}
	
	public void insertLeft(long val) {
		queue[left] = val;
		left = (left - 1 + maxElements) %  maxElements;
		numElements++;
	}
	
	public long removeRight() {
		long result = queue[right];
		right = (right - 1 + maxElements) % maxElements;
		numElements--;
		return result;
	}
	
	public long removeLeft() {
		long result = queue[left];
		left = (left + 1) % maxElements;
		numElements--;
		return result;
	}
	public long peek() {
		return queue[left];
	}
	
	public boolean isFull() {
		return numElements == maxElements;
	}
	
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public String toString() {
		return "DequeueLong [queue=" + Arrays.toString(queue) + ", maxElements=" + maxElements + ", left=" + left
				+ ", right=" + right + ", numElements=" + numElements + "]";
	}

	
}
