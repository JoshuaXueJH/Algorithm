package com.joshua.chapter16;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No16_19 {
	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 } };
		getPonds(matrix);
	}

	public static void getPonds(int[][] matrix) {
		if (matrix == null)
			return;

		int rows = matrix.length;
		int columns = matrix[0].length;

		List<Plot> plots = new ArrayList<Plot>();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == 0) {
					plots.add(new Plot(i, j));
				}
			}
		}

		countArea(plots);
	}

	public static void countArea(List<Plot> plots) {
		if (plots.size() == 0)
			return;

		for (Plot plot : plots) {
			if (plot.getVisited() == false) {
				int size = 0;
				Stack<Plot> stack = new Stack<Plot>();
				stack.push(plot);
				// 此处需要注意，最开始我的算法是入栈不会size++， 也不会setVisited()， 但是这样会有重复计算的问题出现，
				// 试想，a周围有b和c两个相连接的水域，扫描到bc都会入栈，但是都不会size++也不会setVisited()， 
				// 然后从栈中会按照顺序取出a，然后b，此时若b和c也相连，那么由于c未被setVisited()，因此会再次入栈一次，因此会出现重复计算问题
				size++; 
				plot.setVisited();

				while (!stack.isEmpty()) {
					Plot current = stack.pop();
					for (Plot p : plots) {
						if (isAjacent(current, p) && p.getVisited() == false) {
							stack.push(p);
							size++;
							p.setVisited();
						}
					}
				}
				System.out.println(size);
			}
		}
	}

	public static boolean isAjacent(Plot p1, Plot p2) {
		if (Math.abs(p1.getRow() - p2.getRow()) <= 1 && Math.abs(p1.getColumn() - p2.getColumn()) <= 1) {
			return true;
		}
		return false;
	}

}
