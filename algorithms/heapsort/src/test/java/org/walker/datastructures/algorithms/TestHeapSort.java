package org.walker.datastructures.algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestHeapSort {
	Logger log = LoggerFactory.getLogger(TestHeapSort.class);

	@Test
	public void naiveSort10000() {
		int numElements = 10000;
		IntStream ints = new Random().ints(numElements);
		NaiveHeapSort nhs = new NaiveHeapSort();

		long startTime = System.currentTimeMillis();
		int[] sorted = nhs.sort(ints.toArray());
		log.info("Naive Sort Time (10000): " + Long.toString(System.currentTimeMillis() - startTime));

		for (int i = 0; i < numElements - 1; i++) {
			assert (sorted[i] >= sorted[i + 1]);
		}
	}

	@Test
	public void naiveSort100000() {
		int numElements = 100000;
		IntStream ints = new Random().ints(numElements);
		NaiveHeapSort nhs = new NaiveHeapSort();

		long startTime = System.currentTimeMillis();
		int[] sorted = nhs.sort(ints.toArray());
		log.info("Naive Sort Time (100000): " + Long.toString(System.currentTimeMillis() - startTime));

		for (int i = 0; i < numElements - 1; i++) {
			assert (sorted[i] >= sorted[i + 1]);
		}
	}

	@Test
	public void naiveSort1000000() {
		int numElements = 1000000;
		IntStream ints = new Random().ints(numElements);
		NaiveHeapSort nhs = new NaiveHeapSort();

		long startTime = System.currentTimeMillis();
		int[] sorted = nhs.sort(ints.toArray());
		log.info("Naive Sort Time (1000000): " + Long.toString(System.currentTimeMillis() - startTime));

		for (int i = 0; i < numElements - 1; i++) {
			assert (sorted[i] >= sorted[i + 1]);
		}
	}

	@Test
	public void fasterSort10000() {
		int numElements = 10000;
		IntStream ints = new Random().ints(numElements);
		long startTime = System.currentTimeMillis();
		FasterHeapSort fhs = new FasterHeapSort(ints.toArray());
		fhs.sort();
		int[] sorted = fhs.getSortedArray();
		log.info("Faster Sort Time (10000): " + Long.toString(System.currentTimeMillis() - startTime));

		for (int i = 0; i < numElements - 1; i++) {
			assert (sorted[i] <= sorted[i + 1]);
		}
	}

	@Test
	public void fasterSort100000() {
		int numElements = 100000;
		IntStream ints = new Random().ints(numElements);
		int [] elements = ints.toArray();
		
		long startTime = System.currentTimeMillis();
		FasterHeapSort fhs = new FasterHeapSort(elements);
		fhs.sort();
		int [] sorted = fhs.getSortedArray();
		log.info("Faster Sort Time (100000): " + 
		Long.toString(System.currentTimeMillis()-startTime));

		for (int i = 0;i <numElements-1; i++) {
				assert(sorted[i] <=sorted[i+1]);
		}
	}
	
	@Test
	public void fasterSort1000000() {
		int numElements = 1000000;
		IntStream ints = new Random().ints(numElements);
		int [] elements = ints.toArray();
		
		long startTime = System.currentTimeMillis();
		FasterHeapSort fhs = new FasterHeapSort(elements);
		fhs.sort();
		int [] sorted = fhs.getSortedArray();
		log.info("Faster Sort Time (1000000): " + 
		Long.toString(System.currentTimeMillis()-startTime));

		for (int i = 0;i <numElements-1; i++) {
				assert(sorted[i] <=sorted[i+1]);
		}
	}

	@Test
	public void fasterSort10000000() {
		int numElements = 10000000;
		IntStream ints = new Random().ints(numElements);
		int [] elements = ints.toArray();
		
		long startTime = System.currentTimeMillis();
		FasterHeapSort fhs = new FasterHeapSort(elements);
		fhs.sort();
		int [] sorted = fhs.getSortedArray();
		log.info("Faster Sort Time (10000000): " + 
		Long.toString(System.currentTimeMillis()-startTime));

		for (int i = 0;i <numElements-1; i++) {
				assert(sorted[i] <=sorted[i+1]);
		}
	}
	
	@Test
	public void   javaSort10000() {
		int numElements = 10000;
		IntStream ints = new Random().ints(numElements);
		int [] elements = ints.toArray();
		
		
		long startTime = System.currentTimeMillis();
		Arrays.sort(elements);
		log.info("Java Sort Time (10000): " + 
		Long.toString(System.currentTimeMillis()-startTime));

		for (int i = 0;i <numElements-1; i++) {
				assert(elements[i] <=elements[i+1]);
		}		
	}
	
	@Test
	public void   javaSort100000() {
		int numElements = 100000;
		IntStream ints = new Random().ints(numElements);
		int [] elements = ints.toArray();
		
		
		long startTime = System.currentTimeMillis();
		Arrays.sort(elements);
		log.info("Java Sort Time (100000): " + 
		Long.toString(System.currentTimeMillis()-startTime));

		for (int i = 0;i <numElements-1; i++) {
				assert(elements[i] <=elements[i+1]);
		}		
	}

	@Test
	public void   javaSort1000000() {
		int numElements = 1000000;
		IntStream ints = new Random().ints(numElements);
		int [] elements = ints.toArray();
		
		
		long startTime = System.currentTimeMillis();
		Arrays.sort(elements);
		log.info("Java Sort Time (1000000): " + 
		Long.toString(System.currentTimeMillis()-startTime));

		for (int i = 0;i <numElements-1; i++) {
				assert(elements[i] <=elements[i+1]);
		}		
	}
	
	@Test
	public void   javaSort10000000() {
		int numElements = 10000000;
		IntStream ints = new Random().ints(numElements);
		int [] elements = ints.toArray();
		
		
		long startTime = System.currentTimeMillis();
		Arrays.sort(elements);
		log.info("Java Sort Time (1000000): " + 
		Long.toString(System.currentTimeMillis()-startTime));

		for (int i = 0;i <numElements-1; i++) {
				assert(elements[i] <=elements[i+1]);
		}		
	}
}
