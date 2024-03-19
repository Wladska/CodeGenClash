package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * Given a string s, return the longest palindromic substring in s.
	 * 
	 * Example 1:
	 * Input: s = "babad"
	 * Output: "bab"
	 * 
	 * Example 2:
	 * Input: s = "cbbd"
	 * Output: "bb"
	 * 
	 * Constraints:
	 * 1 <= s.length <= 1000
	 * s consist of only digits and English letters.
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
}
