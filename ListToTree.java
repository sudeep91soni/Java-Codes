package geeksForGeeks.trees;

class CNode {
	public CNode(int i) {
		this.value = i;
		this.next = null;
	}

	int value;
	CNode next;
	CNode left;
	CNode right;
}

public class ListToTree {

	public static void main(String[] args) {

		CNode head = new CNode(1);
		head.next = new CNode(10);
		head.next.next = new CNode(3);
		head.next.next.next = new CNode(4);
		head.next.next.next.next = new CNode(5);
		head.next.next.next.next.next = new CNode(6);
		head.next.next.next.next.next.next = new CNode(7);

		CNode temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
		CNode root = convertIntoBST(head, 0, 6);
		levelOrder(root);
		inOrder(root);

	}

	private static void inOrder(CNode root) {
		if(root == null)
		{
			return;
		}
		else
		{
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
		}
		
		
	}

	public static int getHeight(CNode node) {
		if (node == null) {
			return 0;
		} else {
			return (Math.max(getHeight(node.left), getHeight(node.right)) + 1);
		}
	}

	static void levelOrder(CNode node) {
		for (int i = 0; i < getHeight(node); i++) {
			System.out.print("Printing " + i + "th level: ");
			printLevel(node, i);
			System.out.println();
		}
	}

	private static void printLevel(CNode node, int level) {
		if (node == null) {
			return;
		}
		if (level == 0) {
			System.out.print(node.value + " ");
		} else if (level > 0) {
			printLevel(node.left, level - 1);
			printLevel(node.right, level - 1);
		}

	}

	private static CNode convertIntoBST(CNode head, int start, int end) {

		if (head == null || start > end) {
			return null;
		} else {
			int mid = start + (end - start) / 2;
			int index = start;
			CNode temp = head;
			while (index != mid) {
				temp = temp.next;
				index++;
			}
			temp.left = convertIntoBST(head, start, mid - 1);
			temp.right = convertIntoBST(temp.next, mid + 1, end);
			return temp;
		}
	}

}
