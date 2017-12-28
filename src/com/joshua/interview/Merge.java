package com.joshua.interview;

import java.util.Arrays;

public class Merge {
	public static void main(String[] args) {
		int[][] arrays = { { 10, 100, 1000, 10000 }, { 20, 200, 2000, 20000, 200000 }, { 0, 3, 30 },
				{ 400, 500, 800 } };
		Merge m = new Merge();
		int[] result = m.merge(arrays);
		System.out.println(Arrays.toString(result));
	}

	/**
	 * 将n个长度不定的有序数组合并成一个新的有序数组
	 * http://blog.csdn.net/u012328476/article/details/52522900
	 * 一. 最简单的方法是创建一个n*k大小的数组，然后把所有数字拷贝进去，然后再进行时间复杂度为O(nlogn)排序算法，这样总体时间复杂度为O(nklognk)
	 * 
	 * 二. 可以利用最小堆完成，时间复杂度是O(nklogk)，具体过程如下：
	 * 
	 * 创建一个大小为n*k的数组保存最后的结果
	 * 创建一个大小为k的最小堆，堆中元素为k个数组中的每个数组的第一个元素
	 * 重复下列步骤n*k次：
	 * 每次从堆中取出最小元素（堆顶元素），并将其存入输出数组中
	 * 用堆顶元素所在数组的下一元素将堆顶元素替换掉，
	 * 如果数组中元素被取光了，将堆顶元素替换为无穷大。每次替换堆顶元素后，重新调整堆
	 * @param arrays
	 * @return
	 */
	public int[] merge(int[][] arrays) {
		if (arrays == null) {
			return null;
		}

		int finalLen = 0;
		Node[] heap = new Node[arrays.length];
		int heapsize = heap.length;

		for (int i = 0; i < arrays.length; i++) {
			finalLen += arrays[i].length;
			heap[i] = new Node(arrays[i][0], i, 0);
		}

		int[] finalArray = new int[finalLen];
		int pivot = 0;

		buildMinHeap(heap);

		for (int i = finalLen - 1; i >= 0; i--) {
			finalArray[pivot] = heap[0].element;
			pivot++;

			if (arrays[heap[0].number].length - 1 > heap[0].position) {
				int number = heap[0].number;
				int position = heap[0].position;
				heap[0] = new Node(arrays[number][position + 1], number, position + 1);
			} else {
				heap[0] = heap[heapsize - 1];
				heapsize--;
			}
			minHeapify(heap, 0, heapsize);
		}

		return finalArray;
	}

	public void buildMinHeap(Node[] heap) {
		for (int i = heap.length - 1; i >= 0; i--) {
			minHeapify(heap, i, heap.length);
		}
	}

	public void minHeapify(Node[] heap, int i, int heapsize) {
		int l = left(i);
		int r = right(i);
		int smallest = i;

		if (l <= heapsize - 1 && heap[l].element < heap[smallest].element) {
			smallest = l;
		}
		if (r <= heapsize - 1 && heap[r].element < heap[smallest].element) {
			smallest = r;
		}
		if (smallest != i) {
			Node temp = heap[i];
			heap[i] = heap[smallest];
			heap[smallest] = temp;
			minHeapify(heap, smallest, heapsize);
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

	class Node {
		public int element;
		public int number;
		public int position;

		public Node(int element, int number, int position) {
			this.element = element;
			this.number = number;
			this.position = position;
		}
	}

}
