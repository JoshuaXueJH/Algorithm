package com.joshua.chapter8;

public class No8_6 {
	public static void main(String[] args) {
		int n = 3;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}

		for (int i = 29; i >= 0; i--) {
			towers[0].add(i);
		}
		towers[0].moveDisk(30, towers[1], towers[2]);
	}

}
