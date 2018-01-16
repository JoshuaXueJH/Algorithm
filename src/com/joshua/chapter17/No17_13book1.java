package com.joshua.chapter17;

import java.util.ArrayList;
import java.util.HashSet;

public class No17_13book1 {
	public static void main(String[] args) {
		String document = "jesslookedjustliketimherbrother";
		HashSet<String> dictionary = new HashSet<String>();
		dictionary.add("looked");
		dictionary.add("just");
		dictionary.add("like");
		dictionary.add("her");
		dictionary.add("brother");

		No17_13book1 instance = new No17_13book1();
		System.out.println(instance.bestSplit(dictionary, document));
	}

	String bestSplit(HashSet<String> dictionary, String sentence) {
		ParseResult r = split(dictionary, sentence, 0);
		return r == null ? null : r.parsed;
	}

	ParseResult split(HashSet<String> dictionary, String sentence, int start) {
		if (start >= sentence.length()) {
			return new ParseResult(0, "");
		}

		int bestInvalid = Integer.MAX_VALUE;
		String bestParsing = null;
		String partial = "";
		int index = start;
		while (index < sentence.length()) {
			char c = sentence.charAt(index);
			partial += c;
			int invalid = dictionary.contains(partial) ? 0 : partial.length();
			if (invalid < bestInvalid) {
				ParseResult result = split(dictionary, sentence, index + 1);
				if (invalid + result.invalid < bestInvalid) {
					bestInvalid = invalid + result.invalid;
					bestParsing = partial + " " + result.parsed;
					if (bestInvalid == 0)
						break;
				}
			}
			index++;
		}
		return new ParseResult(bestInvalid, bestParsing);
	}

	public class ParseResult {
		public int invalid = Integer.MAX_VALUE;
		public String parsed = "";

		public ParseResult(int invalid, String parsed) {
			this.invalid = invalid;
			this.parsed = parsed;
		}
	}
}
