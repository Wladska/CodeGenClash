package org.wladska;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int maxJumps(int[] arr, int d) {
		int n = arr.length;
		int[] dp = new int[n];
		Integer[] indices = new Integer[n];
		for (int i = 0; i < n; i++) {
			indices[i] = i; // Initialize indices
		}
		// Sort indices by the values in arr to ensure we always jump to smaller values
		Arrays.sort(indices, (a, b) -> arr[a] - arr[b]);

		int maxJumps = 1;
		for (int idx : indices) {
			dp[idx] = 1; // Each index can visit at least itself
			// Jump left
			for (int j = idx - 1; j >= Math.max(0, idx - d) && arr[j] < arr[idx]; j--) {
				dp[idx] = Math.max(dp[idx], dp[j] + 1);
			}
			// Jump right
			for (int j = idx + 1; j <= Math.min(n - 1, idx + d) && arr[j] < arr[idx]; j++) {
				dp[idx] = Math.max(dp[idx], dp[j] + 1);
			}
			maxJumps = Math.max(maxJumps, dp[idx]);
		}

		return maxJumps;
	}

}
