package geeksForGeeks.trees;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

	TreeNode root;

	@Before
	public void setUp() {
		root = new TreeNode(5);
		BinarySearchTreeOps.insert(root, 1);
		BinarySearchTreeOps.insert(root, 3);
		BinarySearchTreeOps.insert(root, 2);
		BinarySearchTreeOps.insert(root, 10);
		BinarySearchTreeOps.insert(root, 11);
		BinarySearchTreeOps.insert(root, 0);
		TreesUtils.levelOrder(root);

		System.out.println(BinarySearchTreeOps.search(root, 3));
	}

	@Test
	public void binarySearchTreeTest() {

		BinarySearchTreeOps.delete(root, 1);
		TreesUtils.levelOrder(root);
	}

	@Test
	public void testSuccessorAndPredessor() {
		System.out.println("Hello");
		SuccessorAndPredecessorInBST.findSuccessorAndPredecessor(root, null,
				null, 2);
	}

	@Test
	public void testBinaryST() {
		System.out.println("Check if a tree is BST Inefficient");
		System.out.println(CheckIfTreeIsBST.checkIfBST(root));
		System.out.println("Check if a tree is BST efficient");

		System.out.println(CheckIfTreeIsBST.isBSTUtil(root, Integer.MIN_VALUE,
				Integer.MAX_VALUE));
	}
}
