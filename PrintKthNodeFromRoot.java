package geeksForGeeks.trees;

public class PrintKthNodeFromRoot {

	static void printKth(TreeNode node, int level) {

		if (node == null) {
			return;
		}
		if (level == 0) {
			System.out.print(node.value + " ");
		} else if (level > 0) {
			printKth(node.left, level - 1);
			printKth(node.right, level - 1);
		}

	}

	static void printLevel(TreeNode node) {
		for (int i = 0; i < height(node); i++) {
			System.out.print("Printing " + i + "th level: ");
			printKth(node, i);
			System.out.println();
		}
	}

	private static int height(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return (Math.max(height(node.left), height(node.right)) + 1);
		}
	}

}
