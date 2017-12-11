/*
Author: Rocky Mazorow
Date: 12/6/2017

Day 1 Part 1
You're standing in a room with "digitization quarantine" written in LEDs along one wall. The only door is locked, but it includes a small interface. "Restricted Area - Strictly No Digitized Users Allowed."

It goes on to explain that you may only leave by solving a captcha to prove you're not a human. Apparently, you only get one millisecond to solve the captcha: too fast for a normal human, but it feels like hours to you.

The captcha requires you to review a sequence of digits (your puzzle input) and find the sum of all digits that match the next digit in the list. The list is circular, so the digit after the last digit is the first digit in the list.

For example:

1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
1111 produces 4 because each digit (all 1) matches the next.
1234 produces 0 because no digit matches the next.
91212129 produces 9 because the only digit that matches the next one is the last digit, 9.

What is the solution to your captcha?
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Day1P1 {
	public static void main(String[] args) {
		File file = new File("Day1.txt");
		Scanner input;
		int sum = 0;
		int count = 0;
		
		try {
			input = new Scanner(file);
			String text = input.next();
			for (int i = 0; i < text.length() - 1; i++) {
				if (text.substring(i, i + 1).equals(text.substring(i + 1, i + 2))) {
					sum += Integer.parseInt(text.substring(i, i + 1));
					count++;
				}
			}
			if (text.substring(text.length() - 1, text.length()).equals(text.substring(0, 1))) {
				sum += Integer.parseInt(text.substring(0, 1));
				count++;
			}
			System.out.println("The captcha is " + sum);
			System.out.println("There are " + count + " numbers that follow this pattern");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}