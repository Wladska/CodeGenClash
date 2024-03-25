package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int myAtoi(String s) {
		s = s.trim(); // Step 1
		if (s.isEmpty()) return 0;

		int sign = 1;
		int index = 0;
		long result = 0; // Use long to detect overflow

		// Step 2: Check for sign
		if (s.charAt(0) == '+' || s.charAt(0) == '-') {
			sign = s.charAt(0) == '-' ? -1 : 1;
			index++;
		}

		// Step 3: Convert digits
		while (index < s.length()) {
			char c = s.charAt(index);
			if (c < '0' || c > '9') break; // Stop if not a digit

			result = result * 10 + (c - '0');
			// Step 4: Check for overflow/underflow
			if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if (sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

			index++;
		}

		return (int) (sign * result);
	}

}
