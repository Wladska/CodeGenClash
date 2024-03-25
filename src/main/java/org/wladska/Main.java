package org.wladska;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int slidingPuzzle(int[][] board) {
		String target = "123450";
		String start = serialize(board);
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		// Directions that the '0' can be swapped to: up, down, left, right
		int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

		queue.offer(start);
		visited.add(start);

		int level = 0; // Number of moves
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String current = queue.poll();
				if (target.equals(current)) {
					return level;
				}

				int zeroPos = current.indexOf('0');
				for (int dir : dirs[zeroPos]) {
					String next = swap(current, zeroPos, dir);
					if (visited.contains(next)) {
						continue;
					}
					visited.add(next);
					queue.offer(next);
				}
			}
			level++;
		}

		return -1; // Not solvable
	}

	private String serialize(int[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]);
			}
		}
		return sb.toString();
	}

	private String swap(String s, int i, int j) {
		char[] chars = s.toCharArray();
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
		return new String(chars);
	}
}
