package com.joshua.chapter8;

public class No8_3 {
	public static void main(String[] args) {
		int[] array1 = new int[] { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
		int[] array2 = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };

		System.out.println(findMagicIndex1(array1));
		System.out.println(findMagicIndex2(array2));
	}

	//第一种情况： 没有重复数据
	public static int findMagicIndex1(int[] array) {
		if (array == null || array.length == 0)
			return -1;

		return findMagicIndex1(array, 0, array.length - 1);
	}

	public static int findMagicIndex1(int[] array, int begining, int end) {
		if (begining > end)
			return -1;
		int middle = (begining + end) / 2;

		if (array[middle] == middle)
			return middle;

		if (array[middle] < middle) {
			return findMagicIndex1(array, middle + 1, end);
		} else {
			return findMagicIndex1(array, begining, end - 1);
		}
	}

	//第二种情况： 有重复数据
	public static int findMagicIndex2(int[] array) {
		if (array == null || array.length == 0)
			return -1;

		return findMagicIndex2(array, 0, array.length - 1);
	}

	public static int findMagicIndex2(int[] array, int begining, int end) {
		if (begining > end)
			return -1;
		int middle = (begining + end) / 2;

		int middleValue = array[middle];
		if (middleValue == middle)
			return middle;

		int leftIndex = Math.min(middleValue, middle - 1);
		int left = findMagicIndex2(array, begining, leftIndex);
		if (left >= 0) {
			return left;
		}

		int rightIndex = Math.max(middleValue, middle + 1);
		int right = findMagicIndex2(array, rightIndex, end);

		return right;
	}
}
