package geeksForGeeks.trees;

public class PrintKthNodeOfBST {

	static int k = 6;

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(5);
		BinarySearchTreeOps.insert(root, 1);
		BinarySearchTreeOps.insert(root, 3);
		BinarySearchTreeOps.insert(root, 2);
		BinarySearchTreeOps.insert(root, 10);
		BinarySearchTreeOps.insert(root, 11);
		BinarySearchTreeOps.insert(root, 0);
		TreesUtils.levelOrder(root);
		TreesUtils.inOrderTraverse(root);
		System.out.println();
		PrintKthNodeOfBST.printKthNode(root);
		System.out.println("M2");
		PrintKthNodeOfBST.printKthNodeM2(root, new Counter(6));
	}

	private static void printKthNode(TreeNode root) {

		if (root == null) {
			return;
		} else {
			printKthNode(root.left);
			k--;
			if (k == 0) {
				System.out.println(root.value);
			}
			printKthNode(root.right);

		}
	}

	private static void printKthNodeM2(TreeNode root, Counter c) {

		if (root == null) {
			return;
		} else {
			printKthNodeM2(root.left, c);
			c.count--;
			if (c.count == 0) {
				System.out.println(root.value);
			}
			printKthNodeM2(root.right, c);

		}
	}
	static class Counter {
		public Counter(int i) {
			this.count = i;
		}

		public int count;
	}
}
