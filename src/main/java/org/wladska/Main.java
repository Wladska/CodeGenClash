package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * Write a program to solve a Sudoku puzzle by filling the empty cells.
	 * A sudoku solution must satisfy all of the following rules:
	 * Each of the digits 1-9 must occur exactly once in each row.
	 * Each of the digits 1-9 must occur exactly once in each column.
	 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
	 * The '.' character indicates empty cells.
	 * 
	 * Example 1:
	 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
	 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
	 * 
	 * Constraints:
	 * board.length == 9
	 * board[i].length == 9
	 * board[i][j] is a digit or '.'.
	 * It is guaranteed that the input board has only one solution.
	 */
	public void solveSudoku(char[][] board) {
		Sudoku sudoku = new Sudoku(board);
		sudoku.solve();
	}
	public static class Sudoku {
		private final char[][] board;
		public Sudoku(char[][] board) {
			this.board = board;
		}
		public void solve() {
			solve(0, 0);
		}
		private boolean solve(int row, int col) {
			if (row == 9) {
				return true;
			}
			if (col == 9) {
				return solve(row + 1, 0);
			}
			if (board[row][col] != '.') {
				return solve(row, col + 1);
			}
			for (char c = '1'; c <= '9'; c++) {
				if (isValid(row, col, c)) {
					board[row][col] = c;
					if (solve(row, col + 1)) {
						return true;
					}
					board[row][col] = '.';
				}
			}
			return false;
		}
		private boolean isValid(int row, int col, char c) {
			for (int i = 0; i < 9; i++) {
				if (board[row][i] == c) {
					return false;
				}
				if (board[i][col] == c) {
					return false;
				}
				if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
					return false;
				}
			}
			return true;
		}
	}
}
