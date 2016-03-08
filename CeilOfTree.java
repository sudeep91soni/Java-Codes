package geeksForGeeks.trees;

public class CeilOfTree {

	public static void main(String[] args) {
		TreeNode root1;
		root1 = new TreeNode(10);
		BinarySearchTreeOps.insert(root1, 4);
		BinarySearchTreeOps.insert(root1, 6);
		BinarySearchTreeOps.insert(root1, 14);
		BinarySearchTreeOps.insert(root1, 12);
		BinarySearchTreeOps.insert(root1, 1);
		TreesUtils.levelOrder(root1);

		int ceilValue = getCeilValue(root1, null, 13);
		System.out.println(ceilValue);
	}

	private static int getCeilValue(TreeNode root, TreeNode saved, int i) {

		if (root == null) {
			return saved == null ? -1 : saved.value;
		}
		if (root.value == i) {
			return root.value;
		} else {
			int left = -1;
			int right = -1;
			if (i < root.value) {
				left = getCeilValue(root.left, root, i);
			} else {
				right = getCeilValue(root.right, saved, i);
			}
			return Math.max(left, right);
		}
	}
}
