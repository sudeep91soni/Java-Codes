package geeksForGeeks.trees;

import org.junit.Before;
import org.junit.Test;

public class LCATest {
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
	public void testLCA() {

		System.out.println("LCA for BST");
		System.out.println(LCAInBinaryST.getLowestCommonAncestorForBST(root, 1,
				2));
		System.out.println("LCA for Binary tree");
		System.out.println(LCAInBinaryST.getLowestCommonAncestorBinaryTree(root, 2,
				3));
	}
}
