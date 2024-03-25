package org.wladska;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), 1, n, k);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> combination, int start, int n, int k) {
		// If the combination is done
		if (k == 0) {
			result.add(new ArrayList<>(combination));
			return;
		}

		for (int i = start; i <= n; i++) {
			// Add i into the current combination
			combination.add(i);

			// Move on to the next element
			backtrack(result, combination, i + 1, n, k - 1);

			// Backtrack
			combination.remove(combination.size() - 1);
		}
	}

}
