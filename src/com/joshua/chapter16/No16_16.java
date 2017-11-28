package com.joshua.chapter16;

public class No16_16 {
	public static void main(String[] args) {
		//int[] array = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(findIndexs(array).toString());
	}

	public static Indexs findIndexs(int[] array) {
		Indexs result = new Indexs(0, (array.length - 1));

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					result.m = i;
					break;
				} else if (array[i] == array[j]) {
					if (!consecutive(array, i, j)) {
						result.m = i;
						break;
					}
				}
			}
			if (result.m > 0) {
				break;
			}
		}

		if (result.m > 0) {
			for (int i = array.length - 1; i >= result.m; i--) {
				for (int j = i - 1; j >= result.m; j--) {
					if (array[i] < array[j]) {
						result.n = i;
						break;
					} else if (array[i] == array[j]) {
						if (!consecutive(array, i, j)) {
							result.n = i;
							break;
						}
					}
				}
				if (result.n < array.length - 1) {
					break;
				}
			}
		}

		if (result.m == 0 && result.n == array.length - 1) {
			result.m = -1;
			result.n = -1;
		}
		return result;
	}

	public static boolean consecutive(int[] array, int start, int end) {
		boolean flag = true;
		while (start < end) {
			if (array[start] != array[end]) {
				flag = false;
				return flag;
			}
			start++;
		}
		return flag;
	}

}
