package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
	 * Given an integer n, return true if n is an ugly number.
	 * 
	 * Example 1:
	 * Input: n = 6
	 * Output: true
	 * 
	 * Example 2:
	 * Input: n = 1
	 * Output: true
	 * 
	 * Example 3:
	 * Input: n = 14
	 * Output: false
	 * 
	 * Constraints:
	 * -2^31 <= n <= 2^31 - 1
	 */
	public static boolean isUgly(int n) {
		if (n <= 0) {
			return false;
		}
		while (n % 2 == 0) {
			n /= 2;
		}
		while (n % 3 == 0) {
			n /= 3;
		}
		while (n % 5 == 0) {
			n /= 5;
		}
		return n == 1;
	}
}
