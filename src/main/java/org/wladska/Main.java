package org.wladska;

import javax.swing.tree.TreeNode;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
	 * A valid BST is defined as follows:
	 * The left subtree of a node contains only nodes with keys less than the node's key.
	 * The right subtree of a node contains only nodes with keys greater than the node's key.
	 * Both the left and right subtrees must also be binary search trees.
	 * 
	 * Example 1:
	 * Input: root = [2,1,3]
	 * Output: true
	 * 
	 * Example 2:
	 * Input: root = [5,1,4,null,null,3,6]
	 * Output: false
	 * 
	 * Constraints:
	 * The number of nodes in the tree is in the range [1, 10^4].
	 * -2^31 <= Node.val <= 2^31 - 1
	 * 
	 *  * Definition for a binary tree node.
		* public class TreeNode {
		*     int val;
		*     TreeNode left;
		*     TreeNode right;
		*     TreeNode() {}
		*     TreeNode(int val) { this.val = val; }
		*     TreeNode(int val, TreeNode left, TreeNode right) {
		*         this.val = val;
		*         this.left = left;
		*         this.right = right;
		*     }
		* }
 		*/
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
		    this.val = val;
		    this.left = left;
		    this.right = right;
		}
	}
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	private boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
			return false;
		}
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
}
