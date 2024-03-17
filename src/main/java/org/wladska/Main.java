package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * Write a function to find the longest common prefix string amongst an array of strings.

	 * If there is no common prefix, return an empty string "".

	 * Example 1:
	 * Input: strs = ["flower","flow","flight"]
	 * Output: "fl"
	 * 
	 * Example 2:
	 * Input: strs = ["dog","racecar","car"]
	 * Output: ""
	 * Explanation: There is no common prefix among the input strings.
	 * 
	 * Constraints:
	 * 1 <= strs.length <= 200
	 * 0 <= strs[i].length <= 200
	 * strs[i] consists of only lowercase English letters.
	 */

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length());
            } else {
                return prefix;
            }
        }
        return prefix;
	}
}
