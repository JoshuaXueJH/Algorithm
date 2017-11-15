package com.joshua.chapter8;

import java.util.HashSet;
import java.util.Set;

public class No8_8 {
	public static void main(String[] args) {
		Set<String> results = getPermutation("aacd");
		for (String str : results) {
			System.out.println(str);
		}
	}

	/**
	 * 此方法跟8_7实际上没与区别，只是把ArrayList换成了Set，这样自动会过滤重复数据
	 * @param str
	 * @return
	 */
	public static Set<String> getPermutation(String str) {
		if (str == null)
			return null;

		Set<String> results = new HashSet<String>();

		if (str.length() == 0) {
			results.add("");
			return results;
		}

		char first = str.charAt(0);
		String remainder = str.substring(1);
		Set<String> words = getPermutation(remainder);

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
}
