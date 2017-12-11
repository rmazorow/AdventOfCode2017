/*
Author: Rocky Mazorow
Date: 12/6/2017

Day 1 Part 2
You notice a progress bar that jumps to 50% completion. Apparently, the door isn't yet satisfied, but it did emit a star as encouragement. The instructions change:

Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. Fortunately, your list has an even number of elements.

For example:

1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
1221 produces 0, because every comparison is between a 1 and a 2.
123425 produces 4, because both 2s match each other, but no other digit has a match.
123123 produces 12.
12131415 produces 4.

What is the solution to your new captcha?
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
			int size = text.length();
			text += text;
			for (int i = 0; i < size - 1; i++) {
				int plus = i + size/2;
				if (text.substring(i, i + 1).equals(text.substring(plus, plus + 1))) {
					sum += Integer.parseInt(text.substring(i, i + 1));
					count++;
				}
			}
			/*if (text.substring(text.length() - 1, text.length()).equals(text.substring(text.length()/2, text.length()/2 + 1))) {
				sum += Integer.parseInt(text.substring(0, 1));
				count++;
			}*/
			System.out.println("The captcha is " + sum);
			System.out.println("There are " + count + " numbers that follow this pattern");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}