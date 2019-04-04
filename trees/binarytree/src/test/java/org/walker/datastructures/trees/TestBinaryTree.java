package org.walker.datastructures.trees;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBinaryTree {
	Logger log = LoggerFactory.getLogger(TestBinaryTree.class);
	
	@Test
	public void insert() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		
		btree.insert(5, 7.0);
		btree.insert(3, 11.0);
		btree.insert(4, 42.0);
		btree.insert(8, 98.0);
		
		log.info(btree.toString());
		assert(true);
	}
	
	@Test
	public void find() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		initSimpleTree(btree);
		
		double foundVal = btree.find(4).getData();
		assert(foundVal == 42.0);
	}
	
	@Test
	public void deleteParentNode() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		initSimpleTree(btree);
		
		btree.delete(3);

		KeyValueNode node = btree.find(3);
		assert(node == null);
	}
	
	@Test 
	public void deleteChildNode() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		initSimpleTree(btree);
		
		btree.delete(4);

		KeyValueNode node = btree.find(4);
		assert(node == null);		
	}
	
	@Test
	public void deleteAndCheckGraftIntegrity() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		initSimpleTree(btree);
		
		btree.delete(3);

		KeyValueNode node = btree.find(3);
		node = btree.find(4);
		assert(node.getData() == 42.0);
	}
	
	@Test 
	public void deleteRoot() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		initSimpleTree(btree);

		btree.delete(5);
		System.out.println(btree);
		KeyValueNode node = btree.find(3);
		assert(node != null);
		node = btree.find(4);
		assert(node != null);
		node = btree.find(8);
		assert(node != null);
		node = btree.find(11);
		assert(node != null);
	}
	
	@Test
	public void visitInOrderAndPrint() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		initSimpleTree(btree);
		btree.visitTreeInOrder((node)->{
			System.out.println(((KeyValueNode)node).getKey());
		});
		assert(true);
	}
	
	@Test
	public void findMinKey() throws Exception {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		initSimpleTree(btree);
		int result = btree.findMinKey();
		assert(result == 3);
	}
	
	@Test
	public void exceptionForMinOfEmptyTree() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		
		try {
			btree.findMinKey();
		} catch (Exception e) {
			assert(true);
		}			
	}
	
	@Test
	public void findMaxKey() throws Exception {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		initSimpleTree(btree);
		int result = btree.findMaxKey();
		assert(result == 11);		
	}
	
	@Test
	public void exceptionForMaxOfEmptyTree() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();
		
		try {
			btree.findMaxKey();
		} catch (Exception e) {
			assert(true);
		}			
	}
	
	@Test
	public void deleteRightChildWithOwnSubtree() {
		KeyValueBinaryTree btree = new KeyValueBinaryTree();

		btree.insert(50, 1.0);
		btree.insert(75, 2.0);
		btree.insert(62, 3.0);
		btree.insert(87, 4.0);
		btree.insert(93, 5.0);
		btree.insert(77, 6.0);
		
		btree.delete(50);
		assert(btree.find(75) != null);
		assert(btree.find(62) != null);
		assert(btree.find(87) != null);
		assert(btree.find(93) != null);
		assert(btree.find(77) != null);
	}
	
	private void initSimpleTree(KeyValueBinaryTree btree) {
		btree.insert(5, 7.0);
		btree.insert(3, 11.0);
		btree.insert(4, 42.0);
		btree.insert(8, 98.0);
		btree.insert(11, 63.0);
		
	}
}
