package com.joshua.chapter17;

public class No17_5 {
	public static void main(String[] args) {
		No17_5 instance = new No17_5();
		char[] array = { '4', '5', 'f', '2', 'd', 'h', 's', 's', 'f', 's', 'j' };

		char[] result = instance.findSubArray(array);
		if (result != null) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		} else {
			System.out.println("empty");
		}

	}

	public char[] findSubArray(char[] array) {
		return findSubArray(array, array.length);
	}

	public char[] findSubArray(char[] array, int length) {
		if (length == 1) {
			return null;
		}

		for (int i = 0; i <= array.length - length; i++) {
			if (hasEqualNumOfLetterAndNum(array, i, i + length - 1)) {
				return getSubArray(array, i, i + length - 1);
			}
		}

		return findSubArray(array, length - 1);
	}

	public char[] getSubArray(char[] array, int start, int end) {
		char[] subArray = new char[end - start + 1];
		int pivot = 0;

		for (int i = start; i <= end; i++) {
			subArray[pivot] = array[i];
			pivot++;
		}

		return subArray;
	}

	public boolean hasEqualNumOfLetterAndNum(char[] array, int start, int end) {
		int numOfLetter = 0;
		int numOfNum = 0;

		for (int i = start; i <= end; i++) {
			if (array[i] >= '0' && array[i] <= '9') { //此处注意 array[i] >= 0 && array[i] <= 9， 这种写法不对.
				numOfNum++;
			} else {
				numOfLetter++;
			}
		}

		return numOfLetter == numOfNum;
	}
}
