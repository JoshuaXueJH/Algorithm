package com.joshua.chapter8;

import java.util.ArrayList;

public class No8_7 {
	public ArrayList<char[]> getPermutation(String str) {
		ArrayList<char[]> results;
		int length = str.length();
		return getPermutation(str, length, results);
	}

	public static ArrayList<char[]> getPermutation(String str, int length, ArrayList<char[]> results){	
		if(length == 1){
			results = new ArrayList<char[]>();
			results.add(str.toCharArray());
			return results;
		}

		ArrayList<char[]> current = new ArrayList<char[]>();
		results = getPermutation(str.substring(0, length-1), length-1, results);
		char[] strs = str.toCharArray();
		for(char[] item : current){
			current = insertToChar(item, strs[length-1]);
		}
		results.clear();
		results.addAll(current);
		return results;
	}

	public static ArrayList<char[]> insertToChar(char[] item, char c) {

	}
}
