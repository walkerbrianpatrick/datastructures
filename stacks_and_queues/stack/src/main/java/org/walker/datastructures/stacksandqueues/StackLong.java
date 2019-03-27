package org.walker.datastructures.stacksandqueues;

public class StackLong {

	private long[] elements;
	private int numElements;
	private int top;

	public StackLong(int numElements) {
		this.numElements = numElements;
		elements = new long[numElements];
		top = -1;
	}
	public void push(Object value) {
		elements[++top] = (Long)value;
	}
	public long pop() {
		return elements[top--];
	}
	public long peek() {
		return elements[top];
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public boolean isFull() {
		return top==numElements-1;
	}
}
