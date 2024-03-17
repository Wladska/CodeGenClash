package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	/**
	 * Given two binary strings a and b, return their sum as a binary string.
	 * 
	 * Example 1:
	 * Input: a = "11", b = "1"
	 * Output: "100"
	 * 
	 * Example 2:
	 * Input: a = "1010", b = "1011"
	 * Output: "10101"
	 * 
	 * Constraints:
	 * 1 <= a.length, b.length <= 104
	 * a and b consist only of '0' or '1' characters.
	 * Each string does not contain leading zeros except for the zero itself.
	 */
	public String addBinary(String a, String b) {
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || carry == 1) {
			int aDigit = i >= 0 ? a.charAt(i) - '0' : 0;
			int bDigit = j >= 0 ? b.charAt(j) - '0' : 0;
			int sum = aDigit + bDigit + carry;
			sb.append(sum % 2);
			carry = sum / 2;
			i--;
			j--;
		}
		return sb.reverse().toString();
	}
}
