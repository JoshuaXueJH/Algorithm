package com.joshua.chapter8;

import java.util.ArrayList;

public class No8_9 {
	public static void main(String[] args) {
		ArrayList<String> result = generateParents(3);
		for (String s : result) {
			System.out.println(s);
		}
	}

	static void addParent(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem)
			return;

		if (leftRem == 0 && rightRem == 0) {
			list.add(String.copyValueOf(str));
		} else {
			str[index] = '(';
			addParent(list, leftRem - 1, rightRem, str, index + 1);

			str[index] = ')';
			addParent(list, leftRem, rightRem - 1, str, index + 1);
		}
	}

	static ArrayList<String> generateParents(int count) {
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParent(list, count, count, str, 0);
		return list;
	}
}
