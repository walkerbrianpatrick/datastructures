package org.walker.datastructures.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.walker.datastructures.stacksandqueues.StackChar;

public class PostfixConverter {
	Logger log = LoggerFactory.getLogger(PostfixConverter.class);
	private String operators;
	
	PostfixConverter() {
		operators = "()*/+-";
	}

	public String parseInfix(String infix) {
		String postfix = "";
		// allocate a bigger stack than you need
		StackChar stack = new StackChar(infix.length());
		char oldItem;
		for (char item : infix.toCharArray()) {
			// if operand, write it to output
			if (isLetter(item)) {
				postfix += item;
			}
			// else if open paren, push to stack
			else if (item == '(') {
				stack.push(item);
			}
			// else if close paren
			else if (item == ')') {
				// while stack not empty pop from stack
				while (!stack.isEmpty()) {
					oldItem = stack.pop();
					// if open paren break
					if (oldItem == '(') {
						break;
					}
					// else, write to output
					postfix += oldItem;
				}
			}
			// else if operator (newOperator)
			else if (isOperator(item)) {
				// if stack empty push
				if (stack.isEmpty()) {
					stack.push(item);
				} else {
					// while stack not empty, pop from stack (item)
					while (!stack.isEmpty()) {
						oldItem = stack.pop();
						// if item is open paren, push item, break
						if (oldItem == '(') {
							stack.push(oldItem);
							break;
						}
						// else if item is operator (oldOperator)
						else if (isOperator(oldItem)) {
							// if oldOperator < newOperator push oldOperator, break
							if(leftOperatorBeforeRight(item, oldItem)) {
								stack.push(oldItem);
								break;
							}
							// else write oldOperator
							else {
								postfix += oldItem;
							}
						}
					}
					// push newOperator
					stack.push(item);
				}
			}
		} // run out of items
		
		// while stack not empty, pop item
		while(!stack.isEmpty()) {
			oldItem = stack.pop();
			// write it to output
			postfix += oldItem;
		}
		return postfix;
	}

	private boolean isOperator(char in) {
		boolean result = false;
		for (int i = 0; i < operators.length(); i++) {
			if (in == operators.charAt(i)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private boolean leftOperatorBeforeRight(char left, char right) {
		int leftVal=0;
		int rightVal=0;
		for (int i = 0; i < operators.length(); i++) {
			if (left == operators.charAt(i)) {
				leftVal = i;
			}
			if (right == operators.charAt(i)) {
				rightVal = i;
			}
		}
		return leftVal<rightVal;
	}

	private boolean isLetter(char in) {
		int asciivalue = (int) in;

		if (((asciivalue > 64) & (asciivalue < 91)) | // uppercase
				((asciivalue > 96) & (asciivalue < 123))) { // lowercase
			return true;
		}
		return false;
	}

}

// pseudocode

// while item in infix
//   if operand, write it to output

//   else if open paren, push to stack

//   else if close paren
//     while stack not empty pop from stack
//       if not open paren write to output
//       else if open paren break

//   else if operator (newOperator) 
//     if stack empty push
//     else
//       while stack not empty, pop from stack (item)
//         if item is open paren, push item, break
//         else if item is operator (oldOperator)
//           if oldOperator < newOperator push oldOperator, break
//           else if oldOperator >= newOperator write oldOperator
//       push newOperator

// run out of items
// while stack not empty, pop item
//   write it to output
