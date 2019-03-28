package org.walker.datastructures.stacksandqueues;

import java.util.Arrays;

public class StackChar{

	private char[] elements;
	private int numElements;
	private int top;

	public StackChar(int numElements) {
		this.numElements = numElements;
		elements = new char[numElements];
		top = -1;
	}

	public void push(Object value) {
		elements[++top] = (char)value;
	}

	public char pop() {
		return elements[top--];
	}

	public char peek() {
		return elements[top];
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public boolean isFull() {
		return top==numElements-1;
	}

	@Override
	public String toString() {
		return "StackChar [elements=" + Arrays.toString(elements) + ", numElements=" + numElements + ", top=" + top
				+ "]";
	}
	
}