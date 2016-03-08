package geeksForGeeks.trees;

public class TreeNode implements Comparable<TreeNode> {
	@Override
	public String toString() {
		return "TreeNode [value=" + value + ", left=" + left + ", right="
				+ right + "]";
	}

	public Integer value;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(Integer value) {
		this.value = value;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public int compareTo(TreeNode arg0) {
		return this.value.compareTo(arg0.value);
	}
}
