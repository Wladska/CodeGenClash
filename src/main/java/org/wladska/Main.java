package org.wladska;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		int n = profits.length;
		// Create a list of project indices
		List<Integer> projectIndices = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			projectIndices.add(i);
		}
		// Sort the project indices based on their capital requirements
		projectIndices.sort((a, b) -> Integer.compare(capital[a], capital[b]));

		// Priority queue to store profitable projects available given the current capital
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(profits[b], profits[a]));

		int j = 0; // Pointer to iterate over sorted projects based on capital
		for (int i = 0; i < k; i++) {
			// Add all projects that can be afforded with the current capital
			while (j < n && capital[projectIndices.get(j)] <= w) {
				pq.add(projectIndices.get(j));
				j++;
			}
			// If there are no projects available, break out of the loop
			if (pq.isEmpty()) break;

			// Pick the most profitable project and update the capital
			w += profits[pq.poll()];
		}

		return w;
	}
}
