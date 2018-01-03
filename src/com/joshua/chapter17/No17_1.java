package com.joshua.chapter17;

import java.util.Random;

public class No17_1 {
	public static void main(String[] args) {
		No17_1 instance = new No17_1();

		System.out.println(instance.add(39, -44));
		System.out.println(instance.subtract(39, -44));
	}

	public int add(int a, int b) {
		while (b != 0) {
			int sum = a ^ b;
			int carry = (a & b) << 1;
			a = sum;
			b = carry;
		}
		return a;
	}

	public int subtract(int a, int b) {
		return add(a, -b);
	}
}
