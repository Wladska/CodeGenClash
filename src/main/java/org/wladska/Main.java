package org.wladska;

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
		int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i] = triangle.get(i).get(0);
            for (int j = 1; j < triangle.get(i).size(); j++) {
                dp[i] = Math.min(dp[i], dp[i - 1] + triangle.get(i).get(j));
            }
        }
        return dp[dp.length - 1];
	}
	
}
