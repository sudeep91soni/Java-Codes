package geeksForGeeks.linkedList;

class Node {

	private String value;
	private Node next;

	public Node(String newVal) {
		this.value = newVal;
		this.next = null;
	}

	public Node() {
		value = null;
		next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		if(this.next == null)
		{
			return "Node [value=" + value + ", next=" + next + "]";
		}
		return "Node [value=" + value + ", next=" + next.value +"]";
	}

	@Override
	public int hashCode() {
		return this.value.length();
	}

	@Override
	public boolean equals(Object obj) {
		if (((Node) obj).value.equals(this.value)) {
			return true;
		} else {
			return false;
		}

	}
}