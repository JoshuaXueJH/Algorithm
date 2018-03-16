package com.joshua.interview;

public class SortLetterAndNum2 {
	public static void main(String[] args) {
		char[] chs = { '2', '1', 'd', '4', 'a', '9', 'f', '3', '2', };

		SortLetterAndNum2 instance = new SortLetterAndNum2();
		int[] array = instance.convert(chs);

		QuickSort.quickSort(array);

		chs = instance.convertBack(array);

		for (char c : chs) {
			System.out.println(c);
		}
	}

	public int[] convert(char[] chs) {
		int[] array = new int[chs.length];
		for (int i = 0; i < chs.length; i++) {
			array[i] = chs[i];
		}
		return array;
	}

	public char[] convertBack(int[] array) {
		char[] chs = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			chs[i] = (char) array[i];
		}
		return chs;
	}
}
