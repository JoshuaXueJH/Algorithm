package com.joshua.chapter2;

public class No2_7 {
	public LinkedListNode findIntersect(LinkedListNode nodeA, LinkedListNode nodeB) {
		int lengthA = 0, lengthB = 0;
		LinkedListNode a = nodeA;
		LinkedListNode b = nodeB;

		while (a.next != null) {
			lengthA++;
			a = a.next;
		}

		while (b.next != null) {
			lengthB++;
			b = b.next;
		}

		if (a != b)
			return null;

		return lengthA > lengthB ? traverseBoth(nodeA, nodeB, lengthA - lengthB)
				: traverseBoth(nodeB, nodeA, lengthB - lengthA);
	}

	LinkedListNode traverseBoth(LinkedListNode list1, LinkedListNode list2, int lengthDiff) {
		while (lengthDiff > 0) {
			list1 = list1.next;
			lengthDiff--;
		}

		while (list1 != list2) {
			list1 = list1.next;
			list2 = list2.next;
		}
		return list1;
	}
}
