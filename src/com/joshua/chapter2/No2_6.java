package com.joshua.chapter2;

public class No2_6 {

	/**
	 * 一次取出单链表中数据存入sb，sb编程char[]，然后判断char[]是否是palindrome
	 * @param node
	 * @return
	 */
	public boolean isPalindrome(LinkedListNode node) {
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.data);
			node = node.next;
		}

		char[] linkedListToCharArray = sb.toString().toCharArray();

		int length = linkedListToCharArray.length;

		for (int i = 0; i < length / 2; i++) {
			if (linkedListToCharArray[i] != linkedListToCharArray[length - 1 - i])
				return false;
		}
		return true;
	}
}
