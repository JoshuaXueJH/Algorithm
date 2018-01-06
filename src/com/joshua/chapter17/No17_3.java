package com.joshua.chapter17;

import java.util.Random;

public class No17_3 {
	public static void main(String[] args) {
		No17_3 instance = new No17_3();
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int[] result = instance.generateNumbers(array, 5);
		for (int i : result) {
			System.out.println(i);
		}
	}

	/**
	 * 此方式跟书中不同
	 * 设置m长度的标记， 每次等概率随机生成一个0 - array.length - 1的数字，将此数字假如结果序列，若此数字已经标记过，则循环继续
	 * @param array
	 * @param resultArraySize
	 * @return
	 */
	public int[] generateNumbers(int[] array, int resultArraySize) {
		if (resultArraySize > array.length)
			return null;
		else if (resultArraySize == array.length)
			return array;

		int[] resultArray = new int[resultArraySize];
		boolean[] flags = new boolean[array.length];
		int pivot = 0;

		while (pivot < resultArraySize) {
			int position = generatePosition(array.length);
			if (flags[position] == false) {
				resultArray[pivot] = array[position];
				pivot++;
				flags[position] = true;
			}
		}

		return resultArray;
	}

	public int generatePosition(int length) {
		Random random = new Random();
		return random.nextInt(length);
	}
}
