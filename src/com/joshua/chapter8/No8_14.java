package com.joshua.chapter8;

public class No8_14 {
	public static void main(String[] args) {
		System.out.println(countEval("0&0&0&1^1|0", true));
	}

	public static int countEval(String s, boolean result) {
		if (s.length() == 0)
			return 0;
		if (s.length() == 1) {
			if (s.equals("1") == result) {
				return 1;
			} else {
				return 0;
			}
		}

		int ways = 0;
		for (int i = 1; i < s.length(); i += 2) {
			String left = s.substring(0, i);
			String right = s.substring(i + 1);

			int leftTrue = countEval(left, true);
			int leftFalse = countEval(left, false);
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

			int totalTrue = 0;
			if (s.charAt(i) == '&') {
				totalTrue += leftTrue * rightTrue;
			} else if (s.charAt(i) == '^') {
				totalTrue += leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (s.charAt(i) == '|') {
				totalTrue += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
			}

			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		return ways;
	}
}
