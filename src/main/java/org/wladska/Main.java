package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int[] plusOne(int[] digits) {
		// Start from the last digit and work backwards
		for (int i = digits.length - 1; i >= 0; i--) {
			// If the current digit is less than 9, increment it and return the array
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			// If the digit is 9, it becomes 0 due to the carry over
			digits[i] = 0;
		}

		// If we're here, all digits were 9 and we need an extra digit at the start
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1; // The rest are initialized to 0 by default

		return newDigits;
	}

}
