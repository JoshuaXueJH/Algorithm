package com.joshua.chapter10;

public class No10_5 {
	public static void main(String[] args) {
//		String[] strs = new String[] { "", "", "", "", "aa", "bb", "", "", "", "cc", "", "", "dd", "ee", "", "", "",
//				"ff", "", "", "", "rr" };
		String[] strs = new String[] {"ee"};
		System.out.println(findIndexOrigin(strs, "ee"));
	}

	//此方法用了while循环，也同样可以使用递归
	public static int findIndex(String[] strs, String str) {
		int begin = 0;
		while (strs[begin] == "") {
			begin++;
		}
		int end = strs.length - 1;
		while (strs[end] == "") {
			end--;
		}
		return findIndex(strs, str, begin, end);
	}

	public static int findIndex(String[] strs, String str, int begin, int end) {
		while (begin <= end) {
			int middle1 = (begin + end) / 2;
			int middle2 = middle1;
			while (strs[middle2].equals("")) {
				middle2++;
			}
			String middleValue = strs[middle2];
			if (middleValue.equals(str)) {
				return middle2;
			} else if (middleValue.compareTo(str) < 0) {
				begin = middle2 + 1;
			} else {
				end = middle1 - 1;
			}
		}
		return -1;
	}

	// 以下是最初的版本，但是会存在bug
	//比如string数组{ "", "", "", "", "aa", "bb", "", "", "", "cc", "", "", "dd", "ee", "", "", "", "ff", "", "", "", "rr" }为例
	//由于每次坐标middle值若为""会向右移动middle指针，直至middle位置的值为字符串， 那么若""足够多，移动多次后再次取middle，可能会出现每次计算出的middle都移动到同一个位置，这样会导致无限循环
	public static int findIndexOrigin(String[] strs, String str) {
		if (strs == null || str == null || str == "") {
			return -1;
		}

		int begin = 0;
		while (strs[begin] == "") {
			begin++;
		}
		int end = strs.length - 1;
		while (strs[end] == "") {
			end--;
		}
		return findIndexOrigin(strs, str, begin, end);
	}

	public static int findIndexOrigin(String[] strs, String str, int begin, int end) {
		while (begin <= end) {
			int middle = (begin + end) / 2;
			while (strs[middle].equals("")) {
				middle++;
			}
			String middleValue = strs[middle];
			if (middleValue.equals(str)) {
				return middle;
			} else if (middleValue.compareTo(str) < 0) {
				begin = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return -1;
	}
}
