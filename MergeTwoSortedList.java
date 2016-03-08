package geeksForGeeks.linkedList;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		Node head1 = new Node("1");
		head1.setNext(new Node("3"));
		head1.getNext().setNext(new Node("5"));
		head1.getNext().getNext().setNext(new Node("7"));
		head1.getNext().getNext().getNext().setNext(new Node("11"));

		Node head2 = new Node("0");
		head2.setNext(new Node("2"));
		head2.getNext().setNext(new Node("4"));
		head2.getNext().getNext().setNext(new Node("8"));
		head2.getNext().getNext().getNext().setNext(new Node("13"));

		LinkedListUtil.traverse(head1);
		LinkedListUtil.traverse(head2);
		// Node mergedRoot = mergeLists(head1, head2);
		Node mergedRoot = mergeListsRecursion(head1, head2);
		System.out.println(mergedRoot);
		LinkedListUtil.traverse(mergedRoot);

	}

	private static Node mergeListsRecursion(Node head1, Node head2) {
		if (head1 == null && head2 == null) {
			return null;
		}

		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}

		Node result;
		if (Integer.parseInt(head1.getValue()) < Integer.parseInt((head2
				.getValue()))) {
			result = head1;
			result.setNext(mergeListsRecursion(head1.getNext(), head2));
		} else {
			result = head2;
			result.setNext(mergeListsRecursion(head1, head2.getNext()));
		}
		return result;
	}

	@SuppressWarnings("unused")
	private static Node mergeLists(Node head1, Node head2) {
		Node curr1 = head1;
		Node curr2 = head2;
		Node mergedHead = null;
		Node mergedPrev = null;
		int count = 0;
		while (curr1 != null && curr2 != null) {
			if (Integer.parseInt(curr1.getValue()) < Integer.parseInt((curr2
					.getValue()))) {
				if (count == 0) {
					mergedHead = curr1;
					count++;
				} else {
					mergedPrev.setNext(curr1);
				}
				mergedPrev = curr1;
				curr1 = curr1.getNext();
			} else {
				if (count == 0) {
					mergedHead = curr2;
					count++;
				} else {
					mergedPrev.setNext(curr2);
				}
				mergedPrev = curr2;
				curr2 = curr2.getNext();
			}

		}
		if (curr1 == null) {
			if (mergedHead == null) {
				mergedHead = curr2;
			} else {
				mergedPrev.setNext(curr2);
			}
		} else {
			if (mergedHead == null) {
				mergedHead = curr1;
			} else {
				mergedPrev.setNext(curr1);
			}
		}
		return mergedHead;
	}

}
