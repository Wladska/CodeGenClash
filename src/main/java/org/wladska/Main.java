package org.wladska;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (char[] row : board) {
			Arrays.fill(row, '.');
		}
		List<List<String>> solutions = new ArrayList<>();
		solve(0, n, board, solutions, new HashSet<>(), new HashSet<>(), new HashSet<>());
		return solutions;
	}

	private void solve(int row, int n, char[][] board, List<List<String>> solutions,
					   Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags) {
		if (row == n) {
			solutions.add(construct(board));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (cols.contains(col) || diags.contains(row - col) || antiDiags.contains(row + col)) {
				continue;
			}
			cols.add(col);
			diags.add(row - col);
			antiDiags.add(row + col);
			board[row][col] = 'Q';
			solve(row + 1, n, board, solutions, cols, diags, antiDiags);
			board[row][col] = '.';
			cols.remove(col);
			diags.remove(row - col);
			antiDiags.remove(row + col);
		}
	}

	private List<String> construct(char[][] board) {
		List<String> solution = new ArrayList<>();
		for (char[] row : board) {
			String rowString = new String(row);
			solution.add(rowString);
		}
		return solution;
	}

}
