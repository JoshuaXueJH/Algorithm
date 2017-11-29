package com.joshua.chapter16;

public class No16_6book {
	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		//int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		findUnsortedSequence(array);
	}

	public static void findUnsortedSequence(int[] array) {
		int end_left = findEndOfLeftSubsequence(array);
		if (end_left >= array.length - 1)
			return;
		int start_right = findStartOfRightSubsequence(array);

		int max_index = end_left;
		int min_index = start_right;
		for (int i = end_left + 1; i < start_right; i++) {
			if (array[i] > array[max_index])
				max_index = i;
			if (array[i] < array[min_index])
				min_index = i;
		}

		int left_index = shrinkLeft(array, min_index, end_left);

		int right_index = shrinkRight(array, max_index, start_right);

		System.out.println(left_index + " " + right_index);
	}

	public static int findEndOfLeftSubsequence(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1])
				return i - 1;
		}
		return array.length - 1;
	}

	public static int findStartOfRightSubsequence(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1])
				return i + 1;
		}
		return 0;
	}

	public static int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for (int i = start - 1; i >= 0; i--) {
			if (comp >= array[i]) {
				return i + 1;
			}
		}
		return 0;
	}

	public static int shrinkRight(int[] array, int max_index, int start) {
		int comp = array[max_index];
		for (int i = start + 1; i < array.length; i++) { // 此处是start+1，应该与shrinkLeft（）方法对应，书中没有写+1，但是分析可以发现是应该+1的
			if (comp <= array[i]) {
				return i - 1;
			}
		}
		return array.length - 1;
	}
}
