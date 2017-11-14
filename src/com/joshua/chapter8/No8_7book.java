package com.joshua.chapter8;

import java.util.ArrayList;

public class No8_7book {

	public static void main(String[] args) {
		ArrayList<String> results = getPerms2("abcd");
		for (String str : results) {
			System.out.println(str);
		}
	}

	public static ArrayList<String> getPermutation(String str) {
		if (str == null)
			return null;

		ArrayList<String> results = new ArrayList<String>();

		if (str.length() == 0) {
			results.add("");
			return results;
		}

		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPermutation(remainder);

		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String item = insertIntoStr(word, i, first);
				results.add(item);
			}
		}
		return results;
	}

	public static String insertIntoStr(String str, int position, char cha) {
		String right = str.substring(position);
		String left = str.substring(0, position);
		return left + cha + right;
	}

	//书中的另一个方法
	static ArrayList<String> getPerms2(String str) {
		ArrayList<String> results = new ArrayList<String>();
		getPerms2("", str, results);
		return results;
	}

	public static void getPerms2(String prefix, String remainder, ArrayList<String> results) {
		if (remainder.length() == 0)
			results.add(prefix);

		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPerms2(prefix + c, before + after, results);
		}
	}
}
