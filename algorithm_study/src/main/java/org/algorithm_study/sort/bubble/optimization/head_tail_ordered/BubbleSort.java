package org.algorithm_study.sort.bubble.optimization.head_tail_ordered;

public class BubbleSort {
	/**
	 * This is the optimized function for the sort of head/tail ordered array.<br>
	 * Two pivots are invented to minimize the inner loop length.<br>
	 * For example:<br>
	 * 1 2 3 7 8 9 4 12 6 10 11 5 13 14 15<br>
	 * |_________|                 |_____|<br>
	 *         leftP            rightP<br>
	 * 1.In this case, the left 6 elements are ordered. Then our sort is from "9" in this round.<br>
	 * 1 2 3 7 8 4 9 6 10 11 5 12 13 14 15<br>
	 * |_______|                |________|<br>
	 *       leftP           rightP<br>
	 * In the next round, we will start from "8". leftP is invented for this purpose.<br>
	 * In this function, leftP is represented by (minSwappedIndex of the last round) - 1.<br> 
	 * 2.This optimization also ignores the round count, it records (maxSwappedIndex of the<br>
	 * last round), which equals rightP - 1.<br>
	 * This optimization has not good effect.<br>
	 * 
	 * @param src
	 * @return
	 */
	public static <T extends Comparable<T>> T[] sort(T[] src) {
		T swapT;
		int minSwappedIndexLastRound = 0;
		int maxSwappedIndexLastRound = src.length - 1;
		while (true) {
			int minSwappedIndexThisRound = -1;
			int maxSwappedIndexThisRound = -1;
			for (int i = minSwappedIndexLastRound == 0 ? 0
					: minSwappedIndexLastRound - 1; i < maxSwappedIndexLastRound; i++) {
				if (src[i].compareTo(src[i + 1]) > 0) {
					// swap
					swapT = src[i];
					src[i] = src[i + 1];
					src[i + 1] = swapT;
					// record minSwappedIndexThisRound and maxSwappedIndexThisRound
					if (minSwappedIndexThisRound < 0)
						minSwappedIndexThisRound = i;
					maxSwappedIndexThisRound = i;
				}
			}
			if (minSwappedIndexThisRound == -1)// this Round has no swap
				return src;
			minSwappedIndexLastRound = minSwappedIndexThisRound;
			maxSwappedIndexLastRound = maxSwappedIndexThisRound;
		}
	}
}
