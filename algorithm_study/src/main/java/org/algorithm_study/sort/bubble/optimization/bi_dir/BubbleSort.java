package org.algorithm_study.sort.bubble.optimization.bi_dir;

public class BubbleSort {
	/**
	 * This optimization enchances the effect of orderd head/tail.<br>
	 * It saves more than 1/4 time of bubble sort.<br>
	 * Although, it still has the n*n time complexity.<br>
	 * 
	 * 1 2 3 7 8 9 4 12 10 11 5 6 13 14 15<br>
	 * |___|_____|____________|____|_____|<br>
	 * ---l1----l2-----------r2---r1<br>
	 * From left to right: int i=l2;i<=r1-2;i++<br>
	 * 1 2 3 7 8 4 9 10 11 5 6 12 13 14 15<br>
	 * |___|___|___________|____|________|<br>
	 * ---l1--l2----------r2---r1<br>
	 * From right to left: int i=r2-1;i>=l1+1;i--<br>
	 * 1 2 3 4 7 8 5 9 10 11 6 12 13 14 15<br>
	 * |_____|___|___________|__|________|<br>
	 * -----l1--l2----------r2-r1<br>
	 * 
	 * @param src
	 * @return
	 */
	public static <T extends Comparable<T>> T[] sort(T[] src) {
//		System.out.println(Arrays.toString(src));
		T swapT;
		int l1 = -1;
		int l2 = 0;
		int r1 = src.length;
		int r2 = src.length - 1;
		int l1_t = -1;// _t means temp
		int l2_t = -1;
		int r1_t = -1;
		int r2_t = -1;
		while (true) {
			l1_t = -1;// _t means temp
			l2_t = -1;
			r1_t = -1;
			r2_t = -1;

			for (int i = Math.max(l1, l2); i <= r1 - 2; i++) {
				if (src[i].compareTo(src[i + 1]) > 0) {
					// swap
					// TODO use System.arraycopy
					swapT = src[i];
					src[i] = src[i + 1];
					src[i + 1] = swapT;
					// TODO minimize the times of assignment below
					if (l2_t < 0)
						l2_t = i == 0 ? 0 : i - 1;
					r1_t = i + 1;
				}
			}
			if (l2_t == -1)// this Round has no swap
				return src;
			l2 = l2_t;
			r1 = r1_t;
//			System.out.println(Arrays.toString(src));
//			System.out.println((l2-l1) + ":" +  ":" + (r1-r2));

			for (int i = Math.min(r1, r2) - 1; i >= l1 + 1; i--) {
				if (src[i].compareTo(src[i + 1]) > 0) {
					// swap
					// TODO use System.arraycopy
					swapT = src[i];
					src[i] = src[i + 1];
					src[i + 1] = swapT;
					// TODO minimize the times of assignment below
					if (r2_t < 0)
						r2_t = (i == src.length - 2) ? src.length - 1 : i + 2;
					l1_t = i;
				}
			}
			if (r2_t == -1)// this Round has no swap
				return src;
			r2 = r2_t;
			l1 = l1_t;
//			System.out.println(Arrays.toString(src));
//			System.out.println((l2-l1) + ":" + (r1-r2));
		}
	}
}
