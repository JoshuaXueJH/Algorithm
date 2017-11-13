package com.joshua.chapter8;

import java.util.Stack;

public class Tower {
	private Stack<Integer> disks;
	private int index;

	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}

	public int index() {
		return index;
	}

	public void add(int i) {
		if (!disks.isEmpty() && disks.peek() <= i) {
			System.out.println("Error placing disk" + i);
		} else {
			disks.push(i);
		}
	}

	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
	}

	public void moveDisk(int n, Tower b, Tower c) {
		if (n > 0) {
			moveDisk(n - 1, c, b);
			moveTopTo(c);
			moveDisk(n - 1, this, c);
		}
	}
}
