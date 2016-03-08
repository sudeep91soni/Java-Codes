package geeksForGeeks.trees;

public class TreesUtils {

	static void inOrderTraverse(TreeNode node) {
		if (node == null) {
			return;
		} else {
			inOrderTraverse(node.left);
			System.out.print(node.value + " ");
			inOrderTraverse(node.right);
		}
	}

	static void preOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.value + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	static void postOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		} else {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.value + " ");
		}
	}

	public static int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return (Math.max(getHeight(node.left), getHeight(node.right)) + 1);
		}
	}

	static void levelOrder(TreeNode node) {
		for (int i = 0; i < getHeight(node); i++) {
			System.out.print("Printing " + i + "th level: ");
			printLevel(node, i);
			System.out.println();
		}
	}

	static void printLevel(TreeNode node, int level) {

		if (node == null) {
			return;
		}
		if (level == 0) {
			System.out.print(node.value + " ");
		} else if (level > 0) {
			printLevel(node.left, level - 1);
			printLevel(node.right, level - 1);
		}
	}

}
