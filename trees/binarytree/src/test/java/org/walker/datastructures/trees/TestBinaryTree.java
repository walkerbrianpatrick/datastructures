package org.walker.datastructures.trees;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBinaryTree {
	Logger log = LoggerFactory.getLogger(TestBinaryTree.class);
	
	@Test
	public void insert() {
		BinaryTree btree = new BinaryTree();
		
		btree.insert(5, 7.0);
		btree.insert(3, 11.0);
		btree.insert(4, 42.0);
		btree.insert(8, 98.0);
		
		log.info(btree.toString());
		assert(true);
	}
	
	@Test
	public void find() {
		BinaryTree btree = new BinaryTree();
		initSimpleTree(btree);
		
		double foundVal = btree.find(4).getData();
		assert(foundVal == 42.0);
	}
	
	@Test
	public void deleteParentNode() {
		BinaryTree btree = new BinaryTree();
		initSimpleTree(btree);
		
		btree.delete(3);

		Node node = btree.find(3);
		assert(node == null);
	}
	
	@Test 
	public void deleteChildNode() {
		BinaryTree btree = new BinaryTree();
		initSimpleTree(btree);
		
		btree.delete(4);

		Node node = btree.find(4);
		assert(node == null);		
	}
	
	@Test
	public void deleteAndCheckGraftIntegrity() {
		BinaryTree btree = new BinaryTree();
		initSimpleTree(btree);
		
		btree.delete(3);

		Node node = btree.find(3);
		node = btree.find(4);
		assert(node.getData() == 42.0);
	}
	
	@Test 
	public void deleteRoot() {
		BinaryTree btree = new BinaryTree();
		initSimpleTree(btree);
		
		btree.delete(5);

		Node node = btree.find(3);
		node = btree.find(4);
		assert(node.getData() == 42.0);		
	}
	
	@Test
	public void visitInOrderAndPrint() {
		BinaryTree btree = new BinaryTree();
		initSimpleTree(btree);
		btree.visitTreeInOrder((node)->{
			System.out.println(((Node)node).getKey());
		});
		assert(true);
	}
	
	private void initSimpleTree(BinaryTree btree) {
		btree.insert(5, 7.0);
		btree.insert(3, 11.0);
		btree.insert(4, 42.0);
		btree.insert(8, 98.0);
		
	}
}
