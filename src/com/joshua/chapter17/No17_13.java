package com.joshua.chapter17;

import java.util.ArrayList;

public class No17_13 {
	public static void main(String[] args) {
		String document = "jesslookedjustliketimherbrother";
		ArrayList<String> dictionary = new ArrayList<String>();
		dictionary.add("looked");
		dictionary.add("just");
		dictionary.add("like");
		dictionary.add("her");
		dictionary.add("brother");

		No17_13 instance = new No17_13();
		System.out.println(instance.unconcatenateSentence(document, dictionary));
	}

	/**
	 * 我的方法跟书中的方法不同
	 * 此方法的最差时间复杂度是O(n*n)，但是永远不可能达到
	 * 我的方式应该比书中的两种方法更好
	 * @param document
	 * @param dictionary
	 * @return
	 */
	public String unconcatenateSentence(String document, ArrayList<String> dictionary) {
		if (document.length() == 0)
			return null;

		StringBuilder newDocument = new StringBuilder();
		boolean quite = false;
		int lastIndex = 0;
		int leftPivot = 0;
		int rightPivot = 0;
		int longestWord = returnLongestLength(dictionary);

		while (leftPivot < document.length()) {
			while (rightPivot <= document.length()) {
				if (rightPivot - leftPivot <= longestWord) {
					String str = document.substring(leftPivot, rightPivot);
					if (dictionary.contains(str)) {
						if (lastIndex != leftPivot) {
							String preStr = document.substring(lastIndex, leftPivot);
							newDocument.append(preStr + " ");
						}
						newDocument.append(str + " ");
						leftPivot = rightPivot;
						lastIndex = rightPivot;
						quite = true;
						break;
					}
				}
				rightPivot++;
			}

			if (!quite) {
				leftPivot++;
				rightPivot = leftPivot;
			} else {
				quite = false;
			}

		}

		return newDocument.toString();
	}

	public int returnLongestLength(ArrayList<String> dictionary) {
		int longestLength = 0;
		for (String word : dictionary) {
			if (word.length() > longestLength) {
				longestLength = word.length();
			}
		}
		return longestLength;
	}
}
