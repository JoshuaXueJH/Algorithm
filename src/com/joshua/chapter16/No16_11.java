package com.joshua.chapter16;

import java.util.HashSet;

public class No16_11 {
	//自己的做法，跟书中最有做法相同
	HashSet<Integer> allLengths(int k, int shorter, int longer) {
		HashSet<Integer> lengths = new HashSet<Integer>();
		for (int i = 0; i <= k; i++) {
			int length = i * shorter + (k - i) * longer;
			lengths.add(length);
		}
		return lengths;
	}
}
