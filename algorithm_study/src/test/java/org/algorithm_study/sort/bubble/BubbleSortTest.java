package org.algorithm_study.sort.bubble;

import java.util.Arrays;
import java.util.Random;

import org.algorithm_study.sort.bubble.optimization.bi_dir.BubbleSort;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BubbleSortTest extends TestCase {
	public BubbleSortTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(BubbleSortTest.class);
	}

	public void test() {
		Integer[] array = randomIntArray(50000);
		Integer[] array1 = Arrays.copyOf(array, array.length);
		Integer[] array2 = Arrays.copyOf(array, array.length);
		Integer[] array3 = Arrays.copyOf(array, array.length);
		long t1 = System.currentTimeMillis();
		Arrays.sort(array);
		long t2 = System.currentTimeMillis();
		System.out.println("Arrays.sort(array):" + (t2 - t1));
		t1 = System.currentTimeMillis();
		assertTrue(Arrays.deepEquals(array, org.algorithm_study.sort.bubble.primitive.BubbleSort.sort(array1)));
		t2 = System.currentTimeMillis();
		System.out.println("primitive.BubbleSort.sort(array1):" + (t2 - t1));
		t1 = System.currentTimeMillis();
		assertTrue(Arrays.deepEquals(array,
				org.algorithm_study.sort.bubble.optimization.head_tail_ordered.BubbleSort.sort(array2)));
		t2 = System.currentTimeMillis();
		System.out.println("head_tail_ordered.BubbleSort.sort(array2):" + (t2 - t1));
		t1 = System.currentTimeMillis();
		assertTrue(Arrays.deepEquals(array,
				org.algorithm_study.sort.bubble.optimization.bi_dir.BubbleSort.sort(array3)));
		t2 = System.currentTimeMillis();
		System.out.println("multi_thread.BubbleSort.sort(array3):" + (t2 - t1));
	}

	private Integer[] randomIntArray(int length) {
		Integer[] ints = new Integer[length];
		for (int i = 0; i < length; i++)
			ints[i] = new Random().nextInt(100);
		return ints;
	}
}
