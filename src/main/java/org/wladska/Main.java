package org.wladska;

import java.util.ArrayList;
import java.util.List;
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
	 * You may return the answer in any order.
	 * 
	 * Example 1:
	 * Input: n = 4, k = 2
	 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
	 * 
	 * Example 2:
	 * Input: n = 1, k = 1
	 * Output: [[1]]
	 * 
	 * Constraints:
	 * 1 <= n <= 20
	 * 1 <= k <= n
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		combine(n, k, 1, new ArrayList<>(), result);
		return result;
	}
	private void combine(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
		if (current.size() == k) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = start; i <= n; i++) {
			current.add(i);
			combine(n, k, i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}
	
}
