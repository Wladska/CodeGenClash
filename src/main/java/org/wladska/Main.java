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
		if (s.length()!= t.length()) {
            return false;
        }
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char c : s.toCharArray()) {
            sCounts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tCounts[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i]!= tCounts[i]) {
                return false;
            }
        }
        return true;
	}
}
