package geeksForGeeks.trees;

public class PrintAncestor {

	static boolean presentInTree(TreeNode node, int value) {

		if (node == null) {
			return false;
		}
		if (node.value == value) {
			return true;
		}
		if (presentInTree(node.left, value)
				|| presentInTree(node.right, value)) {
			System.out.println(node.value + " ");
			return true;
		}
		return false;
	}
}

