package org.wladska;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
	 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
	 * Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
	 * 
	 * Example 1:
	 * Input: board = [[1,2,3],[4,0,5]]
	 * Output: 1
	 * 
	 * Example 2:
	 * Input: board = [[1,2,3],[5,4,0]]
	 * Output: -1
	 * 
	 * Example 3:
	 * Input: board = [[4,1,2],[5,0,3]]
	 * Output: 5
	 * 
	 * Constraints:
	 * board.length == 2
	 * board[i].length == 3
	 * 0 <= board[i][j] <= 5
	 * Each value board[i][j] is unique.
	 */
	public int slidingPuzzle(int[][] board) {
		int[][] target = {{1, 2, 3}, {4, 5, 0}};
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Set<String> visited = new HashSet<>();
		Queue<int[][]> queue = new LinkedList<>();
		queue.offer(board);
		visited.add(Arrays.deepToString(board));
		int res = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[][] cur = queue.poll();
				if (Arrays.deepEquals(cur, target)) {
					return res;
				}
				int x = 0, y = 0;
				boolean found = false;
				for (x = 0; x < 2; x++) {
					for (y = 0; y < 3; y++) {
						if (cur[x][y] == 0) {
							found = true;
							break;
						}
					}
					if (found) {
						break;
					}
				}
				for (int[] dir : dirs) {
					int nx = x + dir[0];
					int ny = y + dir[1];
					if (nx < 0 || nx >= 2 || ny < 0 || ny >= 3) {
						continue;
					}
					int[][] next = new int[2][3];
					for (int j = 0; j < 2; j++) {
						for (int k = 0; k < 3; k++) {
							next[j][k] = cur[j][k];
						}
					}
					next[x][y] = next[nx][ny];
					next[nx][ny] = 0;
					if (visited.add(Arrays.deepToString(next))) {
						queue.offer(next);
					}
				}
			}
			res++;
		}
		return -1;
	}
	
}
