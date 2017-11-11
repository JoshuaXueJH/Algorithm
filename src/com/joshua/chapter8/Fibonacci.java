package com.joshua.chapter8;

public class Fibonacci {
	// 1. Normal 
	int fibonacci1(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		return fibonacci1(i - 1) + fibonacci1(i - 2);
	}

	//2. top-down
	int fibonacci2(int n) {
		return fibonacci2(n, new int[n + 1]);
	}

	int fibonacci2(int n, int[] memo) {
		if (n == 0 || n == 1)
			return n;
		if (memo[n] == 0) {
			memo[n] = fibonacci2(n - 1, memo) + fibonacci2(n - 2, memo);
		}
		return memo[n];
	}

	//3. down-top
	int fibonacci3(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n - 1] + memo[n - 2];
	}

	// another way
	int fibonacci4(int n) {
		if (n == 0)
			return 0;

		int a = 0;
		int b = 1;
		int c;
		for (int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}
}
