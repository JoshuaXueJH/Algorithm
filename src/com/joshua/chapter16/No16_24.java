package com.joshua.chapter16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No16_24 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 5, 12, 16, 17 };
		List<Pair> results = getPairs(array, 17);
		for (Pair result : results) {
			System.out.println(result.i + "--" + result.j);
		}
	}

	public static List<Pair> getPairs(int[] array, int sum) {
		ArrayList<Pair> results = new ArrayList<Pair>();
		HashSet<Integer> arraySet = new HashSet<Integer>();
		for (int i : array) {
			arraySet.add(i);
		}

		for (int j : array) {
			int target = sum - j;
			if (arraySet.contains(target)) {
				if (!results.contains(new No16_24().new Pair(target, j))) {
					results.add(new No16_24().new Pair(j, target));
				}

			}
		}
		return results;
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
