package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.
	 * Divide the marbles into the k bags according to the following rules:
	 * No bag is empty.
	 * If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
	 * If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].
	 * The score after distributing the marbles is the sum of the costs of all the k bags.
	 * Return the difference between the maximum and minimum scores among marble distributions.
	 * 
	 * Example 1:
	 * Input: weights = [1,3,5,1], k = 2
	 * Output: 4
	 * 
	 * Example 2:
	 * Input: weights = [1, 3], k = 2
	 * Output: 0
	 * 
	 * Constraints:
	 * 1 <= k <= weights.length <= 105
	 * 1 <= weights[i] <= 109
	 */
	public int canCompleteCircuit(int[] weights, int k) {
		int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
            min = Math.min(min, weights[i]);
        }
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        if (sum % k!= 0) {
            return -1;
        }
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > max) {
                return -1;
            }
        }
		return max - min;
	}
}
