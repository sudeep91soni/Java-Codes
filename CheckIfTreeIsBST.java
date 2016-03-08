package geeksForGeeks.trees;

public class CheckIfTreeIsBST {

	static boolean checkIfBST(TreeNode node) {

		if (node == null)
			return (true);

		if (node.left != null && maxValue(node.left) > node.value)
			return (false);

		if (node.right != null && minValue(node.right) < node.value)
			return (false);

		if (!checkIfBST(node.left) || !checkIfBST(node.right))
			return (false);

		return (true);

	}

	private static Integer minValue(TreeNode right) {

		if (right.left == null)
			return right.value;
		else {
			return minValue(right.left);
		}
	}

	private static Integer maxValue(TreeNode left) {
		if (left.right == null)
			return left.value;
		else {
			return minValue(left.right);
		}
	}

	static boolean isBSTUtil(TreeNode node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.value < min || node.value > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.value - 1) && isBSTUtil(
				node.right, node.value + 1, max));
	}

}
