package geeksForGeeks.trees;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class TreeTest {

	org.slf4j.Logger logger = LoggerFactory.getLogger(TreeTest.class);
	TreeNode root;

	TreeNode root2;

	TreeNodeNext rootWithNext;

	@Before
	public void setUp() {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.right.left = new TreeNode(7);
		System.out.println("Inorder Traversal");
		TreesUtils.inOrderTraverse(root);
		System.out.println();
		System.out.println("Pre order Traversal");
		TreesUtils.preOrderTraversal(root);
		System.out.println();

		root2 = new TreeNode(2);
		root2.left = new TreeNode(4);
		root2.right = new TreeNode(5);
		System.out.println("Inorder Traversal of T2");
		TreesUtils.inOrderTraverse(root2);
		System.out.println();
		System.out.println("Pre order Traversal");
		TreesUtils.preOrderTraversal(root2);
		System.out.println();

		rootWithNext = new TreeNodeNext(1);
		rootWithNext.left = new TreeNodeNext(2);
		rootWithNext.right = new TreeNodeNext(3);
		rootWithNext.left.left = new TreeNodeNext(4);
		rootWithNext.left.right = new TreeNodeNext(5);
		rootWithNext.left.left.left = new TreeNodeNext(6);
		rootWithNext.right.left = new TreeNodeNext(7);
		System.out.println("Inorder Traversal of next");
		TreesUtils.inOrderTraverse(rootWithNext);
		System.out.println();
		System.out.println("Pre order Traversal");
		TreesUtils.preOrderTraversal(rootWithNext);
		System.out.println();
		System.out.println("=======================");
	}

	@Test
	public void printLevelOrderTest() {

		System.out.println("prints Level order");
		PrintKthNodeFromRoot.printLevel(root);

	}

	@Test
	public void printAllAncestors() {

		System.out.println("printAll Ancestors Test");
		PrintAncestor.presentInTree(root, 6);

	}

	@Test
	public void checkIfSubTree() {
		System.out.println("Check if Tree T2 is subtree of Tree T1");
		System.out.println(CheckIfSubTree.checkIfT2SubOfT1(root, root2));
	}

	@Test
	public void connectNodesOfSameLevel() {
		System.out.println("Root with Next");
		ConnectNodesOfSameLevel.connect(rootWithNext);
	}

}