package com.joshua.chapter8;

import java.util.ArrayList;

public class No8_7 {
	public static void main(String[] args) {
		ArrayList<String> results = getPermutation("abcde");
		for (String item : results) {
			System.out.println(item);
		}
	}

	/**
	 * 没有看书中的提示自己写的方法
	 * 理念就是每次取出一个char字符，生成一个序列
	 * 再取一个char字符，将新char放在原有char序列的各个位置
	 * 
	 * 和书中第一种方法想法相同，但是我的代码写的不如书中简单
	 * @param str
	 * @return
	 */
	public static ArrayList<String> getPermutation(String str) {
		ArrayList<char[]> results = new ArrayList<char[]>();
		results = getPermutation(str, results);

		ArrayList<String> resultsString = new ArrayList<String>();
		for (char[] item : results) {
			resultsString.add(new String(item));
		}
		return resultsString;
	}

	public static ArrayList<char[]> getPermutation(String str, ArrayList<char[]> results) {
		int length = str.length();
		if (length == 1) {
			results.add(str.toCharArray());
			return results;
		}

		results = getPermutation(str.substring(0, length - 1), results);
		ArrayList<char[]> current = new ArrayList<char[]>();
		char[] strs = str.toCharArray();
		for (char[] item : results) {

			for (int i = 0; i <= item.length; i++) {
				char[] item1 = new char[item.length + 1];
				for (int j = item.length - 1; j >= i; j--) {
					item1[j + 1] = item[j];
				}
				item1[i] = strs[length - 1];
				for (int k = 0; k < i; k++) {
					item1[k] = item[k];
				}
				current.add(item1);
			}

		}
		results.clear();
		results.addAll(current);
		return results;
	}
}
