package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

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

	private TreeNode prev = null;

	public boolean isValidBST(TreeNode root) {
		return inorder(root);
	}

	private boolean inorder(TreeNode node) {
		if (node == null) {
			return true;
		}

		// In-order traversal: left, node, right
		if (!inorder(node.left)) {
			return false;
		}

		// Check if the current node is greater than the previous node
		if (prev != null && node.val <= prev.val) {
			return false;
		}
		prev = node; // Update prev to the current node before moving to the right subtree

		return inorder(node.right);
	}
}
