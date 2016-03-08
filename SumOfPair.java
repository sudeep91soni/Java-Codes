package geeksForGeeks.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfPair {

	public static void main(String[] args) {

		TreeNode root = null;
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

		TreeNode listHead;
		listHead = treeToLLQueue(root, 8);

		traverseList(listHead, 14);
	}

	private static void traverseList(TreeNode listHead, int sum) {
		if (listHead == null) {
			return;
		}

		TreeNode temp = null;
		while (listHead != null) {
			TreeNode prev = listHead;
			while (prev != null) {
				if (listHead.value + prev.value > sum) {
					break;
				}
				if (listHead.value + prev.value == sum) {
					System.out.println();
					System.out.println(listHead.value + " + " + prev.value
							+ " = " + sum);
					break;
				}
				prev = prev.right;

			}
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

	private static TreeNode treeToLLQueue(TreeNode root, int sum) {

		if (root == null) {
			return null;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		inOrderTraversal(root, q);

		TreeNode prev = q.poll();
		TreeNode head = prev;
		TreeNode node = null;
		while ((node = q.poll()) != null) {

			if (sum == prev.value + node.value) {
				System.out.println(prev.value + " + " + node.value + " = "
						+ sum);
			}
			prev.right = node;
			node.left = prev;
			prev = node;

		}
		return head;

	}

	private static void inOrderTraversal(TreeNode root, Queue<TreeNode> q) {
		if (root == null) {
			return;
		} else {
			inOrderTraversal(root.left, q);
			q.add(root);
			inOrderTraversal(root.right, q);
		}

	}

}
