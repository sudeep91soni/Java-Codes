package geeksForGeeks.linkedList;

public class LinkedListUtil {

	public static void traverse(Node head)
	{
		Node current = head;
		while(current != null)
		{
			System.out.print(current + " -> ");
			current = current.getNext();
		}
		System.out.println();
	}
}
