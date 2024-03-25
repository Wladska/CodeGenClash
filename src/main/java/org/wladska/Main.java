package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	private static final int MOD = 1000000007;

	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		int n = locations.length;
		int[][] dp = new int[n][fuel + 1];

		// Base case: start with 1 way to be at the 'finish' location with 0 fuel used
		dp[finish][0] = 1;

		// Fill dp table bottom-up
		for (int f = 1; f <= fuel; f++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						int cost = Math.abs(locations[i] - locations[j]);
						if (f >= cost) {
							dp[i][f] = (dp[i][f] + dp[j][f - cost]) % MOD;
						}
					}
				}
			}
		}

		// Sum up all ways to reach 'start' with any fuel level
		int totalWays = 0;
		for (int f = 0; f <= fuel; f++) {
			totalWays = (totalWays + dp[start][f]) % MOD;
		}

		return totalWays;
	}
}
