package com.joshua.chapter10;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = new int[] { 4, 5, 8, 1, 2, 54 };
		mergesort(array);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	// Merge sort
	public static void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}

	public static void mergesort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle);
			mergesort(array, helper, middle + 1, high);
			merge(array, helper, low, middle, high);
		}
	}

	public static void merge(int[] array, int[] helper, int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int leftHelper = low;
		int rightHelper = middle + 1;
		int current = low;

		while (leftHelper <= middle && rightHelper <= high) {
			if (helper[leftHelper] <= helper[rightHelper]) {
				array[current] = helper[leftHelper];
				leftHelper++;
			} else {
				array[current] = helper[rightHelper];
				rightHelper++;
			}
			current++;
		}

		int remain = middle - leftHelper;
		for (int i = 0; i <= remain; i++) {
			array[current + i] = helper[leftHelper + i];
		}
	}
}
