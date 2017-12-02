package com.joshua.chapter16;

public class Plot {
	private int row;
	private int column;
	private boolean visited;

	public Plot(int row, int column) {
		this.row = row;
		this.column = column;
		visited = false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setVisited() {
		visited = true;
	}

	public boolean getVisited() {
		return visited;
	}
}