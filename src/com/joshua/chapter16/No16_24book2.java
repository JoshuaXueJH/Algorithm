package com.joshua.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No16_24book2 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 5, 12, 16, 17 };
		List<Pair> results = findSumPairs(array, 17);
		for (Pair result : results) {
			System.out.println(result.i + "--" + result.j);
		}
	}

	/**
	 * 按照书中的思想写的，但是实现方法跟书中有所不同
	 * 虽然看上去有两层的while，但是其实抛开排序的时间复杂度来讲，这段算法自身的时间复杂度还是n
	 * @param array
	 * @param sum
	 * @return
	 */
	public static ArrayList<Pair> findSumPairs(int[] array, int sum) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int target = sum - array[first];
			while (array[first] + array[last] >= sum) { // 或者是while(array[last] >= target)
				if (target == array[last]) {
					result.add(new No16_24book2().new Pair(array[first], target));
				}
				last--;
			}
			first++;
		}
		return result;
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
