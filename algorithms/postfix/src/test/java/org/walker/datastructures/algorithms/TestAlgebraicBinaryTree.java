package org.walker.datastructures.algorithms;

import org.junit.Test;

public class TestAlgebraicBinaryTree {

	@Test
	public void loadPostfix() {
		String postfix = "ABC+*";
		AlgebraicBinaryTree abt = new AlgebraicBinaryTree(postfix);
		assert true;
	}
	
	@Test
	public void printAsPostfix() {
		String postfix = "ABC+*";
		AlgebraicBinaryTree abt = new AlgebraicBinaryTree(postfix);
		abt.visitPostOrder((node)->{
			System.out.print(node.getSymbol());
		});
		System.out.println();
		
		assert true;
	}
	
	@Test
	public void printAsPrefix() {
		String postfix = "ABC+*";
		AlgebraicBinaryTree abt = new AlgebraicBinaryTree(postfix);
		abt.visitPreOrder((node)->{
			System.out.print(node.getSymbol());
		});
		System.out.println();
		assert true;
	}
	
	@Test
	public void printAsInfix() {
		String postfix = "ABC+*";
		PostfixConverter pcon = new PostfixConverter();
		AlgebraicBinaryTree abt = new AlgebraicBinaryTree(postfix);
		// TODO: need to do something with a stateful visitor, 
		//       which is more complex than should be in a lambda
		abt.visitInOrder((node)->{
			System.out.print(node.getSymbol());
		});
		System.out.println();
		assert true;
	}
}
