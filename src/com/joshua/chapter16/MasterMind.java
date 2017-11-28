package com.joshua.chapter16;

import java.util.Random;

public class MasterMind {
	private final int MAX_LEN = 4;
	private static MasterMind instance = null;

	private MasterMind() {

	}

	public static MasterMind getInstance() {
		if (instance == null) {
			instance = new MasterMind();
			return instance;
		}
		return instance;
	}

	char[] colours = { 'R', 'Y', 'G', 'B' };

	public char[] generateColourSet() {
		char[] colourSet = new char[MAX_LEN];
		Random random = new Random();
		for (int i = 0; i < colourSet.length; i++) {
			colourSet[i] = colours[random.nextInt(4)];
		}
		return colourSet;
	}

	public Result analyzeGuess(char[] guess, char[] colourSet) {
		int[] hitFlags = new int[MAX_LEN];
		int[] pseudoFlags = new int[MAX_LEN];
		Result result = new Result();

		// count hit
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == colourSet[i]) {
				hitFlags[i] = 1;
				result.hit++;
			}
		}

		// count pseudohit
		for (int j = 0; j < guess.length; j++) {
			if (hitFlags[j] != 1) {
				for (int k = 0; k < colourSet.length; k++) {
					if (guess[j] == colourSet[k] && hitFlags[k] != 1 && pseudoFlags[k] != 1) {
						pseudoFlags[k] = 1;
						result.pseudohit++;
						break;
					}
				}
			}
		}

		return result;
	}

	class Result {
		public int hit;
		public int pseudohit;

		public String toString() {
			return "hit num:" + hit + ", pseudohit num:" + pseudohit;
		}
	}
}
