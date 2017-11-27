package com.joshua.chapter16;

public class No16_9 {
	public static void main(String[] args) {
		System.out.println(divide(-10, 3));
	}

	//减法
	public static int subtract(int a, int b) {
		return a + negate(b);
	}

	// 根据书中的理念，自己写的代码
	public static int negate(int a) {
		int neg = 0;
		int newSign = a > 0 ? -1 : 1;

		int count = newSign;
		while (a != 0) {
			if (a + count < 0) { //此处跟书中做法不同，我的更简单
				count = newSign;
			}
			a += count;
			neg += count;
			count += count;
		}
		return neg;
	}

	//乘法
	public static int multiply(int a, int b) {
		boolean isNegative = (a > 0) ^ (b > 0);

		a = abs(a);
		b = abs(b);
		int multiplier = a >= b ? b : a;
		int faciend = a >= b ? a : b;

		int count = -1;
		int result = 0;
		while (multiplier > 0) {
			result += faciend;
			multiplier += count;
		}

		if (isNegative) {
			return negate(result);
		}
		return result;
	}

	public static int abs(int a) {
		if (a < 0) {
			return negate(a);
		}
		return a;
	}

	//除法
	//自己完成，用的减法，书中用的加法，代码几乎差不多。加法实现效率更高，因为减法也是基于加法写出来的
	public static int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Error");
		}

		boolean isNegative = (a > 0) ^ (b > 0);
		a = abs(a);
		b = abs(b);

		int result = 0;
		while (subtract(a, b) >= 0) {
			a = subtract(a, b);
			result += 1;
		}
		if (isNegative) {
			return negate(result);
		}
		return result;
	}
}
