package com.joshua.chapter17;

import java.util.HashMap;

public class No17_5book {
	public static void main(String[] args) {
		No17_5book instance = new No17_5book();
		//char[] array = { '4', '5', 'f', '2', 'd', 'h', 's', 's', 'f', 's', 'j' };
		char[] array = { '4', '5', '3', '2', '2', '2', '2', '2', '2', '2', '2' };

		char[] result = instance.findSubArray(array);
		if (result != null) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		} else {
			System.out.println("empty");
		}
	}

	public char[] findSubArray(char[] array) {
		int[] deltas = calculateDeltas(array);
		int[] match = findLongestMatch(deltas);
		return getSubArray(array, match[0] + 1, match[1]);
	}

	public int[] calculateDeltas(char[] array) {
		int[] deltas = new int[array.length];
		int numOfNum = 0;
		int numOfLetter = 0;

		for (int i = 0; i < array.length; i++) {
			if (Character.isDigit(array[i])) {
				numOfNum++;
			} else if (Character.isLetter(array[i])) {
				numOfLetter++;
			}
			deltas[i] = numOfLetter - numOfNum;
		}

		return deltas;
	}

	public int[] findLongestMatch(int[] deltas) {
		int[] match = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1); // 此处这行很重要
		int maxDistance = 0;

		for (int i = 0; i < deltas.length; i++) {
			if (!map.containsKey(deltas[i])) {
				map.put(deltas[i], i);
			} else {
				int distance = i - map.get(deltas[i]);
				if (distance > maxDistance) {
					maxDistance = distance;
					match[0] = map.get(deltas[i]);
					match[1] = i;
				}
			}
		}

		return match;
	}

	public char[] getSubArray(char[] array, int start, int end) {
		char[] result = new char[end - start + 1];

		for (int i = start; i <= end; i++) {
			result[i - start] = array[i];
		}
		return result;
	}
}
