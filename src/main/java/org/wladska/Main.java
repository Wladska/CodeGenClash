package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public boolean isPalindrome(int x) {
		// Negative numbers and multiples of 10 (except 0) are not palindromes
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int reversedHalf = 0;
		while (x > reversedHalf) {
			reversedHalf = reversedHalf * 10 + x % 10;
			x /= 10;
		}

		// For odd length numbers, discard the middle digit before comparing
		return x == reversedHalf || x == reversedHalf / 10;
	}
}
