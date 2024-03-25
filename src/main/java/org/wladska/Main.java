package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] letterCounts = new int[26]; // For 'a' to 'z'

		for (int i = 0; i < s.length(); i++) {
			letterCounts[s.charAt(i) - 'a']++; // Increment count for 's'
			letterCounts[t.charAt(i) - 'a']--; // Decrement count for 't'
		}

		for (int count : letterCounts) {
			if (count != 0) {
				// If any count is not zero, then 's' and 't' are not anagrams
				return false;
			}
		}

		return true; // All counts are zero, 's' and 't' are anagrams
	}

}
