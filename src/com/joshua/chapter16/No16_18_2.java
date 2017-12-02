package com.joshua.chapter16;

public class No16_18_2 {
	public static void main(String[] args) {
		String value = "catcatgocatgogocat";
		String pattern = "aababba";
		System.out.println(matchesPattern(pattern, value));
	}

	public static boolean matchesPattern(String pattern, String value) {
		int valueLen = value.length();
		int patternLen = pattern.length();

		if (valueLen < patternLen) {
			return false;
		}
		if (patternLen == 1) {
			return true;
		}
		if (!pattern.contains("a") || !pattern.contains("b")) {
			return false;
		}

		int countA = 0;
		int countB = 0;
		for (int i = 0; i < patternLen; i++) {
			if (pattern.charAt(i) == 'a') {
				countA++;
			} else {
				countB++;
			}
		}

		int countPosition = 0;
		int[] aLenCandidates = new int[valueLen]; // possible length of part a
		int[] bLenCandidates = new int[valueLen]; // possible length of part b
		for (int i = 1; i <= valueLen; i++) {
			int aPart = i * countA; // a's total length
			int bPart = valueLen - aPart; // b's total length
			if (bPart < 0) {
				break;
			}
			if (bPart % countB == 0) {
				aLenCandidates[countPosition] = i;
				bLenCandidates[countPosition] = bPart / countB;
				countPosition++;
			}
		}

		for (int i = 0; i < countPosition; i++) {
			if (cutValueAndValidate(value, pattern, aLenCandidates[i], bLenCandidates[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean cutValueAndValidate(String value, String pattern, int partA, int partB) {
		String a = null;
		String b = null;
		boolean flagA = false;
		boolean flagB = false;
		int position = 0; //切割value的过程中position代表位置
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == 'a') {
				if (flagA == false) {
					a = value.substring(position, position + partA);
					flagA = true;
				}
				if (!value.substring(position, position + partA).equals(a)) {
					return false;
				}
				position += partA;
			} else {
				if (flagB == false) {
					b = value.substring(position, position + partB);
					flagB = true;
				}
				if (!value.substring(position, position + partB).equals(b)) {
					return false;
				}
				position += partB;
			}
		}
		return true;
	}
}
