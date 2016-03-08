package geeksForGeeks.trees;

public class InOrderSuccessorInBST {

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

		InOrderSuccessorInBST.getInOrderSuccessor(root, null, 5);
	}

	private static void getInOrderSuccessor(TreeNode root, TreeNode parent,
			int i) {
		if (root == null) {
			return;
		}
		if (root.value == i) {
			if (root.right != null) {
				System.out.println(getSuccessor(root.right, i));
			} else {
				System.out.println(parent);
			}
		}
		if (i < root.value) {
			getInOrderSuccessor(root.left, root, i);
		} else {
			getInOrderSuccessor(root.right, parent, i);
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

}
