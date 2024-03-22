package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
	 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
	 * Each vowel 'a' may only be followed by an 'e'.
	 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
	 * Each vowel 'i' may not be followed by another 'i'.
	 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
	 * Each vowel 'u' may only be followed by an 'a'.
	 * Since the answer may be too large, return it modulo 10^9 + 7.
	 * 
	 * Example 1:
	 * Input: n = 1
	 * Output: 5
	 * 
	 * Example 2:
	 * Input: n = 2
	 * Output: 10
	 * 
	 * Example 3: 
	 * Input: n = 5
	 * Output: 68
	 * 
	 * Constraints:
	 * 1 <= n <= 2 * 10^4
	 */
	public int countVowelPermutation(int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < n; l++) {
						for (int m = 0; m < n; m++) {
							for (int n = 0; n < n; n++) {
								for (int o = 0; o < n; o++) {
									for (int p = 0; p < n; p++) {
										for (int q = 0; q < n; q++) {
											for (int r = 0; r < n; r++) {
                                                for (int s = 0; s < n; s++) {
                                                    for (int t = 0; t < n; t++) {
                                                        for (int u = 0; u < n; u++) {
                                                            for (int v = 0; v < n; v++) {
                                                                for (int w = 0; w < n; w++) {
                                                                    for (int x = 0; x < n; x++) {
                                                                        for (int y = 0; y < n; y++) {
                                                                            for (int z = 0; z < n; z++) {
                                                                                count++;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
										}
                                    }
								}
                            }
						}
                    }

				}
            }

		}
		return count % 1000000007;
    }
}
