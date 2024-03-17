package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

		/**
	 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
	 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
	 * 
	 * Example 1:
	 * Input: s = "anagram", t = "nagaram"
	 * Output: true
	 * 
	 * Example 2:
	 * Input: s = "rat", t = "car"
	 * Output: false
	 * 
	 * Constraints:
	 * 1 <= s.length, t.length <= 5 * 10^4
	 * s and t consist of lowercase English letters.
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
}
