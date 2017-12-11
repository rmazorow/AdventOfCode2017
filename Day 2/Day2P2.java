/*
Author: Rocky Mazorow
Date: 12/7/2017

Day 2 Part 2
"Great work; looks like we're on the right track after all. Here's a star for your effort." However, the program seems a little worried. Can programs be worried?

"Based on what we're seeing, it looks like all the User wanted is some information about the evenly divisible values in the spreadsheet. Unfortunately, none of us are equipped for that kind of calculation - most of us specialize in bitwise operations."

It sounds like the goal is to find the only two numbers in each row where one evenly divides the other - that is, where the result of the division operation is a whole number. They would like you to find those numbers on each line, divide them, and add up each line's result.

For example, given the following spreadsheet:

5 9 2 8
9 4 7 3
3 8 6 5
In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.
In the second row, the two numbers are 9 and 3; the result is 3.
In the third row, the result is 2.
In this example, the sum of the results would be 4 + 3 + 2 = 9.

What is the sum of each row's result in your puzzle input?
*/


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Day2P2 {
	public static int isEvenDiv(String[] nums) {
		int big   = 0;
		int small = 0;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if ((i != j) && (Integer.parseInt(nums[i]) % Integer.parseInt(nums[j]) == 0)) {
					big   = Integer.parseInt(nums[i]);
					small = Integer.parseInt(nums[j]);
					break;
				}
			}
		}
		return (big / small);
	}
	
	public static void main(String[] args) {
		File file = new File("Day2.txt");
		Scanner input;
		int sum = 0;
		
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] nums = line.split("\t");
				sum += isEvenDiv(nums);
			}
			System.out.println("The sum of evenly divisible values is " + sum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}