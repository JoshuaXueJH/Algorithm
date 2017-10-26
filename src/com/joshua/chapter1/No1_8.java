package com.joshua.chapter1;

public class No1_8 {
	public static void main(String[] args) {
		int[][] matrix = new int[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				matrix[i][j] = randomNum();
			}
		}
		matrix[1][1] = 0;
		matrix[4][6] = 0;
		matrix[0][3] = 0;
		System.out.println("original matrix is ---->>");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("matrix after setZero is ---->>");
		setZero(matrix);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static int randomNum() {
		return (int) (Math.random() * 100);
	}

	/**
	 * 设置两个标记数组，分别代表row和column，第一次双层for循环做标记，记录需要替换为0的行列，第二次双层for将标记的行列替换为0
	 * 时间复杂度为n*n， 空间复杂的为n
	 * @param matrix
	 */
	public static void setZero(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length != matrix.length)
			System.exit(-1);

		int n = matrix.length;
		int[] row = new int[n];
		int[] column = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (row[i] != 1) {
						row[i] = 1;
					}
					if (column[j] != 1) {
						column[j] = 1;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (row[i] == 1) {
				clean(matrix, i, "row");
			}
			if (column[i] == 1) {
				clean(matrix, i, "column");
			}
		}
	}

	public static void clean(int[][] matrix, int num, String rowOrColumn) {
		if (rowOrColumn.equals("row")) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[num][i] = 0;
			}
		} else {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][num] = 0;
			}
		}
	}

}
