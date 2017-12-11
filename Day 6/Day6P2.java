/*
Author: Rocky Mazorow
Date: 12/8/2017

Day 6 Part 2
Out of curiosity, the debugger would also like to know the size of the loop: starting from a state that has already been seen, how many block redistribution cycles must be performed before that same state is seen again?

In the example above, 2 4 1 2 is seen again after four cycles, and so the answer in that example would be 4.

How many cycles are in the infinite loop that arises from the configuration in your puzzle input?
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Day6P2 {
	public static int maxIndex(int[] a) {
		int max = a[0];
		int maxI = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				maxI = i;
			}
		}
		return maxI;
	}
	
	public static int countCycles(String main, String temp) {
		int start  = main.indexOf(temp);
		String sub = main.substring(start);
		String[] div = sub.split("\t");
		return div.length;
	}
	
	public static void main(String[] args) {
		File file = new File("Day6.txt");
		Scanner input;
		int[] blocks = new int[16];
				
		try {
			input = new Scanner(file);
			for (int i = 0; i < blocks.length; i++) {
				blocks[i] = input.nextInt();
			}
			
			int maxI = maxIndex(blocks);
			int max  = blocks[maxI];
			int count  = 0;
			int cycles = 0;
			String found = "";
			boolean isFound = false;
			
			blocks[maxI] = 0;
			
			for (int i = maxI + 1; isFound == false; i++) {
				if (i > (blocks.length - 1)) {
					i = 0;
				}
				if (max == 0) {
					maxI = maxIndex(blocks);
					max  = blocks[maxI];
					
					String temp = "";
					for (int j = 0; j < blocks.length; j++) {
						temp += blocks[j] + " ";
					}
					temp += " ";
					
					blocks[maxI] = 0;
					i = maxI + 1;
					if (i > (blocks.length - 1)) {
						i = 0;
					}
					
					if (found.contains(temp)) {
						isFound = true;
						cycles = countCycles(found, temp);
					}
					else {
						found += temp + "\t";
					}
					
					count++;
				}
				blocks[i]++;
				max--;
			}
			
			System.out.println("It took " + count + " redistribution cycles before a configuration is produced that has been seen before");
			System.out.println("There are " + cycles + " in the infinite loop that arises from the configuration");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}