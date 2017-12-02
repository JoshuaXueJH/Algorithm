package com.joshua.chapter16;

import java.util.Arrays;

public class No16_21 {
	public static void main(String[] args) {
		int[] arr1 = { -4, -1, -2, -1, -1, -2 };
		int[] arr2 = { -3, -6, -3, -3 };
		Pair result = sumSwap(arr1, arr2);
		System.out.println(result.toString());
	}

	public static Pair sumSwap(int[] arr1, int[] arr2) {
		int sum1 = 0, sum2 = 0;
		for (int i : arr1) {
			sum1 += i;
		}
		for (int j : arr2) {
			sum2 += j;
		}

		if (sum1 == sum2)
			return null;

		return (sum1 - sum2) > 0 ? findValues(arr1, arr2, sum1 - sum2) : findValues(arr2, arr1, sum2 - sum1);
	}

	public static Pair findValues(int[] bigger, int[] smaller, int difference) {
		Arrays.sort(bigger);
		Arrays.sort(smaller);

		int biggerIndex = 0, smallerIndex = 0;
		while (biggerIndex < bigger.length && smallerIndex < smaller.length) {
			if (bigger[biggerIndex] - smaller[smallerIndex] == difference / 2) {
				return new No16_21().new Pair(bigger[biggerIndex], smaller[smallerIndex]);
			} else if (bigger[biggerIndex] - smaller[smallerIndex] < difference / 2) {
				biggerIndex++;
			} else {
				smallerIndex++;
			}
		}
		return null;
	}

	public class Pair {
		private int bigger;
		private int smaller;

		public Pair(int bigger, int smaller) {
			this.bigger = bigger;
			this.smaller = smaller;
		}

		@Override
		public String toString() {
			return bigger + "--" + smaller;
		}
	}
}
