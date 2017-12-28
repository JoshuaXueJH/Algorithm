package com.joshua.interview;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] array = { 2, 44, 34, 23, 6, 23, 43243 };
		HeapSort minHeap = new HeapSort();
		minHeap.heapsort(array);
		System.out.println(Arrays.toString(array));
	}

	public void heapsort(int[] array) {
		buildMinHeap(array);

		for (int i = array.length - 1; i > 0; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;

			minHeapify(array, 0, i);
		}
	}

	public void buildMinHeap(int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			minHeapify(array, i, array.length);
		}
	}

	public void minHeapify(int[] array, int i, int heapsize) {
		int l = left(i);
		int r = right(i);
		int smallest = i;

		if (l <= heapsize - 1 && array[l] < array[smallest]) {
			smallest = l;
		}
		if (r <= heapsize - 1 && array[r] < array[smallest]) {
			smallest = r;
		}
		if (smallest != i) {
			int temp = array[i];
			array[i] = array[smallest];
			array[smallest] = temp;
			minHeapify(array, smallest, heapsize);
		}
	}

	public int left(int i) {
		return i * 2 + 1;
	}

	public int right(int i) {
		return i * 2 + 2;
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}
}
