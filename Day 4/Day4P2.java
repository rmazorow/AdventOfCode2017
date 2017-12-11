/*
Author: Rocky Mazorow
Date: 12/7/2017

Day 4 Part 2
For added security, yet another system policy has been put in place. Now, a valid passphrase must contain no two words that are anagrams of each other - that is, a passphrase is invalid if any word's letters can be rearranged to form any other word in the passphrase.

For example:

abcde fghij is a valid passphrase.
abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
iiii oiii ooii oooi oooo is valid.
oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.

Under this new system policy, how many passphrases are valid?
*/

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

class Day4P2 {
	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() == s2.length()) {
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();
			
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			if (Arrays.equals(c1, c2)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValid(String[] s) {
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (isAnagram(s[i], s[j])) {
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