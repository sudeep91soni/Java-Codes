package geeksForGeeks.linkedList;

public class ReverseList {

	public static void main(String[] args) {
		Node head = new Node("1");
		head.setNext(new Node("2"));
		head.getNext().setNext(new Node("3"));
		head.getNext().getNext().setNext(new Node("4"));
		head.getNext().getNext().getNext().setNext(new Node("5"));
		LinkedListUtil.traverse(head);
		Node reverseHead = reverseList(head);
		System.out.println(reverseHead);
		LinkedListUtil.traverse(reverseHead);
	}

	private static Node reverseList(Node node) {
		if (node == null) {
			return null;
		}
		Node next = node.getNext();
		if (next == null) {
			return node;
		}
		Node head = reverseList(next);
		next.setNext(node);
		node.setNext(null);

		return head;
	}

}
