package org.walker.datastructures.stacksandqueues;

public class BracketMatcher {
	
	public boolean isOpening(char bracket) {
		return "({[<".indexOf(bracket)>=0;
	}
	
	public boolean isClosing(char bracket) {
		return ")}]>".indexOf(bracket)>=0;
	}
	
	public boolean isMatched(char left, char right) {
		if(left == '(') {
			return right == ')';
		}
		if(left == '{') {
			return right == '}';
		}
		if(left == '[') {
			return right == ']';
		}
		if(left == '<') {
			return right == '>';
		}
		return false;
	}
	
	public boolean checkStringForMatchingBrackets(String line) {
		StackChar stack = new StackChar(line.length());
		
		// if a traditional for loop is used here, this function
		// can report the location of the error in the string
		for(char letter : line.toCharArray()) {
			if(isOpening(letter)) {
				stack.push(letter);
			} else if (isClosing(letter)) {
				if (!stack.isEmpty()) {
					char left = stack.pop();
					if (!isMatched(left, letter)) {
						stack.push(left);
						break;
					}
				} else {
					stack.push(letter);
					break;
				}
			}
		}
		return stack.isEmpty();
	}
	
	
}
