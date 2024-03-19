package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * Given an integer num, return a string of its base 7 representation.
	 * 
	 * Example 1:
	 * Input: num = 100
	 * Output: "202"
	 * 
	 * Example 2:
	 * Input: num = -7
	 * Output: "-10"
	 * 
	 * Constraints:
	 * -10^7 <= num <= 10^7
	 */
	public String convertToBase7(int num) {
		if (num == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		boolean isNegative = num < 0;
		if (isNegative) {
			num = -num;
		}
		while (num > 0) {
			sb.append(num % 7);
			num /= 7;
		}
		if (isNegative) {
			sb.append("-");
		}
		return sb.reverse().toString();
	}
}
