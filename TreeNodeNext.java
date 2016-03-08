package geeksForGeeks.trees;

public class TreeNodeNext extends TreeNode {
	public TreeNodeNext next;

	public TreeNodeNext(Integer value) {
		super(value);
	}

	@Override
	public String toString() {
		return "TreeNodeNext [next=" + next + ", value=" + value + ", left="
				+ left + ", right=" + right + "]";
	}

	public TreeNodeNext getNext() {
		return next;
	}

	public void setNext(TreeNodeNext next) {
		this.next = next;
	}
}
