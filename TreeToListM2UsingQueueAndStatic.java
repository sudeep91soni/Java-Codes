package geeksForGeeks.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeToListM2UsingQueueAndStatic {

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

		listHead = treeToLL(root);

		while (listHead.left != null) {
			listHead = listHead.left;
		}

		traverseList(listHead);
		System.out.println();
		System.out.println();
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
		
		listHead = treeToLLQueue(root);

		traverseList(listHead);
	}

	static TreeNode prev = null;
	static TreeNode head = null;

	private static TreeNode treeToLL(TreeNode root) {

		if (root == null) {
			return null;
		}

		treeToLL(root.left);
		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		treeToLL(root.right);

		return head;

	}

	private static TreeNode treeToLLQueue(TreeNode root) {

		if (root == null) {
			return null;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		inOrderTraversal(root, q);

		TreeNode prev = q.poll();
		TreeNode head = prev;
		TreeNode node = null;
		while ((node = q.poll()) != null) {

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
}
