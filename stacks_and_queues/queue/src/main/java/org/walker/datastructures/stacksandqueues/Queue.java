package org.walker.datastructures.stacksandqueues;

public class Queue <T>{

	private T[] queue;
	private int maxElements;
	private int front;
	private int back;
	private int numElements;
	
	@SuppressWarnings("unchecked")
	public Queue(int maxElements){
		this.maxElements = maxElements;
		queue = (T[]) new Object[maxElements];
		front = 0;
		back = 0;
	}
	
	public void insert(T val) {
		queue[back] = val;
		back = back + 1 % maxElements;
		numElements++;
	}
	
	public T remove() {
		T result = queue[front];
		front = (front + 1) % maxElements;
		numElements--;
		return result;
	}
	public T peek() {
		return queue[front];
	}
	
	public boolean isFull() {
		return numElements == maxElements;
	}
	
	public boolean isEmpty() {
		return numElements == 0;
	}
	
	public void printQueue() {
		for (int i = 0; i< numElements; i++) {
			System.out.print(queue[i]);
		}
		System.out.println();
	}
}
