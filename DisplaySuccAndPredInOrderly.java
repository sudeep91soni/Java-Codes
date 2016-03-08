package geeksForGeeks.trees;


public class DisplaySuccAndPredInOrderly {

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

		displayPredAndSucc(root, null, null);

		// traverseList(listHead);
	}

	private static void traverseList(TreeNode listHead) {
		if (listHead == null) {
			return;
		}
		if (listHead.left == null && listHead.right == null) {
			System.out.println(listHead.value + ", ");
		} else if (listHead.left == null && listHead.right != null) {
			System.out.println(listHead.left.value + " <- " + listHead.value
					+ ", ");
		} else if (listHead.left != null && listHead.right == null) {
			System.out.println(listHead.value + " -> " + listHead.right.value
					+ ", ");
		} else {
			System.out.println(listHead.left.value + " <- " + listHead.value
					+ " -> " + listHead.right.value + ", ");
		}

	}

	private static void displayPredAndSucc(TreeNode root, TreeNode pred,
			TreeNode succ) {

		if (root == null) {
			return;
		} else {
			displayPredAndSucc(root.left, pred, root);

			System.out.print("|");
			displayPred(root, pred);
			System.out.print(" -" + root.value + "- ");
			displaySucc(root, succ);
			System.out.print("|");

			displayPredAndSucc(root.right, root, succ);

		}
	}

	private static TreeNode getSuccessor(TreeNode root, int i) {
		if (root == null) {
			return null;
		}
		if (root.left == null) {
			return root;
		} else {
			return getSuccessor(root.left, i);
		}
	}

	private static void displaySucc(TreeNode root, TreeNode parent) {
		if (root.right != null) {
			TreeNode succ = getSuccessor(root.right, root.value);
			if (succ != null)

				System.out.print(succ.value);
			else
				System.out.println("N");
		} else {
			if (parent != null)
				System.out.print(parent.value);
			else
				System.out.print("N");
		}

	}

	private static TreeNode getPredecessor(TreeNode root, int i) {
		if (root == null) {
			return null;
		}
		if (root.right == null) {
			return root;
		} else {
			return getPredecessor(root.right, i);
		}
	}

	private static void displayPred(TreeNode root, TreeNode parent) {
		if (root.left != null) {
			TreeNode pred = getPredecessor(root.left, root.value);
			if (pred != null)
				System.out.print(pred.value);
			else
				System.out.println("N");
		} else {
			if (parent != null)
				System.out.print(parent.value);
			else
				System.out.print("N");
		}

	}
}
