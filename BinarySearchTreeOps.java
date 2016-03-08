package geeksForGeeks.trees;

public class BinarySearchTreeOps {

	static TreeNode insert(TreeNode node, Integer value) {
		if (node == null) {
			node = new TreeNode(value);
			return node;
		}
		if (node.value == value) {
			return node;
		} else {
			if (node.value.compareTo(value) > 0) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
		}
		return node;
	}

	static boolean search(TreeNode node, Integer value) {

		if (node == null) {
			return false;
		}

		if (node.value.compareTo(value) == 0) {
			return true;
		} else {
			boolean left = false;
			boolean right = false;
			if (node.value.compareTo(value) > 0) {
				left = search(node.left, value);
			} else {
				right = search(node.right, value);
			}
			return left || right;
		}
	}

	static TreeNode delete(TreeNode node, Integer value) {

		if (node == null || node.value == value && node.left == null
				&& node.right == null) {
			return null;
		}
		if (node.value == value && node.left != null && node.right == null) {
			return node.left;
		}
		if (node.value == value && node.left == null && node.right != null) {
			return node.right;
		}
		if (node.value == value && node.left != null && node.right != null) {
			TreeNode inOrder = findInorder(node.right);
			swapContent(node, inOrder);
			delete(node, inOrder.value);
		} else if (node.value != value) {
			node.left = delete(node.left, value);
			node.right = delete(node.right, value);
		}
		return node;
	}

	static void swapContent(TreeNode node, TreeNode inOrder) {
		if (inOrder != null && node != null) {
			Integer temp = inOrder.value;
			inOrder.value = node.value;
			node.value = temp;
		}
	}

	static TreeNode findInorder(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.left == null) {
			return node;
		} else {
			return findInorder(node.left);
		}
	}
}
