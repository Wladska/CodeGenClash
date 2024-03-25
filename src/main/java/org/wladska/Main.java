package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalTank = 0, currentTank = 0, startingStation = 0;
		for (int i = 0; i < gas.length; i++) {
			totalTank += gas[i] - cost[i];
			currentTank += gas[i] - cost[i];
			if (currentTank < 0) {
				// Cannot reach station i + 1 from the current starting station
				startingStation = i + 1;
				currentTank = 0; // Reset the current tank
			}
		}
		return totalTank >= 0 ? startingStation : -1;
	}

}
