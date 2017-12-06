package com.joshua.chapter16;

import java.util.Stack;

public class No16_26 {
	public static void main(String[] args) {
		String equation = "2*3+5/6*3+15";
		System.out.println(calculate(equation));
	}

	public static double calculate(String equation) {
		int length = equation.length();
		Stack<Integer> stack = new Stack<Integer>();

		int current = 0;
		while (current < length) {
			if (equation.charAt(current) == '*') {
				int a = stack.pop() * (equation.charAt(current + 1) - '0');
				stack.push(a);
				current += 2;
			} else if (equation.charAt(current) == '/') {
				int b = stack.pop() / (equation.charAt(current + 1) - '0');
				stack.push(b);
				current += 2;
			} else {
				if (equation.charAt(current) == '+' || equation.charAt(current) == '-') {
					stack.push((int) equation.charAt(current));
				} else {
					stack.push(equation.charAt(current) - '0');
				}
				current++;
			}
		}

		double result = 0.0;
		int out;
		while (current >= 0 && !stack.isEmpty()) {
			out = stack.pop();
			if (out != '+' && out != '-') {
				result = (double) out;
				current--;
			} else if (out == '+') {
				result = stack.pop() + result;
				current -= 2;
			} else if (out == '-') {
				result = stack.pop() - result;
				current -= 2;
			}

		}
		return result;
	}
}
