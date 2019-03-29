package org.walker.datastructures.trees;

public class BinaryTree {
	private Node root;

	public Node find(int key) {
		return walkFind(root, key);
	}

	public void insert(int key, double data) {
		Node child = new Node(key, data); 
		if (root == null) {
			root = child;
		} else {
			walkInsert(root, child);
		}
	}

	public void delete(int key) {
		// find the node first
		walkDelete(root,key);
	}

	private Node walkFind(Node node, int key) {
		// catch the null case
		if(node == null) {
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

	private Node walkDelete(Node node, int key) {
		// catch the null case
		Node tempChild;
		if(node == null) {
			return node;
		} // the right case
		else if (key > node.getKey()) {
			tempChild = node.getRightChild();
			Node child = walkDelete(node.getRightChild(), key);
			if (tempChild != child) {
				node.setRightChild(child);
			}
		} // the left case
		else if (key < node.getKey()) {
			tempChild = node.getLeftChild();
			Node child = walkDelete(node.getLeftChild(), key);
			if (tempChild != child) {
				node.setLeftChild(child);
			}
		} // the keys are equal, self delete logic 
		else {
			// if it has a left child
			if(node.getLeftChild()!= null) {
				node.graft(node.getLeftChild());
			} // if it has a right child, but no left child
			else if (node.getRightChild() != null) {
				node.graft(node.getRightChild());
			} // if it has no children
			else {
				return null;
			}
		}
		return node;
	}
	
	
	private void walkInsert(Node parent, Node child) {
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
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}
	
}
