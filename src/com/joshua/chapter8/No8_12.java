package com.joshua.chapter8;

import java.util.ArrayList;

public class No8_12 {
	public static final int GRID_SIZE = 8;

	public static void main(String[] args) {
		ArrayList<Integer[]> ways = getWays();
		for (Integer[] way : ways) {
			for (int i = 0; i < way.length; i++) {
				System.out.print("[" + i + "," + way[i] + "]" + "  ");
			}
			System.out.println();
		}
	}

	public static ArrayList<Integer[]> getWays() {
		ArrayList<Integer[]> ways = new ArrayList<Integer[]>();
		int startRow = 0;

		getWays(startRow, new Integer[GRID_SIZE], ways);

		return ways;
	}

	public static void getWays(int row, Integer[] columnsTaken, ArrayList<Integer[]> ways) {
		if (row == GRID_SIZE) {
			ways.add(columnsTaken.clone());
		}

		for (int column = 0; column < GRID_SIZE; column++) {
			if (isValidLocation(row, column, columnsTaken)) {
				columnsTaken[row] = column;
				getWays(row + 1, columnsTaken, ways);
			}
		}
	}

	static boolean isValidLocation(int row, int column, Integer[] columnsTaken) {
		// Check is current position is in the diagonal
		for (int i = 0; i < row; i++) {
			// Check if current column was taken
			if (columnsTaken[i] == column)
				return false;

			// Check is current position is on the diagonal
			int verticalDistance = row - i;
			int horizontalDistance = Math.abs(columnsTaken[i] - column);

			if (verticalDistance == horizontalDistance)
				return false;
		}
		return true;
	}
}
