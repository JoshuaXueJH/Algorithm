package com.joshua.chapter16;

public class No16_18 {
	public static void main(String[] args) {
		String value = "catcatgocatgogo";
		String pattern = "aababb";
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
			int partA = aLenCandidates[i];
			int partB = bLenCandidates[i];
			String[] pieces = cutValueToPieces(value, pattern, partA, partB);
			if (fitsPattern(pieces, pattern)) {
				return true;
			}
		}
		return false;
	}

	public static String[] cutValueToPieces(String value, String pattern, int partA, int partB) {
		StringBuilder sb = new StringBuilder();
		int position = 0;
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (ch == 'a') {
				sb.append(value.substring(position, position + partA));
				position += partA;
			} else {
				sb.append(value.substring(position, position + partB));
				position += partB;
			}
			sb.append(" ");
		}
		return sb.toString().split(" ");
	}

	public static boolean fitsPattern(String[] pieces, String pattern) {
		String a = null;
		String b = null;
		boolean flagA = false;
		boolean flagB = false;
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (ch == 'a') {
				if (flagA == false) {
					a = pieces[i];
					flagA = true;
				}
				if (!pieces[i].equals(a)) {
					return false;
				}
			} else {
				if (flagB == false) {
					b = pieces[i];
					flagB = true;
				}
				if (!pieces[i].equals(b)) {
					return false;
				}
			}
		}
		return true;
	}
}
