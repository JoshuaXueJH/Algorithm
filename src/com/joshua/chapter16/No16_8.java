package com.joshua.chapter16;

import java.util.LinkedList;

public class No16_8 {
	public static void main(String[] args) {
		System.out.println(describeNum2(10340));
	}

	public static String describeNum(int num) {
		if (num == 0) {
			return "Zero";
		}
		StringBuilder description = new StringBuilder();

		//split initial num to multiple sections, each section has three digits
		int[] sections = new int[4];
		int sectionCounter = 0;
		while (num != 0) {
			sections[sectionCounter] = num % 1000;
			sectionCounter++;
			num /= 1000;
		}

		for (int i = sections.length - 1; i >= 0; i--) {
			if (sections[i] > 0) {
				String sectionDescription = processSection(sections[i]);
				description.append(sectionDescription);
				if (i == 3) {
					description.append("Billion");
				} else if (i == 2) {
					description.append("Million");
				} else if (i == 1) {
					description.append("Thousand");
				} else {
					description.append("");
				}
				description.append(" ");
			}
		}
		return description.toString();
	}

	public static String processSection(int num) {
		String[] strs1 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eithteen", "Nineteen" };
		String[] strs2 = { "", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

		String[] sectionDescription = new String[3];
		if ((num % 100) < 20) {
			sectionDescription[0] = "";
			sectionDescription[1] = strs1[num % 100];
			num /= 100;
			if (num > 0) {
				sectionDescription[2] = strs1[num % 10] + "Hundred";
			}
		} else {
			sectionDescription[0] = strs1[num % 10];
			num /= 10;
			sectionDescription[1] = strs2[num % 10];
			num /= 10;
			if (num > 0) {
				sectionDescription[2] = strs1[num % 10] + "Hundred";
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i >= 0; i--) {
			if (sectionDescription[i] != null) {
				sb.append(sectionDescription[i]);
			}
		}
		return sb.toString();
	}

	//对以上方法的优化
	public static String describeNum2(int num) {
		if (num == 0) {
			return "Zero";
		}
		StringBuilder description = new StringBuilder();

		//split initial num to multiple sections, each section has three digits
		int[] sections = new int[4];
		int sectionCounter = 0;
		while (num != 0) {
			sections[sectionCounter] = num % 1000;
			sectionCounter++;
			num /= 1000;
		}

		for (int i = sections.length - 1; i >= 0; i--) {
			if (sections[i] > 0) {
				String sectionDescription = processSection2(sections[i], i);
				description.append(sectionDescription);
			}
		}
		return description.toString();
	}

	public static String processSection2(int num, int index) {
		String[] strs1 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eithteen", "Nineteen" };
		String[] strs2 = { "", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] strs3 = { "", "Thousand", "Million", "Billion" };

		String[] sectionDescription = new String[3];
		if ((num % 100) < 20) {
			sectionDescription[0] = "";
			sectionDescription[1] = strs1[num % 100];
			num /= 100;
			if (num > 0) {
				sectionDescription[2] = strs1[num % 10] + "Hundred";
			}
		} else {
			int counter = 0;
			while (num > 0) {
				switch (counter) {
				case 0:
					sectionDescription[counter] = strs1[num % 10];
					break;
				case 1:
					sectionDescription[counter] = strs2[num % 10];
					break;
				case 2:
					sectionDescription[counter] = strs1[num % 10] + "Hundred";
				}
				counter++;
				num /= 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i >= 0; i--) {
			if (sectionDescription[i] != null) {
				sb.append(sectionDescription[i]);
			}
		}
		return sb.toString() + strs3[index] + " ";
	}

	// 看了书上的方法，对自己的方法进行优化
	public static String describeNum3(int num) {
		if (num == 0) {
			return "Zero";
		}
		LinkedList<String> list = new LinkedList<String>();

		int sectionCounter = 0;
		while (num != 0) {
			if (num % 1000 > 0) {
				String sectionDescription = processSection3(num % 1000, sectionCounter);
				list.addFirst(sectionDescription);
			}
			sectionCounter++;
			num /= 1000;
		}

		StringBuilder description = new StringBuilder();
		for (String str : list) {
			description.append(str);
		}
		return description.toString();
	}

	public static String processSection3(int num, int index) {
		String[] strs1 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eithteen", "Nineteen" };
		String[] strs2 = { "", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] strs3 = { "", "Thousand", "Million", "Billion" };

		String[] sectionDescription = new String[3];
		if ((num % 100) < 20) {
			sectionDescription[0] = "";
			sectionDescription[1] = strs1[num % 100];
			num /= 100;
			if (num > 0) {
				sectionDescription[2] = strs1[num % 10] + "Hundred";
			}
		} else {
			int counter = 0;
			while (num > 0) {
				switch (counter) {
				case 0:
					sectionDescription[counter] = strs1[num % 10];
					break;
				case 1:
					sectionDescription[counter] = strs2[num % 10];
					break;
				case 2:
					sectionDescription[counter] = strs1[num % 10] + "Hundred";
				}
				counter++;
				num /= 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i >= 0; i--) {
			if (sectionDescription[i] != null) {
				sb.append(sectionDescription[i]);
			}
		}
		return sb.toString() + strs3[index] + " ";
	}
}
