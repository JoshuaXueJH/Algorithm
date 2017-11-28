package com.joshua.chapter16;

import java.util.Scanner;

import com.joshua.chapter16.MasterMind.Result;

public class No16_15 {
	public static void main(String[] args) {
		System.out.println("Please input your guess:");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		char[] inputChars = input.toCharArray();

		MasterMind masterMind = MasterMind.getInstance();
		char[] colourSet = masterMind.generateColourSet();
		Result result = masterMind.analyzeGuess(inputChars, colourSet);

		System.out.println(new String(colourSet));
		System.out.println(result.toString());
	}
}
