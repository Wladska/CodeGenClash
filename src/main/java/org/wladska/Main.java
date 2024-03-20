package org.wladska;

import java.util.List;
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	
	/**
	 * Given a triangle array, return the minimum path sum from top to bottom.
	 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
	 * 
	 * Example 1:
	 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
	 * Output: 11
	 * 
	 * Example 2:
	 * Input: triangle = [[-10]]
	 * Output: -10
	 * 
	 * Constraints:
	 * 1 <= triangle.length <= 200
	 * triangle[0].length == 1
	 * triangle[i].length == triangle[i - 1].length + 1
	 * -10^4 <= triangle[i][j] <= 10^4
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] dp = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
}
