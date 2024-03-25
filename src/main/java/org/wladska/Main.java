package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int countVowelPermutation(int n) {
		final int MOD = 1000000007;
		long[][] dp = new long[n + 1][5];
		// Base case: one string of length 1 for each vowel
		for (int j = 0; j < 5; j++) {
			dp[1][j] = 1;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4]) % MOD; // a follows e, i, u
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD; // e follows a, i
			dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % MOD; // i follows e, o
			dp[i][3] = (dp[i-1][2]) % MOD; // o follows i
			dp[i][4] = (dp[i-1][2] + dp[i-1][3]) % MOD; // u follows i, o
		}

		long result = 0;
		for (int j = 0; j < 5; j++) {
			result = (result + dp[n][j]) % MOD;
		}

		return (int) result;
	}

}
