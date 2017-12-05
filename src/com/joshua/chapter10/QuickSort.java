package com.joshua.chapter10;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = { 1, 6, 2, 4, 56, 43 };
		quicksort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.println(i);
		}

	}

	public static void quicksort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1) {
			quicksort(array, left, index - 1);
		}
		if (index < right) {
			quicksort(array, index, right);
		}
	}

	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		while (left <= right) {
			while (arr[left] < pivot)
				left++;

			while (arr[right] > pivot)
				right--;

			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
