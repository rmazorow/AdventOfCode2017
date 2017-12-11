/*
Author: Rocky Mazorow
Date: 12/7/2017

Day 4 Part 1
A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a password. A passphrase consists of a series of words (lowercase letters) separated by spaces.

To ensure security, a valid passphrase must contain no duplicate words.

For example:

aa bb cc dd ee is valid.
aa bb cc dd aa is not valid - the word aa appears more than once.
aa bb cc dd aaa is valid - aa and aaa count as different words.

The system's full passphrase list is available as your puzzle input. How many passphrases are valid?
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Day4P1 {
	public static boolean isValid(String[] s) {
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (s[i].equals(s[j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		File file = new File("Day4.txt");
		Scanner input;
		int valid = 0;
		
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				String line   = input.nextLine();
				String[] s = line.split(" ");
				boolean isValid = isValid(s);
				
				if (isValid) {
					valid++;
				}
			}
			System.out.println("There are " + valid + " valid passphrases");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}