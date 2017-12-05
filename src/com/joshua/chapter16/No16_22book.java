package com.joshua.chapter16;

public class No16_22book {
	public class Grid {
		private boolean[][] grid;
		private Ant ant = new Ant();

		public Grid() {
			grid = new boolean[1][1];
		}

		private void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftColumn) {
			for (int r = 0; r < oldGrid.length; r++) {
				for (int c = 0; c < oldGrid[0].length; c++) {
					newGrid[r + shiftRow][c + shiftColumn] = oldGrid[r][c];
				}
			}
		}

		private void ensureFit(Position position) {
			int shiftRow = 0;
			int shiftColumn = 0;

			int numRows = grid.length;
			if (position.row < 0) {
				shiftRow = numRows;
				numRows *= 2;
			} else if (position.row >= numRows) {
				numRows *= 2;
			}

			int numColumns = grid[0].length;
			if (position.column < 0) {
				shiftColumn = numColumns;
				numColumns *= 2;
			} else if (position.column > numColumns) {
				numColumns *= 2;
			}

			if (numRows != grid.length || numColumns != grid[0].length) {
				boolean[][] newGrid = new boolean[numRows][numColumns];
				copyWithShift(grid, newGrid, shiftRow, shiftColumn);
				ant.adjustPosition(shiftRow, shiftColumn);
				grid = newGrid;
			}
		}

		private void flip(Position position) {
			int row = position.row;
			int column = position.column;
			grid[row][column] = grid[row][column] ? false : true;
		}

		public void move() {
			ant.turn(grid[ant.position.row][ant.position.column]);
			flip(ant.position);
			ant.move();
			ensureFit(ant.position);
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int r = 0; r < grid.length; r++) {
				for (int c = 0; c < grid[0].length; r++) {
					if (r == ant.position.row && c == ant.position.column) {
						sb.append(ant.orientation);
					} else if (grid[r][c]) {
						sb.append("X");
					} else {
						sb.append("_");
					}
				}
				sb.append("\n");
			}
			sb.append("Ant: " + ant.orientation + ". \n");
			return sb.toString();
		}
	}

	public class Ant {
		public Position position = new Position(0, 0);
		public Orientation orientation = Orientation.right;

		public void turn(boolean clockwise) {
			orientation = orientation.getTurn(clockwise);
		}

		public void move() {
			if (orientation == Orientation.left) {
				position.column--;
			} else if (orientation == Orientation.right) {
				position.column++;
			} else if (orientation == Orientation.up) {
				position.row--;
			} else if (orientation == Orientation.down) {
				position.row++;
			}
		}

		public void adjustPosition(int shiftRow, int shiftColumn) {
			position.row += shiftRow;
			position.column += shiftColumn;
		}
	}

	public enum Orientation {
		left, up, right, down;

		public Orientation getTurn(boolean clockwise) {
			if (this == left) {
				return clockwise ? up : down;
			} else if (this == up) {
				return clockwise ? right : left;
			} else if (this == right) {
				return clockwise ? down : up;
			} else {
				return clockwise ? left : right;
			}
		}

		public String toString() {
			if (this == left) {
				return "\u2190";
			} else if (this == up) {
				return "\u2191";
			} else if (this == right) {
				return "\u2192";
			} else {
				return "\u2193";
			}
		}
	}

	public class Position {
		public int row;
		public int column;

		public Position(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
}
