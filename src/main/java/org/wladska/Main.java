package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public String convertToBase7(int num) {
		if (num == 0) {
			// Directly return "0" if the number is 0
			return "0";
		}

		StringBuilder result = new StringBuilder();
		boolean isNegative = num < 0;

		// Work with a positive number for the conversion
		num = Math.abs(num);

		while (num > 0) {
			// Prepend the remainder (digit in base 7) to the result string
			result.insert(0, num % 7);
			num /= 7;
		}

		if (isNegative) {
			// Add the minus sign for negative numbers
			result.insert(0, "-");
		}

		return result.toString();
	}

}
