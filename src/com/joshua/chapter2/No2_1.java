package com.joshua.chapter2;

import java.util.HashSet;
import java.util.LinkedList;

public class No2_1 {
	public static void main(String[] args) {

	}

	public static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();

		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
}
