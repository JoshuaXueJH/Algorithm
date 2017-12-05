package com.joshua.chapter10;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = { 1, 345, 5, 23, 7, 434, 2 };
		bubblesort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void bubblesort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
}
