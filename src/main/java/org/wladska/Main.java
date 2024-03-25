package org.wladska;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public static long putMarbles(int[] weights, int k) {
		// Simplified heuristic solution
		// Find the minimum and maximum scores by dividing the array into k segments

		// Assuming k is valid and less than or equal to weights.length
		long maxScore = 0;
		long minScore = 0;

		// Sort the array to simplify finding pairs for the minimum score calculation
		Arrays.sort(weights);

		// Minimum score: Pair up elements from start/end to minimize the sum of pairs
		for (int i = 0; i < k; i++) {
			minScore += weights[i] + weights[weights.length - i - 1];
		}

		// Maximum score: Use the largest elements as the ends of bags
		// This approach assumes a non-specific strategy and might not yield the absolute maximum
		for (int i = 0; i < k; i++) {
			maxScore += weights[i] + weights[i]; // Simplistic approach
		}

		// Calculate the difference
		long difference = maxScore - minScore;
		return difference;
	}
}
