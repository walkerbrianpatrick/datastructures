package org.walker.datastructures.trees;

public class BinaryTree<T> implements BinaryTreeIF<T> {
	private Node<T> root;

	@Override
	public Node<T> find(long key) {
		return walkFind(root, key);
	}

	private Node<T> walkFind(Node<T> node, long key) {
		// catch the null case
		if (node == null) {
			return node;
		} // the right case
		else if (key > node.getKey()) {
			return walkFind(node.getRightChild(), key);
		} // the left case
		else if (key < node.getKey()) {
			return walkFind(node.getLeftChild(), key);
		} // the keys are equal
		else {
			return node;
		}
	}

	@Override
	public void insert(long key, T data) {
		Node<T> child = new Node<T>(key, data);
		if (root == null) {
			root = child;
		} else {
			walkInsert(root, child);
		}
	}

	private void walkInsert(Node<T> parent, Node<T> child) {
		// right path
		if (child.getKey() > parent.getKey()) {
			// if no child exists
			if (parent.getRightChild() == null) {
				// place child to the right
				parent.setRightChild(child);
			} // else, follow tree to right child
			else {
				walkInsert(parent.getRightChild(), child);
			}
		} // left path
		else if (child.getKey() < parent.getKey()) {
			// if no child exists
			if (parent.getLeftChild() == null) {
				// place child to the right
				parent.setLeftChild(child);
			} // else, follow tree to right child
			else {
				walkInsert(parent.getLeftChild(), child);
			}
		} // key == parent key, update parent
		else {
			parent.setData(child.getData());
		}
	}

	@Override
	public void delete(long key) {
		walkDelete(root, key);
	}

	private Node<T> walkDelete(Node<T> node, long key) {
		// catch the null case
		Node<T> tempChild;
		if (node == null) {
			return node;
		} // the right case
		else if (key > node.getKey()) {
			tempChild = node.getRightChild();
			Node<T> child = walkDelete(node.getRightChild(), key);
			if (tempChild != child) {
				node.setRightChild(child);
			}
		} // the left case
		else if (key < node.getKey()) {
			tempChild = node.getLeftChild();
			Node<T> child = walkDelete(node.getLeftChild(), key);
			if (tempChild != child) {
				node.setLeftChild(child);
			}
		} // the keys are equal, self delete logic
		else {
			// if it has a left child and no right child
			if (node.getLeftChild() != null && node.getRightChild() == null) {
				node.graft(node.getLeftChild());
			} // if it has a right child, but no left child
			else if (node.getRightChild() != null && node.getLeftChild() == null) {
				node.graft(node.getRightChild());
			} // if it has both children, inorder successor is needed
			else if (node.getLeftChild() != null && node.getRightChild() != null) {
				Node<T> successor = inOrderSuccessor(node);
				node.setKey(successor.getKey());
				node.setData(successor.getData());
				walkDelete(successor, successor.getKey());
			} // if it has no children
			else {
				return null;
			}
		}
		return node;
	}

	// The in order successor is the minimum key to the right of
	// the current value
	private Node<T> inOrderSuccessor(Node<T> node) {
		return getMinKeyNode(node.getRightChild());
	}

	private Node<T> getMinKeyNode(Node<T> node) {
		if(node == null) {
			return node;
		} 
		else {
			if (node.getLeftChild()!=null) {
				return getMinKeyNode(node.getLeftChild());
			}
			return node;
		}
	}
	
	@Override
	public long findMinKey() throws Exception {
		// recursively walk to the left of the tree
		return minKey(root);
	}
	
	private long minKey(Node <T> node) throws Exception {
		// catch the null case
		if (node == null) {
			throw new Exception("The minimum value is not defined for an empty tree.");
		} else {
			// if this node has a left child, then go left
			if (node.getLeftChild()!=null) {
				return minKey(node.getLeftChild());
			} // otherwise, this node is the minimum value
			else {
				return node.getKey();
			}
		}
	}
	
	@Override
	public long findMaxKey() throws Exception {
		// recursively walk to the right of the tree
		return maxKey(root);
	}
	
	private long maxKey(Node<T> node) throws Exception {
		// catch the null case
		if (node == null) {
			throw new Exception("The maximum value is not defined for an empty tree.");
		} else {
			// if this node has a right child, the go right
			if (node.getRightChild()!=null) {
				return maxKey(node.getRightChild());
			} // otherwise, this node is the maximum value
			else {
				return node.getKey();
			}
		}
	}

	
}
