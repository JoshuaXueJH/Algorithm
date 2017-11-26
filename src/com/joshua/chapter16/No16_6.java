package com.joshua.chapter16;

import java.util.Arrays;

public class No16_6 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 11, 15 };
		int[] arr2 = { 4, 12, 15, 23, 127, 235 };
		System.out.println(getDifference(arr1, arr2));
	}

	public static int getDifference(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int a = 0;
		int b = 0;

		int diff = Integer.MAX_VALUE;

		while (a < arr1.length && b < arr2.length) {
			int currentDiff = Math.abs(arr1[a] - arr2[b]);
			if (currentDiff < diff) {
				diff = currentDiff;
			}
			if (arr1[a] < arr2[b]) {
				a++;
			} else if (arr1[a] > arr2[b]) {
				b++;
			} else { // 相比起书中的optimal，加如了等于零直接break的条件
				break;
			}
		}
		return diff;
	}
}
