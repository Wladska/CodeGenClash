package org.wladska;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
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
		int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
		String target = "123450";
		Queue<String> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		String start = Arrays.toString(board[0]) + Arrays.toString(board[1]);
		queue.offer(start);
		visited.add(start);
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(target)) {
					return step;
				}
				int zero = cur.indexOf('0');
				for (int dir : dirs[zero]) {
					String next = swap(cur, zero, dir);
					if (visited.add(next)) {
						queue.offer(next);
					}
				}
			}
			step++;
		}
		return -1;
	}
	private String swap(String s, int i, int j) {
		char[] arr = s.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return new String(arr);
	}

}
