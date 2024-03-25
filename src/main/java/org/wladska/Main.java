package org.wladska;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		for (int num : nums) {
			if (seen.contains(num)) {
				// Found a duplicate
				return true;
			}
			seen.add(num);
		}
		// No duplicates found
		return false;
	}
}
