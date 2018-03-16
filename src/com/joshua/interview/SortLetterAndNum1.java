package com.joshua.interview;

public class SortLetterAndNum1 {
	public static void main(String[] args) {
		char[] chs = { '2', '1', 'd', '4', 'a', '9', 'f', '3', '2', };
		/*		char c = 'B';
				char b = '1';
				System.out.println((int) c);
				System.out.println((int) b);*/
		SortLetterAndNum1 instance = new SortLetterAndNum1();
		instance.quickSort(chs);
		for (char c : chs) {
			System.out.println(c);
		}
	}

	public void quickSort(char[] chs) {
		quickSort(chs, 0, chs.length - 1);
	}

	public void quickSort(char[] chs, int left, int right) {
		int index = partition(chs, left, right);
		if (index - 1 > left) {
			quickSort(chs, left, index - 1);
		}
		if (index < right) {
			quickSort(chs, index, right);
		}
	}

	public int partition(char[] chs, int left, int right) {
		char pivot = chs[(left + right) / 2];
		while (left <= right) {
			while (chs[left] < pivot)
				left++;
			while (chs[right] > pivot)
				right--;

			if (left <= right) {
				swap(chs, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public void swap(char[] chs, int left, int right) {
		char temp = chs[left];
		chs[left] = chs[right];
		chs[right] = temp;
	}
}
