package org.walker.datastructures.trees;

public interface BinaryTreeIF<T> {

	Node<T> find(long key);

	void insert(long key, T data);

	void delete(long key);

	long findMinKey() throws Exception;

	long findMaxKey() throws Exception;

}