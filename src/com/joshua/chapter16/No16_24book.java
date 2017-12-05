package com.joshua.chapter16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No16_24book {
	public static void main(String[] args) {
		int[] array = { 1, 2, 5, 12, 16, 17 };
		List<Pair> results = printPairSums(array, 17);
		for (Pair result : results) {
			System.out.println(result.i + "--" + result.j);
		}
	}

	public static ArrayList<Pair> printPairSums(int[] array, int sum) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		HashMap<Integer, Integer> unpairedCount = new HashMap<Integer, Integer>();
		for (int x : array) {
			int complement = sum - x;
			if (unpairedCount.getOrDefault(complement, 0) > 0) {
				result.add(new No16_24book().new Pair(x, complement));
				adjustCounterBy(unpairedCount, complement, -1);
			} else {
				adjustCounterBy(unpairedCount, x, 1);
			}
		}
		return result;
	}

	public static void adjustCounterBy(HashMap<Integer, Integer> counter, int key, int delta) {
		counter.put(key, counter.getOrDefault(key, 0) + delta);
	}

	public class Pair {
		public int i;
		public int j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
