package org.wladska;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int romanToInt(String s) {
		// Map each Roman numeral to its value
		Map<Character, Integer> romanValues = new HashMap<>();
		romanValues.put('I', 1);
		romanValues.put('V', 5);
		romanValues.put('X', 10);
		romanValues.put('L', 50);
		romanValues.put('C', 100);
		romanValues.put('D', 500);
		romanValues.put('M', 1000);

		int total = 0;
		int prevValue = 0; // To keep track of the previous value
		for (char c : s.toCharArray()) {
			int value = romanValues.get(c);

			// If the previous value is less than the current value, we need to subtract twice the previous value
			if (prevValue < value) {
				total += value - 2 * prevValue;
			} else {
				total += value;
			}

			prevValue = value; // Update the previous value for the next iteration
		}

		return total;
	}
}
