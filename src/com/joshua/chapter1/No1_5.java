package com.joshua.chapter1;

public class No1_5 {
	public static void main(String[] args) {
		if (isOneEdit("abcdf ", "abcd")) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static boolean isOneEdit(String s1, String s2) {
		if (s1.equals(s2))
			return true;

		if ((s1.length() + 1) == s2.length()) {
			return insertOrRemove1(s1.toCharArray(), s2.toCharArray());
		} else if (s1.length() == (s2.length() + 1)) {
			return insertOrRemove1(s2.toCharArray(), s1.toCharArray());
		} else if (s1.length() == s2.length()) {
			return replaced(s1.toCharArray(), s2.toCharArray());
		} else {
			return false;
		}
	}

	public static boolean insertOrRemove(char[] shorter, char[] longer) {
		for (int i = 0; i < shorter.length; i++) {
			if (shorter[i] != longer[i]) {
				for (int j = i; j < longer.length - 1; j++) {
					longer[j] = longer[j + 1];
				}
				break;
			}
			continue;
		}
		longer[longer.length - 1] = '\0';

		String shorter_str = new String(shorter);
		String longer_str = new String(longer);
		//		System.out.println("shoter_str-->" + shorter_str.trim());
		//		System.out.println("longer_str-->" + longer_str.trim());
		if (shorter_str.trim().equals(longer_str.trim()))
			return true;
		return false;
	}

	public static boolean insertOrRemove1(char[] shorter, char[] longer) {
		int differenceTag = -1;
		for (int i = 0; i < shorter.length; i++) {
			if (shorter[i] != longer[i]) {
				differenceTag = i;
				break;
			}
			continue;
		}

		if (differenceTag >= 0) {
			for (int j = differenceTag; j < shorter.length; j++) {
				if (shorter[j] != longer[j + 1]) {
					return false;
				}
				continue;
			}
		}
		return true;
	}

	public static boolean replaced(char[] ch1, char[] ch2) {
		boolean locationFound = false;
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i]) {
				if (locationFound)
					return false;
				locationFound = true;
			}
			continue;
		}
		return true;
	}
}
