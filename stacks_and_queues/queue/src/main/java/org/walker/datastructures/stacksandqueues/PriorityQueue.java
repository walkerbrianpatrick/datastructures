package org.walker.datastructures.stacksandqueues;

import java.util.Arrays;

public class PriorityQueue {
	// A priority queue is really just a sorted stack
	// where higher priority items are higher on the stack

	private long[] elements;
	private int numElements;
	private int maxElements;

	public PriorityQueue(int maxElements) {
		this.numElements = 0;
		elements = new long[maxElements];
	}

	public void push(long value) {
		// find where this item belongs in the array starting at the top
		int position = numElements;
		while (position > 0) {
			// if the value is lower priority
			if (value < elements[position - 1]) {
				// move the top item up, and check the next item
				elements[position] = elements[position - 1];
				position--;
			} else {
				// place the value and move on
				elements[position] = value;
				numElements++;
				break;
			}

		}
		// catch the initial condition and placing a value
		// at the bottom of the stack
		if (position == 0) {
			elements[position] = value;
			numElements++;
		}
	}

	public long pop() {
		return elements[numElements-- - 1];
	}

	public long peek() {
		return elements[numElements - 1];
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == maxElements;
	}

	@Override
	public String toString() {
		return "PriorityQueue [elements=" + Arrays.toString(elements) + ", numElements=" + numElements
				+ ", maxElements=" + maxElements + "]";
	}

}
