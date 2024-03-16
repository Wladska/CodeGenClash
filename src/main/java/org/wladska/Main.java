package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	/* Given an integer x, return true if x is a palindrome, and false otherwise.
		Example 1:
		Input: x = 121
		Output: true

		Example 2:
		Input: x = -121
		Output: false

		Constraints:
		-231 <= x <= 231 - 1
	*/
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		int reversed = 0;
		int original = x;
		while (x != 0) {
			reversed = reversed * 10 + x % 10;
			x /= 10;
		}
		return reversed == original;
	}
}
