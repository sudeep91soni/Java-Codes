package geeksForGeeks.trees;

public class LCAInBinaryST {

	public static TreeNode getLowestCommonAncestorForBST(TreeNode node,
			Integer value1, Integer value2) {
		if (node == null) {
			return null;
		}
		if (node.value == value1 || node.value == value2) {
			return node;
		}
		if (value1 < node.value && value2 > node.value) {
			return node;
		} else if (value2 < node.value) {
			return getLowestCommonAncestorForBST(node.left, value1, value2);
		} else {
			return getLowestCommonAncestorForBST(node.right, value1, value2);
		}

	}

	/*
	 * Node lca(Node node, int n1, int n2) { if (node == null) { return null; }
	 * 
	 * // If both n1 and n2 are smaller than root, then LCA lies in left if
	 * (node.data > n1 && node.data > n2) { return lca(node.left, n1, n2); }
	 * 
	 * // If both n1 and n2 are greater than root, then LCA lies in right if
	 * (node.data < n1 && node.data < n2) { return lca(node.right, n1, n2); }
	 * 
	 * return node; }
	 */

	public static TreeNode getLowestCommonAncestorBinaryTree(TreeNode node,
			Integer value1, Integer value2) {
		if (node == null) {
			return null;
		}
		if (node.value == value1 || node.value == value2) {
			return node;
		}
		if (presentInSubTree(node.left, value1)) {
			if (presentInSubTree(node.right, value2)) {
				return node;
			} else {
				return getLowestCommonAncestorBinaryTree(node.left, value1,
						value2);
			}

		} else {
			if (presentInSubTree(node.left, value2)) {
				return node;
			} else {
				return getLowestCommonAncestorForBST(node.right, value1, value2);
			}
		}

	}

	private static boolean presentInSubTree(TreeNode node, Integer value) {
		if (node == null) {
			return false;
		}
		if (node.value == value) {
			return true;
		} else {
			return presentInSubTree(node.left, value)
					|| presentInSubTree(node.right, value);
		}
	}
}
