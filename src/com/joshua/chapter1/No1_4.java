package com.joshua.chapter1;

public class No1_4 {
	public static void main(String[] args) {
		if (isPalindrome3("Aabbxx ijkijk ")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	public static boolean isPalindrome1(String s) {
		s = s.toLowerCase();
		char[] s_array = s.toCharArray();
		int count = 0;
		int[] letters = new int[127];

		for (int i = 0; i < s_array.length; i++) {
			char c = s_array[i];
			if (c != ' ') {
				count++;
				letters[c]++;
			}
		}

		if (count % 2 == 0) {
			for (int a : letters) {
				if (a % 2 != 0)
					return false;
				continue;
			}
		} else {
			int times = 0;
			for (int j = 0; j < letters.length & times <= 1; j++) {
				if (letters[j] % 2 != 0)
					times++;
				continue;
			}
			if (times > 1)
				return false;
		}
		return true;
	}

	public static boolean isPalindrome2(String s) {
		s = s.toLowerCase();
		char[] s_array = s.toCharArray();
		int[] letters = new int[128];

		for (int i = 0; i < s_array.length; i++) {
			char c = s_array[i];
			if (c != ' ') {
				letters[c]++;
			}
		}

		boolean foundOdd = false;
		for (int a : letters) {
			if (a % 2 == 1) {
				if (foundOdd)
					return false;
				foundOdd = true;
			}
		}
		return true;
	}

	public static boolean isPalindrome3(String s) {
		s = s.toLowerCase();
		char[] s_array = s.toCharArray();
		int[] letters = new int[128];

		int countOdd = 0;
		for (int i = 0; i < s_array.length; i++) {
			char c = s_array[i];
			if (c != ' ') {
				letters[c]++;
				if (letters[c] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}
}
