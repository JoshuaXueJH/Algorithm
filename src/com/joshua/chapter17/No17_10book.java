package com.joshua.chapter17;

public class No17_10book {
	public static void main(String[] args) {
		int[] array = { 1, 2, 5, 9, 5, 5, 5 };
		No17_10book instance = new No17_10book();

		System.out.println(instance.findMajorityEle(array));
	}

	/**
	 * First try: relaxing the requirement of having O(n) time, but sticking to the requirement of O(1) space
	 * Time complexity for this algorithm in worst case is O(n*n)
	 * @param array
	 * @return
	 */
	public int findMajorityEle(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == array[i]) {
					count++;
				}
			}
			if (count > (array.length / 2)) {
				return array[i];
			}
		}

		return -1;
	}
}
