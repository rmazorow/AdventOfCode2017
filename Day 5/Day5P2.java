/*
Author: Rocky Mazorow
Date: 12/7/2017

Day 5 Part 2
Now, the jumps are even stranger: after each jump, if the offset was three or more, instead decrease it by 1. Otherwise, increase it by 1 as before.

Using this rule with the above example, the process now takes 10 steps, and the offset values after finding the exit are left as 2 3 2 3 -1.

How many steps does it now take to reach the exit?
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

class Day5P1 {
	public static void main(String[] args) {
		File file = new File("Day5.txt");
		Scanner input;
		ArrayList<Integer> directions = new ArrayList<Integer>();
		int count = 0;
		int i = 0;
		
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				directions.add(input.nextInt());
			}
			
			while (true) {
				int value = directions.get(i);
				if (value > 2) {
					directions.set(i, value - 1);
				}
				else {
					directions.set(i, value + 1);
				}
				i += value;
				count++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("It took " + count + " steps to escape");
		}
	}
}