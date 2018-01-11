package com.joshua.chapter17;

public class No17_11_1 {
	public static void main(String[] args) {
		String file = "aa 000 bb 111 cc dd 000 ff ee gg 000 ss 000 oo ll 111 hs sd ge we sd we gr we gw 111 we gr hr";
		String[] words = file.split(" ");
		No17_11_1 instance = new No17_11_1();
		System.out.println(instance.distanceOfWords(words, "000", "111"));
	}

	/**
	 * 本题目分为两部分
	 * 以下为第一部分
	 * 思路： 1. 遍历一次words。 初试状态current和expectation都为null，发现word1就将current设为word1， expectation设为word2， 并记录current的位置。 反之亦然。 
	 * 2. 之后若发现当前位置等于expectation， 立即计算当前位置和前边记录的current的位置差，小于最小距离就更新，否则跳过。 并且交换current和expectation的内容。
	 * 3. 之后若发现当前位置是current，就更新第一步记录的current的位置（因为此刻期待的是expectation， 显然最新的current距离下一个即将期待出签的expectation更近，才有是最小距离的可能性）
	 * 这种方式能够实现算法，但是代码看着有点冗余，不优雅
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int distanceOfWords(String[] words, String word1, String word2) {
		int shortestDistance = Integer.MAX_VALUE;
		String current = null;
		String expectation = null;
		int previousIndex = -1;

		for (int i = 0; i < words.length; i++) {
			if (current == null && expectation == null) {
				if (words[i].equals(word1)) {
					current = word1;
					expectation = word2;
					previousIndex = i;
				} else if (words[i].equals(word2)) {
					current = word2;
					expectation = word1;
					previousIndex = i;
				}
			} else {
				if (words[i].equals(expectation)) {
					swap(current, expectation);
					int distance = i - previousIndex;
					if (distance < shortestDistance) {
						shortestDistance = distance;
					}
				}
				if (words[i].equals(current)) {
					previousIndex = i;
				}
			}
		}

		return shortestDistance - 1;
	}

	public void swap(String current, String expectation) {
		String temp = current;
		current = expectation;
		expectation = temp;
	}
}
