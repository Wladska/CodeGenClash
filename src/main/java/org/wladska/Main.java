package org.wladska;

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
		 int[] dist = new int[n];
		 for (int i = 0; i < n; i++) {
             dist[i] = Integer.MAX_VALUE;
         }
		 dist[0] = 0;
		 for (int i = 0; i < n; i++) {
			 for (int j = 0; j < graph[i].length; j++) {
                 if (dist[graph[i][j]] > dist[i] + 1) {
                     dist[graph[i][j]] = dist[i] + 1;
                 }
             }
			 if (dist[i] == Integer.MAX_VALUE) {
                 return -1;
             }


			 for (int j = 0; j < graph[i].length; j++) {
                 if (dist[graph[i][j]] > dist[i] + 1) {
                     dist[graph[i][j]] = dist[i] + 1;
                 }
             }
             if (dist[i] == Integer.MAX_VALUE) {
                 return -1;
             }
         
		  }
          return dist[n - 1];
	 }
}
