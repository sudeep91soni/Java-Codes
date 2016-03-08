package geeksForGeeks.linkedList;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestLinkedListOps {
	
Logger logger = LoggerFactory.getLogger(TestLinkedListOps.class);

	LinkedList list = new LinkedList();

	@Before
	public void setup() {
		list.add("abc");
		list.add("pqr");
		list.add("def");
	}

	@Test
	public void testOperations() {
		list.traverse();
		list.remove();
		list.traverse();
		list.remove();
		list.traverse();
		list.add("hello");
		list.traverse();
		list.add(0, "lol");
		logger.info("Size is " + list.size());
		list.traverse();
		list.removeFirst();
		list.traverse();
		list.get(1);
		list.remove();
		list.traverse();
		list.remove();
		list.traverse();
	}
}
