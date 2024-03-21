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
        // TODO Auto-generated method stub
		solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
			System.out.println();
		}

		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
			System.out.println();
		}
    }

	private void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = (char) (k + '0');
                            solve(board);
                            board[i][j] = '.';
                        }
                    }
                }
            }
        }
	}
	
	private boolean isValid(char[][] board, int i, int j, int k) {
		for (int ii = 0; ii < 9; ii++) {
            if (board[ii][j] == k || board[i][ii] == k) {
                return false;
            }
        }
        int x = i / 3;
        int y = j / 3;
        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                if (board[x * 3 + ii][y * 3 + jj] == k) {
                    return false;
                }
            }
        }
        return true;
	}
}
