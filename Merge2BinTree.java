package geeksForGeeks.trees;

import java.util.Set;
import java.util.TreeSet;

public class Merge2BinTree {

	public static void main(String[] args) {

		TreeNode root1;
		root1 = new TreeNode(10);
		BinarySearchTreeOps.insert(root1, 4);
		BinarySearchTreeOps.insert(root1, 6);
		BinarySearchTreeOps.insert(root1, 14);
		BinarySearchTreeOps.insert(root1, 12);
		BinarySearchTreeOps.insert(root1, 1);
		TreesUtils.levelOrder(root1);

		TreeNode root2;
		root2 = new TreeNode(13);
		BinarySearchTreeOps.insert(root2, 18);
		BinarySearchTreeOps.insert(root2, 3);
		BinarySearchTreeOps.insert(root2, 5);
		BinarySearchTreeOps.insert(root2, 1);
		BinarySearchTreeOps.insert(root2, 7);
		TreesUtils.levelOrder(root2);

		TreeNode result = mergeTree(root1, root2);

		TreesUtils.levelOrder(result);

	}

	private static TreeNode mergeTree(TreeNode root1, TreeNode root2) {

		Set<TreeNode> merged = new TreeSet<TreeNode>();

		fillSet(root1, merged);
		fillSet(root2, merged);

		for (TreeNode node : merged) {
			System.out.print(node.value + " ");
		}
		System.out.println();
		return listToTree((TreeNode[]) merged.toArray(new TreeNode[0]), 0,
				merged.size() - 1);
	}

	private static TreeNode listToTree(TreeNode[] nodes, int start, int end) {

		if (start > end) {
			return null;
		} else {
			int mid = start + (end - start) / 2;
			TreeNode temp = nodes[mid];
			temp.left = listToTree(nodes, start, mid - 1);
			temp.right = listToTree(nodes, mid + 1, end);
			return temp;
		}
	}

	private static void fillSet(TreeNode root, Set<TreeNode> merged) {

		if (root == null) {
			return;
		} else {
			fillSet(root.left, merged);
			merged.add(root);
			fillSet(root.right, merged);
		}
	}

}
