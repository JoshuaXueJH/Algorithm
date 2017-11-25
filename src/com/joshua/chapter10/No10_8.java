package com.joshua.chapter10;

import java.util.BitSet;

public class No10_8 {
	public static void main(String[] args) {
		int[] numbers = new int[32000];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		numbers[99] = 100;
		numbers[100] = 1000;
		numbers[1000] = 99;
		numbers[88] = 99;
		numbers[1] = 99;
		checkDuplicates2(numbers);
	}

	/**
	 * 参考了10_7的方式来做，跟书中略有不同，但是思路差不多
	 * @param numbers
	 */
	public static void checkDuplicates(int[] numbers) {
		byte[] bitsfield = new byte[4000];

		for (int num : numbers) {
			if ((bitsfield[num / 8] & (1 << (num % 8))) >> (num % 8) == 1) { //if ((bitsfield[num / 8] & (1 << (num % 8))) != 0)
				System.out.println(num);
			} else {
				bitsfield[num / 8] |= (1 << (num % 8));
			}
		}
	}

	/**
	 * 把自己的方法用java内部的BitSet来实现
	 */
	public static void checkDuplicates2(int[] numbers) {
		BitSet bitsfield = new BitSet(32000);
		for (int num : numbers) {
			if (bitsfield.get(num)) {
				System.out.println(num);
			} else {
				bitsfield.set(num);
			}
		}
	}
}
