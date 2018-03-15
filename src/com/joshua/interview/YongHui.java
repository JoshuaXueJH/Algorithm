package com.joshua.interview;

//2, 1, 6, 4, d, a, 8, 3
//select gender, count(*) from TABLE group by gender;

public class YongHui {
	public static void main(String[] args) {
		char[] chs = { '2', '1', 'd', '4', 'a', '9', 'f', '3', '2',  };

		YongHui yh = new YongHui();
		char[] result = yh.sortArray(chs);

		for (char c : result) {
			System.out.println(c);
		}
	}

	public char[] sortArray(char[] chs) {
		YHClass c = partition(chs);

		quickSort(c.getChs(), 0, c.getPartition());
		quickSort(c.getChs(), c.getPartition() + 1, chs.length - 1);
		return c.getChs();
	}

	public YHClass partition(char[] chs) {
		char[] helper = new char[chs.length];
		int leftPivot = 0;
		int rightPivot = chs.length - 1;
		for (int i = 0; i < chs.length; i++) {
			if (Character.isDigit(chs[i])) {
				helper[leftPivot] = chs[i];
				leftPivot++;
			} else {
				helper[rightPivot] = chs[i];
				rightPivot--;
			}
		}
		return new YHClass(helper, leftPivot - 1);
	}

	public void quickSort(char[] chs, int low, int high) {
		int index = partition1(chs, low, high);

		if (low < index - 1) {
			quickSort(chs, low, index - 1);
		}
		if (high > index) {
			quickSort(chs, index, high);
		}
	}

	public int partition1(char[] chs, int low, int high) {
		char pivot = chs[(low + high) / 2];
		while (low <= high) {
			while (chs[low] < pivot)
				low++;
			while (chs[high] > pivot)
				high--;

			if (low <= high) {
				swap(chs, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	public void swap(char[] chs, int low, int high) {
		char ch1 = chs[low];
		chs[low] = chs[high];
		chs[high] = ch1;
	}
}
