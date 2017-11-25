package com.joshua.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No10_1 {
	public static void main(String[] args) {
		String[] strs = new String[] { "chanel", "chnael", "nacheldd", "cahnel", "aa", "bbaa", "aabb", "ss", "abab",
				"def", "wewe", "edf" };
		sortAnagrams(strs);
		for (String s : strs) {
			System.out.println(s);
		}

	}

	static void sortAnagrams(String[] array) {
		Map<String, ArrayList<String>> results = new HashMap<String, ArrayList<String>>();

		for (String s : array) {
			String key = sortChars(s);
			ArrayList<String> value = results.get(key);
			if (value != null) {
				value.add(s);
				results.put(key, value);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				results.put(key, list);
			}
		}

		int index = 0;
		for (String key : results.keySet()) {
			ArrayList<String> list = results.get(key);
			for (String t : list) {
				array[index] = t;
				index++;
			}
		}
	}

	static String sortChars(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
