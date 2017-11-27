package com.joshua.chapter16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No16_10 {

	public class Person {
		private String name;
		private int age;
		private int birthYear;
		private int deathYear;

		public Person(String name, int birthYear, int deathYear) {
			this.name = name;
			this.birthYear = birthYear;
			this.deathYear = deathYear;
			age = deathYear - birthYear - 1;
		}

		public int getBirthYear() {
			return birthYear;
		}

		public int getDeathYear() {
			return deathYear;
		}
	}

	// first version
	public int yearWithMostAlive(List<Person> persons) {
		Map<Integer, Integer> record = new HashMap<Integer, Integer>();
		for (int i = 1900; i <= 2017; i++) {
			record.put(i, 0);
		}

		for (Person person : persons) {
			updateRecord(record, person);
		}

		int yearWithMostAlive = 0;
		for (int year : record.keySet()) {
			if (record.get(year) > record.get(yearWithMostAlive)) {
				yearWithMostAlive = year;
			}
		}
		return yearWithMostAlive;
	}

	public static void updateRecord(Map<Integer, Integer> record, Person person) {
		for (int i = person.getBirthYear(); i <= person.getDeathYear(); i++) {
			record.put(i, record.get(i) + 1);
		}
	}

	// second version
	// 时间复杂度是O(PY) P代表people数量， Y代表平均年龄
	public int yearWithMostAlive2(List<Person> persons) {
		Map<Integer, Integer> record = new HashMap<Integer, Integer>();

		int yearWithMostAlive = 0;
		for (Person person : persons) {
			yearWithMostAlive = updateRecordAndReturnPeak(record, person, yearWithMostAlive);
		}

		return yearWithMostAlive;
	}

	public static int updateRecordAndReturnPeak(Map<Integer, Integer> record, Person person, int year) {
		for (int i = person.getBirthYear(); i <= person.getDeathYear(); i++) {
			if (record.containsKey(i)) {
				record.put(i, record.get(i) + 1);
			} else {
				record.put(i, 1);
			}

			if (record.get(year) == null || record.get(year) < record.get(i)) {
				year = i;
			}
		}
		return year;
	}

}
