package com.joshua.chapter8;

import java.util.ArrayList;

public class No8_4 {
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		ArrayList<ArrayList<Integer>> result = getSubsets(set);
		for (ArrayList<Integer> item : result) {
			for (int i : item) {
				System.out.print(i + "-->");
			}
			System.out.println();
		}

	}

	//此方法为书中方法，使用了二进制的移动，很巧妙
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = convertIntToSet(i, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}

	static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}

}
