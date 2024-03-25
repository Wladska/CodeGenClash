package org.wladska;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		// We can modify the triangle list in-place to save space.
		// Alternatively, you could use a separate DP array if modifying the input is not allowed.
		for (int row = n - 2; row >= 0; row--) { // Start from the second last row
			for (int col = 0; col <= row; col++) {
				int value = triangle.get(row).get(col);
				int minBelow = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
				triangle.get(row).set(col, value + minBelow);
			}
		}
		return triangle.get(0).get(0); // The top element now contains the minimum path sum
	}

}
