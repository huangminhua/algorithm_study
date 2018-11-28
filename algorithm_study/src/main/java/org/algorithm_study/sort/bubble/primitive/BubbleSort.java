package org.algorithm_study.sort.bubble.primitive;

public class BubbleSort {
	public static <T extends Comparable<T>> T[] sort(T[] src) {
		T swapT;
		for (int i = src.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (src[j].compareTo(src[j + 1]) > 0) {
					swapT = src[j];
					src[j] = src[j + 1];
					src[j + 1] = swapT;
				}
			}
		}
		return src;
	}
}
