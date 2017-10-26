package com.joshua.chapter1;

public class No1_6 {
	public static void main(String[] args) {
		System.out.println(compressStr("cdddfff"));
	}

	public static String compressStr(String originStr) {
		StringBuilder newStr = new StringBuilder();
		char currentChar = ' ';
		int count = 0;
		for (int i = 0; i < originStr.length(); i++) {
			if (originStr.charAt(i) != currentChar) {
				if (currentChar != ' ') {
					newStr.append(currentChar).append(count);
				}
				currentChar = originStr.charAt(i);
				count = 0;
			}
			count++;
			if (i == originStr.length() - 1) {
				newStr.append(currentChar).append(count);
			}
		}
		//System.out.println("originalStr-->" + originStr);
		//System.out.println("newStr-->" + newStr);
		return originStr.length() <= newStr.length() ? originStr : newStr.toString();
	}
}
