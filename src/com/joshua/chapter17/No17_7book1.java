package com.joshua.chapter17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class No17_7book1 {
	public static void main(String[] args) {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		list.put("John", 10);
		list.put("Jon", 3);
		list.put("Davis", 2);
		list.put("Kari", 3);
		list.put("Johnny", 11);
		list.put("Carlton", 8);
		list.put("Carleton", 2);
		list.put("Jonathan", 9);
		list.put("Carrie", 5);

		String[][] pairs = { { "Jonathan", "John" }, { "Jon", "Johnny" }, { "Johnny", "John" }, { "Kari", "Carrie" },
				{ "Carleton", "Carlton" } };

		No17_7book1 instance = new No17_7book1();
		HashMap<String, Integer> newList = instance.trulyMostPopular(list, pairs);
		for (String key : newList.keySet()) {
			System.out.println(key + "---->" + newList.get(key));
		}
	}

	HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms) {
		HashMap<String, NameSet> groups = constructGroups(names);
		mergeClasses(groups, synonyms);
		return convertToMap(groups);
	}

	HashMap<String, Integer> convertToMap(HashMap<String, NameSet> groups) {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		for (NameSet group : groups.values()) {
			list.put(group.getRootName(), group.getFrequency());
		}
		return list;
	}

	void mergeClasses(HashMap<String, NameSet> groups, String[][] synonyms) {
		for (String[] entry : synonyms) {
			String name1 = entry[0];
			String name2 = entry[1];
			NameSet set1 = groups.get(name1);
			NameSet set2 = groups.get(name2);
			if (set1 != set2) {
				NameSet smaller = set2.size() < set1.size() ? set2 : set1;
				NameSet bigger = set2.size() < set1.size() ? set1 : set2;

				Set<String> otherNames = smaller.getNames();
				int frequency = smaller.getFrequency();
				bigger.copyNamesWithFrequency(otherNames, frequency);

				for (String name : otherNames) {
					groups.put(name, bigger);
				}
			}
		}
	}

	HashMap<String, NameSet> constructGroups(HashMap<String, Integer> names) {
		HashMap<String, NameSet> groups = new HashMap<String, NameSet>();
		for (Entry<String, Integer> entry : names.entrySet()) {
			String name = entry.getKey();
			int frequency = entry.getValue();
			NameSet group = new NameSet(name, frequency);
			groups.put(name, group);
		}
		return groups;
	}

	public class NameSet {
		private Set<String> names = new HashSet<String>();
		private int frequency = 0;
		private String rootName;

		public NameSet(String name, int freq) {
			names.add(name);
			frequency = freq;
			rootName = name;
		}

		public void copyNamesWithFrequency(Set<String> more, int freq) {
			names.addAll(more);
			frequency += freq;
		}

		public Set<String> getNames() {
			return names;
		}

		public String getRootName() {
			return rootName;
		}

		public int getFrequency() {
			return frequency;
		}

		public int size() {
			return names.size();
		}
	}
}
