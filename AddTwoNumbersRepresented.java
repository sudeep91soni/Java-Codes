package geeksForGeeks.linkedList;

public class AddTwoNumbersRepresented {

	public static void main(String[] args) {
		Node head1 = new Node("1");
		head1.setNext(new Node("4"));
		head1.getNext().setNext(new Node("5"));
		head1.getNext().getNext().setNext(new Node("7"));
		LinkedListUtil.traverse(head1);
		Node head2 = new Node("0");
		head2.setNext(new Node("2"));
		head2.getNext().setNext(new Node("4"));
		head2.getNext().getNext().setNext(new Node("8"));
		LinkedListUtil.traverse(head2);
		Node headAdd = addTwoList(head1, head2);
		LinkedListUtil.traverse(headAdd);
	}

	private static Node addTwoList(Node head1, Node head2) {

		if (head1 == null || head2 == null) {
			if (head1 == null && head2 != null) {
				return head2;
			} else if (head2 == null && head1 != null) {
				return head1;
			}
			return null;
		}
		Node headAdd = null;
		Node prevNode = null;
		Integer carry = 0;
		while (head1 != null || head2 != null) {
			Integer total = Integer.parseInt(head1.getValue() == null ? "0"
					: head1.getValue())
					+ Integer.parseInt(head2.getValue() == null ? "0" : head2
							.getValue()) + carry;
			Integer unitPlace = total % 10;
			carry = total / 10;
			Node newNode = new Node(unitPlace.toString());
			if (headAdd == null) {
				headAdd = newNode;
			} else {
				prevNode.setNext(newNode);

			}
			prevNode = newNode;
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		if (carry != 0) {
			Node newNode = new Node(carry.toString());
			prevNode.setNext(newNode);
		}

		return headAdd;
	}
}
