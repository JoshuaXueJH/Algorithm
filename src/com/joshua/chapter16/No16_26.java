package com.joshua.chapter16;

import java.util.Stack;

/**
 * 想通过一个栈来实现计算
 * 如果是+ -运算则允许入栈
 * 如果是* /运算则先进行运算再将结果入栈，
 * 最后再做一次出栈操作，讲所有+ -运算完成
 * 返回最终结果
 * 
 * 但是问题在于如何用一个栈保存运算符（char）和数字（double）
 * @author JianHuaXue
 *
 */
public class No16_26 {
	public static void main(String[] args) {
		String equation = "2*3+5/6*3+15";
		System.out.println(calculate(equation));
	}

	public static double calculate(String equation) { // charAt()方法每次取一个char，数字15会被分割成1和5，不正确
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
