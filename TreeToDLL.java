package geeksForGeeks.trees;

public class TreeToDLL {

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

		TreeNode listHead = null;
		listHead = treeToDLL(root);

		while (listHead.left != null) {
			listHead = listHead.left;
		}

		traverseList(listHead);
	}

	private static void traverseList(TreeNode listHead) {
		if (listHead == null) {
			return;
		}

		TreeNode temp = null;
		while (listHead != null) {
			System.out.print(listHead.value + " ");
			if (listHead.right == null) {
				temp = listHead;
			}
			listHead = listHead.right;
		}
		System.out.println();
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.left;
		}

	}

	private static TreeNode treeToDLL(TreeNode root) {

		if (root == null) {
			return null;
		}

		if (root.left != null) {
			TreeNode left = treeToDLL(root.left);
			while (left.right != null) {
				left = left.right;
			}
			left.right = root;
			root.left = left;
		}
		if (root.right != null) {
			TreeNode right = treeToDLL(root.right);
			while (right.left != null) {
				right = right.left;
			}
			right.left = root;
			root.right = right;
		}

		return root;
	}

}
