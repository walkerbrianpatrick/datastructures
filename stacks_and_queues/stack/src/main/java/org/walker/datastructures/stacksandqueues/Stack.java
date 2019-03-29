package org.walker.datastructures.stacksandqueues;

import java.util.Arrays;

public class Stack <T>{
	private T[] elements;
	private int numElements;
	private int top;

	@SuppressWarnings("unchecked")
	public Stack (int numElements) {
		this.numElements = numElements;
		elements = (T[]) new Object[numElements];
		top = -1;
	}

	public void push(T value) {
		elements[++top] = value;
	}

	public T pop() {
		return elements[top--];
	}

	public T peek() {
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
