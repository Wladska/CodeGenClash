package org.wladska;

import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public boolean isValidSudoku(char[][] board) {
		HashSet<String> seen = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char number = board[i][j];
				if (number != '.') {
					if (!seen.add(number + " in row " + i) ||
							!seen.add(number + " in column " + j) ||
							!seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
						// If any of the add operations returns false, it means a duplicate was found
						return false;
					}
				}
			}
		}

		return true; // No duplicates were found
	}

}
