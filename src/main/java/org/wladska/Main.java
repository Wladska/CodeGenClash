package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	/**
	 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
	 * Increment the large integer by one and return the resulting array of digits.
	 * 
	 * Example 1:
	 * Input: digits = [1,2,3]
	 * Output: [1,2,4]
	 * 
	 * Example 2:
	 * Input: digits = [4,3,2,1]
	 * Output: [4,3,2,2]
	 * 
	 * Example 3:
	 * Input: digits = [9]
	 * Output: [1,0]
	 * 
	 * Constraints:
	 * 1 <= digits.length <= 100
	 * 0 <= digits[i] <= 9
	 * digits does not contain any leading 0's.
	 */
	public int[] plusOne(int[] digits) {
		int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
	}
}
