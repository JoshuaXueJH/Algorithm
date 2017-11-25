package com.joshua.chapter10;

import java.util.Arrays;

public class No10_11 {
	public static void main(String[] args) {
		int[] a = { 0, 1, 4, 7, 8, 9 };
		int[] result = sortArray(a);
		for (int n : result) {
			System.out.println(n);
		}
	}

	/**
	 * 算法思路，将array排序，然后从array前后依次取值组成新的array
	 * 此方法的时间复杂度是n（不包括排序），但是空间复杂度也为n。
	 * 书中方法的空间复杂度只有1
	 * @param array
	 * @return
	 */
	public static int[] sortArray(int[] array) {
		Arrays.sort(array);
		int[] result = new int[array.length];

		int count = 0;
		int begin = 0;
		int end = array.length - 1;
		boolean left = true;

		while (count <= array.length - 1) {
			if (left) {
				result[count] = array[begin];
				begin++;
				count++;
				left = false;
			} else {
				result[count] = array[end];
				end--;
				count++;
				left = true;
			}
		}
		return result;
	}
}
