package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
	 * Return the minimum number of intervals required to complete all tasks.
	 * 
	 * Example 1:
	 * Input: tasks = ["A","A","A","B","B","B"], n = 2
	 * Output: 8
	 * 
	 * Example 2:
	 * Input: tasks = ["A","C","A","B","D","B"], n = 1
	 * Output: 6
	 * 
	 * Example 3:
	 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
	 * Output: 10
	 * 
	 * Constraints:
	 * 1 <= tasks.length <= 10^4
	 * tasks[i] is an uppercase English letter.
	 * 0 <= n <= 100
	 */
	public int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            res += (count[i] - 1) / n + 1;
        }
        return res;
	}
}
