package com.joshua.chapter2;

public class LinkedListNode {
	LinkedListNode next;
	int data;

	public LinkedListNode(int d) {
		this.data = d;
	}

	public void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while (this.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
