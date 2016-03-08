package geeksForGeeks.linkedList;

public class LinkedList {

	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void add(String newVal) {
		Node node = new Node(newVal);
		if (head == null) {
			System.out.println("Added");
			head = node;
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node(newVal));
			System.out.println("Added");
		}
	}

	public void traverse() {
		Node current = head;
		System.out.print("Traversing: ");
		if(current == null)
		{
			try {
				throw new Exception("Cannot traverse as list is empty");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (current != null) {
			if (current.getNext() != null) {
				System.out.print(current + " -> ");
			} else {
				System.out.println(current);
			}
			current = current.getNext();
		}
	}

	public int size() {
		int size = 0;
		Node current = head;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}

	public boolean add(int i, String newVal) {

		if (i < 0 || i > size()) {
			try {
				throw new Exception("Cannot add as Index is out of range");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return false;
		} else {
			Node newNode = new Node(newVal);
			if (head == null) {
				head = newNode;
				System.out.println("Added");
				return true;
			} else {
				Node current = head;
				if (i == 0) {
					head = newNode;
					head.setNext(current);
					System.out.println("Added");
					return true;
				}
				int pointer = 0;
				while (pointer < i - 1) {
					current = current.getNext();
					pointer++;
				}
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				System.out.println("Added");
				return true;
			}
		}
	}

	public boolean removeFirst() {
		if (head == null) {
			try {
				throw new Exception("Cannot remove first as List empty");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return false;
		} else {
			head = head.getNext();
			System.out.println("Removed first");
			return true;
		}
	}

	public boolean remove() {
		if (head == null) {
			try {
				throw new Exception("Cannot remove as List Empty");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return false;
		}
		if (head.getNext() == null) {
			head = null;
			System.out.println("Removed");
			return true;
		} else {
			Node current = head;
			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);
			System.out.println("Removed");
			return true;
		}
	}

	public boolean remove(int i) {

		if (i < 0 || i >= size()) {
			try {
				throw new Exception("Cannot remove as Index is out of range");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return false;
		} else {
			if (head == null) {
				try {
					throw new Exception("Cannot remove as List Empty");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return false;
			} else {
				Node current = head;
				if (i == 0) {
					head = head.getNext();
					System.out.println("Removed");
					return true;
				}
				int pointer = 0;
				while (pointer < i - 1) {
					current = current.getNext();
					pointer++;
				}
				current.setNext(current.getNext().getNext());
				System.out.println("Removed");
				return true;
			}
		}
	}

	public String get(int i) {
		if (i < 0 || i >= size()) {
			try {
				throw new Exception("Cannot get as Index is out of range");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		} else {
			if (head == null) {
				try {
					throw new Exception("Cannot get as List Empty");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return null;
			} else {
				Node current = head;
				if (i == 0) {
					System.out.println("Got " + head.getValue());
					return head.getValue();
				}
				int pointer = 0;
				while (pointer < i - 1) {
					current = current.getNext();
					pointer++;
				}
				System.out.println("Got " + current.getNext().getValue());
				return current.getNext().getValue();
			}
		}
	}
}
