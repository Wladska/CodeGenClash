package org.wladska;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] seen = new boolean[n][1 << n]; // seen[node][state]

		for (int i = 0; i < n; i++) {
			queue.offer(new int[]{i, 1 << i}); // Initialize with every node as starting point
			seen[i][1 << i] = true;
		}

		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int node = cur[0];
				int state = cur[1];

				// Check if all nodes are visited
				if (state == (1 << n) - 1) return steps; // All bits are set

				// Explore neighbors
				for (int next : graph[node]) {
					int nextState = state | (1 << next);
					if (!seen[next][nextState]) {
						seen[next][nextState] = true;
						queue.offer(new int[]{next, nextState});
					}
				}
			}
			steps++; // Increment the number of steps taken
		}

		return -1; // Should never reach here since the graph is connected
	}
}
