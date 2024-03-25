package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		// Step 1: Find the first decreasing element
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}

		if (i >= 0) {
			int j = nums.length - 1;
			// Step 2: Find the element to swap with the pivot
			while (nums[j] <= nums[i]) {
				j--;
			}
			// Step 3: Swap the pivot with the found element
			swap(nums, i, j);
		}
		// Step 4: Reverse the suffix
		reverse(nums, i + 1);
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

}
