package com.joshua.chapter2;

public class No2_8 {
	LinkedListNode findBeginning(LinkedListNode head) {
		LinkedListNode first = head;
		LinkedListNode second = head;

		while (second.next != null) {
			second = second.next;
		}

		while (first != second) {
			first = first.next;
		}
		return first;
	}
}
