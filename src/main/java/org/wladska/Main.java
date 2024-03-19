package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
	 * The algorithm for myAtoi(string s) is as follows:
	 * 1. Read in and ignore any leading whitespace.
	 * 2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
	 * 3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
	 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
	 * 5. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
	 * 6. Return the integer as the final result.
	 * 
	 * Note:
	 * Only the space character ' ' is considered a whitespace character.
	 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
	 * 
	 * Example 1:
	 * Input: s = "42"
	 * Output: 42
	 * 
	 * Example 2:
	 * Input: s = "   -42"
	 * Output: -42
	 * 
	 * Example 3:
	 * Input: s = "4193 with words"
	 * Output: 4193
	 * 
	 * Constraints:
	 * 0 <= s.length <= 200
	 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
	 */
	public int myAtoi(String s) {
		int i = 0;
		int n = s.length();
		while (i < n && s.charAt(i) == ' ') {
			i++;
		}
		if (i == n) {
			return 0;
		}
		int sign = 1;
		if (s.charAt(i) == '+' || s.charAt(i) == '-') {
			sign = s.charAt(i) == '+' ? 1 : -1;
			i++;
		}
		int num = 0;
		while (i < n && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';
			if (num > (Integer.MAX_VALUE - digit) / 10) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}
}
