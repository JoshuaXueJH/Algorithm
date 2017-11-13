package com.joshua.chapter8;

import java.util.HashMap;
import java.util.Map.Entry;

public class No8_5 {
	public static void main(String[] args) {
		System.out.println(minProduct2(17, 23));
	}

	//自己完成的，对于书中第一种方式的优化。
	//与书中的第二种方式理念相同，但是实现方法有点不同
	static int minProduct(int a, int b) {
		int bigger = a > b ? a : b;
		int smaller = a > b ? b : a;
		HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
		int result = minProductHelper(smaller, bigger, history);
		for (Entry<Integer, Integer> item : history.entrySet()) {
			System.out.println(item.getKey() + "-->" + item.getValue());
		}
		return result;
	}

	static int minProductHelper(int smaller, int bigger, HashMap<Integer, Integer> history) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		} else if (history.containsKey(smaller)) {
			return history.get(smaller);
		}

		int s = smaller >> 1;
		int smallHalfSum = minProductHelper(s, bigger, history);
		history.put(s, smallHalfSum);
		int bigHalfSum = smallHalfSum;
		if (smaller % 2 == 1) {
			bigHalfSum = minProductHelper(smaller - s, bigger, history);
		}
		return smallHalfSum + bigHalfSum;
	}

	//-------------书中的第二种方法, 和我的方法记录的值不同，书中的稍好点----------------
	static int minProduct2(int a, int b) {
		int bigger = a > b ? a : b;
		int smaller = a > b ? b : a;
		int[] memo = new int[smaller + 1];
		int result = minProductHelper2(smaller, bigger, memo);
		for (int i = 0; i < memo.length; i++) {
			if (memo[i] > 0) {
				System.out.println(i + "-->" + memo[i]);
			}
		}
		return result;
	}

	static int minProductHelper2(int smaller, int bigger, int[] memo) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		} else if (memo[smaller] > 0) {
			return memo[smaller];
		}

		int s = smaller >> 1;
		int smallHalfSum = minProductHelper2(s, bigger, memo);
		int bigHalfSum = smallHalfSum;
		if (smaller % 2 == 1) {
			bigHalfSum = minProductHelper2(smaller - s, bigger, memo);
		}
		memo[smaller] = smallHalfSum + bigHalfSum;
		return memo[smaller];
	}
}
