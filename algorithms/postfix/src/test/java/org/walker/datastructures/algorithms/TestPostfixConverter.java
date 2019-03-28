package org.walker.datastructures.algorithms;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestPostfixConverter {
	Logger log = LoggerFactory.getLogger(TestPostfixConverter.class);
	private boolean verbose = false;
	@Test
	public void additionAndSubtraction() {
		String input = "A+B-C";
		String output = "AB+C-";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
	
	@Test
	public void multiplicationAndDivision() {
		String input = "A*B/C";
		String output = "AB*C/";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
	
	@Test
	public void additionThenMultiplication() {
		String input = "A+B*C";
		String output = "ABC*+";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
	
	@Test
	public void multiplicationThenAddition() {
		String input = "A*B+C";
		String output = "AB*C+";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
	
	@Test
	public void multiplicationThenAdditionWithParenthesis() {
		String input = "A*(B+C)";
		String output = "ABC+*";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
	
	@Test
	public void multiplyAddMultiply() {
		String input = "A*B+C*D";
		String output = "AB*CD*+";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
	
	@Test
	public void multiplyTwoSubproblems() {
		String input = "(A+B)*(C-D)";
		String output = "AB+CD-*";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
	
	@Test
	public void nestedSubproblems() {
		String input = "((A+B)*C)-D";
		String output = "AB+C*D-";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
	
	@Test
	public void complexNestedSubproblems() {
		String input = "A+B*(C-D/(E+F))";
		String output = "ABCDEF+/-*+";
		PostfixConverter pcon = new PostfixConverter();
		String postfix = pcon.parseInfix(input);
		if(verbose) log.info(postfix+ " " + output);
		assert(output.equalsIgnoreCase(postfix));
	}
}
