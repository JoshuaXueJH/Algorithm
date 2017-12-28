package com.joshua.interview;

import java.util.Arrays;

public class MinHeap {
	protected double[] A;
	protected int heapsize;

	public MinHeap() {

	}

	public MinHeap(double[] A) {
		buildMinHeap(A);
	}

	public void heapsort(double[] A) {
		buildMinHeap(A);

		for (int i = A.length - 1; i > 0; i--) {
			double temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			heapsize--;

			minHeapify(0);
		}
	}

	public void buildMinHeap(double[] A) {
		this.A = A;
		this.heapsize = A.length;

		for (int i = A.length - 1; i >= 0; i--) {
			minHeapify(i);
		}
	}

	protected void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;

		if (l <= heapsize - 1 && A[l] < A[smallest]) {
			smallest = l;
		}
		if (r <= heapsize - 1 && A[r] < A[smallest]) {
			smallest = r;
		}
		if (smallest != i) {
			double temp = A[i];
			A[i] = A[smallest];
			A[smallest] = temp;

			this.minHeapify(smallest);
		}
	}

	protected int left(int i) {
		return i * 2 + 1;
	}

	protected int right(int i) {
		return i * 2 + 2;
	}

	protected int parent(int i) {
		return (i - 1) / 2;
	}

	public static void main(String[] args) {
		double[] A = { 3, 7, 2, 11, 3, 4, 9, 2, 18, 0 };
		System.out.println("Input: " + Arrays.toString(A));
		MinHeap minhp = new MinHeap();
		minhp.heapsort(A);
		System.out.println("Output: " + Arrays.toString(A));
	}
}
