package com.joshua.chapter16;

import java.util.Stack;

public class No16_26book {
	public static void main(String[] args) {
		String sequence = "2*3+5/6*3+15";
		System.out.println(compute(sequence));
	}

	public enum Operator {
		ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK
	}

	public static double compute(String sequence) {
		Stack<Double> numberStack = new Stack<Double>();
		Stack<Operator> operatorStack = new Stack<Operator>();

		for (int i = 0; i < sequence.length(); i++) {
			try {
				int value = parseNextNumber(sequence, i);
				numberStack.push((double) value);

				i += Integer.toString(value).length();
				if (i >= sequence.length()) {
					break;
				}

				Operator op = parseNextOperator(sequence, i);
				collapseTop(op, numberStack, operatorStack);
				operatorStack.push(op);
			} catch (NumberFormatException ex) {
				return Integer.MIN_VALUE;
			}
		}

		collapseTop(Operator.BLANK, numberStack, operatorStack);
		if (numberStack.size() == 1 && operatorStack.size() == 0) {
			return numberStack.pop();
		}
		return 0;
	}

	public static void collapseTop(Operator futureTop, Stack<Double> numberStack, Stack<Operator> operatorStack) {
		while (operatorStack.size() >= 1 && numberStack.size() >= 2) {
			if (priorityOfOperator(futureTop) <= priorityOfOperator(operatorStack.peek())) {
				double second = numberStack.pop();
				double first = numberStack.pop();
				Operator op = operatorStack.pop();
				double collapsed = applyOp(first, op, second);
				numberStack.push(collapsed);
			} else {
				break;
			}
		}
	}

	public static int priorityOfOperator(Operator op) {
		switch (op) {
		case ADD:
			return 1;
		case SUBTRACT:
			return 1;
		case MULTIPLY:
			return 2;
		case DIVIDE:
			return 2;
		case BLANK:
			return 0;
		}
		return 0;
	}

	public static double applyOp(double left, Operator op, double right) {
		if (op == Operator.ADD)
			return left + right;
		else if (op == Operator.SUBTRACT)
			return left - right;
		else if (op == Operator.MULTIPLY)
			return left * right;
		else if (op == Operator.DIVIDE)
			return left / right;
		else
			return right;
	}

	public static int parseNextNumber(String seq, int offset) {
		StringBuilder sb = new StringBuilder();
		while (offset < seq.length() && Character.isDigit(seq.charAt(offset))) {
			sb.append(seq.charAt(offset));
			offset++;
		}
		return Integer.parseInt(sb.toString());
	}

	public static Operator parseNextOperator(String sequence, int offset) {
		if (offset < sequence.length()) {
			char op = sequence.charAt(offset);
			switch (op) {
			case '+':
				return Operator.ADD;
			case '-':
				return Operator.SUBTRACT;
			case '*':
				return Operator.MULTIPLY;
			case '/':
				return Operator.DIVIDE;
			}
		}
		return Operator.BLANK;
	}
}
