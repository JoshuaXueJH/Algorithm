package com.joshua.chapter1;

import org.junit.Test;

public class No1_7 {
	public static void main(String[] args) {
		int[][] matrix = new int[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				matrix[i][j] = randomNum();
			}
		}
		System.out.println("original matrix is ---->>");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("rotated matrix is ---->>");
		matrix = rotate(matrix);
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
	 * 此算法不太好理解，做的时候可以先画图，画一个矩阵，不考虑内层，只考虑最外层
	 * 写出最外层的旋转算法（单for循环）， 然后考虑不同的layers（两层for循环）
	 * @param matrix
	 * @return
	 */
	public static int[][] rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length != matrix.length)
			System.exit(-1);

		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			for (int i = layer; i < n - 1 - layer; i++) {
				int temp = matrix[layer][i];
				matrix[layer][i] = matrix[n - 1 - i][layer];
				matrix[n - 1 - i][layer] = matrix[n - 1 - layer][n - 1 - i];
				matrix[n - 1 - layer][n - 1 - i] = matrix[i][n - 1 - layer];
				matrix[i][n - 1 - layer] = temp;
			}
		}

		return matrix;
	}
}
