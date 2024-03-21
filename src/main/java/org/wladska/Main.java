package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
	 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
	 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
	 * 
	 * Example 1:
	 * Input: n = 4
	 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
	 * 
	 * Example 2:
	 * Input: n = 1
	 * Output: [["Q"]]
	 * 
	 * Constraints:
	 * 1 <= n <= 9
	 */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], '.');
		}
		backtrack(result, board, 0);
		return result;
	}

	private void backtrack(List<List<String>> result, char[][] board, int row) {
		if (row == board.length) {
			result.add(construct(board));
			return;
		}
		for (int col = 0; col < board.length; col++) {
			if (isValid(board, row, col)) {
				board[row][col] = 'Q';
				backtrack(result, board, row + 1);
				board[row][col] = '.';
			}
		}
	}


	private boolean isValid(char[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}

	private List<String> construct(char[][] board) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			result.add(new String(board[i]));
		}
		return result;
	}
}
