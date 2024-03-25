package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;

		while (i >= 0 || j >= 0 || carry > 0) {
			if (i >= 0) {
				carry += a.charAt(i) - '0'; // Convert char to int and add to carry
				i--;
			}
			if (j >= 0) {
				carry += b.charAt(j) - '0'; // Convert char to int and add to carry
				j--;
			}

			result.append(carry % 2); // Append the remainder of carry divided by 2 to the result
			carry /= 2; // Update carry
		}

		return result.reverse().toString(); // Reverse and convert to string before returning
	}
}
