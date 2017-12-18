package com.joshua.chapter16;

import java.util.ArrayList;

import com.joshua.chapter16.No16_26book1.Term.Operator;

public class No16_26book1 {
	double compute(String sequence) {
		ArrayList<Term> terms = Term.parseTermSequence(sequence);
		if (terms == null)
			return Integer.MIN_VALUE;

		double result = 0;
		Term processing = null;

		for (int i = 0; i < terms.size(); i++) {
			Term current = terms.get(i);
			Term next = i + 1 < terms.size() ? terms.get(i + 1) : null;

			processing = collapseTerm(processing, current);

			if (next == null || next.getOperator() == Operator.ADD || next.getOperator() == Operator.SUBTRACT) {
				result = applyOp(result, processing.getOperator(), processing.getNumber());
			}
		}
		return result;
	}

	Term collapseTerm(Term primary, Term secondary) {
		if (primary == null)
			return secondary;
		if (secondary == null)
			return primary;

		double value = applyOp(primary.getNumber(), secondary.getOperator(), secondary.getNumber());
		primary.setNumber(value);
		return primary;
	}

	double applyOp(double left, Operator op, double right) {
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

	public static class Term {
		public enum Operator {
			ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK
		}

		private double value;
		private Operator operator = Operator.BLANK;

		public Term(double v, Operator op) {
			value = v;
			operator = op;
		}

		public double getNumber() {
			return value;
		}

		public Operator getOperator() {
			return operator;
		}

		public void setNumber(double v) {
			value = v;
		}

		public static ArrayList<Term> parseTermSequence(String sequence) {
			return null;
		}
	}
}
