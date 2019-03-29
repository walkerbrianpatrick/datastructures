package org.walker.datastructures.algorithms;

import java.util.function.Consumer;

import org.walker.datastructures.stacksandqueues.Stack;
import org.walker.datastructures.trees.CharNode;

public class AlgebraicBinaryTree {

	private CharNode root;
	private Stack<CharNode> cuttings;
	// pseudocode for constructing the tree
	// for each element in postfix notation
	//   if operand, make a tree of it, push it to the stack
	//   if operator,
	//     pop two operands from the stack, (A, B)
	//     create a new tree with the operator as the root
	//     attach A as right child
	//     attach B as left child
	//     push the tree back to the stack
	// when done, pop the last remaining element from the stack
	// and presto chango, you have an algebra tree
	public AlgebraicBinaryTree(String postfix) {
		cuttings = new Stack<CharNode>(postfix.length());
		PostfixConverter pcon = new PostfixConverter();
		
		for (char symbol : postfix.toCharArray()) {
			
			if (pcon.isLetter(symbol)) {
				cuttings.push(new CharNode(symbol));
			} else if (pcon.isOperator(symbol)) {
				CharNode op = new CharNode(symbol);
				// attach A 
				op.setRightChild(cuttings.pop());
				// attach B
				op.setLeftChild(cuttings.pop());
				cuttings.push(op);
			}
		}
		// presto chango
		root = cuttings.pop();
	}
	
	
	public void visitInOrder(Consumer <CharNode> visitor) {
		inOrder(root,visitor);
	}
	private void inOrder(CharNode node, Consumer <CharNode> visitor) {
		if(node == null) {
			return;
		} else {
			inOrder(node.getLeftChild(), visitor);
			visitor.accept(node);
			inOrder(node.getRightChild(), visitor);
		}
	}
	
	public void visitPreOrder(Consumer <CharNode> visitor) {
		preOrder(root,visitor);
	}
	private void preOrder(CharNode node, Consumer <CharNode> visitor) {
		if(node == null) {
			return;
		} else {
			visitor.accept(node);
			preOrder(node.getLeftChild(), visitor);
			preOrder(node.getRightChild(), visitor);
		}
	}
	
	public void visitPostOrder(Consumer <CharNode> visitor) {
		postOrder(root,visitor);
	}
	
	private void postOrder(CharNode node, Consumer <CharNode> visitor) {
		if(node == null) {
			return;
		} else {
			postOrder(node.getLeftChild(), visitor);
			postOrder(node.getRightChild(), visitor);
			visitor.accept(node);
		}
	}
	
}
