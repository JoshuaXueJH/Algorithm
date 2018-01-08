package com.joshua.chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class No17_7 {
	public static void main(String[] args) {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		list.put("John", 15);
		list.put("Jon", 12);
		list.put("Chris", 13);
		list.put("Kris", 4);
		list.put("Christopher", 19);

		String[][] pairs = { { "Jon", "John" }, { "John", "Johnny" }, { "Chris", "Kris" }, { "Chris", "Christopher" } };

		No17_7 instance = new No17_7();
		HashMap<String, Integer> newList = instance.mergeNames(list, pairs);

		for (String key : newList.keySet()) {
			System.out.println(key + "---->" + newList.get(key));
		}
	}

	public HashMap<String, Integer> mergeNames(HashMap<String, Integer> list, String[][] pairs) {
		HashMap<String, Integer> newList = new HashMap<String, Integer>();

		for (String name : list.keySet()) {
			HashSet<String> synonyms = getSynonyms(pairs, name);

			if (synonyms.size() > 0) { // has synonym
				boolean found = false;
				for (String synonym : synonyms) {
					if (newList.containsKey(synonym)) { // synonym in the
														// newList
						newList.put(synonym, newList.get(synonym) + list.get(name));
						found = true;
						break;
					}
				}

				if (!found) {
					newList.put(name, list.get(name)); // synonym not in the
														// newList
				}
			} else { // no sysnonyms
				newList.put(name, list.get(name));
			}
		}

		return newList;
	}

	public HashSet<String> getSynonyms(String[][] pairs, String name) {
		ArrayList<HashSet<String>> cache = new ArrayList<HashSet<String>>();
		for (HashSet<String> entry : cache) {
			if (entry.contains(name)) {
				return entry;
			}
		}

		HashSet<String> synonyms = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(name);

		while (!queue.isEmpty()) {
			String synonym;
			for (int i = 0; i < pairs.length; i++) {
				synonym = findNameFromLine(pairs, i, queue.peek());

				if (synonym != null && !synonym.isEmpty() && !synonym.equals(name)) {
					if (!synonyms.contains(synonym)) {
						synonyms.add(synonym);
						queue.add(synonym);
					}
				}
			}
			queue.remove();
		}

		cache.add(synonyms);
		return synonyms;
	}

	public String findNameFromLine(String[][] pairs, int i, String name) {
		if (pairs[i][0].equals(name)) {
			return pairs[i][1];
		} else if (pairs[i][1].equals(name)) {
			return pairs[i][0];
		}
		return null;
	}

}
