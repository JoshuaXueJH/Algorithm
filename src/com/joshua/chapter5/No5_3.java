package com.joshua.chapter5;

public class No5_3 {
	public static void main(String[] args) {
		System.out.println(returnLength(-8));
	}

	public static int returnLength(int num) {
		int longest = 0;
		int numberOf1 = 0;
		boolean numberOf0 = false;
		StringBuilder sb = new StringBuilder();

		while (num > 0) {
			int reminder = num % 2;
			sb.append(reminder);
			if (reminder == 1) {
				numberOf1++;
				if (numberOf1 > longest)
					longest = numberOf1;
			} else {
				if (!numberOf0 && numberOf1 > 0) {
					numberOf0 = true;
				} else {
					if (numberOf1 > longest)
						longest = numberOf1;
					numberOf1 = 0;
					numberOf0 = false;
				}
			}
			num = num / 2;
		}
		System.out.println(sb.toString());
		System.out.println(Integer.BYTES);
		if (longest == 0) {
			return 1;
		} else if (longest == sb.length()) {
			return --longest;
		} else {
			return longest + 1;
		}
	}
}
