package org.walker.datastructures.algorithms;


import org.walker.datastructures.trees.Node;

public class HuffmanTree {
	private Node<Symbol> root;
	
	
	public Symbol[] getCharacterFrequency(String message) {
		int numChar = 0;
		boolean newChar;
		char [] characters = new char [256];
		long [] frequency = new long [256];
		
		// fill in the list of characters and their frequency of appearance
		for(char sym : message.toCharArray()) {
			newChar = true;
			for (int i = 0; i<numChar; i++) {
				if (characters[i] == sym) {
					frequency[i] = frequency[i] +1;
					newChar = false;
				}
			}
			if(newChar) {
				characters[numChar] = sym;
				frequency[numChar] = 1;
				numChar++;
			}
		}
		
		// convert the two arrays to a Symbol Array
		Symbol [] result = new Symbol[numChar];

		for(int i = 0; i< numChar; i++) {
			result[i] = new Symbol(frequency[i], characters[i]);
		}
		return result;
	}
	
}
