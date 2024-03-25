package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public void solveSudoku(char[][] board) {
		solve(board);
	}

	private boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// If the cell is empty
				if (board[i][j] == '.') {
					// Try all possible numbers
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;

							// Recurse and if the solution is found, return true
							if (solve(board)) {
								return true;
							} else {
								// Backtrack
								board[i][j] = '.';
							}
						}
					}
					// If no valid number is found, return false
					return false;
				}
			}
		}
		// When all cells are filled correctly
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			// Check row
			if (board[row][i] == c) return false;
			// Check column
			if (board[i][col] == c) return false;
			// Check 3x3 box
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
		}
		return true;
	}

}
