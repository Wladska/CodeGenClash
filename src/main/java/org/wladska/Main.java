package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int leastInterval(char[] tasks, int n) {
		int[] frequencies = new int[26];
		for (char task : tasks) {
			frequencies[task - 'A']++;
		}

		int maxFrequency = 0;
		for (int f : frequencies) {
			maxFrequency = Math.max(maxFrequency, f);
		}

		int tasksWithMaxFrequency = 0;
		for (int f : frequencies) {
			if (f == maxFrequency) tasksWithMaxFrequency++;
		}

		// Part 1: Calculate the part contributed by the most frequent tasks
		int intervalsForMostFrequentTasks = (maxFrequency - 1) * (n + 1) + tasksWithMaxFrequency;

		// Part 2: The total intervals must at least be the number of tasks
		// because you can't complete tasks in fewer intervals than the number of tasks.
		return Math.max(intervalsForMostFrequentTasks, tasks.length);
	}

}
