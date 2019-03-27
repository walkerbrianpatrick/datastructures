package org.walker.datastructures.stacksandqueues;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StackTest {
	Logger log = LoggerFactory.getLogger(StackTest.class);
	@Test
	public void pushAndPopTest() {
		StackLong stack = new StackLong(10);
		
		stack.push(123L);
		stack.push(234L);
		stack.push(345L);
		stack.push(456L);
		
		assert (456 == stack.pop());
		assert (345 == stack.pop());
		assert (234 == stack.pop());
		assert (123 == stack.pop());	
	}
	
	@Test
	public void checkFullStack() {
		StackLong stack = new StackLong(1);
		stack.push(123L);
		assert(stack.isFull() == true);
	}

	@Test
	public void checkEmptyStack() {
		StackLong stack = new StackLong(1);
		assert(stack.isEmpty() == true);
	}
	
	@Test
	public void useStackToReverseString() {
		String in = "Hello World";
		String out = "";
		StackChar stack = new StackChar(12);
		for(int i =0; i<in.length(); i++) {
			stack.push(in.charAt(i));
		}
		
		while(!stack.isEmpty()) {
			out= out + stack.pop();
		}
		assert(out.equalsIgnoreCase("dlroW olleH"));
	}
	
	@Test
	public void useStackToCheckBrackets0() {
		String test0 = "c[d]"; // good
		BracketMatcher bm = new BracketMatcher();		
		assert(bm.checkStringForMatchingBrackets(test0));
	}
	
	@Test
	public void useStackToCheckBrackets1() {
		String test1 = "a{b[c]d}e"; //good
		BracketMatcher bm = new BracketMatcher();		
		assert(bm.checkStringForMatchingBrackets(test1));
	}
	@Test
	public void useStackToCheckBrackets2() {
		String test2 = "a{b(c]d}e"; //bad
		BracketMatcher bm = new BracketMatcher();		
		assert(!bm.checkStringForMatchingBrackets(test2));
	}
	@Test
	public void useStackToCheckBrackets3() {
		String test3 = "a[b{c}d]e}"; //bad
		BracketMatcher bm = new BracketMatcher();		
		assert(!bm.checkStringForMatchingBrackets(test3));
	}
	@Test
	public void useStackToCheckBrackets4() {
		String test4 = "a{b(c)"; //bad
		BracketMatcher bm = new BracketMatcher();		
		assert(!bm.checkStringForMatchingBrackets(test4));
	}
	
}
