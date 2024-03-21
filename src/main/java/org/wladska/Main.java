package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * You are given an array of distinct positive integers locations where locations[i] represents the position of city i. You are also given integers start, finish and fuel representing the starting city, ending city, and the initial amount of fuel you have, respectively.
	 * At each step, if you are at city i, you can pick any city j such that j != i and 0 <= j < locations.length and move to city j. Moving from city i to city j reduces the amount of fuel you have by |locations[i] - locations[j]|. Please notice that |x| denotes the absolute value of x.
	 * Notice that fuel cannot become negative at any point in time, and that you are allowed to visit any city more than once (including start and finish).
	 * Return the count of all possible routes from start to finish. Since the answer may be too large, return it modulo 109 + 7.
	 * 
	 * Example 1:
	 * Input: locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
	 * Output: 4
	 * 
	 * Example 2:
	 * Input: locations = [4,3,1], start = 1, finish = 0, fuel = 6
	 * Output: 5
	 * 
	 * Example 3:
	 * Input: locations = [5,2,1], start = 0, finish = 2, fuel = 3
	 * Output: 0
	 * 
	 * Constraints:
	 * 2 <= locations.length <= 100
	 * 1 <= locations[i] <= 109
	 * All integers in locations are distinct.
	 * 0 <= start, finish < locations.length
	 * 1 <= fuel <= 200
	 */
	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		if (start == finish) {
            return 1;
        }
        if (start > finish) {
            int temp = start;
            start = finish;
            finish = temp;
        }
        if (fuel < 0) {
            return 0;
        }
        if (fuel == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < locations.length; i++) {
            if (locations[i]!= start && locations[i]!= finish) {
                count += countRoutes(locations, locations[i], finish, fuel - Math.abs(locations[i] - locations[start]));
            }
        }
        return count;
	}
}
