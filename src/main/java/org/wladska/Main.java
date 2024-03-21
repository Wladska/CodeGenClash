package org.wladska;

import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
	 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
	 * 
	 * Example 1:
	 * Input: graph = [[1,2,3],[0],[0],[0]]
	 * Output: 4
	 * 
	 * Example 2:
	 * Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
	 * Output: 4
	 * 
	 * Constraints:
	 * n == graph.length
	 * 1 <= n <= 12
	 * 0 <= graph[i].length < n
	 * graph[i] does not contain i.
	 * If graph[a] contains b, then graph[b] contains a.
	 * The input graph is always connected.
	 */
	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		int[][] visited = new int[n][1 << n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			queue.add(new int[]{i, 1 << i});
			visited[i][1 << i] = 1;
		}
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				if (cur[1] == (1 << n) - 1) {
					return step;
				}
				for (int next : graph[cur[0]]) {
					int nextState = cur[1] | (1 << next);
					if (visited[next][nextState] == 0) {
						visited[next][nextState] = 1;
						queue.add(new int[]{next, nextState});
					}
				}
			}
			step++;
		}
		return -1;
	}

}
