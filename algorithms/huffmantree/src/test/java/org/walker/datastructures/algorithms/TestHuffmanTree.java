package org.walker.datastructures.algorithms;

import org.junit.Test;

public class TestHuffmanTree {
	/* reference frequency for characters
	S6
	U1
	I3
	E2
	Space4
	A2
	Y2
	T1
	Linefeed1
	*/
	@Test
	public void testCreateSymbolsAndFrequency() {
		String message = "SUSIE SAYS IT IS EASY\n";
		
		HuffmanTree htree = new HuffmanTree();
		
		Symbol [] testSymbols = new Symbol [9];
		testSymbols [0] = new Symbol(6, 'S');
		testSymbols [1] = new Symbol(1, 'U');
		testSymbols [2] = new Symbol(3, 'I');
		testSymbols [3] = new Symbol(2, 'E');
		testSymbols [4] = new Symbol(4, ' ');
		testSymbols [5] = new Symbol(2, 'A');
		testSymbols [6] = new Symbol(2, 'Y');
		testSymbols [7] = new Symbol(1, 'T');
		testSymbols [8] = new Symbol(1, '\n');
		
		
		Symbol [] symbols = htree.getCharacterFrequency(message);
		// check that each symbol is recorded correctly
		for(int i = 0; i < symbols.length; i++) {
			assert(testSymbols[i].equals(symbols[i]));
		}
	}
	
	
}
