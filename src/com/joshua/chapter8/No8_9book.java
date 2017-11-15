package com.joshua.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class No8_9book {
	public static void main(String[] args) {
		Set<String> result = generateParens1(4);
		for (String s : result) {
			System.out.println(s);
		}
	}

	//书中第一种方法
	static Set<String> generateParens1(int remaining) {
		Set<String> parents = new HashSet<String>();
		if (remaining == 0) {
			parents.add("");
			return parents;
		}

		Set<String> current = generateParens1(remaining - 1);
		for (String item : current) {
			for (int i = 0; i < item.length(); i++) {
				if (item.charAt(i) == '(') {
					String str = insertToParent(item, i);
					parents.add(str);
				}
			}
			parents.add("()" + item);
		}
		return parents;
	}

	static String insertToParent(String item, int position) {
		String before = item.substring(0, position + 1);
		String after = item.substring(position + 1);
		return before + "()" + after;
	}

	//书中第二种方法
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
