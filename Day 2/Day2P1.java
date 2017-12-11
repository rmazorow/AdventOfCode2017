/*
Author: Rocky Mazorow
Date: 12/7/2017

Day 2 Part 1
As you walk through the door, a glowing humanoid shape yells in your direction. "You there! Your state appears to be idle. Come help us repair the corruption in this spreadsheet - if we take another millisecond, we'll have to display an hourglass cursor!"

The spreadsheet consists of rows of apparently-random numbers. To make sure the recovery process is on the right track, they need you to calculate the spreadsheet's checksum. For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences.

For example, given the following spreadsheet:

5 1 9 5
7 5 3
2 4 6 8
The first row's largest and smallest values are 9 and 1, and their difference is 8.
The second row's largest and smallest values are 7 and 3, and their difference is 4.
The third row's difference is 6.
In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.

What is the checksum for the spreadsheet in your puzzle input?
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Day2P1 {
	public static int calcCheckSum(String[] nums) {
		int min = Integer.parseInt(nums[0]);
		int max = Integer.parseInt(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			if (Integer.parseInt(nums[i]) < min) {
				min = Integer.parseInt(nums[i]);
			}
			else if (Integer.parseInt(nums[i]) > max) {
				max = Integer.parseInt(nums[i]);
			}
		}
		return (max - min);
	}
	
	public static void main(String[] args) {
		File file = new File("Day2.txt");
		Scanner input;
		int checkSum = 0;
		
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] nums = line.split("\t");
				checkSum += calcCheckSum(nums);
			}
			System.out.println("The checksum value is " + checkSum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}