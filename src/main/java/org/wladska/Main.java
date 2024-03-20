package org.wladska;

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
        if (k > n) {
            return result;
        }
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                result.add(list);
            }
            return result;
        }
        if (k == 2) {
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(i + 1);
                result.add(list);
            }
            return result;
        }
		List<List<Integer>> combinations = combine(n - 1, k - 1);
		for (int i = 0; i < combinations.size(); i++) {
			List<Integer> list = new ArrayList<>();
            list.add(combinations.get(i).get(combinations.get(i).size() - 1));
            list.add(combinations.get(i).get(combinations.get(i).size() - 2));
            result.add(list);
        }
		return result;
	}
	
}
