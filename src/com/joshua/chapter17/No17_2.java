package com.joshua.chapter17;

import java.util.Random;

public class No17_2 {
	/**
	 * 此算法是看完书中理念自己完成的，跟书中基本一样，生成数字的rand方法不太相同
	 * @param cards
	 * @return
	 */
	public int[] shuffle(int[] cards) {
		return shuffle(cards, cards.length - 1);
	}

	public int[] shuffle(int[] cards, int i) {
		if (i == 0) {
			return cards;
		}

		cards = shuffle(cards, i - 1);
		int target = rand(i);
		swap(cards, target, i);

		return cards;
	}

	public void swap(int[] array, int target, int current) {
		int temp = array[target];
		array[target] = array[current];
		array[current] = temp;
	}

	public int rand(int top) {
		Random random = new Random();
		return random.nextInt(top + 1);
	}
}
