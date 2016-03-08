package geeksForGeeks.trees;

public class CheckIfSubTree {

	static boolean checkIfT2SubOfT1(TreeNode n1, TreeNode n2) {
		if (n2 == null) {
			return true;
		}
		if (n1 == null) {
			return false;
		}
		if (isSame(n1, n2)) {
			return true;
		} else {
			return checkIfT2SubOfT1(n1.left, n2)
					|| checkIfT2SubOfT1(n1.right, n2);
		}

	}

	private static boolean isSame(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null) {
			return true;
		}
		if (n1 == null && n2 != null) {
			return false;
		}
		if (n1 != null && n2 == null) {
			return true;
		}
		if (n1.value == n2.value) {
			return isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
		} else {
			return false;
		}
	}
}
