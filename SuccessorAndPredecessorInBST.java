package geeksForGeeks.trees;

public class SuccessorAndPredecessorInBST {

	static void findSuccessorAndPredecessor(TreeNode node, TreeNode parentPred, TreeNode parentSucc, Integer value) {
		if (node == null) {
			return;
		}
		if (node.value == value) {
			if (node.left != null) {
				System.out.println(findPredecessor(node.left));
			}
			else if(node.left == null){
				System.out.println(parentPred);
			}
			if (node.right != null) {
				System.out.println(findSuccessor(node.right));
			}
			else if(node.right == null)
			{
				System.out.println(parentSucc);
			}
		} else {

			if (value < node.value) {
				findSuccessorAndPredecessor(node.left, parentPred, node, value);
			} else {
				findSuccessorAndPredecessor(node.right, node, parentSucc, value);

			}
		}

	}

	private static TreeNode findSuccessor(TreeNode right) {
		if (right == null) {
			return null;
		}
		if (right.left == null) {
			return right;
		} else {
			return findSuccessor(right.left);
		}

	}

	private static TreeNode findPredecessor(TreeNode left) {
		if (left == null) {
			return null;
		}
		if (left.right == null) {
			return left;
		} else {
			return findPredecessor(left.right);
		}

	}
}
