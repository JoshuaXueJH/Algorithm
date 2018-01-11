package com.joshua.chapter17;

import java.util.ArrayList;
import java.util.HashMap;

public class No17_11_2 {
	public static void main(String[] args) {
		String file = "aa 000 bb 111 cc dd 000 ff ee gg 000 ss 000 oo ll 111 hs sd ge we sd we gr we gw 111 we gr hr";
		No17_11_2 instance = new No17_11_2();
		No17_11_2.processFile(file.split(" "));
		System.out.println(instance.distanceOfWords(dictionary, "000", "111"));
	}

	/**
	 * 静态方法将file内容处理成HashMap<String, ArrayList<Integer>形式保存在静态变量
	 * @param dictionary
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int distanceOfWords(HashMap<String, ArrayList<Integer>> dictionary, String word1, String word2) {
		if (!dictionary.containsKey(word1) || !dictionary.containsKey(word2)) {
			return -1;
		}

		ArrayList<Integer> positions1 = dictionary.get(word1);
		ArrayList<Integer> positions2 = dictionary.get(word2);

		return findShortestDistance(positions1, positions2);
	}

	public int findShortestDistance(ArrayList<Integer> positions1, ArrayList<Integer> positions2) {
		int shortestDistance = Integer.MAX_VALUE;

		for (int i = 0; i < positions1.size(); i++) {
			int tag = Integer.MAX_VALUE; // 对每一轮做一个标记，如果标记越来越小，说明有可能出现最小值，如果增长，直接break，最小值不可能之后出现
			for (int j = 0; j < positions2.size(); j++) {
				int distance = Math.abs(positions1.get(i) - positions2.get(j));
				if (distance < shortestDistance) {
					shortestDistance = distance;
				}

				if (distance > tag) {
					break;
				} else {
					tag = distance;
				}
			}
		}

		return shortestDistance - 1;
	}

	public final static HashMap<String, ArrayList<Integer>> dictionary = new HashMap<String, ArrayList<Integer>>();

	public static void processFile(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (dictionary.containsKey(words[i])) {
				dictionary.get(words[i]).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				dictionary.put(words[i], list);
			}
		}
	}
}
