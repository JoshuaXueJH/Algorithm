package com.joshua.chapter16;

public class No16_17 {
	public static void main(String[] args) {
		int[] array = { 2, -8, 3, -2, 4, -10 };
		System.out.println(getSum(array));
	}

	public static int getSum(int[] array) {
		int sum = Integer.MIN_VALUE;
		int current = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				current += array[j];
				if (current > sum) {
					sum = current;
				}
			}
			current = 0;
		}
		return sum;
	}
}
