package org.walker.datastructures.algorithms;

import org.walker.datastructures.trees.CharNode;

public class StatefulVisitor {
	private CharNode previousNode;

	public void visit(CharNode node) {
		if (previousNode == null) {
			this.previousNode = node;
			System.out.print('(');
			System.out.print(node.getSymbol());
			return;
		} else {
			
			if (PostfixConverter.isLetter(node.getSymbol())) {
				if (previousNode.getLeftChild() != node && previousNode.getRightChild() != node) {
					System.out.print('(');
				}
				System.out.print(node.getSymbol());
				if (previousNode.getRightChild() == node) {
					System.out.print(')');
				}
			} else {
				System.out.print(node.getSymbol());
			}
		}

		this.previousNode = node;
	}
}
